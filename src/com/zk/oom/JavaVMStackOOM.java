package com.zk.oom;

/**
 * 虚拟机栈内存溢出
 *
 * VM Args: -Xss2M （这时候不妨设置大一些）
 *
 * 线程过多导致的栈内存溢出
 */
public class JavaVMStackOOM {

    public static void main(String[] args) {
        while (true) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            dontStop();
                        }
                    }
            ).start();
        }
    }
    private static void dontStop() {
        while (true) {
        }
    }
}
