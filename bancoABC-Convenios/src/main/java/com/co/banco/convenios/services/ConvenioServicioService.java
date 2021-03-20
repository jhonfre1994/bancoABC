/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.services;

import com.co.banco.convenios.model.ConvenioServicioDTO;
import com.co.banco.convenios.model.DatosTransaccion;

/**
 *
 * @author jhonfre
 */
public interface ConvenioServicioService {
    
    ConvenioServicioDTO consultarConvenioServicio(String convenio, String nombreOperacion, String tiposervicio);
    
    ConvenioServicioDTO realizarTransaccion(DatosTransaccion datos);
}
