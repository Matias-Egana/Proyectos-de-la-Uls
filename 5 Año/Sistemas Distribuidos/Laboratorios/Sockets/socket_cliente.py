import socket
s = socket.socket()
#invoco  el metodo connect del socket pasando como parametro (IP , puerto)
s.connect(("192.168.1.154",  9999))
while  True:
    mensaje=input("> ").encode('utf-8')
    s.send(mensaje)
    #invoco  el metodo send pasando como parametro el string ingresado por el  usuario
    aux=mensaje.decode()
    if  aux.lower() == "exit":
        break
#cierro  socket
s.close()