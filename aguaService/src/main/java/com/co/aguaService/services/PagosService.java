/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.aguaService.services;

import com.co.aguaService.model.DatosTransaccion;

/**
 *
 * @author jhonfre
 */
public interface PagosService {

    String consultarFactura(DatosTransaccion data);

    String pagarFactura(DatosTransaccion data);

    String compensacionFactura(DatosTransaccion data);

}
