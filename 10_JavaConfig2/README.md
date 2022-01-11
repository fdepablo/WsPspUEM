# Configuración de una app Spring mediante java

Como hemos visto en el anterior ejemplo, podemos dar de alta un contexto de spring sin necesidad de usar un xml.

En este ejemplo vamos a ver como podemos dar de alta objetos en el contexto de spring sin necesidad ni de xml ni de anotaciones. 

Esto se suele usar cuando queremos dar de alta objetos en nuestro contexto de spring a nivel programatico pero cuyas clases no tenemos el codigo fuente y no podemos anotar.

Todos estos objetos habria que darlos de alta en una clase de configuracion, es decir, que este anota con @Configuration

