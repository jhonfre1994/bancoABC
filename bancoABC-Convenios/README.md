# CONVENIO SERVICE

Microservicio que persiste la informacion de los diferentes convenios.

## Funcionalidades 

* Gestiona y persiste la informacion de los convenios, se guarda la información acerca de los microservicios y los convenios, esta informacion tambibien es usada para hacer las peticiones a los otros microservicios por medio del feign, de esta manera se permite crear otro convenio en la base de datos sin hacer modificaciones de codigo.
* Tiene la funcion de un orquestador, ya que por medio de este servicio se envian las peticiones a los otros microservicios, esto dependiendo de la informacion suministrada en el body.

## Construido con 🛠️

Este proyecto esta construido con las siguientes tecnologias:

## Backend y dependencias

* Java 1.8
* Spring MVC with Spring Boot
* Maven
* eureka client
* openapi-ui
* Spring cloud
* Openfeign
* H2
* flyway

### El microservicio de gas esta compuesto por lo siguientes paquetes:
   * Web: Responde a eventos lanzados por el usuario desde la web
   * Exceptions: clases para capturar excepciones HTTP de manera personalizada.
   * Model: Objetos que se usan para la comunicación a través de las API.
   * Service: capa de servicio que maneja la logica de negocio.
   * Entity: clases de tipo entidad de la base de datos.
   * model: Objetos que se usan para la comunicación a través de las API y tambien clases "Data transfer Object"
   * Client: interfaz que envia las peticiones a los microservicio de gas y agua.
   * helper: clases de ayuda para la validacion de los json y la decoficiacion de los errores del feign.
 

## Arquitectura del microservicio

Spring Boot es un módulo de Spring Framework. Se utiliza para crear aplicaciones independientes basadas en resortes de grado de producción con un esfuerzo mínimo. Está desarrollado sobre el núcleo Spring Framework.

Spring Boot sigue una arquitectura en capas en la que cada capa se comunica con la capa directamente debajo o encima (estructura jerárquica).

Antes de comprender la arquitectura Spring Boot , debemos conocer las diferentes capas y clases presentes en ella. Hay cuatro capas en Spring Boot que son las siguientes:

* Capa de presentación: la capa de presentación maneja las solicitudes HTTP, traduce el parámetro JSON en un objeto, autentica la solicitud y la transfiere a la capa empresarial. En resumen, consta de vistas , es decir, parte de la interfaz.

* Capa empresarial: la capa empresarial maneja toda la lógica empresarial . Consiste en clases de servicio y utiliza servicios proporcionados por capas de acceso a datos. También realiza autorización y validación .

* Capa de persistencia: la capa de persistencia contiene toda la lógica de almacenamiento y traduce los objetos comerciales desde y hacia las filas de la base de datos.

* Capa de base de datos: En la capa de base de datos, se realizan operaciones CRUD (crear, recuperar, actualizar, eliminar).


La arquitectura Spring Boot se basa en el marco Spring. Por lo tanto, usa principalmente todas las características y módulos de Spring MVC, Spring Core, etc..

El siguiente diagrama muestra el flujo de trabajo de Spring Boot.

![alt text](https://github.com/jhonfre1994/bancoABC/blob/master/imagenes/arquitectura-microservicio.png)


# Modelo base de datos:

La base de datos esta contruida en h2 para mayor facilidad. La siguiente imagen muestra el pequeño modelo de datos y un ejemplo de la información que se almacena en ella.

![alt text](https://github.com/jhonfre1994/bancoABC/blob/master/imagenes/convenios-modelo.png)

# Direccionamiento de peticiones con OpenFeign

Se usa la dependencia open feign para enrutar las peticiones a otros microservicios, la información de la base de datos sirve de  base para saber que metodo y hacia donde debe ir la petición solicitada. La unica manera de llamar una API de un microservicio es por medio de conevio-service, ya que el body que se envia en el la peticion tiene la información necesaria para saber a que microservicio dirigir la peticion final. 



## Autor ✒️

* **Jhon Freddy salamanca** - [jhonfre1994](https://github.com/jhonfre1994)

