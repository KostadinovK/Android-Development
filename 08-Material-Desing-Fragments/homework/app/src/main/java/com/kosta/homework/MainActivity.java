package com.kosta.homework;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.kosta.homework.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //ActivityMainBinding binding;
    @BindView(R.id.fab)
    FloatingActionButton floatingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(toolbar);
        setupBottomNavigation();
       // List<Post> data = new ArrayList<>();
        ImageView profile = findViewById(R.id.img_avatar);
        ImageButton option = findViewById(R.id.ibtn_more);
        ImageView picture = findViewById(R.id.img_picture);
        ImageButton sock = findViewById(R.id.btn_sock);
        ImageButton share = findViewById(R.id.btn_share);
        Post post = new Post(profile, "FRANCISCO WATSON", "TODAY, 10:52PM", option, picture, "Lorem ipsum dolor sit amet", sock, 31, share, "Send a gift");
        //data.add(post);
        StoriesFragment.data.add(post);


    }

    @OnClick(R.id.fab)
    public void onFloatingBtnClicked() {
        Toast msg = Toast.makeText(this, "Not available...", Toast.LENGTH_SHORT);
        msg.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search_option) {
            Toast msg = Toast.makeText(this, "Not available...", Toast.LENGTH_SHORT);
            msg.show();
        }
        return super.onOptionsItemSelected(item);
    }

    // for the Bottom Navigation Menu
    private void setupBottomNavigation() {


        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.item_feed);
        Menu menu = bottomNav.getMenu();
        selectFragment(menu.getItem(0));
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(item.getTitle());
                }
                selectFragment(item);

                return false;
            }
        });
    }

    protected void selectFragment(MenuItem item) {
        item.setChecked(true);
        if (item != null) {
            //toolbar.setElevation(4);
        }


        switch (item.getItemId()) {
            case R.id.item_feed:

                pushFragment(new FeedFragment());
                item.setIcon(R.drawable.feed_red);

                break;
            case R.id.item_gifts:
                item.setIcon(R.drawable.gifts_red);
                pushFragment(new NotAvailableFragment());
                break;
            case R.id.item_scanner:
                item.setIcon(R.drawable.scanner_red);
                pushFragment(new NotAvailableFragment());
                break;
            case R.id.item_profile:
                item.setIcon(R.drawable.profile_red);
                pushFragment(new NotAvailableFragment());
                break;
        }
    }

    protected void pushFragment(Fragment fragment) {
        hideKeyboard();
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.grp_container, fragment);
                ft.commit();
            }
        }
    }

    public void hideKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }
}
