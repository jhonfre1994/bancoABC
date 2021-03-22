/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.efigas.web;

import com.co.efigas.model.DatosTransaccion;
import com.co.efigas.model.ResultadoConsultaRequest;
import com.co.efigas.model.ResultadoPagoRequest;
import com.co.efigas.service.PagoGasService;
import com.intempo.intempo.ObjectFactory;
import com.intempo.intempo.ReferenciaFactura;
import com.intempo.intempo.ResultadoConsulta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhonfre
 */
@RestController
@RequestMapping("/api/v.1/pagosGas")
public class PagosGasController {

    @Autowired
    private PagoGasService gasService;

    @Operation(summary = "Servicio que consume un servicio externo de la empresa de gas"
            + "para consultar la factura")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna mensaje con el valor y la"
                + "referencia de la factura",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResultadoConsultaRequest.class))})})
    @PostMapping("consultarFactura")
    public ResponseEntity<?> consultarPago(@RequestBody DatosTransaccion data) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(gasService.consultarFactura(data));
    }

    @Operation(summary = "Servicio que consume un servicio externo de la empresa de gas"
            + "para pagar la factura")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna mensaje con el valor y la"
                + "referencia de la factura",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResultadoPagoRequest.class))})})
    @PostMapping("pagoFactura")
    public ResponseEntity<?> pagoFactura(@RequestBody DatosTransaccion data) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(gasService.pagarFactura(data));
    }

}
