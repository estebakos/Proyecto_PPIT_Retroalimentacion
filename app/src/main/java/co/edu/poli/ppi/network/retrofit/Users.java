package co.edu.poli.ppi.network.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by TEBAN on 4/06/2016.
 */
public interface Users {

        @GET("auth/getUser")
        @Headers("Content-Type: application/json")
        Call<String> authenticate(@Query("idtype") int identificationType, @Query("id")String identification, @Query("password") String password);
}
