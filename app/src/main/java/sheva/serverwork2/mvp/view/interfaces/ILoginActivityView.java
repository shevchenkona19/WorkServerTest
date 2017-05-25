package sheva.serverwork2.mvp.view.interfaces;

import com.arellomobile.mvp.MvpView;

import sheva.serverwork2.mvp.model.entities.TokenEntity;

public interface ILoginActivityView extends MvpView{
    void onLogged(TokenEntity token);
    void showError(String error);
}
