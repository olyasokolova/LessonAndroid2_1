package com.app.nik.lessonandroid2_1;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private static final String TAG ="MainActivity";
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.drawerOpen,R.string.drawerClose);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Class fragmentClass = null;
        switch (menuItem.getItemId()){
            case R.id.item1: fragmentClass = FirstFragment.class;
                break;
            case R.id.item2: fragmentClass = SecondFragment.class;
                break;
            case R.id.item3: fragmentClass = ThirdFragment.class;
                break;
            case R.id.item4: fragmentClass =FourthFragment.class;
                break;
        }
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            }
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container_fragment,fragment).commit();
        mDrawerLayout.closeDrawers();
        return true;
    }
    public static void log(String message){
        Log.d(TAG,message);
    }

}
