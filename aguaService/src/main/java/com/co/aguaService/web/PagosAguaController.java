/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.aguaService.web;

import com.co.aguaService.model.DatosTransaccion;
import com.co.aguaService.services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhonfre
 */
@RestController
@RequestMapping("/api/v.1/pagosAgua")
public class PagosAguaController {

    @Autowired
    private PagosService pagosService;

    @PostMapping("consultarFactura")
    public ResponseEntity<?> consultarPago(@RequestBody DatosTransaccion datosTransaccion) {
//        String json = "{\n"
//                + "  \"idFactura\": \"123456789\",\n"
//                + "  \"valorFactura\" : 250000\n"
//                + "}";
//        return ResponseEntity.ok(json);
        return ResponseEntity.ok(pagosService.consultarFactura(datosTransaccion));
    }

    @PostMapping("pagoFactura")
    public ResponseEntity<?> efectuarPago(@RequestBody DatosTransaccion datosTransaccion) {
//        String json = "{\n"
//                + "  \"idFactura\": \"123456789\",\n"
//                + "  \"mensajeOK\" : \"Facttura pagada correctamente\"\n"
//                + "}";
//        return ResponseEntity.ok(json);
        return ResponseEntity.ok(pagosService.pagarFactura(datosTransaccion));
    }

    @PostMapping("compensacionFactura")
    public ResponseEntity<?> compensacionFactura(@RequestBody DatosTransaccion datosTransaccion) {
//        String json = "{\n"
//                + "  \"idFactura\": \"123456789\",\n"
//                + "  \"mensajeOK\" : \"Facttura compensada correctamente\"\n"
//                + "}";
//        return ResponseEntity.ok(json);
        return ResponseEntity.ok(pagosService.compensacionFactura(datosTransaccion));
    }

}
