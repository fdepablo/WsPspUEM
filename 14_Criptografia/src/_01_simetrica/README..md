# Clave sim�trica en Java

En este tipo de sistemas la clave para encriptar y la clave para desencriptar es la misma.

Podemos encontrar muchos tipos de algoritmos, vamos a trabajar con dos, DES y AES.

## Algoritmo DES (Data Encryption Standard)

DES (Data Encryption Standard) es un algoritmo de cifrado sim�trico que fue acogido por los Estados Unidos en 1976 y sigui� utiliz�ndose hasta 1999.

Caracter�sticas del algoritmo DES.

1. El algoritmo DES divide el mensaje original en bloques de 64 bits.
2. La clave generada tambi�n es de 64 bits.
3. Cada bloque de 64 bits sufre una transformaci�n inicial, denominada permutaci�n.
4. Tras la primera transformaci�n, cada bloque sufrir� otras 16 transformaciones a trav�s de las denominadas "Rondas Feistel". Cada transformaci�n utilizar� su propia clave generada a partir de la clave inicial.
5. Una vez finalizadas las 16 rondas, cada bloque sufrir� una transformaci�n final.


## Algoritmo AES (Advanced Encryption Standard)

A partir del a�o 2000, el gobierno de los Estados Unidos adopt� el algoritmo AES.

Fue desarrollado por Joan Daemen y Vincent Rijmen, dos estudiantes belgas expertos en criptolog�a, originariamente con el nombre de "Algoritmo Rijndael".

El funcionamiento del algoritmo AES es muy similar al anterior DES, con algunas diferencias que mencionamos a continuaci�n: 

1. El mensaje a cifrar tambi�n se divide en bloques, pero esta vez cada bloque puede ser de longitud variable, entre 128, 192 o 256 bits.
2. La clave tambi�n puede ser de 128, 192 o 256 bits.
3. Se trata de un algoritmo m�s r�pido y seguro que el algoritmo DES.
4. En Java se implementa de la misma manera que vimos en el apartado anterior, lo unico que la instancia que hay que pedir sera la de "AES" en vez de la de "DES". Por lo dem�s el c�digo sera el mismo.
