from xmlrpc.server import SimpleXMLRPCServer

def is_even(n):
    if n % 2 == 0:
        return ("Par")
    else:
        return ("Impar")

server = SimpleXMLRPCServer(("localhost", 8000))
print("Listening on port 8000...")
server.register_function(is_even, "is_even")
server.serve_forever()