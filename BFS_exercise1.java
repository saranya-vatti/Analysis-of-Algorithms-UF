// BFS.G; s
// Page 601
// CLRS Third Edition Chapter 22
// Exercise 22.2-1
// Figure 22.1

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
        Node one = new Node("White", 9, null, 0);
        Node two = new Node("White", 9, null, 1);
        Node three = new Node("White", 9, null, 2);
        Node four = new Node("White", 9, null, 3);
        Node five = new Node("White", 9, null, 4);
        graph[0].add(two);
        graph[0].add(five);
        graph[1].add(one);
        graph[1].add(three);
        graph[1].add(four);
        graph[1].add(five);
        graph[2].add(two);
        graph[2].add(four);
        graph[3].add(two);
        graph[3].add(three);
        graph[3].add(five);
        graph[4].add(one);
        graph[5].add(two);
        graph[5].add(four);
        Queue<Node> queue = new LinkedList<>();
        queue.add(three);
        three.setColor("Gray");
        three.setDegree(0);
        three.setPredecessor(null);
        while(!queue.isEmpty()) {

            System.out.print("Queue: ");
            for (Node node : queue) {
                System.out.print(node.getVal() + " ");
            }
            System.out.println();

            System.out.println("three : " + three.getColor() + " " +  three.getDegree() + " " + (three.getPredecessor() != null ? three.getPredecessor().getVal() : ""));
            System.out.println("two : " + two.getColor() + " " +  two.getDegree() + " " + (two.getPredecessor() != null ? two.getPredecessor().getVal() : ""));
            System.out.println("four : " + four.getColor() + " " +  four.getDegree() + " " + (four.getPredecessor() != null ? four.getPredecessor().getVal() : ""));
            System.out.println("one : " + one.getColor() + " " +  one.getDegree() + " " + (one.getPredecessor() != null ? one.getPredecessor().getVal() : ""));
            System.out.println("five : " + five.getColor() + " " +  five.getDegree() + " " + (five.getPredecessor() != null ? five.getPredecessor().getVal() : ""));

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
