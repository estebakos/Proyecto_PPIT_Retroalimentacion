package co.edu.poli.ppi.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import co.edu.poli.ppi.R;
import co.edu.poli.ppi.network.NetworkManager;
import co.edu.poli.ppi.network.listeners.LoginListenr;
import co.edu.poli.ppi.utilities.AppContext;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginListenr{

    private EditText etUser, etPassword;
    private Button btnSignIn;
    private Spinner spIdentificationTypes;
    private NetworkManager networkManager;
    private ProgressDialog loginProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppContext.setGlobalContext(this);
        networkManager  = NetworkManager.getInstance();
        networkManager.setLoginListenr(this);
        etUser = (EditText) findViewById(R.id.tvUser);
        etPassword = (EditText) findViewById(R.id.tvPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        spIdentificationTypes = (Spinner) findViewById(R.id.spIdentificationTypes);

        List<String> listIdentificationTypes = Arrays.asList(getResources().getStringArray(R.array.identification_types));
        ArrayAdapter<String> indentificationTypesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listIdentificationTypes);
        spIdentificationTypes.setAdapter(indentificationTypesAdapter);
        btnSignIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSignIn:
                if(etPassword.getText().toString().equals("")|| etUser.getText().toString().equals(""))
                {
                    Toast.makeText(this, "Debes llenar todos los campos" , Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        networkManager.authenticate(spIdentificationTypes.getSelectedItemPosition() + 1, etUser.getText().toString(), etPassword.getText().toString());
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onAuthenticate() {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            finish();

    }

    @Override
    public void onAuthenticateProblem() {
        if(loginProgressDialog != null && loginProgressDialog.isShowing())
        {
            loginProgressDialog.cancel();
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}
