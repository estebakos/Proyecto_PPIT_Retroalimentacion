package co.edu.poli.ppi.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import co.edu.poli.ppi.R;
import co.edu.poli.ppi.utilities.ApplicationSession;

/**
 * Created by TEBAN on 4/06/2016.
 */
public class EvaluationActivity extends FragmentActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationSession.setEvaluationSteps(ApplicationSession.getSocializacionResp().getEvaluadores().get(0).getCriterios().size());
        setContentView(R.layout.activity_evaluation_wizard);
    }

    @Override
    public void onBackPressed() {
        ApplicationSession.getEvaluationViewHolder().clear();
        super.onBackPressed();
    }
}
