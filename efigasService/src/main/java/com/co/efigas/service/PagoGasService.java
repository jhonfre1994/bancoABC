/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.efigas.service;

import com.co.efigas.model.DatosTransaccion;
import com.co.efigas.model.ResultadoConsultaRequest;
import com.co.efigas.model.ResultadoPagoRequest;

/**
 *
 * @author jhonfre
 */
public interface PagoGasService {

    ResultadoConsultaRequest consultarFactura(DatosTransaccion data);

    ResultadoPagoRequest pagarFactura(DatosTransaccion data);

}
