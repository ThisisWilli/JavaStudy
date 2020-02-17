package com.jvm;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-17 13:33
 **/

/**
 * 得出虚拟机试图使用的最大内存和实际使用的内存
 */
public class GetMemory {
    public static void main(String[] args) {
        // 返回虚拟机试图使用最大内存
        long max = Runtime.getRuntime().maxMemory();
        // 返回虚拟机实际使用内存
        long total = Runtime.getRuntime().totalMemory();
        System.out.println("试图使用最大内存为 " + max);
        System.out.println("实际使用内存为 " + total);

        // -Xms1024m -Xmx1024m -XX:+PrintGCDetails

    }
}
