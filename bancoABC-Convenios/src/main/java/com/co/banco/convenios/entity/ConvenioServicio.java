/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jhonfre
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CONVENIO_SERVICIO")
public class ConvenioServicio {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "idConvenio")
    private Integer idConvenio;
    @Column(name = "tipoOperacion")
    private String tipoOperacion;
    @Column(name="httpMethod")
    private String httpMethod;
    @Column(name="httpHeader")
    private String httpHeader;
    @Column(name = "url")
    private String url;
}
