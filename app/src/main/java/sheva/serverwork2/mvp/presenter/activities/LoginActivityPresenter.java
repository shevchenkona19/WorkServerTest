package sheva.serverwork2.mvp.presenter.activities;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import rx.Subscriber;
import sheva.serverwork2.App;
import sheva.serverwork2.mvp.datamanager.DataManager;
import sheva.serverwork2.mvp.model.entities.LoginData;
import sheva.serverwork2.mvp.model.entities.TokenEntity;
import sheva.serverwork2.mvp.presenter.base.BasePresenter;
import sheva.serverwork2.mvp.presenter.interfaces.ILoginActivityPresenter;
import sheva.serverwork2.mvp.view.interfaces.ILoginActivityView;

/**
 * Created by shevc on 25.05.2017.
 */
@InjectViewState
public class LoginActivityPresenter extends BasePresenter<ILoginActivityView> implements ILoginActivityPresenter{
    @Inject
    DataManager manager;

    public LoginActivityPresenter() {
        App.get().getAppComponent().inject(this);
    }


    @Override
    public void login(String username, String password) {
        LoginData data = new LoginData(username, password);
        TokenEntity[] tokenEntityM = new TokenEntity[1];
        manager.loginUser(data).subscribe(new Subscriber<TokenEntity>() {
            @Override
            public void onCompleted() {
                getViewState().onLogged(tokenEntityM[0]);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("MY", e.getMessage());
                getViewState().showError(e.getMessage());
            }

            @Override
            public void onNext(TokenEntity tokenEntity) {
                tokenEntityM[0] = tokenEntity;
            }
        });
    }
}
