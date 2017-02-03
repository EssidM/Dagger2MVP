package com.leadit.dagger2mvp.mainscreen;

import com.leadit.dagger2mvp.entities.Post;
import com.leadit.dagger2mvp.network.PostService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * @author Mohamed Essid on 03/02/2017.
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {

    MainScreenContract.View mView;
    Retrofit mRetrofit;

    @Inject
    public MainScreenPresenter(MainScreenContract.View mView, Retrofit retrofit) {
        this.mView = mView;
        this.mRetrofit = retrofit;
    }

    @Override
    public void loadPosts() {
        mRetrofit.create(PostService.class)
                .getPostList()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.showPosts(posts);
                    }
                });
    }
}
