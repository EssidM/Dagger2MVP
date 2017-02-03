package com.leadit.dagger2mvp.data.component;

import com.leadit.dagger2mvp.data.module.MainScreenModule;
import com.leadit.dagger2mvp.mainscreen.MainActivity;
import com.leadit.dagger2mvp.util.MainScope;

import dagger.Component;

/**
 * @author Mohamed Essid on 03/02/2017.
 */

@MainScope
@Component(dependencies = NetworkComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {

    void inject(MainActivity activity);
}
