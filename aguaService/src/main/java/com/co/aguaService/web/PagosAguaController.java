/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.aguaService.web;

import com.co.aguaService.model.ConsultarFacturaResponse;
import com.co.aguaService.model.DatosTransaccion;
import com.co.aguaService.model.ErrorModel;
import com.co.aguaService.model.PagoCompensacionResponse;
import com.co.aguaService.services.PagosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Servicio que consume un servicio externo de la empresa de agua"
            + "para consultar la cantidad a pagar de una factura")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna el precio a pagar de la factura",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsultarFacturaResponse.class))}),

        @ApiResponse(responseCode = "400", description = "La factura no existe",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorModel.class))}),

        @ApiResponse(responseCode = "500", description = "Ocurrio un error al intentar consumir el servicio externo",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorModel.class)))})
    @PostMapping("consultarFactura")
    public ResponseEntity<?> consultarPago(@RequestBody DatosTransaccion datosTransaccion) {
//        String json = "{\n"
//                + "  \"idFactura\": \"123456789\",\n"
//                + "  \"valorFactura\" : 250000\n"
//                + "}";
//        return ResponseEntity.ok(json);
        return ResponseEntity.ok(pagosService.consultarFactura(datosTransaccion));
    }

    @Operation(summary = "Servicio que consume un servicio externo de la empresa de agua"
            + "para pagar una factura")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna mensaje de exito si el proceso lo realiza "
                + "correctamente",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PagoCompensacionResponse.class))}),

        @ApiResponse(responseCode = "400", description = "Ocurrio un error al intentar pagar la factura",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorModel.class))}),

        @ApiResponse(responseCode = "500", description = "Ocurrio un error al intentar consumir el servicio externo",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorModel.class)))})

    @PostMapping("pagoFactura")
    public ResponseEntity<?> efectuarPago(@RequestBody DatosTransaccion datosTransaccion) {
//        String json = "{\n"
//                + "  \"idFactura\": \"123456789\",\n"
//                + "  \"mensajeOK\" : \"Facttura pagada correctamente\"\n"
//                + "}";
//        return ResponseEntity.ok(json);
        return ResponseEntity.ok(pagosService.pagarFactura(datosTransaccion));
    }

    @Operation(summary = "Servicio que consume un servicio externo de la empresa de agua"
            + "para compensar una factura")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna mensaje de exito si el proceso lo realiza "
                + "correctamente",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PagoCompensacionResponse.class))}),

        @ApiResponse(responseCode = "400", description = "La factura no existe",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorModel.class))}),

        @ApiResponse(responseCode = "500", description = "Ocurrio un error al intentar consumir el servicio externo",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorModel.class)))})
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
