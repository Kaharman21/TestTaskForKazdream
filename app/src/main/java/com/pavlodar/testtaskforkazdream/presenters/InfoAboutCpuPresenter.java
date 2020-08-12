package com.pavlodar.testtaskforkazdream.presenters;

import com.pavlodar.testtaskforkazdream.models.CpuPropertyModel;
import com.pavlodar.testtaskforkazdream.parsers.CpuPropertyParser;
import com.pavlodar.testtaskforkazdream.views.IInfoAboutCpuView;

import java.util.ArrayList;
import java.util.List;

public class InfoAboutCpuPresenter {

    IInfoAboutCpuView infoAboutCpuView;

    public InfoAboutCpuPresenter(IInfoAboutCpuView infoAboutCpuView) {
        this.infoAboutCpuView = infoAboutCpuView;
    }


    public StringBuilder createDetailInfoAboutCpu(){
        StringBuilder builder = new StringBuilder();
        List<CpuPropertyModel> cpuPropertyList = new ArrayList<>();     // полученные данные
        cpuPropertyList = CpuPropertyParser.parseCpuInfo();             // получаем распарсенные данные
        for (int i=0; i<cpuPropertyList.size(); i++){
            builder.append(cpuPropertyList.get(i).getName()).append(": ").append(cpuPropertyList.get(i).getValue()).append("\n");
        }
        return builder;
    }
}
