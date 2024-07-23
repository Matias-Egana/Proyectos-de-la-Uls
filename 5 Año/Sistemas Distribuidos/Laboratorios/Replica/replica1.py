from flask import Flask, request, jsonify
from flask_cors import CORS
from datetime import datetime
import requests

app = Flask(__name__)
CORS(app)

data = {
    "items": [],
    "transactions_processed": set(),
    "last_updated": datetime.now().isoformat()
}

# Añade más URLs de réplicas según sea necesario
other_replicas = ["http://localhost:5001/data"]

@app.route('/data', methods=['GET', 'POST', 'DELETE'])
def data_handler():
    if request.method == 'GET':
        return jsonify({
            "items": data["items"],
            "transactions_processed": list(data["transactions_processed"]),
            "last_updated": data["last_updated"]
        })

    transaction_id = request.json.get("transaction_id")
    if not transaction_id or transaction_id in data["transactions_processed"]:
        return jsonify({"error": "Invalid or repeated transaction ID"}), 400

    if request.method == 'POST':
        new_item = request.json.get("item")
        quantity = request.json.get("quantity")
        if new_item and quantity:
            data["items"].append({"item": new_item, "quantity": quantity})
            data["transactions_processed"].add(transaction_id)
            data["last_updated"] = datetime.now().isoformat()
            propagate_to_replicas('POST', transaction_id, new_item, quantity)
            return jsonify({
                "success": True,
                "items": data["items"],
                "transactions_processed": list(data["transactions_processed"]),
                "last_updated": data["last_updated"]
            }), 200

    elif request.method == 'DELETE':
        item_index = request.json.get("item_index")
        if 0 <= item_index < len(data["items"]):
            removed_item = data["items"].pop(item_index)
            data["transactions_processed"].add(transaction_id)
            data["last_updated"] = datetime.now().isoformat()
            propagate_to_replicas('DELETE', transaction_id, item_index)
            return jsonify({
                "success": True,
                "removed_item": removed_item,
                "items": data["items"],
                "transactions_processed": list(data["transactions_processed"]),
                "last_updated": data["last_updated"]
            }), 200

        return jsonify({"error": "Item index out of range"}), 400

def propagate_to_replicas(method, transaction_id, item, quantity=None):
    payload = {
        "transaction_id": transaction_id,
        "item_index": item if method == 'DELETE' else None,
        "item": item if method == 'POST' else None,
        "quantity": quantity if method == 'POST' else None
    }
    for url in other_replicas:
        try:
            if method == 'POST':
                response = requests.post(url, json=payload)
            elif method == 'DELETE':
                response = requests.delete(url, json=payload)
            print(f"Propagated {method} to {url} with status {response.status_code}")
        except requests.exceptions.RequestException as e:
            print(f"Failed to connect to {url}: {e}")

def sync_with_replicas():
    global data
    for url in other_replicas:
        try:
            response = requests.get(url)
            if response.status_code == 200:
                print("a")
                replica_data = response.json()
                print(f"Data from {url}: {replica_data}")  # Debugging line
                if replica_data["last_updated"] < data["last_updated"]:
                    print ("b")
                    data["items"] = replica_data["items"]
                    data["transactions_processed"] = set(replica_data["transactions_processed"])
                    data["last_updated"] = replica_data["last_updated"]
                    print(f"Synchronized with {url}")
                    print(f"Updated data: {data}")  # Debugging line to verify the update
                    return  # Exit after a successful sync
        except requests.exceptions.RequestException as e:
            print(f"Failed to connect to {url}: {e}")

if __name__ == '__main__':
    sync_with_replicas()  # Sync with replicas at startup
    app.run(port=5000)










