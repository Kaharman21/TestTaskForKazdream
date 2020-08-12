package com.pavlodar.testtaskforkazdream.presenters;

import android.os.Build;

import com.pavlodar.testtaskforkazdream.views.IInfoAboutPhoneView;

public class InfoAboutPhonePresenter {

    IInfoAboutPhoneView IInfoAboutPhoneView;

    public InfoAboutPhonePresenter(IInfoAboutPhoneView IInfoAboutPhoneView) {
        this.IInfoAboutPhoneView = IInfoAboutPhoneView;
    }

    public StringBuilder createDetailInfoAboutPhone(){
        StringBuilder builder = new StringBuilder();
        builder.append("SERIAL: ").append(Build.SERIAL).append("\n");
        builder.append("MODEL: ").append(Build.MODEL).append("\n");
        builder.append("ID: ").append(Build.ID).append("\n");
        builder.append("Manufacture: (Производство) ").append(Build.MANUFACTURER).append("\n");
        builder.append("brand: ").append(Build.BRAND).append("\n");
        builder.append("type: ").append(Build.TYPE).append("\n");
        builder.append("user: ").append(Build.USER).append("\n");
        builder.append("BASE: " + Build.VERSION_CODES.BASE + "\n");
        builder.append("INCREMENTAL (дополнительный)").append(Build.VERSION.INCREMENTAL).append("\n");
        builder.append("SDK  ").append(Build.VERSION.SDK).append("\n");
        builder.append("BOARD: (доска)").append(Build.BOARD).append("\n");
        builder.append("BRAND ").append(Build.BRAND).append("\n");
        builder.append("HOST ").append(Build.HOST).append("\n");
        builder.append("FINGERPRINT: ").append(Build.FINGERPRINT).append("\n");
        builder.append("Version Code: ").append(Build.VERSION.RELEASE).append("\n");
        builder.append("------------------------------------------ \n");
        builder.append("PRODUCT: ").append(Build.PRODUCT).append("\n");
        builder.append("CPU : ").append(Build.CPU_ABI).append("\n");
        builder.append("------------------------------------------ \n");
        return builder;
    }

}
