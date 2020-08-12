package com.pavlodar.testtaskforkazdream.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.pavlodar.testtaskforkazdream.R;
import com.pavlodar.testtaskforkazdream.ui.fragments.AllInfoFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new AllInfoFragment());
        }


    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(
                        R.id.container,
                        fragment
                ).commit();
    }

}