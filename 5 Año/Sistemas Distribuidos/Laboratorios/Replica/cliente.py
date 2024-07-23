import webbrowser
import requests

replica_urls = ["http://localhost:5000/data", "http://localhost:5001/data"]
html_file_path = './index.html'  # Asegúrate de especificar la ruta correcta del archivo HTML

def check_replicas():
    for url in replica_urls:
        try:
            response = requests.get(url)
            if response.status_code == 200:
                return True
        except requests.exceptions.RequestException as e:
            print(f"Error connecting to {url}: {e}")
    return False

def open_html():
    webbrowser.open_new_tab(html_file_path)
    

if __name__ == '__main__':
    if check_replicas():
        print("Al menos una réplica está disponible. Abriendo el formulario...")
        open_html()
    else:
        print("Servidores no disponibles.")
