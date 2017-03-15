package com.leadit.dagger2mvp.mainscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.leadit.dagger2mvp.BaseApplication;
import com.leadit.dagger2mvp.R;

import com.leadit.dagger2mvp.data.component.DaggerMainScreenComponent;
import com.leadit.dagger2mvp.data.module.MainScreenModule;
import com.leadit.dagger2mvp.entities.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {

    @BindView(R.id.main_list_posts)
    ListView mPostListView;

    private ArrayList<String> mList;
    private ArrayAdapter<String> mAdapter;

    @Inject
    MainScreenPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<>();

        ButterKnife.bind(this);

        DaggerMainScreenComponent.builder()
                .mainScreenModule(new MainScreenModule(this))
                .networkComponent(((BaseApplication) getApplication()).getNetworkComponent())
                .build().inject(this);

        findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.loadPosts();
            }
        });

    }

    @Override
    public void showPosts(List<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            mList.add(posts.get(i).getTitle());
        }
        //Create the array adapter and set it to list view
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mList);
        mPostListView.post(new Runnable() {
            @Override
            public void run() {
                mPostListView.setAdapter(mAdapter);
            }
        });
    }

    @Override
    public void showError(String err) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Error" + message, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void showComplete() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Complete", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
