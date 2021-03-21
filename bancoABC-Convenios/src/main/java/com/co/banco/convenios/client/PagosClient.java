/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.client;

import feign.RequestLine;
import java.net.URI;

/**
 *
 * @author jhonfre
 */
public interface PagosClient {

    @RequestLine("GET")
    String findByDepartment(URI baseUri);

}
