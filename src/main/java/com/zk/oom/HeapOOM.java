package com.zk.oom;

import java.util.ArrayList;

/**
 * 堆内存溢出
 *
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * 通过参数-XX:+HeapDumpOnOutOfMemoryError可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后分析
 */
public class HeapOOM {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();
        while (true) {
            list.add(new Object());
        }
    }
}
