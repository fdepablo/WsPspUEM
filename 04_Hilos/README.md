# Hilos

Los hilos estan asociados a un <b>proceso</b> de nuestro sistema operativo. La definici�n de proceso es un programa en ejecuci�n. Puesto que un proceso est� en ejecuci�n, est� consumiendo recursos del sistema. Por ejemplo, cuando abrimos un navegador, ejecutamos dicho programa por lo que se abrir� un proceso en nuestro sistema.

Crear un proceso en un ordenador implica los siguientes cambios:

- La reserva de una determinada memoria de trabajo.
- Carga de trabajo para el procesador, que tendr� que ir ejecutando las instrucciones incluidas en el proceso.
- Cambios de estado del proceso, que se reflejan en los valores de los registros de la CPU.

Los procesos se pueden ver en ejecucion en el sistema operativo, en windows por ejemplo los podemos ver dentro del administrador de tareas.

Un <b>hilo</b> es la unidad m�nima de procesamiento y se encuentra dentro de un proceso. Es decir, un conjunto de instrucciones en ejecuci�n dentro del contexto de un proceso. 

Todo proceso tendr� al menos un hilo en ejecuci�n, aunque podr�a tener varios simult�neos, creando lo que se denomina multitarea.

Hay que tener claro que el sistema operativo tiene control sobre los procesos, pero NO sobre las hilos de una manera directa

Esto nos lleva a distinguir entre los conceptos de multiproceso y multitarea.

- <b>Multiproceso</b>: varios procesos que se ejecutan de manera concurrente y que son gestionados por el sistema operativo.
- <b>Multitarea</b>: varios hilos de ejecuci�n simult�neos dentro del mismo proceso.

Nosotros en esta lecci�n nos vamos a centrar en los sistemas multitarea.

## Sistemas multitarea 

Estos sistemas tienen una serie de caracter�sticas:

- Varios hilos en ejecuci�n dentro del mismo proceso.

- Todos los hilos comparten los recurso que el sistema operativo haya asignado al proceso. La incorporaci�n de un hilo m�s no supone la asignaci�n de m�s recursos del sistema. 

- Si el ordenador dispone de varios n�cleos, cada hilo en ejecuci�n puede aprovechar un n�cleo distinto, produci�ndose as� la multitarea en el sentido estricto de la palabra.

- El uso de varios hilos de ejecuci�n en un proceso es especialmente interesante en los programas en red de tipo cliente/servidor. Un hilo de ejecuci�n puede estar atendiendo peticiones y, si el procesamiento de la respuesta es largo, podr�a generarse un hilo independiente para cada respuesta. De este modo, se podr�a estar atendiendo varias peticiones al mismo tiempo.

## Beneficios de un sistema multitarea

Uno de los mayores beneficios que tiene la programaci�n multitarea es el poder reducir de manera considerada los tiempos de ejecuci�n de una aplicaci�n.

Supongamos que estamos haciendo una aplicaci�n que para acabar tiene que hacer 3 tareas:

- Tarea A: Procesar unos ficheros de texto para guardar la informaci�n en base de datos. Supongamos que el tiempo de duracion de esta tarea es de 25 segundos.
- Tarea B: Mandar un numero indeterminado de emails a nuestros clientes. Supongamos que el tiempo de duracion de esta tarea es de 20 segundos.
- Tarea C: Hacer calculos estadisticos e informes para enviar a nuestros directores. Supongamos que el tiempo de duracion de esta tarea es de 15 segundos.

En una situacion normal en la que no hay multitarea (una aplicaci�n normal en Java), es decir, en la que solo hay un hilo de ejecuci�n, la duraci�n total de la aplicaci�n ser�a de 60 segundos. En esta situaci�n irian ejecutandose las tareas de manera secuencial (no empezar�a la tarea B a ejecutarse hasta que no acabe la tarea A).

En una situaci�n en que que hay multitarea, es decir, en que hay creamos varios hilos de ejecuci�n (en este caso 3 hilos, cada uno asociado a una tarea), la duraci�n total seria la de la tarea con mayor duraci�n, en este caso 25 segundos, habiendo reducido el tiempo a menos de la mitad. En esta situaci�n irian ejecutandose las tareas de manera paralela.

Por supuesto habr�a que tener en cuenta que nuestro ordenador a nivel de hardware tuviera hilos suficientes para ejecutar todos nuestros hilos en paralelo, de nada serviria hacer programaci�n multitarea si ejecutamos el codigo en un ordenador antiguo con un solo hilo de procesamiento.

## Hilos en Java

Existen dos maneras de declarar y configurar hilos en Java: 

- Crear una clase que extienda de la clase Thread (herencia)

- Crear un clase que implemente la interfaz Runnable (interfaces)

Ademas existen muchos metodos estaticos asociados a la clase Thread que nos van a ayudar:

- sleep(X): Duerme el hilo por el que esta pasando el programa X milisegundos
- start(): Arranca un hilo, ejecutando su metodo run(). El hilo acabar� cuando salga del metodo run().
- currentThread().getName(): Nos da el nombre el hilo que esta pasando por el programa.


Existen muchos mas metodos que podemos ver en la documentacion oficial.

En el paquete 01_basico podemos encontrar ejemplos sobre los hilos en java

## Estados de un hilo

![Estados Hilos](img/estadosHilos.png))

La imagen refleja los distintos cambios de estados por los que pasa un hilo y los m�todos que pueden provocar dichos cambios. Un hilo nuevo pasa a ejecutable por la invocaci�n al m�todo start(). Por otro lado, puede pasar de ejecutable a bloqueado por la invocaci�n a los m�todos sleep(), wait(), o a la espera de una operaci�n de entrada/salida, volviendo de nuevo al estado ejecutable cuando llegue el momento.

Un hilo pasa a estar muerto en la mayor�a de los casos cuando ha terminado de ejecutarse el m�todo run() y, por consiguiente, ya cumpli� su misi�n, pero tambi�n podr�a pasar a estado muerto por la ejecuci�n del m�todo stop(), que interrumpe el hilo, o por otro tipo de interrupci�n inesperada.

## Hilos sincronizados en Java

Cuando estamos trabajando con hilos podemos tener problemas de sincronizaci�n entre ellos o lo que es lo mismo problemas cuando dos hilos acceden simultaneamente a la misma posici�n de memoria.

Varios hilos podr�an compartir informaci�n accediendo a la misma variable, objeto, fichero, etc. Esto podr�a crear zonas cr�ticas, es decir, �reas de c�digo que podr�an crear problemas de concurrencia.

Para indicar que un fragmento de c�digo est� sincronizado, es decir, que solamente un hilo puede acceder a dicho m�todo a la vez se utilizara el modificador "synchronized" que se utiliza para indicar que un fragmento de c�digo est� sincronizado, es decir, que solamente un hilo puede acceder a dicho m�todo a la vez. 

Se podr�a afirmar que un m�todo sincronizado tiene una marca de abierto y cerrado: cuando est� cerrado ning�n otro hilo puede entrar en dicho m�todo.

La clave de la sincronizaci�n est� en la palabra <b>monitor</b>. Como hemos comentado anteriormente, s�lo un hilo de ejecuci�n puede acceder a un m�todo sincronizado al mismo tiempo; se dice que ese hilo es el que tiene el monitor y tendr� bloqueado el proceso hasta que finalice su ejecuci�n y lo libere.

Podemos ver los ejemplos 03 de este proyecto para ver ejemplos sobre la sincronizaci�n de hilos.

## Wait y Notify

Los m�todos wait() y notify() pertenecen a la clase Object, por consiguiente, todos los objetos cuentan con ellos ya que todos las clases herendan de la clase Object.

El m�todo wait() deja bloqueado el hilo que lo llama, hasta que es liberado por otro hilo por medio de la ejecuci�n del m�todo notify(). El m�todo wait() esta sobrecargado y admite tambien un parametro de entrada en el que le pasamos un n�mero de milisegundos, en caso de que pase dicho numero de milisegundos y ningun hilo haya ejecutado un notify sobre el objeto, entonces el hilo seguira su ejecuci�n.

Podemos ver el ejemplo 04 para ver un sistema de productores y consumidores usando los metodos wait() y notify().

## Bibliografia
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html

