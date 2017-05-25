package sheva.serverwork2.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import sheva.serverwork2.mvp.model.repositories.ServerRepository;
import sheva.serverwork2.mvp.model.retrofit.ServerAPI;

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    public ServerAPI provideServerApi(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://174.138.54.52/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(ServerAPI.class);
    }

    @Provides
    @Singleton
    public ServerRepository provideServerrepository() {
        return new ServerRepository();
    }
    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }
}
