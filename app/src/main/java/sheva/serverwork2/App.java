package sheva.serverwork2;

import android.app.Application;

import sheva.serverwork2.di.component.AppComponent;
import sheva.serverwork2.di.component.DaggerAppComponent;
import sheva.serverwork2.di.module.AppModule;

public class App extends Application {
    protected static App instance;
    private AppComponent appComponent;

    public static App get() {
        return instance;
    }
    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }
}
