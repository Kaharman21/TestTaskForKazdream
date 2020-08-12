package com.pavlodar.testtaskforkazdream.parsers;

import com.pavlodar.testtaskforkazdream.models.CpuPropertyModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CpuPropertyParser {

    private static final String PROC_CPUINFO_FILENAME = "/proc/cpuinfo";


    public static List<CpuPropertyModel> parseCpuInfo() {

        List<CpuPropertyModel> cpuPropertyList = new ArrayList<>();
        CpuPropertyModel property;

        String temp;
        int readBlockSize = 8192;  // 8 КБ

        try {
            FileReader fileReader = new FileReader(PROC_CPUINFO_FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader, readBlockSize);

            while ((temp = bufferedReader.readLine()) != null) {
                property = parseCpuInfoLine(temp);
                if (property != null) {
                    cpuPropertyList.add(property);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cpuPropertyList;
    }


    private static CpuPropertyModel parseCpuInfoLine(String line) {

        String[] parts = line.split(":");  // делим полученное значение на два. До и после двоеточия (:)
        if (parts.length == 2 && parts[0] != null && parts[1] != null) {
            return new CpuPropertyModel(parts[0].trim(), parts[1].trim());
        }
        return null;
    }


}
