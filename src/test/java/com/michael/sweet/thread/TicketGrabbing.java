package com.michael.sweet.thread;

/**
 * @author michael.wang
 * @date 2019-12-18 16:22
 */
public class TicketGrabbing implements Runnable{
    private String name;
    private int count=10;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if(count == 6 && Thread.currentThread().getName().equals("黄牛党")) {
                    try {
                        Thread.currentThread().join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(count > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(Thread.currentThread().getName().equals("黄牛党")) {
                        System.out.println(Thread.currentThread().getName() + "抢到了第" + (11 - count) + "张票，剩余" + --count + "张票！");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "抢到了第" + (11 - count) + "张票，剩余" + --count + "张票！");
                } else {
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

class TicketTest {
    public static void main(String[] args) {
        TicketGrabbing tc = new TicketGrabbing();
        Thread t1 = new Thread(tc, "小王");
        Thread t2 = new Thread(tc, "小李");
        Thread t3 = new Thread(tc, "黄牛党");
        t1.setPriority(2);
        t2.setPriority(4);
        t3.setPriority(8);
        t1.start();
        t2.start();
        t3.start();
    }
}
