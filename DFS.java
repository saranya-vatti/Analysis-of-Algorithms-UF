// DFS
// Algo Page 604
// Figure PAge 605
// CLRS Third Edition Chapter 22
// Exercise 22.2-2
// Figure 22.3a, with u as the starting point

package com.company;

import java.util.*;
import java.lang.*;

class Node {
    private String color;
    private int start;
    private int end;
    private Node predecessor;
    private int val;
    public void setColor(String c) {
        color = c;
    }
    public String getColor() {
        return color;
    }
    public void setStart(int s) {
        start = s;
    }
    public int getStart() {
        return start;
    }
    public void setEnd(int e) {
        end = e;
    }
    public int getEnd() {
        return end;
    }
    public void setPredecessor(Node p) {
        predecessor = p;
    }
    public Node getPredecessor() {
        return predecessor;
    }
    public void setVal(int v) {
        val = v;
    }
    public int getVal() {
        return val;
    }
    Node (String c, Node p, int v) {
        color = c;
        predecessor = p;
        val = v;
        start = -1;
    }
}
class Main
{
    private static int time=0;
    private static void visit(LinkedList<Node>[] graph, Node curr) {
        time++;
        if(curr.getStart() == -1) {
            curr.setStart(time);
        }
        curr.setColor("Gray");
        for (int i=0;i<graph[curr.getVal()].size();i++) {
            Node tmp = graph[curr.getVal()].get(i);
            if (tmp.getColor() == "White") {
                tmp.setPredecessor(curr);
                visit(graph, tmp);
            }
        }
        curr.setColor("Black");
        time++;
        curr.setEnd(time);
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        LinkedList<Node>[] graph = new LinkedList[6];
        for(int i=0;i<graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        Node u = new Node("White", null, 0);
        Node v = new Node("White", null, 1);
        Node w = new Node("White", null, 2);
        Node x = new Node("White", null, 3);
        Node y = new Node("White", null, 4);
        Node z = new Node("White", null, 5);
        graph[0].add(v);
        graph[0].add(x);
        graph[1].add(y);
        graph[2].add(y);
        graph[2].add(z);
        graph[3].add(v);
        graph[4].add(x);
        graph[5].add(z);
        Node[] tmp1 = {u,v,w,x,y,z};
        for(int i=0;i<tmp1.length;i++) {
            Node curr = tmp1[i];
            if(curr.getColor() == "White") {
                visit(graph, curr);

                System.out.println("Running over : " + curr.getVal());
                System.out.println("u : " + u.getColor() + " Start : " +  u.getStart() + " End : " + u.getEnd() + " Predecessor : " + (u.getPredecessor() != null ? u.getPredecessor().getVal() : ""));
                System.out.println("v : " + v.getColor() + " Start : " +  v.getStart() + " End : " + v.getEnd() + " Predecessor : " + (v.getPredecessor() != null ? v.getPredecessor().getVal() : ""));
                System.out.println("w : " + w.getColor() + " Start : " +  w.getStart() + " End : " + w.getEnd() + " Predecessor : " + (w.getPredecessor() != null ? w.getPredecessor().getVal() : ""));
                System.out.println("x : " + x.getColor() + " Start : " +  x.getStart() + " End : " + x.getEnd() + " Predecessor : " + (x.getPredecessor() != null ? x.getPredecessor().getVal() : ""));
                System.out.println("y : " + y.getColor() + " Start : " +  y.getStart() + " End : " + y.getEnd() + " Predecessor : " + (y.getPredecessor() != null ? y.getPredecessor().getVal() : ""));
                System.out.println("z : " + z.getColor() + " Start : " +  z.getStart() + " End : " + z.getEnd() + " Predecessor : " + (z.getPredecessor() != null ? z.getPredecessor().getVal() : ""));
            }
        }
    }
}
