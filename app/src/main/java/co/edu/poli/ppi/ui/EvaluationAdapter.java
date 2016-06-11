package co.edu.poli.ppi.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import co.edu.poli.ppi.R;
import co.edu.poli.ppi.model.EscalaValoresRsp;
import co.edu.poli.ppi.model.EvaluationCriteria;
import co.edu.poli.ppi.utilities.AppContext;
import co.edu.poli.ppi.utilities.ApplicationSession;


public class EvaluationAdapter extends RecyclerView.Adapter<EvaluationAdapter.EvaluationViewHolder> {

    private static List<EvaluationCriteria> evaluation;

    public EvaluationAdapter(List<EvaluationCriteria> evaluation) {
        this.evaluation = evaluation;
    }


    @Override
    public EvaluationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.list_evaluation, viewGroup, false);

        EvaluationViewHolder evaluationViewHolder = new EvaluationViewHolder(itemLayoutView);
        return evaluationViewHolder;
    }

    @Override
    public void onBindViewHolder(EvaluationViewHolder evaluationViewHolder, final int i) {

        final EvaluationCriteria evaluation = EvaluationAdapter.evaluation.get(i);
        evaluationViewHolder.tvEvaluator.setText(evaluation.getEvaluatorName());

        evaluationViewHolder.setRgEvaluation(evaluationViewHolder.rgEvaluation);
        ApplicationSession.getEvaluationViewHolder().add(evaluationViewHolder);

        for(final EscalaValoresRsp criteriaValue : evaluation.getCriteria().getEscalaValores())
        {
            RadioButton radioCriteria = new RadioButton(AppContext.getGlobalContext());
            radioCriteria.setText(criteriaValue.getDescripcion());
            radioCriteria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                     for(EscalaValoresRsp escalaValoresRsp : evaluation.getCriteria().getEscalaValores())
                     {
                         if(escalaValoresRsp.getNombre().equals(buttonView.getText().toString()))
                         {
                             ApplicationSession.getRetroalimentacion().getRetroalimentacionValor().get(i).setEscalavalor(escalaValoresRsp.getIdEscalaValor());
                         }
                     }
                    }
                }
            });
            evaluationViewHolder.rgEvaluation.addView(radioCriteria);
        }
        evaluationViewHolder.rgEvaluation.check(evaluationViewHolder.rgEvaluation.getChildAt(0).getId());
    }

    @Override
    public int getItemCount() {
        return evaluation.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class EvaluationViewHolder extends RecyclerView.ViewHolder {

        public TextView tvEvaluator;
        public RadioGroup rgEvaluation;

        public void setRgEvaluation(RadioGroup rgEvaluation) {
            this.rgEvaluation = rgEvaluation;
        }

        public RadioGroup getRgEvaluation() {
            return rgEvaluation;
        }

        public EvaluationViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            rgEvaluation = (RadioGroup) itemLayoutView.findViewById(R.id.rgEvaluation);
            tvEvaluator = (TextView) itemLayoutView.findViewById(R.id.tvEvaluator);
        }

    }
}
