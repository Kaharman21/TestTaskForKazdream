package com.pavlodar.testtaskforkazdream.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pavlodar.testtaskforkazdream.R;
import com.pavlodar.testtaskforkazdream.models.CpuPropertyModel;
import com.pavlodar.testtaskforkazdream.presenters.InfoAboutCpuPresenter;
import com.pavlodar.testtaskforkazdream.views.IInfoAboutCpuView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InfoAboutCpuFragment extends Fragment implements IInfoAboutCpuView {

    @BindView(R.id.fragment_txt_cpu) TextView fragment_txt_cpu;
    StringBuilder builder;
    InfoAboutCpuPresenter infoAboutCpuPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_about_cpu, container, false);
        init();
        initView(view);
        showDetailInfoAboutCpu();

        return view;
    }


    @Override
    public void showDetailInfoAboutCpu(){
        builder = infoAboutCpuPresenter.createDetailInfoAboutCpu();
        fragment_txt_cpu.setText(builder);
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
    }

    private void init() {
        infoAboutCpuPresenter = new InfoAboutCpuPresenter(this);
    }
}