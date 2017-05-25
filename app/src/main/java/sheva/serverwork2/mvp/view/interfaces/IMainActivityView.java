package sheva.serverwork2.mvp.view.interfaces;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import sheva.serverwork2.mvp.model.entities.TokenEntity;
import sheva.serverwork2.mvp.model.entities.UserEntity;

public interface IMainActivityView extends MvpView{

    void onUpdateList(List<UserEntity> list);

    void fetchUsersFromServer(TokenEntity tokenEntity);
    void onFetched();
}
