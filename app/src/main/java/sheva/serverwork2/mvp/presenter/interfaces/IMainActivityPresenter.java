package sheva.serverwork2.mvp.presenter.interfaces;

import sheva.serverwork2.mvp.model.entities.TokenEntity;

/**
 * Created by shevc on 25.05.2017.
 */

public interface IMainActivityPresenter {
    void updateList();
    void getUsersFromServer(TokenEntity tokenEntity);
}
