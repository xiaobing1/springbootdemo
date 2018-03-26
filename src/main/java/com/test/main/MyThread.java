package com.test.main;

import java.util.ArrayList;

/**
 * @author xiaobin.wang
 * @date 2018/3/16
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        Thread.interrupted();
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(10);
        for (;arrayList.size()<10;) {
            arrayList.add(1);
        }
        arrayList.add(2);
    }
}
