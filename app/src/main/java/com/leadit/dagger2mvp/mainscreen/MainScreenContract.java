package com.leadit.dagger2mvp.mainscreen;

import com.leadit.dagger2mvp.entities.Post;

import java.util.List;

/**
 * Main screen contract - defines MVP
 *
 * @author Mohamed Essid on 03/02/2017.
 */

public class MainScreenContract {

    /**
     * defines required view operations available to presenter
     */
    public interface View {
        void showPosts(List<Post> posts);

        void showError(String err);

        void showComplete();
    }

    /**
     * presenter operations
     */
    public interface Presenter {
        void loadPosts();
    }
}
