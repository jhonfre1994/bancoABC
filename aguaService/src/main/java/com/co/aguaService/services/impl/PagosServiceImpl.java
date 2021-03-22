/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.aguaService.services.impl;

import com.co.aguaService.exceptions.responses.HttpResponseException;
import com.co.aguaService.model.DatosTransaccion;
import com.co.aguaService.services.PagosService;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhonfre
 */
@Service
public class PagosServiceImpl implements PagosService {

    @Value("${apiAguas.url}")
    private String serverURL;

    @Override
    public String consultarFactura(DatosTransaccion data) {
        try {
            String url = this.serverURL + String.valueOf(data.getReferenciaFactura());
            HttpResponse<JsonNode> response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .asJson();
            if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
                throw new HttpResponseException(response.getStatus(), url, "La factura no existe");
            } else if (response.getStatus() != HttpStatus.OK.value()) {
                throw new HttpResponseException(response.getStatus(), url, response.getStatusText());
            }
            return response.getBody().getObject().toString();
        } catch (UnirestException e) {
            String message = "Error interno del sistema durante la obtención de la factura";
            throw new HttpResponseException(500, "", message);
        }
    }

    @Override
    public String pagarFactura(DatosTransaccion data) {
        try {
            String url = this.serverURL + String.valueOf(data.getReferenciaFactura());
            HttpResponse<JsonNode> response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .asJson();
            if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
                throw new HttpResponseException(response.getStatus(), url, response.getBody().getObject().getString("mensajeBad"));
            } else if (response.getStatus() != HttpStatus.OK.value()) {
                throw new HttpResponseException(response.getStatus(), url, response.getStatusText());
            }
            return response.getBody().getObject().toString();
        } catch (UnirestException e) {
            String message = "Error interno del sistema durante la obtención de la factura";
            throw new HttpResponseException(500, "", message);
        }
    }

    @Override
    public String compensacionFactura(DatosTransaccion data) {
        try {
            String url = this.serverURL + String.valueOf(data.getReferenciaFactura());
            HttpResponse<JsonNode> response = Unirest.delete(url)
                    .header("Content-Type", "application/json")
                    .asJson();

            if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
                throw new HttpResponseException(response.getStatus(), url, response.getBody().getObject().getJSONObject("mensajeBad").toString());
            } else if (response.getStatus() != HttpStatus.OK.value()) {
                throw new HttpResponseException(response.getStatus(), url, response.getStatusText());
            }
            return response.getBody().getObject().toString();
        } catch (UnirestException e) {
            String message = "Error interno del sistema durante la obtención de la factura";
            throw new HttpResponseException(500, "", message);
        }
    }

}
