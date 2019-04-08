package com.zk;

import org.junit.Test;

public class CommonTest {

  @Test
  public void test() {
    System.out.println("ok");
  }


  @Test
  public void test2() throws InterruptedException {
    cpuFix();
  }

  public static void cpuFix() throws InterruptedException {
    // 80%的占有率
    int busyTime = 8;
    // 20%的占有率
    int idelTime = 2;
    // 开始时间
    long startTime = 0;

    while (true) {
      // 开始时间
      startTime = System.currentTimeMillis();

      /*
       * 运行时间
       */
      while (System.currentTimeMillis() - startTime < busyTime) {
        ;
      }

      // 休息时间
      Thread.sleep(idelTime);
    }
  }
}
