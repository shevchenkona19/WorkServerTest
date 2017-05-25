package sheva.serverwork2.mvp.model.repositories;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import sheva.serverwork2.App;
import sheva.serverwork2.mvp.model.entities.LoginData;
import sheva.serverwork2.mvp.model.entities.RegistrationData;
import sheva.serverwork2.mvp.model.entities.TokenEntity;
import sheva.serverwork2.mvp.model.entities.UserEntity;
import sheva.serverwork2.mvp.model.retrofit.ServerAPI;

public class ServerRepository {
    @Inject
    ServerAPI api;

    public ServerRepository() {
        App.get().getAppComponent().inject(this);
    }

    public Observable<List<UserEntity>> getAllUsers(String token) {
        return api.getAllUsers(token);
    }

    public Observable<TokenEntity> loginUser(LoginData data) {
        return api.loginUser(data);
    }

    public Observable<TokenEntity> registerUser(RegistrationData data) {
        return api.registerUser(data);
    }
}
