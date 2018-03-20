package com.test.main;

/**
 * @author xiaobin.wang
 * @date 2018/3/16
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        Thread.interrupted();
    }
}
