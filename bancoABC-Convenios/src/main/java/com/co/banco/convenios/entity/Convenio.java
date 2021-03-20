/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "CONVENIO")
public class Convenio {

    @Id
    @Column(name = "idConvenio")
    private int idConvevio;
    @Column(name = "nombreConvenio")
    private String nombreConvenio;
}
