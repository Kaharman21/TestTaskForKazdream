package com.pavlodar.testtaskforkazdream.presenters;

import android.os.Build;

import com.pavlodar.testtaskforkazdream.models.CpuPropertyModel;
import com.pavlodar.testtaskforkazdream.models.PhonePropertyModel;
import com.pavlodar.testtaskforkazdream.parsers.CpuPropertyParser;
import com.pavlodar.testtaskforkazdream.views.IAllInfoView;

import java.util.ArrayList;
import java.util.List;

public class AllInfoPresenter {

    IAllInfoView mainView;

    public AllInfoPresenter(IAllInfoView mainView) {
        this.mainView = mainView;
    }


    public List<PhonePropertyModel> addPhonePropertyItems() {
        List<PhonePropertyModel> phonePropertyModelList = new ArrayList<>();
        phonePropertyModelList.add(new PhonePropertyModel("Manufacture: ", Build.MANUFACTURER));
        phonePropertyModelList.add(new PhonePropertyModel("Model: ", Build.MODEL));
        phonePropertyModelList.add(new PhonePropertyModel("Android Version: ", Build.VERSION.RELEASE));
        phonePropertyModelList.add(new PhonePropertyModel("Incremental: ", Build.VERSION.INCREMENTAL));
        phonePropertyModelList.add(new PhonePropertyModel("SDK  ", Build.VERSION.SDK));
        return phonePropertyModelList;
    }


    public List<CpuPropertyModel> addCpuPropertyItems() {
        List<CpuPropertyModel> cpuPropertyList;     // полученные данные
        List<CpuPropertyModel> cpuPropertyNewList = new ArrayList<>();  // отфильтрованные данные
        int kernelCount = 0;                                            // количество ядер
        cpuPropertyList = CpuPropertyParser.parseCpuInfo();             // получаем распарсенные данные

        for (int i = 0; i < cpuPropertyList.size(); i++) {                   // отбираем только то, что нам нужно
            switch (cpuPropertyList.get(i).getName()) {
                case CpuPropertyModel.PROCESSOR:
                    addCpuPropertyNewItem(i, cpuPropertyNewList, cpuPropertyList);
                    break;
                case CpuPropertyModel.CPU_ARCHITECTURE:
                    kernelCount = kernelCount + 1;
                    if (kernelCount == 1) {
                        addCpuPropertyNewItem(i, cpuPropertyNewList, cpuPropertyList);
                    }
                    break;
                case CpuPropertyModel.HARDWARE:
                    addCpuPropertyNewItem(i, cpuPropertyNewList, cpuPropertyList);
                    break;
            }
        }
        return cpuPropertyNewList;
    }


    private List<CpuPropertyModel> addCpuPropertyNewItem(int position, List<CpuPropertyModel> cpuPropertyNewList,
                                                         List<CpuPropertyModel> cpuPropertyList) {
        cpuPropertyNewList.add(new CpuPropertyModel(cpuPropertyList.get(position).getName(),
                cpuPropertyList.get(position).getValue()));
        return cpuPropertyNewList;
    }


}
