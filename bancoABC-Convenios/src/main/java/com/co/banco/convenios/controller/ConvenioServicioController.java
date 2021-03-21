/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.controller;

import com.google.gson.Gson;
import com.co.banco.convenios.helpers.JsonHelper;
import com.co.banco.convenios.model.ConvenioServicioDTO;
import com.co.banco.convenios.model.DatosTransaccion;
import com.co.banco.convenios.services.ConvenioServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhonfre
 */
@RestController
@RequestMapping("/api/v.1/transaccion")
public class ConvenioServicioController {

    @Autowired
    private ConvenioServicioService convenioServicioService;

    @GetMapping()
    public ResponseEntity<?> consultarConvenio(@RequestBody String jsonString) {

        JsonHelper myJsonHelper2 = new JsonHelper(jsonString);
        myJsonHelper2.validateSchema("convenio\\validateDataTransaccion.json");
        DatosTransaccion data = new Gson().fromJson(jsonString, DatosTransaccion.class);
        return ResponseEntity.ok(convenioServicioService.realizarTransaccion(data));
    }

}
