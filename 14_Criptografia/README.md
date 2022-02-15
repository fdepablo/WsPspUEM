# Criptograf�a

La criptograf�a es la ciencia que estudia las distintas t�cnicas que se pueden utilizar para proteger documentos y datos, transform�ndolos por medio de alg�n tipo de codificaci�n secreta.

La palabra criptograf�a proviene de la uni�n de dos palabras de la lengua griega:
- Kryptos: oculto.
- Graphia: escritura.

Para los sistemas inform�ticos, la criptograf�a tiene como objetivo ocultar la informaci�n a personas o programas no autorizados, que no s�lo podr�an leerla, sino incluso manipularla con objeto de modificar su contenido.

## Usos de la criptograf�a

La criptograf�a se viene empleando desde tiempos inmemoriales. En las antigua Grecia y Roma ya se creaban criptogramas (mensajes cifrados) para cuestiones diplom�ticas, �rdenes militares, informes sobre actividades de espionaje o documentos de �ndole pol�tica. A lo largo de la historia el hombre ha inventado varios sistemas criptogr�ficos. Veamos a continuaci�n algunos ejemplos:

### La esc�tala espartana. 

Fue el primer metodo de encriptaci�n de la historia. La idea consistia en enrollar un papiro en una esc�tala (una palo con muescas) y escribir un mensaje por una de sus caras. Luego se desenrollaba el papiro y se enviaba a un receptor. Dicho receptor enrollaba el mensaje en una escitala exactamente igual que la primera para poder leer el mensaje.

![Escitala espartana](img/escitala.jfif)

### El m�todo C�sar. 

Se denomina as� porque fue utilizado por Julio C�sar. Es muy sencillo: consiste en sustituir cada letra por otra situada varias posiciones m�s adelante dentro del alfabeto. El n�mero de posiciones es lo que llamamos desplazamiento.

![Metodo Cesar](img/metodo_cesar.png)

### La m�quina enigma

La m�quina Enigma comenz� a utilizarse en la Segunda Guerra Mundial por los alemanes para cifrar sus mensajes secretos. Con cada tecla pulsada, unos rotores giraban, modificando dicha tecla por otra distinta seleccionada por la m�quina a trav�s de diferentes reglas complejas.

![maquina enigma](img/maquina_enigma.jpg)

Fue Alan Turing, un cient�fico brit�nico, quien logro descifrar los c�digos alemanes utilizados en la m�quina Enigma, contribuyendo as� a la derrota nazi.

### HTTPS

Dentro del protocolo HTTP tenemos tambien la versi�n segura, el cual se cifra la comunicaci�n entre el cliente y el servidor.

## Concepto de encriptacion

La encriptaci�n es el proceso que hace posible la criptograf�a, es decir, el proceso necesario para volver ilegible dicha informaci�n para terceros. Aqu� tenemos varios conceptos:

1. <b>Encriptar.</b> Proceso por el cual volvemos ilegible una informaci�n. Tambien llamado cifrar.
2. <b>Desencriptar.</b> Proceso de obtener el mensaje original a traves del mensaje encriptado. Tambien llamado descifrar.
3. <b>Criptograma.</b> El mensaje secreto, es decir, el mensaje escrito en clave o cifrado.

Tanto para encriptar como para desencriptar utilizaremos una <b>CLAVE</b> para realizar la transformaci�n.

![cifrar descifrar](img/cifrar_descifrar.png)

## Tipos de clave Criptogr�fica

Existen dos tipos de claves criptogr�ficas, que son:

- <b>Clave sim�trica.</b> Se utiliza la misma llave (o clave) para el cifrado y el descifrado. Tambi�n se denomina m�todo de clave privada. Este m�todo es el que primero se invent� y ha sido usado durante toda la historia de la humanidad. Como ejemplos podr�amos encontrar la escitala espartana, el metodo cesar o la m�quina Enigma. Este m�todo, aunque fiable y robusto, representa un grave problema: �C�mo transferimos o distribuimos la clave entre el emisor o el receptor? Es aqu� donde entra tambien el concepto de <b>canal seguro</b>, que es un canal el cual podemos mandar informaci�n sin miedo a que sea interceptada. Este problema lo podemos encontrar tanto si el emisor y el receptor son personas como si nos movemos en un entorno de cliente y servidor.

- <b>Clave asim�trica.</b> Se utiliza una clave para el cifrado y otra distinta para el descifrado. Tambi�n se conoce como m�todo de clave p�blica. En este m�todo tenemos dos llaves (o claves), una se conoce como clave p�blica (A) y la otra se conoce como clave privada (B). La idea b�sica es que lo que ciframos con la clave p�blica SOLAMENTE lo podemos descifrar con la clave privada, y lo que ciframos con la clave privada SOLAMENTE lo podemos descifrar con la clave publica. NUNCA lo que ciframos con una clave lo podemos descifrar con la misma (a diferencia de los metodos con clave sim�trica). Tenemos dos principales ramas en la criptograf�a de clave sim�trica, en funci�n de si usamos la clave publica o la clave privada para cifrar, estos son: 

    1. <b>Cifrado con clave p�blica.</b> Un mensaje cifrado con la clave p�blica de un destinatario no puede ser descifrado por nadie (incluyendo al que lo cifr�), excepto un poseedor de la clave privada correspondiente, presumiblemente su propietario y la persona asociada con la clave p�blica utilizada. Su funci�n es garantizar la confidencialidad del mensaje.

    2. <b>Cifrado con clave privada</b> Un mensaje firmado con la clave privada del remitente puede ser verificado por cualquier persona que tenga acceso a la clave p�blica de dicho remitente, lo que demuestra que este remitente ten�a acceso a la clave privada (y por lo tanto, es probable que sea la persona asociada con la clave privada utilizada). Se utiliza para garantizar la autenticidad del mensaje. Este metodo es usado para las firmas digitales.

Existe un tercer m�todo conocido como <b>Clave mixta</b>,que no es un tipo de criptograf�a como tal, simplemente es una conbinaci�n de clave sim�trica y clave asim�tica. Un ejemplo ser�a el protocolo HTTPS. La idea b�sica es usar la clave asim�trica para intercambiar la clave simetrica.

## Trabajando con la criptograf�a en Java

Java cuenta con mecanismos para encriptaci�n de informaci�n mediante uso de claves. Las clases que permiten desarrollar dichos mecanismos est�n distribuidas en las siguientes clases Java:
    
- La interfaz <b>java.security.Key</b> representa una clave que puede ser utilizada en la funci�n de cifrado y de descifrado. 

- La interfaz <b>javax.crypto.SecretKey</b> es otra interfaz m�s concreta que implementa a la interfaz Key.

- La clase <b>javax.crypto.spec.SecretKeySpec</b> es una clase que implementa la interfaz SecretKey.

- La clase <b>javax.crypto.Cipher</b> implementa las funciones de cifrado o descifrado, especificando el tipo de algoritmo utilizado.

## Hash: funciones de resumen

Las funciones de resumen, o funciones hash, disponen de un algoritmo capaz de crear, a partir de una determinada informaci�n de longitud variable (entrada), una cadena de longitud fija (salida) que resume dicha informaci�n.

Los algoritmos hash garantizan que:

1. La cadena de salida obtenida representa un resumen del mensaje original. A partir de dicho resumen NUNCA se podr� obtener el mensaje original (a diferencia de cuando ciframos, que se puede descifrar). Lo que "hasheamos" no se puede "deshashear".

2. Para la misma informaci�n de entrada, se obtendr� <b>SIEMPRE</b> el mismo resumen hash. Esta regla se cumple siempre y cuando se utilice le mismo tipo de algoritmo.

Podemos pasar un algoritmo hash a cualquier informaci�n, ya sea un texto, un fichero excel, un fichero .zip, etc.

Adem�s, un resumen hash tiene aplicaciones muy importantes:

1. <b>Comprobar que un archivo no ha sido modificado y garantizar su integridad</b>. Cuando hay que transmitir mucha informaci�n a trav�s de la red, dicha informaci�n puede transmitirse junto con el resumen y el tipo de algoritmo utilizado. Una vez que la informaci�n llega al destino, puede volverse a generar el resumen con el mismo algoritmo y comprobar si ha habido alg�n cambio durante la transmisi�n. 

2. <b>Comprobar contrase�as de manera segura</b>. Las contrase�as NUNCA se deben guardar encriptadas en base de datos, ya que cuando encriptamos un mensaje lo podemos desencriptar. Por ejemplo, un programador usa una clave para encriptar los passwords de los usuarios, por lo que al tener la clave puede en cualquier momento usar la misma clave para desencriptarlos. Los passwords en base de datos se guardan con el RESUMEN hash, que garantiza que nunca se podr� obtener la informaci�n original. La manera de entonces de proceder ser�a guardar el pasword "hasheado" en base de datos y cada vez que nos mande el usuario su password para autenticarlo ser�a "hasheando" tambien dicho password y compararlo con el resumen hash del password guardado en base de datos. Recordemos el el algoritmo hash nos garantiza que una misma entrada produce siempre la misma salida.

### Algoritmos Hash:

Podemos encontrar distintos algoritmos hash:

1. <b>MD5</b> (Message-Digest Algorithm 5) es un algoritmo de resumen criptogr�fico creado por el profesor Ronald Rivest del Instituto Tecnol�gico de Massachusetts en 1991. Actualmente esta obsoleto ya que genera colisiones. En los algoritmos hash, se denomina colisi�n a la ocurrencia de dos mensajes de entrada distintos que generan la misma cadena de salida de resumen.

2. <b>SHA</b> (Secure Hash Algorithm), cuya primera versi�n fue lanzada en 1993 por el Instituto Nacional de Normas y Tecnolog�a de EEUU. Este algoritmo ha ido evolucionando para su mejora seg�n se han ido detectando vulnerabilidades, y dando lugar a diferentes versiones como pueden ser SHA-256, SHA-512 o SH-1024. Es el m�s utilizados actualmente ya que las versiones m�s modernas de SHA son consideradas resistentes a las colisiones.e

## P�ginas de interes

- Pagina para crear resumenes hash a partir de ficheros o cadenas <https://hash.online-convert.com/es/generador-sha512>

- Pagina con base de datos de resumenes hash <https://crackstation.net/>

## Bibliograf�a

- <https://es.wikipedia.org/wiki/Criptograf�a>

- <https://es.wikipedia.org/wiki/Funci�n_hash>
