package co.edu.poli.ppi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TEBAN on 10/06/2016.
 */
public class Retroalimentacion {
    private int socializacion;
    private int criterio;
    private List<RetroalimentacionValor> retroalimentacionValor = new ArrayList<>();

    public int getSocializacion() {
        return socializacion;
    }

    public void setSocializacion(int socializacion) {
        this.socializacion = socializacion;
    }

    public int getCriterio() {
        return criterio;
    }

    public void setCriterio(int criterio) {
        this.criterio = criterio;
    }

    public List<RetroalimentacionValor> getRetroalimentacionValor() {
        return retroalimentacionValor;
    }

    public void setRetroalimentacionValor(List<RetroalimentacionValor> retroalimentacionValor) {
        this.retroalimentacionValor = retroalimentacionValor;
    }
}
