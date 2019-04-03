package com.zk.oom;

import java.util.ArrayList;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 运行时常量池导致的内存溢出异常
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        String base = "你好呀";
        while (true) {
            String add = base + base;
            list.add(add.intern());
            base = add;
        }
    }
}
