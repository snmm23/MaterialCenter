package com.android.material.center;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

public class MaterialCenterActivity extends AppCompatActivity implements OnRefreshListener,AppBarLayout.OnOffsetChangedListener{

    private SwipeToLoadLayout swipeRefreshLayout;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private PagerAdapter viewPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.center_activity_layout);
        swipeRefreshLayout=(SwipeToLoadLayout)findViewById(R.id.swipeToLoadLayout);
        appBarLayout=(AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbar =(CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewpager = (ViewPager) findViewById(R.id.viewPager);
        appBarLayout.addOnOffsetChangedListener(this);
        swipeRefreshLayout.setLoadMoreEnabled(false);
        swipeRefreshLayout.setOnRefreshListener(this);
        setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar.setTitle("MaterialCenter");
        viewPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if(verticalOffset==0){
            swipeRefreshLayout.setRefreshEnabled(true);
        }else{
            swipeRefreshLayout.setRefreshEnabled(false);
        }
    }
}
