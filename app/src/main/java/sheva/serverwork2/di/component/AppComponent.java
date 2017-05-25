package sheva.serverwork2.di.component;

import javax.inject.Singleton;

import dagger.Component;
import sheva.serverwork2.di.module.AppModule;
import sheva.serverwork2.di.module.RetrofitModule;
import sheva.serverwork2.mvp.datamanager.DataManager;
import sheva.serverwork2.mvp.model.repositories.ServerRepository;
import sheva.serverwork2.mvp.presenter.activities.LoginActivityPresenter;
import sheva.serverwork2.mvp.presenter.activities.MainActivityPresenter;
import sheva.serverwork2.mvp.presenter.activities.RegisterActivityPresenter;

@Component(modules = {AppModule.class, RetrofitModule.class})
@Singleton
public interface AppComponent {
    void inject(DataManager manager);
    void inject(ServerRepository repository);
    void inject(LoginActivityPresenter presenter);
    void inject(RegisterActivityPresenter presenter);
    void inject(MainActivityPresenter presenter);
}
