package com.leadit.dagger2mvp.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Mohamed Essid on 03/02/2017.
 */

@Retention(RetentionPolicy.RUNTIME)
@Scope
@Documented
public @interface MainScope {
}
