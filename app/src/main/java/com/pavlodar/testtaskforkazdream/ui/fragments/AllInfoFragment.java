package com.pavlodar.testtaskforkazdream.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pavlodar.testtaskforkazdream.R;
import com.pavlodar.testtaskforkazdream.adapters.CpuPropertyAdapter;
import com.pavlodar.testtaskforkazdream.adapters.PhonePropertyAdapter;
import com.pavlodar.testtaskforkazdream.models.CpuPropertyModel;
import com.pavlodar.testtaskforkazdream.models.PhonePropertyModel;
import com.pavlodar.testtaskforkazdream.presenters.AllInfoPresenter;
import com.pavlodar.testtaskforkazdream.views.IAllInfoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AllInfoFragment extends Fragment implements IAllInfoView {

    @BindView(R.id.main_recycler_phone)
    RecyclerView main_recycler_phone;
    @BindView(R.id.main_recycler_cpu)
    RecyclerView main_recycler_cpu;

    PhonePropertyAdapter phonePropertyAdapter;
    CpuPropertyAdapter cpuPropertyAdapter;
    List<PhonePropertyModel> phonePropertyList;
    List<CpuPropertyModel> cpuPropertyList;

    PhonePropertyAdapter.ItemClickListener phoneItemClickListener;
    CpuPropertyAdapter.ItemClickListener cpuItemClickListener;
    AllInfoPresenter allInfoPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_info, container, false);

        init();
        initView(view);
        onClickItem();
        addPhoneProperty();
        addCpuProperty();

        return view;
    }


    @Override
    public void addPhoneProperty() {
        phonePropertyList = allInfoPresenter.addPhonePropertyItems();
        phonePropertyAdapter = new PhonePropertyAdapter(getContext(), phonePropertyList, phoneItemClickListener);
        main_recycler_phone.setAdapter(phonePropertyAdapter);
    }

    @Override
    public void addCpuProperty() {
        cpuPropertyList = allInfoPresenter.addCpuPropertyItems();
        cpuPropertyAdapter = new CpuPropertyAdapter(getContext(), cpuPropertyList, cpuItemClickListener);
        main_recycler_cpu.setAdapter(cpuPropertyAdapter);
    }

    @Override
    public void onClickItem() {
        cpuItemClickListener = (((view, position) -> {
            replaceFragment(new InfoAboutCpuFragment());
        }));

        phoneItemClickListener = (((view, position) -> {
            replaceFragment(new InfoAboutPhoneFragment());
        }));
    }

    public void replaceFragment(Fragment fragment) {
        requireFragmentManager().beginTransaction()
                .addToBackStack(null).
                replace(
                        R.id.container,
                        fragment
                ).commit();
    }

    private void init() {
        allInfoPresenter = new AllInfoPresenter(this);
        phonePropertyList = new ArrayList<>();
        cpuPropertyList = new ArrayList<>();
    }


    private void initView(View view) {
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManagerForPhone = new LinearLayoutManager(getContext());
        main_recycler_phone.setLayoutManager(layoutManagerForPhone);
        LinearLayoutManager layoutManagerForCpu = new LinearLayoutManager(getContext());
        main_recycler_cpu.setLayoutManager(layoutManagerForCpu);
    }
}