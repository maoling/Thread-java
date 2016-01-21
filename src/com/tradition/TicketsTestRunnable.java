package com.tradition;
class MyRunnable implements Runnable{
    
    private int ticketsCount = 5;
    
    
    public void run() {
        while(ticketsCount > 0){
            ticketsCount--;
            System.out.println(Thread.currentThread().getName()+" 卖了一张票，还剩下："+ticketsCount);
        }
    }
}
public class TicketsTestRunnable {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread th1 = new Thread(mr,"窗口1");
        Thread th2 = new Thread(mr,"窗口2");
        Thread th3 = new Thread(mr,"窗口3");
        
        th1.start();
        th2.start();
        th3.start();
    }
}