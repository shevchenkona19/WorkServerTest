package sheva.serverwork2.mvp.model.retrofit;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import sheva.serverwork2.mvp.model.entities.LoginData;
import sheva.serverwork2.mvp.model.entities.RegistrationData;
import sheva.serverwork2.mvp.model.entities.TokenEntity;
import sheva.serverwork2.mvp.model.entities.UserEntity;

public interface ServerAPI {
    @GET("authorization/allUsers")
    Observable<List<UserEntity>> getAllUsers(@Query("Authorization") String token);

    @POST("authorization/login/")
    Observable<TokenEntity> loginUser(@Body LoginData data);

    @POST("authorization/registration")
    Observable<TokenEntity> registerUser(@Body RegistrationData data);
}
