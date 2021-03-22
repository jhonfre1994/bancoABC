/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.efigas.service.impl;

import com.co.efigas.model.DatosTransaccion;
import com.co.efigas.model.ResultadoConsultaRequest;
import com.co.efigas.model.ResultadoPagoRequest;
import com.co.efigas.service.PagoGasService;
import com.intempo.intempo.ObjectFactory;
import com.intempo.intempo.Pago;
import com.intempo.intempo.ReferenciaFactura;
import com.intempo.intempo.ResultadoConsulta;
import javax.xml.bind.JAXBElement;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhonfre
 */
@Service
public class PagoGasServiceImpl implements PagoGasService {

    @Override
    public ResultadoConsultaRequest consultarFactura(DatosTransaccion data) {
        ResultadoConsulta consultaFactura = new ResultadoConsulta();
        consultaFactura.setTotalPagar(0.0);
        ReferenciaFactura referenciaFactura = new ReferenciaFactura();
        referenciaFactura.setReferenciaFactura(data.getIdentificacion());
        consultaFactura.setReferenciaFactura(referenciaFactura);
        ObjectFactory consulta = new ObjectFactory();
        JAXBElement<ResultadoConsulta> resultado = consulta.createResultadoConsulta(consultaFactura);
        ResultadoConsultaRequest res = new ResultadoConsultaRequest(resultado.getValue().getTotalPagar(),
                resultado.getValue().getReferenciaFactura().getReferenciaFactura());
        return res;
    }

    @Override
    public ResultadoPagoRequest pagarFactura(DatosTransaccion data) {
        Pago pagoFactura = new Pago();
        pagoFactura.setTotalPagar(0.0);
        ReferenciaFactura referenciaFactura = new ReferenciaFactura();
        referenciaFactura.setReferenciaFactura(data.getIdentificacion());
        pagoFactura.setReferenciaFactura(referenciaFactura);
        ObjectFactory consulta = new ObjectFactory();
        JAXBElement<Pago> resultado = consulta.createPago(pagoFactura);
        ResultadoPagoRequest res = new ResultadoPagoRequest(resultado.getValue().getTotalPagar(),
                resultado.getValue().getReferenciaFactura().getReferenciaFactura());
        return res;
    }

}
