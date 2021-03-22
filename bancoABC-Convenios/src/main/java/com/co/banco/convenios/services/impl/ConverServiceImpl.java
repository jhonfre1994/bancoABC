/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.services.impl;

import com.co.banco.convenios.model.ConvenioServicioDTO;
import com.co.banco.convenios.model.DatosTransaccion;
import com.co.banco.convenios.repository.ConvenioServicioRepository;
import com.co.banco.convenios.services.ConvenioServicioService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.banco.convenios.client.PagosClient;
import com.co.banco.convenios.exceptions.responses.HttpResponseException;
import com.co.banco.convenios.helpers.ErrorDecoderFeign;
import feign.Feign;
import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import feign.jackson.JacksonEncoder;

/**
 *
 * @author jhonfre
 */
@Service
public class ConverServiceImpl implements ConvenioServicioService {

    @Autowired
    private ConvenioServicioRepository convenioServiceRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${url.gateway}")
    private String urlGateway;

    public ConvenioServicioDTO consultarConvenioServicio(String convenio, String nombreOperacion, String tiposervicio) {
        try {
            Map<String, Object> entityResult = convenioServiceRepository.consultarInformacionConvenio(convenio, nombreOperacion, tiposervicio);
            if (entityResult.isEmpty()) {
                throw new HttpResponseException(404, "", "Ocurrio un error al consultar la información del convenio");
            }
            ConvenioServicioDTO convenioData = new ConvenioServicioDTO(entityResult);
            return convenioData;
        } catch (Exception e) {
            throw new HttpResponseException(400, "", "Ocurrio un error al consultar la información del convenio");
        }
    }

    @Override
    public String realizarTransaccion(DatosTransaccion datos) {

        ConvenioServicioDTO res = consultarConvenioServicio(datos.getNombreConvenio(), datos.getOperacion(), datos.getTipoConvenio());
        URI uri = URI.create(urlGateway + res.getUrl());
        PagosClient client = Feign.builder()
                .encoder(new JacksonEncoder())
                .errorDecoder(new ErrorDecoderFeign())
                .target(PagosClient.class, urlGateway);
        return client.crearTransaccion(uri, datos);
    }

}
