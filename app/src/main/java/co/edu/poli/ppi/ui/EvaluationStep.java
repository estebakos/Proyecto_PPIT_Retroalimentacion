package co.edu.poli.ppi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ppi.R;
import co.edu.poli.ppi.model.EscalaValoresRsp;
import co.edu.poli.ppi.model.EvaluadoresRsp;
import co.edu.poli.ppi.model.EvaluationCriteria;
import co.edu.poli.ppi.model.Retroalimentacion;
import co.edu.poli.ppi.model.RetroalimentacionValor;
import co.edu.poli.ppi.model.SocializacionResp;
import co.edu.poli.ppi.network.NetworkManager;
import co.edu.poli.ppi.network.listeners.MenuListenr;
import co.edu.poli.ppi.utilities.AppContext;
import co.edu.poli.ppi.utilities.ApplicationSession;
import co.edu.poli.ppi.utilities.wizard.Wizard;
import co.edu.poli.ppi.utilities.wizard.WizardStep;

/**
 * Created by TEBAN on 4/06/2016.
 */
public class EvaluationStep extends WizardStep implements MenuListenr {

    private RecyclerView rvEvaluation;
    private EvaluationAdapter evaluationAdapter;
    private TextView tvCriteriaName, tvCriteriaDescription;
    private List<EvaluationCriteria> evaluationCriterias = new ArrayList<>();
    private NetworkManager networkManager;
    private Wizard wizard;

    //Wire the layout to the step
    public EvaluationStep() {
        ApplicationSession.setEvaluationStepInstance(this);
    }

    //Set your layout here
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_evaluation, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        networkManager = NetworkManager.getInstance();
        networkManager.setMenuListenr(this);
        rvEvaluation = (RecyclerView) view.findViewById(R.id.rvEvaluation);
        tvCriteriaDescription = (TextView) view.findViewById(R.id.tvCriteriaDescription);
        tvCriteriaName = (TextView) view.findViewById(R.id.tvCriteriaName);

        tvCriteriaDescription.setText(ApplicationSession.getSocializacionResp().getEvaluadores().get(0).getCriterios().get(ApplicationSession.getEvaluationStep()).getDescripcion());
        tvCriteriaName.setText(ApplicationSession.getSocializacionResp().getEvaluadores().get(0).getCriterios().get(ApplicationSession.getEvaluationStep()).getNombre());

        Retroalimentacion retroalimentacion = new Retroalimentacion();
        retroalimentacion.setCriterio(ApplicationSession.getSocializacionResp().getEvaluadores().get(0).getCriterios().get(ApplicationSession.getEvaluationStep()).getIdCriterio());
        retroalimentacion.setSocializacion(ApplicationSession.getSocializacionResp().getIdSocializacion());

        for(EvaluadoresRsp evaluator : ApplicationSession.getSocializacionResp().getEvaluadores())
        {
            EvaluationCriteria evaluationCriteria = new EvaluationCriteria();
            evaluationCriteria.setEvaluatorName(evaluator.getNombre() + " " + evaluator.getApellido());
            evaluationCriteria.setCriteria(evaluator.getCriterios().get(ApplicationSession.getEvaluationStep()));
            evaluationCriteria.setEvaluator(evaluator.getIdUsuario());

            RetroalimentacionValor valor = new RetroalimentacionValor();
            valor.setProfesor(evaluator.getIdUsuario());
            retroalimentacion.getRetroalimentacionValor().add(valor);

            List<RadioButton> radioButtons = new ArrayList<>();
            for(EscalaValoresRsp rsp : evaluationCriteria.getCriteria().getEscalaValores())
            {
                RadioButton radioCriteria = new RadioButton(AppContext.getGlobalContext());
                radioCriteria.setText(rsp.getDescripcion());
                radioButtons.add(radioCriteria);
            }
            evaluationCriteria.setRadioButtons(radioButtons);
            evaluationCriterias.add(evaluationCriteria);
        }

        ApplicationSession.setRetroalimentacion(retroalimentacion);

        evaluationAdapter = new EvaluationAdapter(evaluationCriterias);
        rvEvaluation.setHasFixedSize(true);
        rvEvaluation.setItemViewCacheSize(evaluationCriterias.size());
        rvEvaluation.setLayoutManager(new LinearLayoutManager(AppContext.getGlobalContext()));
        rvEvaluation.setAdapter(evaluationAdapter);
    }

    public void sendCriteria(Wizard wizard)
    {
        this.wizard = wizard;
        networkManager.sendCriteria();
    }

    @Override
    public void onSocialization(SocializacionResp resp) {

    }

    @Override
    public void onSocializationFail() {

    }

    @Override
    public void onCriteriaReady() {
        wizard.goNext();
    }

    @Override
    public void onCriteriaProblem() {

    }

    @Override
    public void onNoteProblem() {

    }

    @Override
    public void onNoteReady(String note) {

    }
}
