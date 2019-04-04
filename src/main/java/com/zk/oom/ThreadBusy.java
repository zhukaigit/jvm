package com.zk.oom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class ThreadBusy {

  /**
   * 线程死循环演示
   */
  public static void createBusyThread() {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {}
      }
    }, "testBusyThread");
    thread.start();
  }

  public static void createLockThread(final Object lock) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }, "testLockThread");
    thread.start();
  }

  /**
   * 休眠
   */
  public static void createSleepThread() {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "testSleepThread");
    thread.start();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("第一次：" + br.readLine());
    createBusyThread();
    System.out.println("第二次：" + br.readLine());
//    br.readLine();
    Object obj = new Object();
    createLockThread(obj);
    createSleepThread();
  }

}
