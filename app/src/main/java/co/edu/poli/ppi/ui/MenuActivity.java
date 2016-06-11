package co.edu.poli.ppi.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import co.edu.poli.ppi.R;
import co.edu.poli.ppi.model.SocializacionResp;
import co.edu.poli.ppi.network.NetworkManager;
import co.edu.poli.ppi.network.listeners.MenuListenr;
import co.edu.poli.ppi.utilities.AppContext;
import co.edu.poli.ppi.utilities.ApplicationSession;

/**
 * Created by TEBAN on 4/06/2016.
 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener, MenuListenr {

    private Button btnStartEvaluation;
    private NetworkManager networkManager;
    private ProgressDialog progressDialog;
    private TextView tvDescription, tvSocializationTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        AppContext.setGlobalContext(this);
        progressDialog = ProgressDialog.show(this, "Cargando" , "Espera un momento, estamos consultando los datos de tu socialiación");
        progressDialog.setCancelable(false);
        networkManager = NetworkManager.getInstance();
        networkManager.setMenuListenr(this);
        networkManager.getSocialization();
        btnStartEvaluation = (Button) findViewById(R.id.btnStartEvaluation);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvSocializationTitle = (TextView) findViewById(R.id.tvSocializacionTitle);
        btnStartEvaluation.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        networkManager.setMenuListenr(this);
        if(ApplicationSession.isReadyToGetNote())
        {
            btnStartEvaluation.setVisibility(View.GONE);
            progressDialog = ProgressDialog.show(this, "Consultando nota", "Espera un momento mientras calculamos tu nota");
            networkManager.getNote();
        }
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnStartEvaluation:
                Intent intent = new Intent(this, EvaluationActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSocialization(SocializacionResp resp) {
        ApplicationSession.setSocializacionResp(resp);
        ApplicationSession.setEvaluators(ApplicationSession.getSocializacionResp().getEvaluadores());
        tvSocializationTitle.setText(resp.getNombreSocicalizacion());
        progressDialog.dismiss();
        progressDialog.cancel();
    }

    @Override
    public void onSocializationFail() {
        Toast.makeText(this, "Tenemos problemas obeteniendo los datos de tu socialización, por favor inténtalo en unos minutos", Toast.LENGTH_LONG).show();
        progressDialog.dismiss();
        progressDialog.cancel();
    }

    @Override
    public void onCriteriaReady() {

    }

    @Override
    public void onCriteriaProblem() {

    }

    @Override
    public void onNoteProblem() {

    }

    @Override
    public void onNoteReady(String note) {
        if(progressDialog != null && progressDialog.isShowing())
        {
            tvDescription.setVisibility(View.GONE);
            tvSocializationTitle.setText("Tu puntaje en la socialización es de " +note);
            tvSocializationTitle.setGravity(Gravity.CENTER);
            progressDialog.dismiss();
            progressDialog.cancel();
        }
    }
}
