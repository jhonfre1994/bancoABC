/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.model;

import java.io.Serializable;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jhonfre
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConvenioServicioDTO {

    private String nombreConvenio;
    private String tipoServicio;
    private String tipoOperacion;
    private String httpMethod;
    private String httpHeader;
    private String url;

    public ConvenioServicioDTO(Map<String, Object> values) {
        this.nombreConvenio = values.get("nombreConvenio") != null ? (String) values.get("nombreConvenio") : null;
        this.tipoServicio = values.get("tipoServicio") != null ? (String) values.get("tipoServicio") : null;
        this.tipoOperacion = values.get("tipoOperacion") != null ? (String) values.get("tipoOperacion") : null;
        this.httpMethod = values.get("httpMethod") != null ? (String) values.get("httpMethod") : null;
        this.httpHeader = values.get("httpHeader") != null ? (String) values.get("httpHeader") : null;
        this.url = values.get("url") != null ? (String) values.get("url") : null;

    }
}
