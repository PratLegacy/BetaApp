package com.example.abhishek.betaapp1_0;

/**
 * Created by abhishek on 20/11/16.
 */

public class DataModel {

    String appName;
    private int appLogo;

    public DataModel() {

    }

    public DataModel(String appName, int appLogo) {
        this.appLogo = appLogo;
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(int appLogo) {
        this.appLogo = appLogo;
    }
}
