# Anotaciones en Spring

En programación, una Anotación Java es una forma de añadir metadatos al código fuente Java que están disponibles para la aplicación en tiempo de ejecución o de compilación. Muchas veces se usa como una alternativa a la tecnología XML. Tienen una sintaxis tal que "@NOMBRE_DE_LA_ANOTACION"

Por ejemplo, la anotacion @Override de la JDK de java, comprueba en tiempo de compilacion que la firma del metodo sea igual a la firma de un metodo de una clase padre. Si no coincide la firma, daría un error.

Spring tiene otras anotaciones, como @Component, que actuan en tiempo de ejecución.

Las Anotaciones Java pueden añadirse a los elementos de programa tales como clases, métodos, atributos o propiedades, variables locales, y paquetes. Las Anotaciones Java son completamente accesibles al programador y suelen ser proogramadas usando el API de reflexión de JAVA.

Spring actua basicamente de la siguiente manera cuando va a dar de alta un objeto en el contexto mediante anotaciones:

1. Cuando va a dar de alta un objeto en el contexto mira las anotaciones que tiene
2. En funcion de las anotacines que tenga, le aplicara al objeto que cree dicha funcionalidad de la anotacion.
3. Si no tiene anotaciones, no hara nada con el.

## Tipos de anotaciones para dar del alta objetos

En Spring tenemos muchos tipos de anotaciones, dentro del grupo que usaremos para dar de alta objetos podemos encontrar 4 estereotipos, todos ellos dan de alta un objeto en el contexto de Spring de igual manera, simplemente la diferencia es semantica, es decir, aporta información del tipo del objeto al programador.

1. <b>@Component</b>, Da un objeto de alta en el contexto de spring. La clase del objeto sería la clase donde esta anotada, y el id sera el nombre de la clase en lowerCamelCase.
2. <b>@Controller</b>, Igual que @Component pero esta vez representa un objeto controlador dentro del MVC
3. <b>@Service</b>, Igual que @Component pero esta vez representa un objeto de logica de negocio, gestor o servicio. La logica de negocio estaría dentro del modelo dentro del MVC
4. <b>@Repository</b>, Igual que @Component pero esta vez representa un objeto de acceso a datos. La capa de acceso a datos tambien estaria dentro del modelo dentro del MVC.

Hay mas anotaciones que veremos en los ejemplos.

## Composicion del ejemplo

En este ejemplo vamos a partir del mismo ejemplo anterior, pero esta vez vamos a dar de alta los beans en Spring por anotaciones en vez de por XML.

El contexto de Spring lo seguiremos dando de alta mediante XML.

Siempre que estemos trabajando con anotaciones, debemos de decirle a Spring donde tiene que ir a buscar clases
anotadas, y que seran gestionadas por Spring. Como en este caso, vamos a dar de alta el contexto de Spring mediante XML, debemos decirle al XML donde tiene que ir a buscar dichas anotaciones, es decir, el nombre del paquete. Debemos de poner en el XML la siguiente  etiqueta:

    <context:component-scan base-package="es.curso"></context:component-scan>
    
Esta etiqueta pertenece al namespace "context", por lo que hay que usarlo dentro del XML. Para ello podemos añadir el namespace siguiente:

    xmlns:context="http://www.springframework.org/schema/context"
    
Se puede ver en este ejemplo como hacerlo.
    
El nombre del paquete que se le de, buscará en dicho paquete y en todos los paquetes hijos. Por lo que suele ser habitual dar el nombre del paquete raiz del proyecto.

## Anotaciones VS XML

1. Mediante anotaciones solo podemos dar de alta en el contexto de Spring objetos cuyas
clases tenemos su codigo fuente. No podemos anotar clases como por ejemplo ArrayList
2. Mediante anotaciones NO necesitamos crear los setters y getters de los atributos para inyectarles dependencias de los objetos. Por XML era obligatorio.
3. Mediante anotaciones SOLO podemos dar de alta un objeto de un tipo en el contexto de Spring. Mediante XML podemos dar todos los que queramos.
4. Mediante anotaciones NO podemos cambiar el tipo de los objetos sin volver a compilar el codigo (punto bastante negativo).
5. Dar de alta objetos con anotaciones es mas facil y más rapido que por XML
6. Normalmente se utiliza más las anotaciones que el XML, pero por XML podemos hacer funcionalidades que por anotaciones no podemos. Así que realmente las dos son utiles en cada contexto.


