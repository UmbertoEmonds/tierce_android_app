package com.example.admin.tp2.vue;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.tp2.R;
import com.example.admin.tp2.vue.AccueilFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (null==savedInstanceState) {
            pushFragment(new AccueilFragment());
        }

    }

    public void pushFragment(Fragment newFragment) {

        FragmentManager fm;
        FragmentTransaction transaction;

        fm=getSupportFragmentManager();
        transaction=fm.beginTransaction();
        transaction.addToBackStack(null);
        transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
        transaction.replace(R.id.fragment, newFragment);
        transaction.commit();
    }

    public void popFragment(){

        FragmentManager fm;
        fm = getSupportFragmentManager();
        fm.popBackStack();

    }

}
