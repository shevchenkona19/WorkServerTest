package sheva.serverwork2.mvp.presenter.activities;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import rx.Subscriber;
import sheva.serverwork2.App;
import sheva.serverwork2.mvp.datamanager.DataManager;
import sheva.serverwork2.mvp.model.entities.RegistrationData;
import sheva.serverwork2.mvp.model.entities.TokenEntity;
import sheva.serverwork2.mvp.presenter.base.BasePresenter;
import sheva.serverwork2.mvp.presenter.interfaces.IRegisterActivityPresenter;
import sheva.serverwork2.mvp.view.interfaces.IRegisterActivityView;

/**
 * Created by shevc on 25.05.2017.
 */
@InjectViewState
public class RegisterActivityPresenter extends BasePresenter<IRegisterActivityView> implements IRegisterActivityPresenter{
    @Inject
    DataManager manager;

    public RegisterActivityPresenter() {
        App.get().getAppComponent().inject(this);
    }
    @Override
    public void register(String username, String password, String email) {
        RegistrationData data = new RegistrationData(username, password, email);
        TokenEntity[] token = new TokenEntity[1];
        manager.registerUser(data).subscribe(new Subscriber<TokenEntity>() {
            @Override
            public void onCompleted() {
                getViewState().onRegistred(token[0]);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("MY", e.getMessage());
            }

            @Override
            public void onNext(TokenEntity tokenEntity) {
                token[0] = tokenEntity;
            }
        });
    }
}
