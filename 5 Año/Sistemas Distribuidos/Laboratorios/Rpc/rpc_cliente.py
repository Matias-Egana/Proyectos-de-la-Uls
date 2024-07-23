import xmlrpc.client
numero=0
with xmlrpc.client.ServerProxy("http://localhost:8000/") as proxy:

    while (numero>=0):
        numero=int(input("Ingrese un Número positivo:"))
        if numero >0:
            respuesta=str(proxy.is_even(numero))
            print(numero," es ",respuesta,"\n")
    
    print("\nFin !!")
    