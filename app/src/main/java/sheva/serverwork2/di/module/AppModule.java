package sheva.serverwork2.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sheva.serverwork2.mvp.datamanager.DataManager;


@Module
public class AppModule {
    private Application application;
    public AppModule(Application application) {
        this.application = application;
    }
    @Provides
    @Singleton
    public Context provideContext(){
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public DataManager provideDataManager(){
        return new DataManager();
    }
}
