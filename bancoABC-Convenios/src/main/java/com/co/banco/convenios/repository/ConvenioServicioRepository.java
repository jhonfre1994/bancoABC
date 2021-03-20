/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.repository;

import com.co.banco.convenios.entity.ConvenioServicio;
import com.co.banco.convenios.model.ConvenioServicioDTO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhonfre
 */
@Repository
public interface ConvenioServicioRepository extends JpaRepository<ConvenioServicio, Integer> {

    @Query(value = "SELECT con.nombreConvenio as nombreConvenio, con.tipoServicio as tipoServicio, cons.tipoOperacion as tipoOperacion, "
            + "cons.httpMethod as httpMethod , cons.httpHeader as httpHeader, cons.url as url from convenio_servicio cons\n"
            + "INNER JOIN convenio con ON con.idConvenio = cons.idConvenio\n"
            + "where con.nombreConvenio = :nombreConvenio and cons.tipoOperacion = :tipoOperacion and con.tiposervicio = :tiposervicio", nativeQuery = true)
    Map<String, Object> consultarInformacionConvenio(@Param("nombreConvenio") String nombreConvenio, 
            @Param("tipoOperacion") String tipoOperacion, @Param("tiposervicio") String tiposervicio);

}
