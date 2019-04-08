package com.zk.oom;

public class DeadLock {

  private static final Object A_LOCK = new Object();
  private static final Object B_LOCK = new Object();

  public static void main(String[] args) throws InterruptedException {
    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (A_LOCK) {
          System.out.println(Thread.currentThread().getName() + "拿到A锁，等待B锁");
          try {
            // 确保第二个线程已经占用B锁
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized (B_LOCK) {
            System.out.println("do 2...");
          }
        }
      }
    }).start();

    // 确保第一个线程已经占用A锁
    Thread.sleep(200);

    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (B_LOCK) {
          System.out.println(Thread.currentThread().getName() + "拿到B锁，等待A锁");
          synchronized (A_LOCK) {
            System.out.println("do 2...");
          }
        }
      }
    }).start();

  }

}
