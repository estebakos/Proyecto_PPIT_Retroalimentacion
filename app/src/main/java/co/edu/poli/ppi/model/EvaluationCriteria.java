package co.edu.poli.ppi.model;

import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TEBAN on 4/06/2016.
 */
public class EvaluationCriteria {
    private CriteriosRsp criteria;
    private String evaluatorName;
    private int evaluator;
    private List<RadioButton> radioButtons = new ArrayList<>();

    public List<RadioButton> getRadioButtons() {
        return radioButtons;
    }

    public void setRadioButtons(List<RadioButton> radioButtons) {
        this.radioButtons = radioButtons;
    }

    public int getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(int evaluator) {
        this.evaluator = evaluator;
    }


    public CriteriosRsp getCriteria() {
        return criteria;
    }

    public void setCriteria(CriteriosRsp criteria) {
        this.criteria = criteria;
    }

    public String getEvaluatorName() {
        return evaluatorName;
    }

    public void setEvaluatorName(String evaluatorName) {
        this.evaluatorName = evaluatorName;
    }

}

