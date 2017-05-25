package sheva.serverwork2.mvp.datamanager;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sheva.serverwork2.App;
import sheva.serverwork2.mvp.model.db.DBHelper;
import sheva.serverwork2.mvp.model.entities.LoginData;
import sheva.serverwork2.mvp.model.entities.RegistrationData;
import sheva.serverwork2.mvp.model.entities.TokenEntity;
import sheva.serverwork2.mvp.model.entities.UserEntity;
import sheva.serverwork2.mvp.model.repositories.ServerRepository;

public class DataManager {
    @Inject
    ServerRepository serverRepository;
    @Inject
    DBHelper helper;

    public DataManager() {
        App.get().getAppComponent().inject(this);
    }

    public Observable<List<UserEntity>> getAllUsers(String token) {
        return serverRepository.getAllUsers(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<TokenEntity> loginUser(LoginData data) {
        return serverRepository.loginUser(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<TokenEntity> registerUser(RegistrationData data) {
        return serverRepository.registerUser(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<UserEntity>> getUsersFromDb() {
        return helper.getAllUsersFromDB();
    }

    public void insert(UserEntity user) {
        helper.insert(user);
    }
}
