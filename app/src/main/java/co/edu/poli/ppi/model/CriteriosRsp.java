/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.poli.ppi.model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Rosemberg
 */
public class CriteriosRsp {
    private Integer idCriterio;
    private String nombre;
    private String descripcion;
    private List<EscalaValoresRsp> escalaValores =  new ArrayList<>();

    public Integer getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<EscalaValoresRsp> getEscalaValores() {
        return escalaValores;
    }

    public void setEscalaValores(EscalaValoresRsp escalaValores) {
        this.escalaValores.add(escalaValores);
    }
    
    
    
}
