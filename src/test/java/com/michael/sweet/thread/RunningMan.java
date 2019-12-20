package com.michael.sweet.thread;

/**
 * @author michael.wang
 * @date 2019-12-18 16:48
 */
public class RunningMan implements Runnable {
    private String name;
    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "号选手拿到接力棒！");
            for (int j=1; j<=10; j++) {
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "号选手跑完了" + j * 10 + "米!");
                if(j == 10) {
                    break;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class RunningTest {
    public static void main(String[] args) {
        RunningMan rm = new RunningMan();
        for (int i=1; i<=10; i++) {
            Thread ti = new Thread(rm, i + "");
            ti.start();
            System.out.println(ti.getName());
            try {
                ti.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
