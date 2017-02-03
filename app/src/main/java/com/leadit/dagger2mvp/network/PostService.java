package com.leadit.dagger2mvp.network;

import com.leadit.dagger2mvp.entities.Post;

import java.util.List;

import retrofit2.http.GET;

/**
 * Post service api
 * <p>
 * defines all request regarding posts
 *
 * @author Mohamed Essid on 03/02/2017.
 */

public interface PostService {

    /**
     * fetch all posts
     *
     * @return
     */
    @GET("/posts")
    rx.Observable<List<Post>> getPostList();
}
