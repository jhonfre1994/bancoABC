/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.aguaService.model;

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
public class DatosTransaccion {

    private String tipoIdentificacion;
    private String identificacion;
    private String nombreConvenio;
    private String tipoConvenio;
    private String operacion;

}
