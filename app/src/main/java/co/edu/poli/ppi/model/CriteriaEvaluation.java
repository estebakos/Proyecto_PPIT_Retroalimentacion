package co.edu.poli.ppi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TEBAN on 9/06/2016.
 */
public class CriteriaEvaluation {

    private int criteria;
    private int socialization;
    private List<teacher_value> teacher_values = new ArrayList<>();

    public int getCriteria() {
        return criteria;
    }

    public void setCriteria(int criteria) {
        this.criteria = criteria;
    }

    public int getSocialization() {
        return socialization;
    }

    public void setSocialization(int socialization) {
        this.socialization = socialization;
    }

    public List<teacher_value> getTeacher_values() {
        return teacher_values;
    }

    public void setTeacher_values(List<teacher_value> teacher_values) {
        this.teacher_values = teacher_values;
    }
}
