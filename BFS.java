// BFS.G; s
// Page 595
// CLRS Third Edition Chapter 22.2

package com.company;

import java.util.*;
import java.lang.*;

class Node {
    private String color;
    private int degree;
    private Node predecessor;
    private int val;
    public void setColor(String c) {
        color = c;
    }
    public String getColor() {
        return color;
    }
    public void setDegree(int d) {
        degree = d;
    }
    public int getDegree() {
        return degree;
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
    Node (String c, int d, Node p, int v) {
        color = c;
        degree = d;
        predecessor = p;
        val = v;
    }
}
class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        LinkedList<Node>[] graph = new LinkedList[8];
        for(int i=0;i<graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        Node r = new Node("White", 9, null, 0);
        Node s = new Node("White", 9, null, 1);
        Node t = new Node("White", 9, null, 2);
        Node u = new Node("White", 9, null, 3);
        Node v = new Node("White", 9, null, 4);
        Node w = new Node("White", 9, null, 5);
        Node x = new Node("White", 9, null, 6);
        Node y = new Node("White", 9, null, 7);
        graph[0].add(s);
        graph[0].add(v);
        graph[1].add(r);
        graph[1].add(w);
        graph[2].add(s);
        graph[2].add(w);
        graph[2].add(x);
        graph[3].add(t);
        graph[3].add(x);
        graph[3].add(y);
        graph[4].add(r);
        graph[5].add(s);
        graph[5].add(t);
        graph[5].add(x);
        graph[6].add(w);
        graph[6].add(t);
        graph[6].add(u);
        graph[6].add(y);
        graph[7].add(u);
        graph[7].add(x);
        Queue<Node> queue = new LinkedList<>();
        queue.add(s);
        s.setColor("Gray");
        s.setDegree(0);
        s.setPredecessor(null);
        while(!queue.isEmpty()) {

            System.out.print("Queue: ");
            for (Node node : queue) {
                System.out.print(node.getVal() + " ");
            }
            System.out.println();

            System.out.println("s : " + s.getColor() + " " +  s.getDegree() + " " + (s.getPredecessor() != null ? s.getPredecessor().getVal() : ""));
            System.out.println("w : " + w.getColor() + " " +  w.getDegree() + " " + (w.getPredecessor() != null ? w.getPredecessor().getVal() : ""));
            System.out.println("r : " + r.getColor() + " " +  r.getDegree() + " " + (r.getPredecessor() != null ? r.getPredecessor().getVal() : ""));
            System.out.println("t : " + t.getColor() + " " +  t.getDegree() + " " + (t.getPredecessor() != null ? t.getPredecessor().getVal() : ""));
            System.out.println("x : " + x.getColor() + " " +  x.getDegree() + " " + (x.getPredecessor() != null ? x.getPredecessor().getVal() : ""));
            System.out.println("v : " + v.getColor() + " " +  v.getDegree() + " " + (v.getPredecessor() != null ? v.getPredecessor().getVal() : ""));
            System.out.println("u : " + u.getColor() + " " +  u.getDegree() + " " + (u.getPredecessor() != null ? u.getPredecessor().getVal() : ""));
            System.out.println("y : " + y.getColor() + " " +  y.getDegree() + " " + (y.getPredecessor() != null ? y.getPredecessor().getVal() : ""));

            Node curr = queue.remove();
            for (int i=0;i<graph[curr.getVal()].size();i++) {
                Node tmp = graph[curr.getVal()].get(i);
                if(tmp.getColor().equals("White")) {
                    tmp.setColor("Gray");
                    tmp.setDegree(curr.getDegree()+1);
                    tmp.setPredecessor(curr);
                    queue.add(tmp);
                }
            }
            curr.setColor("Black");
        }
    }
}
