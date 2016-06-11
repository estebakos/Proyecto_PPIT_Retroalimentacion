package co.edu.poli.ppi.model;

import android.location.Criteria;

import java.util.List;

/**
 * Created by TEBAN on 4/06/2016.
 */
public class Evaluation {

    private EvaluadoresRsp teacherName;

    public co.edu.poli.ppi.model.Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(co.edu.poli.ppi.model.Criteria criteria) {
        this.criteria = criteria;
    }

    private co.edu.poli.ppi.model.Criteria criteria;
    private List<CriteriosRsp> listCriterial;

    public List<CriteriosRsp> getListCriterial() {
        return listCriterial;
    }

    public void setListCriterial(List<CriteriosRsp> listCriterial) {
        this.listCriterial = listCriterial;
    }
}
