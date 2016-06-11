package co.edu.poli.ppi.network.ws;

import com.google.gson.Gson;

import co.edu.poli.ppi.R;
import co.edu.poli.ppi.model.SocializacionResp;
import co.edu.poli.ppi.network.listeners.WsListener;
import co.edu.poli.ppi.network.retrofit.Socialization;
import co.edu.poli.ppi.network.retrofit.Users;
import co.edu.poli.ppi.utilities.AppContext;
import co.edu.poli.ppi.utilities.ApplicationSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TEBAN on 4/06/2016.
 */
public class WsManager {

    WsListener wsListener;

    public WsManager(WsListener wsListener)
    {
        this.wsListener = wsListener;
    }

    public void Authenticate(int identificationType, String identification, String password)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppContext.getGlobalContext().getString(R.string.ws_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        Users users = retrofit.create(Users.class);

        Call<String> call = users.authenticate(identificationType, identification, password);
        //asynchronous call
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body() != null) {
                    wsListener.onAuthenticate(response.body());
                }
                else
                {
                    wsListener.onAuthenticationFail();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                wsListener.onAuthenticationFail();
            }
        });
    }

    public void getSocialization()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppContext.getGlobalContext().getString(R.string.ws_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        Socialization socialization = retrofit.create(Socialization.class);
        try {


            Call<SocializacionResp> call = socialization.getSocialization(1);
            //asynchronous call
            call.enqueue(new Callback<SocializacionResp>() {
                @Override
                public void onResponse(Call<SocializacionResp> call, Response<SocializacionResp> response) {
                    wsListener.onSocialization(response.body());
                }

                @Override
                public void onFailure(Call<SocializacionResp> call, Throwable t) {
                    wsListener.onSocializationFail();
                }
            });
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void putCriteria()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppContext.getGlobalContext().getString(R.string.ws_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        Socialization socialization = retrofit.create(Socialization.class);
        String gson = new Gson().toJson(ApplicationSession.getRetroalimentacion());
        gson.replace("\\\"", "\"");
        Call<String> call = socialization.putCriteria(Integer.parseInt(ApplicationSession.getToken()), gson);
        //asynchronous call
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                wsListener.onCriteriaReady();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                wsListener.onCriteriaProblem();
            }
        });
    }

    public void getNote()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppContext.getGlobalContext().getString(R.string.ws_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        Socialization socialization = retrofit.create(Socialization.class);

        Call<String> call = socialization.getNote(Integer.parseInt(ApplicationSession.getToken()), ApplicationSession.getSocializacionResp().getIdSocializacion());
        //asynchronous call
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                wsListener.onNoteReady(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                wsListener.onNoteProblem();
            }
        });
    }
}
