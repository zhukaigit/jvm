package com.zk.oom;

public class JavaVMStackSOF {

    /**
     * 虚拟机内存溢出
     *
     * 测试虚拟机栈内存溢出（即，stackOverFlowError）
     * -Xss：设置每个线程的栈容量大小。默认JDK1.4中是256K，JDK1.5+中是1M
     *
     * 本示例：-Xss160k
     *
     * 结果表明：无论是由于栈帧太大还是虚拟机栈容量太小，当内存无法分配的时候，虚拟机栈抛出的都是StackOverFlowError异常
     */
    public static void main(String[] args) throws Throwable {
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length : " + stackLength);
            throw e;
        }
    }

    private static int stackLength = 1;

    private static void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
