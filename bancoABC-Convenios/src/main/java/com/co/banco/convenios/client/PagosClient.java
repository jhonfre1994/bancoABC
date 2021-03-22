/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.client;

import com.co.banco.convenios.model.DatosTransaccion;
import feign.Headers;
import feign.RequestLine;
import java.net.URI;

/**
 *
 * @author jhonfre
 */
@Headers("Reference: convenio-service")
public interface PagosClient {

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    public String crearTransaccion(URI baseUri, DatosTransaccion data);

}
