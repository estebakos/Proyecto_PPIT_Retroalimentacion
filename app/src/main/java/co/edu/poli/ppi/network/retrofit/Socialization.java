package co.edu.poli.ppi.network.retrofit;

import co.edu.poli.ppi.model.SocializacionResp;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by TEBAN on 4/06/2016.
 */
public interface Socialization {

        @GET("rest/getSoc")
        @Headers("Content-Type: application/json")
        Call<SocializacionResp> getSocialization(@Header("token") int token);

        @GET("rest/getNota")
        @Headers("Content-Type: application/json")
        Call<String> getNote(@Header("token") int token, @Query("socializacion") int socializacion);

        @POST("rest/putRetro")
        @Headers("Content-Type: application/json")
        Call<String> putCriteria(@Header("token") int token , @Body String content);
}
