package com.company.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-29 15:52
 *
 * 小团惹小美生气了，小美要去找小团“讲道理”。小团望风而逃，他们住的地方可以抽象成一棵有n个结点的树，小美位于x位置，小团位于y位置。
 * 小团和小美每个单位时间内都可以选择不动或者向相邻的位置转移，假设小美足够聪明，很显然最终小团会无路可逃，只能延缓一下被“讲道理”的时间，
 * 请问最多经过多少个单位时间后，小团会被追上。
 *
 *
 *
 * 输入描述
 * 输入第一行包含三个整数n，x，y，分别表示树上的结点数量，小美所在的位置和小团所在的位置。(1<=n<=50000)
 *
 * 接下来有n-1行，每行两个整数u，v，表示u号位置和v号位置之间有一条边，即u号位置和v号位置彼此相邻。
 *
 * 输出描述
 * 输出仅包含一个整数，表示小美追上小团所需的时间。
 *
 *
 * 样例输入
 * 5 1 2
 * 2 1
 * 3 1
 * 4 2
 * 5 3
 * 样例输出
 * 2
 **/

public class Main3 {


    static List<List<Integer>> graph;
    // 找到最远的入度为1的节点，并且
    /**
     *
     * @param graph
     * @param x
     * @param y 团
     */
    public void helper(List<List<Integer>> graph, int x, int y){
        boolean[] visited = new boolean[graph.size()];
        while (y != x){
            for (int i = 0; i < graph.get(x).size(); i++) {
                int loc = graph.get(x).get(i);
                if (loc != y){

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        graph = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x + 1).add(y);
            graph.get(y + 1).add(x);
        }
    }
}
