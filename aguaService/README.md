# AGUA SERVICE

Microservicio para el manejo de las facturas de gas.

## Funcionalidades 

* transformar la informacion suministrada por parte del servicio de convenio service.
* ejecutar los servicios suminiatrados en los archivos pagos.wsdl

## Construido con 🛠️

Este proyecto esta construido con las siguientes tecnologias:

## Backend y dependencias

* Java 1.8
* Spring MVC with Spring Boot
* Maven
* eureka client
* openapi-ui
* Spring cloud


### El microservicio de gas esta compuesto por lo siguientes paquetes:
   * Web: Responde a eventos lanzados por el usuario desde la web
   * Exceptions: clases para capturar excepciones HTTP de manera personalizada.
   * Model: Objetos que se usan para la comunicación a través de las API.
   * Service: capa de servicio que maneja la logica de negocio.
   

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

## Autor ✒️

* **Jhon Freddy salamanca** - [jhonfre1994](https://github.com/jhonfre1994)

