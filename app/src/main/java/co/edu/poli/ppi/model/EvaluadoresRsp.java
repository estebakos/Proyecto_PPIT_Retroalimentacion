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
    public class EvaluadoresRsp {

    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private List<CriteriosRsp> criterios = new ArrayList<>();

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<CriteriosRsp> getCriterios() {
        return criterios;
    }

    public void setCriterios(CriteriosRsp criterios) {
        this.criterios.add(criterios);
    }
    
    
}
