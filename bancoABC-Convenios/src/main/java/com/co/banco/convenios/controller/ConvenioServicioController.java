/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.controller;

import com.google.gson.Gson;
import com.co.banco.convenios.helpers.JsonHelper;
import com.co.banco.convenios.model.ConsultarFacturaResponse;
import com.co.banco.convenios.model.ConvenioServicioDTO;
import com.co.banco.convenios.model.DatosTransaccion;
import com.co.banco.convenios.model.ErrorModel;
import com.co.banco.convenios.model.PagoCompensacionResponse;
import com.co.banco.convenios.services.ConvenioServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.awt.print.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Operation(summary = "Metodo para iniciar una transaccion")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Devuelve una respuesta dependiendo del tipo de operacion solicitada",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(oneOf = {
                        ConsultarFacturaResponse.class, PagoCompensacionResponse.class}))}),

        @ApiResponse(responseCode = "400", description = "Ocuerrio un error al validar la información suministrada en el body",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorModel.class))}),

        @ApiResponse(responseCode = "404", description = "No encontro la información del convenio en la base de datos",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorModel.class)))})
    @GetMapping()
    public ResponseEntity<?> consultarConvenio(@RequestBody DatosTransaccion data) {
        JsonHelper myJsonHelper2 = new JsonHelper(data);
        myJsonHelper2.validateSchema("convenio\\validateDataTransaccion.json");
        return ResponseEntity.ok(convenioServicioService.realizarTransaccion(data));
    }

    @GetMapping("error")
    public ResponseEntity<?> error() {
        return ResponseEntity.ok("");
    }
}
