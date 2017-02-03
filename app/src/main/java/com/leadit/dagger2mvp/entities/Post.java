package com.leadit.dagger2mvp.entities;

/**
 * Post POJO
 *
 * @author Mohamed Essid on 03/02/2017.
 */

public class Post {

    private final Integer userid;
    private final Integer id;
    private final String title;
    private final String body;

    public Post(Integer userid, Integer id, String title, String body) {
        this.userid = userid;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getUserid() {
        return userid;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
