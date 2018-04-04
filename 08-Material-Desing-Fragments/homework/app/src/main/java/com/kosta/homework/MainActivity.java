package com.kosta.homework;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import android.widget.Toolbar;

import com.kosta.homework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActivityMainBinding binding;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        setupBottomNavigation();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search_option){
            Toast msg = Toast.makeText(this,"Not available...",Toast.LENGTH_SHORT);
            msg.show();
        }
        return super.onOptionsItemSelected(item);
    }
    // for the Bottom Navigation Menu
    private void setupBottomNavigation() {

        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.item_feed);
        Menu menu = bottomNavigationView.getMenu();
        selectFragment(menu.getItem(0));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
        if(item != null){
            //toolbar.setElevation(4);
        }


        switch (item.getItemId()) {
            case R.id.item_feed:

                pushFragment(new FeedFragment());
               // toolbar.setElevation(0);
                break;
            case R.id.item_gifts:
                Toast msg = Toast.makeText(this,"This section isn't available yet...",Toast.LENGTH_SHORT);
                msg.show();
                break;
            case R.id.item_scanner:
                Toast msg2 = Toast.makeText(this,"This section isn't available yet...",Toast.LENGTH_SHORT);
                msg2.show();
                break;
            case R.id.item_profile:
                Toast msg3 = Toast.makeText(this,"This section isn't available yet...",Toast.LENGTH_SHORT);
                msg3.show();
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
