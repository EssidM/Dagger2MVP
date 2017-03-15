package com.leadit.dagger2mvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leadit.dagger2mvp.R;
import com.leadit.dagger2mvp.entities.Post;

import java.util.List;

/**
 * Created by mohessid on 15/03/2017.
 */

public class PostsRecyclerAdapter extends RecyclerView.Adapter<PostsRecyclerAdapter.PostAdapterViewHolder> {


    private List<Post> mData;

    public PostsRecyclerAdapter(List<Post> mData) {
        this.mData = mData;
    }

    @Override
    public PostAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);

        return new PostAdapterViewHolder(root);
    }

    @Override
    public void onBindViewHolder(PostAdapterViewHolder holder, int position) {
        Post post = mData.get(position);
        holder.title.setText(post.getTitle());
        holder.message.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class PostAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView message;

        PostAdapterViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.post_title);
            message = (TextView) itemView.findViewById(R.id.post_message);
        }
    }


}
