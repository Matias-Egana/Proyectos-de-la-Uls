import socket
s = socket.socket()

#Invoco  al metodo bind, pasando como parametro (IP,puerto)
s.bind(("192.168.1.154",  9999))
#Invoco  el metodo listen para escuchar conexiones
#con el numero maximo de  conexiones como parametro
print ("Esperando a los clientes....")
s.listen(5)
#El  metodo accept bloquea la ejecucion a la espera de conexiones
#accept  devuelve un objeto socket y una tupla Ip y puerto
sc, addr = s.accept()
print ("Recibo conexion de " + str(addr[0]) + ":" + str(addr[1])+ " ...escriba Exit para terminar")
while True:
    #invoco  recv sobre el socket cliente, para recibir un maximo de 1024 bytes
    try: recibido = sc.recv(1024)
    except:
        break
    aux=recibido.decode('utf-8')
    #Envio  la respuesta al socket cliente
    try: sc.send(recibido)
    except:
        break
    print (aux)
print  ("...Cliente desconectado")
#cierro  sockets cliente y servidor
sc.close()
s.close()