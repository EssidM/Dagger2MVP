package com.leadit.dagger2mvp;

import android.app.Application;

import com.leadit.dagger2mvp.data.component.DaggerNetworkComponent;
import com.leadit.dagger2mvp.data.component.NetworkComponent;
import com.leadit.dagger2mvp.data.module.AppModule;
import com.leadit.dagger2mvp.data.module.NetworkModule;
import com.leadit.dagger2mvp.util.Constant;

/**
 * @author Mohamed Essid on 03/02/2017.
 */

public class BaseApplication extends Application {

    /**
     * network component
     */
    private NetworkComponent mNetworkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetworkComponent = DaggerNetworkComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }

    /**
     * returns network component
     *
     * @return
     */
    public NetworkComponent getNetworkComponent() {
        return mNetworkComponent;
    }
}
