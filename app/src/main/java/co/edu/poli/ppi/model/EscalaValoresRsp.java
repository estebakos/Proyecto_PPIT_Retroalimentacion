/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.poli.ppi.model;

/**
 *
 * @author Rosemberg
 */
public class EscalaValoresRsp {
    
    private Integer idEscalaValor;
    private String nombre;
    private String descripcion;
    private double puntos;

    public Integer getIdEscalaValor() {
        return idEscalaValor;
    }

    public void setIdEscalaValor(Integer idEscalaValor) {
        this.idEscalaValor = idEscalaValor;
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

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }
    
}
