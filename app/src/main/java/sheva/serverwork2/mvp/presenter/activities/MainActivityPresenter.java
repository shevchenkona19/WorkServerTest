package sheva.serverwork2.mvp.presenter.activities;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import sheva.serverwork2.App;
import sheva.serverwork2.mvp.datamanager.DataManager;
import sheva.serverwork2.mvp.model.entities.TokenEntity;
import sheva.serverwork2.mvp.model.entities.UserEntity;
import sheva.serverwork2.mvp.presenter.base.BasePresenter;
import sheva.serverwork2.mvp.presenter.interfaces.IMainActivityPresenter;
import sheva.serverwork2.mvp.view.interfaces.IMainActivityView;

@InjectViewState
public class MainActivityPresenter extends BasePresenter<IMainActivityView> implements IMainActivityPresenter{
    @Inject
    DataManager manager;

    public MainActivityPresenter() {
        App.get().getAppComponent().inject(this);
    }
    @Override
    public void updateList() {
        List<UserEntity> list1 = new ArrayList<>();
        manager.getUsersFromDb().subscribe(new Subscriber<List<UserEntity>>() {
            @Override
            public void onCompleted() {
                getViewState().onUpdateList(list1);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("MY", e.getMessage());
            }

            @Override
            public void onNext(List<UserEntity> list) {
                list1.addAll(list);
            }
        });
    }

    @Override
    public void getUsersFromServer(TokenEntity tokenEntity) {
        List<UserEntity> userEntityList = new ArrayList<>();
        manager.getAllUsers(tokenEntity.getToken()).subscribe(new Subscriber<List<UserEntity>>() {
            @Override
            public void onCompleted() {
                for (UserEntity user :
                        userEntityList) {
                    manager.insert(user);
                }
                getViewState().onFetched();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("MY", e.getMessage());
            }

            @Override
            public void onNext(List<UserEntity> list) {
                userEntityList.addAll(list);
            }
        });
    }
}
