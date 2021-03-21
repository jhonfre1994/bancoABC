CREATE TABLE IF NOT EXISTS CONVENIO (
    idConvenio SERIAL PRIMARY KEY, 
    nombreConvenio VARCHAR,
    tipoServicio VARCHAR,
    PRIMARY KEY (idConvenio)
);


CREATE TABLE IF NOT EXISTS CONVENIO_SERVICIO (
    id serial,
    idConvenio int,
    tipoOperacion VARCHAR,
    httpMethod VARCHAR ,
    httpHeader VARCHAR,
    url VARCHAR,
    PRIMARY KEY (id)
);

insert into CONVENIO(idConvenio,nombreConvenio, tipoServicio) values (1, 'Aguas y Aguas de Pereira', 'AGUA');
insert into CONVENIO(idConvenio,nombreConvenio, tipoServicio) values (2, 'Brilla', 'GAS');

insert into CONVENIO_SERVICIO(id, idConvenio, tipoOperacion, httpMethod, httpHeader, url ) values (1, 1, 'Consulta', 'GET', '', 'http://localhost:8060/agua-service/api/v.1/pagosAgua/consultarFactura');
insert into CONVENIO_SERVICIO(id, idConvenio, tipoOperacion, httpMethod, httpHeader, url ) values (2, 1, 'Pago', 'POST', '{\"Content-type\":\"application/json\"}', 'http://localhost:8060/agua-service/api/v.1/pagosAgua/pagoFactura');
insert into CONVENIO_SERVICIO(id, idConvenio, tipoOperacion, httpMethod, httpHeader, url ) values (3, 1, 'Compensacion', 'DELETE', '', 'http://localhost:8060/agua-service/api/v.1/pagosAgua/compensacionFactura');
insert into CONVENIO_SERVICIO(id, idConvenio, tipoOperacion, httpMethod, httpHeader, url ) values (4, 2, 'Consulta', 'GET', '', 'http://localhost:8060/efigas-service/api/v.1/pagosGas');
insert into CONVENIO_SERVICIO(id, idConvenio, tipoOperacion, httpMethod, httpHeader, url ) values (5, 2, 'Pago', 'POST', '{\"Content-type\":\"application/json\"}', 'http://localhost:8060/efigas-service/api/v.1/pagosGas');


