/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.services.impl;

import com.co.banco.convenios.exceptions.responses.BadRequestException;
import com.co.banco.convenios.model.ConvenioServicioDTO;
import com.co.banco.convenios.model.DatosTransaccion;
import com.co.banco.convenios.repository.ConvenioServicioRepository;
import com.co.banco.convenios.services.ConvenioServicioService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhonfre
 */
@Service
public class ConverServiceImpl implements ConvenioServicioService {

    @Autowired
    private ConvenioServicioRepository convenioServiceRepository;

    @Override
    public ConvenioServicioDTO consultarConvenioServicio(String convenio, String nombreOperacion, String tiposervicio) {
        try {
            Map<String, Object> entityResult = convenioServiceRepository.consultarInformacionConvenio(convenio, nombreOperacion, tiposervicio);
            if (entityResult.isEmpty()) {
                throw new BadRequestException("Ocurrio un error al conusltar la información del convenio");
            }
            ConvenioServicioDTO convenioData = new ConvenioServicioDTO(entityResult);
            return convenioData;
        } catch (Exception e) {
            throw new BadRequestException("Ocurrio un error al conusltar la información del convenio");
        }

    }

    @Override
    public ConvenioServicioDTO realizarTransaccion(DatosTransaccion datos) {
        ConvenioServicioDTO res = consultarConvenioServicio(datos.getNombreConvenio(), datos.getOperacion(), datos.getTipoConvenio());
        return res;
    }

}
