package com.michael.sweet;

/**
 * @author michael.wang
 * @date 2019-12-18 15:10
 */
public class ClimbThread implements Runnable{
    private String name;
    private int time;
    private int number;

    public ClimbThread(String name, int time, int number) {
        this.name = name;
        this.time = time;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void run() {
        for(int i=1; i<= this.number; i++) {
            try {
                Thread.sleep(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "已爬完第" + i + "个100米!还剩" + (this.number - i) * 100 + "米！");
            if(this.number == i) {
                System.out.println(Thread.currentThread().getName() + "到达终点");
            }

        }
    }
}

class ThreadTest {
    public static void main(String[] args) {
        System.out.println("***************开始爬山**************");
        ClimbThread cd = new ClimbThread("老年人", 4000, 3);
        ClimbThread cd2 = new ClimbThread("年轻人", 1000, 20);
        Thread t1 = new Thread(cd);
        Thread t2 = new Thread(cd2);
        t1.setName(cd.getName());
        t2.setName(cd2.getName());
        t1.start();
        t2.start();
    }
}
