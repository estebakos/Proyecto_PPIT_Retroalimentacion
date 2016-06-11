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
public class SocializacionResp {
    private int idSocializacion;
    private String nombreSocicalizacion;
    private int id_formato;
    private List<EvaluadoresRsp> evaluadores = new ArrayList<>();

    public void SocializacionResp(){
    }

    public int getIdSocializacion() {
        return idSocializacion;
    }

    public void setIdSocializacion(int idSocializacion) {
        this.idSocializacion = idSocializacion;
    }
    public String getNombreSocicalizacion() {
        return nombreSocicalizacion;
    }

    public void setNombreSocicalizacion(String nombreSocicalizacion) {
        this.nombreSocicalizacion = nombreSocicalizacion;
    }

    public List<EvaluadoresRsp> getEvaluadores() {
        return evaluadores;
    }

    public void setEvaluadores(EvaluadoresRsp evaluadores) {
        this.evaluadores.add(evaluadores);
    }

    public int getId_formato() {
        return id_formato;
    }

    public void setId_formato(int id_formato) {
        this.id_formato = id_formato;
    }
    
    
    
}
