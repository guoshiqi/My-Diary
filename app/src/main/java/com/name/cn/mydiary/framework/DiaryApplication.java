package com.name.cn.mydiary.framework;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.name.cn.mydiary.util.database.GreenDaoManager;
import com.squareup.leakcanary.LeakCanary;

import java.util.List;


/**
 * app init
 * Created by guoshiqi on 2016/12/9.
 */

public class DiaryApplication extends Application {
    private static DiaryApplication instance;

    public static DiaryApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
        String processName = getProcessName(this);
        if (processName!= null) {
            if(processName.equals("com.name.cn.mydairly.mock")){
                //初始化com.name.cn.mydairly以包名为进程名，项目默认的进程
                initApp();
            }
        }
    }

    private void initApp() {
        instance = this;
        GreenDaoManager.getInstance();
    }

    private String getProcessName(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo proInfo : runningApps) {
            if (proInfo.pid == android.os.Process.myPid()) {
                if (proInfo.processName != null) {
                    return proInfo.processName;
                }
            }
        }
        return null;
    }



}
