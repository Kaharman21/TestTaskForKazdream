package com.pavlodar.testtaskforkazdream.ui.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pavlodar.testtaskforkazdream.R;
import com.pavlodar.testtaskforkazdream.presenters.InfoAboutPhonePresenter;
import com.pavlodar.testtaskforkazdream.views.IInfoAboutPhoneView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InfoAboutPhoneFragment extends Fragment implements IInfoAboutPhoneView {

    @BindView(R.id.fragment_txt_phone) TextView fragment_txt_phone;

    InfoAboutPhonePresenter infoAboutPhonePresenter;
    StringBuilder builder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_about_phone, container, false);
        init();
        initView(view);
        showDetailInfoAboutPhone();
        return view;
    }

    @Override
    public void showDetailInfoAboutPhone() {
        builder = infoAboutPhonePresenter.createDetailInfoAboutPhone();
        fragment_txt_phone.setText(builder);
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
    }

    private void init() {
        infoAboutPhonePresenter = new InfoAboutPhonePresenter(this);
    }
}