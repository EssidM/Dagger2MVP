package com.leadit.dagger2mvp.data.module;

import com.leadit.dagger2mvp.mainscreen.MainScreenContract;
import com.leadit.dagger2mvp.util.MainScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author Mohamed Essid on 03/02/2017.
 */

@Module
public class MainScreenModule {
    MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View view) {
        this.mView = view;
    }

    @Provides
    @MainScope
    MainScreenContract.View provideMainScreenView() {
        return mView;
    }
}
