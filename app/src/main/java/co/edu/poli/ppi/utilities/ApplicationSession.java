package co.edu.poli.ppi.utilities;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ppi.model.EvaluadoresRsp;
import co.edu.poli.ppi.model.Evaluation;
import co.edu.poli.ppi.model.Evaluator;
import co.edu.poli.ppi.model.Retroalimentacion;
import co.edu.poli.ppi.model.SocializacionResp;
import co.edu.poli.ppi.ui.EvaluationAdapter;
import co.edu.poli.ppi.ui.EvaluationStep;

/**
 * Created by TEBAN on 4/06/2016.
 */
public class ApplicationSession {

    private static int evaluationStep = 0;
    private static List<Evaluation> evaluationList;
    private static List<EvaluadoresRsp> evaluators;
    private static EvaluationStep evaluationStepInstance;
    private static String idToken = "1";
    private static List<EvaluationAdapter.EvaluationViewHolder> evaluationViewHolder = new ArrayList<>();
    private static String token;
    private static SocializacionResp socializacionResp;
    private static Retroalimentacion retroalimentacion;
    private static boolean readyToGetNote;

    public static Retroalimentacion getRetroalimentacion() {
        return retroalimentacion;
    }

    public static void setRetroalimentacion(Retroalimentacion retroalimentacion) {
        ApplicationSession.retroalimentacion = retroalimentacion;
    }

    public static SocializacionResp getSocializacionResp() {
        return socializacionResp;
    }

    public static void setSocializacionResp(SocializacionResp socializacionResp) {
        ApplicationSession.socializacionResp = socializacionResp;
    }

    public static List<EvaluationAdapter.EvaluationViewHolder> getEvaluationViewHolder() {
        return evaluationViewHolder;
    }

    public static void setEvaluationViewHolder(List<EvaluationAdapter.EvaluationViewHolder> evaluationViewHolder) {
        ApplicationSession.evaluationViewHolder = evaluationViewHolder;
    }

    private static  int evaluationSteps = 0;

    public static int getEvaluationSteps() {
        return evaluationSteps;
    }

    public static void setEvaluationSteps(int evaluationSteps) {
        ApplicationSession.evaluationSteps = evaluationSteps;
    }

    public static void setToken(String token) {
        ApplicationSession.token = token;
    }

    public static String getToken() {
        return token;
    }

    public static void setReadyToGetNote(boolean readyToGetNote) {
        ApplicationSession.readyToGetNote = readyToGetNote;
    }

    public static boolean isReadyToGetNote() {
        return readyToGetNote;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public static EvaluationStep getEvaluationStepInstance() {
        return evaluationStepInstance;
    }

    public static void setEvaluationStepInstance(EvaluationStep evaluationStepInstance) {
        ApplicationSession.evaluationStepInstance = evaluationStepInstance;
    }

    public static List<EvaluadoresRsp> getEvaluators() {
        return evaluators;
    }

    public static void setEvaluators(List<EvaluadoresRsp> evaluators) {
        ApplicationSession.evaluators = evaluators;
    }

    public static int getEvaluationStep() {
        return evaluationStep;
    }

    public static void setEvaluationStep(int evaluationStep) {
        ApplicationSession.evaluationStep = evaluationStep;
    }

    public static List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public static void setEvaluationList(List<Evaluation> evaluationList) {
        ApplicationSession.evaluationList = evaluationList;
    }
}
