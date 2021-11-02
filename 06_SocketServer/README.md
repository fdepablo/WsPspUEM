# Sockets y desarrollo de aplicaciones Cliente-Servidor. 

Con estos ejemplos vamos a abordar los sockets y como podemos aplicarlos dentro de una arquitectura de cliente servidor.

## Programaci�n distribuida. Modelo cliente-servidor

Es muy habitual encontrarnos programas que no estan centralizados en una unica aplicacion sino que estan distribuidos en varias aplicaciones para realizar la funcionalidad.

La programaci�n distribuida hace referencia a las aplicaciones que tienen sus programas distribuidos en distintos equipos conectados a trav�s de la red. Los diferentes programas colaboran entre s� para alcanzar un objetivo com�n.

En este tipo de programaciones podemos encontrarnos una de las m�s extendidas que ser�a el modelo cliente-servidor, en el cual tenemos varias aplicaciones cliente que se contectan a un solo servidor (en principio, aunque tambien podemos tener muchos servidores si necesitamos que nuestro sistema sea escalable).

En este modelo las tareas ser�an repartidas de la siguiente manera:

1. <b>El servidor:</b> como proveedor o suministrador de recursos. Sus funciones ser�an:
    - Aceptar las peticiones de los clientes.
    - Analizar la petici�n del cliente e interactuar con el resto de capas del sistema (capa de datos, capa l�gica) para poder responder a la petici�n.
    - Generar la respuesta para el cliente.
    - Enviar la respuesta al cliente.
2. <b>El cliente:</b> como consumidor de los recursos que provee el servidor.
    - Suele Interactuar con el usuario.
    - Realiza peticiones al servidor.
    - Recibe los resultados del servidor.
    - Presenta los resultados al usuario o a otros procesos que lo requieran.

### Caracteristicas del modelo cliente servidor

1. Los clientes inician una comunicaci�n con el servidor a trav�s de un protocolo y el servidor responde. Los sockets pueden utilizar el protocolo TCP/IP (protocolo orientado a conexion) o el protocolo UDP (protocolo orientado a NO conexion). En nuestros ejemplos vamos a ver los sockets orientados a conexion.
2. El servidor presta los recursos y servicios al cliente que los consume.
3. El cliente no tienen por qu� saber d�nde se encuentran los recursos que consume. Simplemente le hace peticiones al servidor siendo como una caja negra para el, es decir, existe encapsulamiento de los servicios prestados por el servidor.
4. Se utilizan tecnolog�as que permitan independencia de la plataforma, tanto del cliente como del servidor. Es decir, el servidor puede estar hecho con Java y el cliente con PHP. El ejemplo m�s claro son los servidores web y los navegadores. En nuestro caso tanto el cliente como el servidor estar� hecho en Java pero no tendr�a porque ser as�.
5. Los sistemas deben ser escalables para garantizar la posibilidad de crecimiento y la adaptaci�n a cambios imprevistos.

![CLIENTE-SERVIDOR](img/cliente-servidor.png)

## Sockets

Los sockets proveen de un mecanismo para la comunicaci�n entre dos procesos que pueden encontrarse en distinta m�quina. 

Ofrecen una abstracci�n de la pila de protocolos IP que permite al programador olvidarse de los detalles t�cnicos de m�s bajo nivel en las comunicaciones a trav�s de la red.

La traducci�n literal de socket es "enchufe" y representa un extremo de un canal o flujo de datos que comunicar� dos procesos.

El uso de sockets es fundamental en los sistemas distribuidos donde una aplicaci�n est� compuesta por varios programas situados en diferentes equipos conectados a trav�s de la red que colaboran y se comunican entre ellos para conseguir un objetivo com�n.

![SOCKETS](img/sockets1.png)

Podemos observar como dentro de cada aplicacion (la app cliente y la app servidor) tendremos un socket (uno en cada extremo), que seran los encargados de mantener el flujo de datos (Stream) entre ambas aplicaciones y por donde se intercambiaran los mensajes para establecer la comunicaci�n.

Para conectar las dos aplicaciones normalmente el cliente hace una peticion TCP/IP a la aplicacion servidora, por lo que debemos de conocer la IP de donde se encuentra el servidor y el puerto por el cual esta escuchando dichas peticiones.

## Flujo de datos

Toda la informaci�n que se trasmite a trav�s de un ordenador fluye desde una entrada hacia una salida. Para transmitir informaci�n, Java utiliza unos objetos especiales denominados streams (flujos o corrientes).

Podemos entender el flujo de datos como una carretera o autopista con dos carriles que conecta dos ciudades, uno para cada sentido, el cual tenemos camiones que van viajando de una ciudad a otra. Las ciudades ser�an las dos aplicaciones, la aplicacion cliente y la aplicacion servidora. Los camiones transportar�an la informaci�n que queremos mandar entre las dos ciudades. Por �ltimo, los dos carriles que tendriamos ser�an el medio para intercambiar informaci�n(el flujo de datos o canal), uno para mandar informaci�n de la Ciudad A a la Ciudad B y el otro para mandar informaci�n de la Ciudad B a la Ciudad A.

Los stream permiten transmitir secuencias ordenadas de datos desde un origen a un destino. Para transmitir informaci�n de un ordenador a otro, necesitamos un socket a cada extremo y cada uno de estos sockets suministrar� un flujo de entrada o salida para realizar la transferencia.

## Sockets y Java

Java dispone de dos grupos de flujos de datos.

1. <b>InputStreams:</b> Para recibir los datos desde otro socket emisor.
2. <b>OutputStreams:</b> Para emitir datos hacia otro socket receptor.

Todo proceso de lectura o escritura de datos consta de tres pasos:

1. Abrir el flujo de datos de lectura o de escritura.
2. Leer o escribir datos a trav�s del flujo abierto.
3. Cerrar el flujo de datos.

Todas las clases que representan flujos de datos est�n ubicadas en el paquete <b>java.io</b> de java. Podemos encontrar las siguiente clases, dentro de las m�s importantes:

1. <b>Socket:</b> es la clase que nos va a permitir comunicarnos con el servidor. Aqui creamos un objeto socket con la IP y el puerto por el que vamos a contectarnos al servidor. En el servidor se creara otro objeto socket que se enlazara con este mediante TCP/IP. 
2. <b>InputStreamReader:</b> Entrada de datos. Es el canal de entrada para recibir los datos de otro socket. Normalmente nos apoyaremos en otro objeto llamado <b>BufferedReader</b> que permite hacer lecturas m�s sencillas.
3. <b>PrintStream:</b> Salida de datos. Es el canal de salida para mandar datos hacia otro socket.
4. <b>ServerSocket:</b> Este objeto es el que estar� escuchando peticiones por un puerto y crear� un objeto Socket por cada peticion. Este objeto solamente esta en el lado del servidor y tiene el  m�todo <b>accept()</b> el cual deja el hilo a la espera de que algun cliente le haga una peticion para crear el objeto Socket y poder continuar con la ejecuci�n. 
5. <b>InetSocketAddress :</b> Objeto que utilizaremos para encapsular la IP y el puerto.
		
## Diagrama de Streams y Sockets en java

Podemos entender el flujo de una aplicacion cliente-servidora de la siguiente manera. En los ejemplos esta tambien explicado.

![DiagramaStreams](img/diagramaStreams.png)

Notese que si no cerramos el socket ni en el servidor ni en el cliente, la comunicaci�n se mantendr�a abierta y podriamos estar continuamente utilizando los objetos stream para mandar informaci�n.

## Ejemplo sockets

En los ejemplos 19_SocketClient y el 19_SocketServer vamos a ver como crear aplicaciones cliente-servidor mediante Sockets. Son dos aplicaciones diferentes tal y como hemos visto hasta ahora.

Como primer ejemplo vamos a ver las clases <b>SocketCliente.java</b> y <b>SocketServidor.java</b>, que represetan un ejemplo de como recoger dos n�meros en el cliente y mandarselos a un servidor para que los sume. Cada vez que arrancamos el SocketCliente.java har�a una conexion al servidor y luego se parar�a, mientras que el servidor ser�a comun a todos los clientes y nunca dejar�a de estar arrancado.

Como segundo ejemplo, vamos a ver las clases <b>SocketClienteRepetitivo.java</b> y <b>SocketServidor.java</b>. En este caso el servidor funciona exactamente igual, pero en el caso del cliente, no parar�a el programa hasta que el usuario lo diga, y se crear�a un nuevo objeto Socket cada vez que mandemos dos n�meros para sumar.

## Hilos y Sockets	

En los servidores de aplicaciones es muy habitual el uso de hilos en los programas y eso es debido a las propias limitaciones de los sitemas con un solo hilo de ejecuci�n.

Hay que tener en cuenta que si no usamos hilos en nuestro servidor SOLAMENTE podr� atender a un cliente al mismo tiempo, es decir, hasta que no acabe de procesar una peticion no volvera el servidor a aceptar otras peticiones (hasta que el hilo principal del servidor no vuelva a la linea donde se invoca el m�todo <b>accept()</b>).

De esta manera, si queremos hacer programaci�n paralela y poder procesar varias peticiones de diferentes clientes, <b>deberemos de abrir un nuevo hilo por cada peticion</b> y que sea esta la que se encargue de las comunicaciones con el cliente.

Supongamos que, el ejemplo anterior que hemos visto, tardara mucho en ejecutarse, por ejemplo que en vez de calcular la suma de dos numeros, que es una tarea muy sencilla a nivel de procesador, fuera el calculo de saber si un numero es primo o no, la cual puede llevar mucho tiempo de calculo. Si utilizamos un solo hilo de ejecucion y tuvieramos varios clientes haciendo peticiones al servidor, se crear�a una cola de peticiones de manera natural, por lo que los ultimos clientes en hacer la solicitud ver�an como el servidor les tarda en responder una cantidad de tiempo anormal.

En este ejemplo vamos a ver las clases <b>SocketClienteHilo.java</b> y <b>SocketServidorHilo.java</b>, que represetan un ejemplo de como queremos que el servidor nos responda cuantos caracteres tiene una frase que les mande un cliente. El cliente nos podr� mandar frases continuamente hasta que nos mande la palabra "FIN", que sera cuando se corte la comunicaci�n. En este caso, aunque la idea sea la misma que en el ejemplo anterior (segundo ejemplo), la manera de implementarlo es diferente, ya que en este caso NO se habre un socket en el lado cliente y servidor por cada peticion del cliente, sino que el cliente abre una conexi�n  al principio y los socket permanecen abiertos hasta que el el cliente escriba la palabra "FIN".

Para solventar el problema de que ningun otro cliente pueda contectarse al servidor hasta que el cliente anterior haya cerrado la comunicaci�n, vamos a hacer que el <b>SocketServidorHilo.java</b> abra un hilo nuevo de la clase <b>HiloContadorLetras.java</b> que ser� en el encargado de mantener el socket abierto, liberando as� el hilo principal pudiendo aceptar peticiones nuevas. Por cada peticion de un cliente nuevo, el servidor crear� un hilo nuevo asignado a dicha petici�n.

Esta es la manera de trabajar de todos los servidores de aplicaciones, para poder as� dar soporte al mayoria de clientes posibles (Paginas web, videojuegos, etc.).

![SERVIDOR CON HILOS](img/socketsHilos.png)


