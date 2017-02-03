package com.leadit.dagger2mvp.data.component;

import com.leadit.dagger2mvp.BaseApplication;
import com.leadit.dagger2mvp.data.module.AppModule;
import com.leadit.dagger2mvp.data.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * @author Mohamed Essid on 03/02/2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface NetworkComponent {
    Retrofit retrofit();

}
