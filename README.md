# BANCO ABC

# ARQUITECTURA 馃捇

Se decide trabajar con una arquitectura de microservicios, esto nos ofrece una mayor escalabilidad a medida que se a帽aden nuevos convenios, cada convenio es un microservicio, de esta manera se puede gestionar cada convenio dependiendo del contrato que se entregue, tambien permite que cada microservicio sea desplegado de manera independiente y que cada uno tenga su propia base de datos. El uso de contenedores permite el despliegue de los servicios r谩pidamente.

El siguiente diagrama muestra la arquitectura propuesta para la solucion.

![alt text](https://github.com/jhonfre1994/bancoABC/blob/master/imagenes/arquitectura.png)

### Eureka 
Para el registro y localizaci贸n de microservicios se creo un servidor eureka. La funci贸n de Eureka es registrar las diferentes instancias de microservicios existentes, su localizaci贸n, estado, metadatos.

Cada microservicio, durante su arranque, se comunicar谩 con el servidor Eureka para notificar que est谩 disponible, d贸nde est谩 situado, sus metadato. De esta forma Eureka mantendr谩 en su registro la informaci贸n de todos los microservicios del ecosistema.

### Config-server

es un servidor de configuraci贸n pensado para sistemas distribuidos. Su funci贸n es almacenar las propiedades de configuraci贸n de los microservicios del ecosistema. Cuando se lanza un microservicio este se dirige al servidor de configuracion y toma su correspondiente archivo de configuracion (application.properties).

### Gateway

Zuul Server es una aplicaci贸n API Gateway. Maneja todas las solicitudes y realiza el enrutamiento din谩mico de aplicaciones de microservicio. Funciona como puerta de entrada para todas las solicitudes. Tambi茅n se conoce como servidor perimetral.


# OPEN-API

Para la definici贸n y documentaci贸n de las APIs se usa **open-api**, adicionalmente de documentan los controladores con las etiquetas de swagger para tener una mayor especificaci贸n de las APIs expuestas.

La documentacion esta en la carpeta [definicionContratosApi](https://github.com/jhonfre1994/bancoABC/tree/master/definicionContratosApi)

# SERVICIOS IMPLEMENTADOS

* [convevio-service](https://github.com/jhonfre1994/bancoABC/tree/master/bancoABC-Convenios) : gestiona y persiste la informaci贸n de los convenios, tambien tiene el papel de orquestador.
* [efigas-service](https://github.com/jhonfre1994/bancoABC/tree/master/efigasService) : transforma la informaci贸n recibida de acuerdo a los wsdl suministrados.
* [agua-service](https://github.com/jhonfre1994/bancoABC/tree/master/aguaService) : reenvia la informaci贸n necesaria a las APIs REST externas suminitradas en el archivo api.raml.

**NOTA: Dentro de la carpeta de cada microservicio se encuentra informaci贸n mas detallada sobre su contrucci贸n.**

## DOCKER

Se crean contenedores docker independientes para cada servicio.

## Autor 鉁掞笍

* **Jhon Freddy salamanca** - [jhonfre1994](https://github.com/jhonfre1994)

