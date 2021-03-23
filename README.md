# BANCO ABC

# ARQUITECTURA 💻

Se decide trabajar con una arquitectura de microservicios, esto nos ofrece una mayor escalabilidad a medida que se añaden nuevos convenios, cada convenio es un microservicio, de esta manera se puede gestionar cada convenio dependiendo del contrato que se entregue, tambien permite que cada microservicio sea desplegado de manera independiente y que cada uno tenga su propia base de datos. El uso de contenedores permite el despliegue de los servicios rápidamente.

El siguiente diagrama muestra la arquitectura propuesta para la solucion.

![alt text](https://github.com/jhonfre1994/bancoABC/blob/master/imagenes/arquitectura.png)

### Eureka 
Para el registro y localización de microservicios se creo un servidor eureka. La función de Eureka es registrar las diferentes instancias de microservicios existentes, su localización, estado, metadatos.

Cada microservicio, durante su arranque, se comunicará con el servidor Eureka para notificar que está disponible, dónde está situado, sus metadato. De esta forma Eureka mantendrá en su registro la información de todos los microservicios del ecosistema.

### Config-server

es un servidor de configuración pensado para sistemas distribuidos. Su función es almacenar las propiedades de configuración de los microservicios del ecosistema. Cuando se lanza un microservicio este se dirige al servidor de configuracion y toma su correspondiente archivo de configuracion (application.properties).

### Gateway

Zuul Server es una aplicación API Gateway. Maneja todas las solicitudes y realiza el enrutamiento dinámico de aplicaciones de microservicio. Funciona como puerta de entrada para todas las solicitudes. También se conoce como servidor perimetral.


# OPEN-API

Para la definición y documentación de las APIs se usa **open-api**, adicionalmente de documentan los controladores con las etiquetas de swagger para tener una mayor especificación de las APIs expuestas.

La documentacion esta en la carpeta [definicionContratosApi](https://github.com/jhonfre1994/bancoABC/tree/master/definicionContratosApi)

# SERVICIOS IMPLEMENTADOS

[convevio-service](https://github.com/jhonfre1994/bancoABC/tree/master/bancoABC-Convenios) : gestiona y persiste la información de los convenios, tambien tiene el papel de orquestador.
[efigas-service](https://github.com/jhonfre1994/bancoABC/tree/master/efigasService) : transforma la información recibida de acuerdo a los wsdl suministrados.
[agua-service](https://github.com/jhonfre1994/bancoABC/tree/master/aguaService) : reenvia la información necesaria a las APIs REST externas suminitradas en el archivo api.raml.

**NOTA: Dentro de la carpeta de cada microservicio encontrara información mas detallada sobre su contrucción.**

## DOCKER

Se crean contenedores docker independientes para cada servicio.

## Autor ✒️

* **Jhon Freddy salamanca** - [jhonfre1994](https://github.com/jhonfre1994)

