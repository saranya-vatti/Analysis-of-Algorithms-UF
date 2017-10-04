// DFS-Stack-Print-Edges
// Figure Page 605
// CLRS Third Edition Chapter 22 Page 612
// Exercise 22.3-11 - Number of connected components
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
    private int connectedComponent;
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
    public int getVal() {
        return val;
    }
    public void setConnectedComponent(int v) {
        connectedComponent = v;
    }
    public int getConnectedComponent() {
        return connectedComponent;
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
    private static int connectedComponentCounter = 1;
    private static LinkedList<String> tree_edges = new LinkedList();
    private static LinkedList<String> back_edges = new LinkedList();
    private static LinkedList<String> forward_edges = new LinkedList();
    private static LinkedList<String> cross_edges = new LinkedList();
    private static void visit(LinkedList<Node>[] graph, Node s) {
        Stack<Node> st = new Stack();
        st.push(s);
        time++;
        s.setStart(time);
        s.setConnectedComponent(connectedComponentCounter);
        while(!st.isEmpty()) {
            Node curr = st.peek();
            curr.setColor("Gray");
            int numOfWhiteChildren = 0;
            for (int i=0;i<graph[curr.getVal()].size();i++) {
                Node tmp = graph[curr.getVal()].get(i);
                String edge = curr.getVal() + " " + tmp.getVal();
                if (tmp.getColor() == "White") {
                    numOfWhiteChildren++;
                    tmp.setPredecessor(curr);
                    tmp.setConnectedComponent(curr.getConnectedComponent());
                    if(tmp.getStart() == -1) {
                        time++;
                        tmp.setStart(time);
                        if(!tree_edges.contains(edge) && !back_edges.contains(edge) && !forward_edges.contains(edge) && !cross_edges.contains(edge)) {
                            tree_edges.push(edge);
                        }
                    }
                    tmp.setColor("Gray");
                    st.push(tmp);
                } else if(tmp.getColor() == "Gray") {
                    if(!tree_edges.contains(edge) && !back_edges.contains(edge) && !forward_edges.contains(edge) && !cross_edges.contains(edge)) {
                        back_edges.push(edge);
                    }
                } else {
                    if(curr.getStart() < tmp.getStart()) {
                        if(!tree_edges.contains(edge) && !back_edges.contains(edge) && !forward_edges.contains(edge) && !cross_edges.contains(edge)) {
                            forward_edges.push(edge);
                        }
                    } else {
                        if(!tree_edges.contains(edge) && !back_edges.contains(edge) && !forward_edges.contains(edge) && !cross_edges.contains(edge)) {
                            cross_edges.push(edge);
                        }
                    }
                }
            }
            if(numOfWhiteChildren == 0) {
                st.pop();
                curr.setColor("Black");
                time++;
                curr.setEnd(time);
            }
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        LinkedList<Node>[] graph = new LinkedList[13];
        for(int i=0;i<graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        Node n = new Node("White", null, 10);
        Node o = new Node("White", null, 11);
        Node p = new Node("White", null, 12);
        Node q = new Node("White", null, 0);
        Node r = new Node("White", null, 1);
        Node s = new Node("White", null, 2);
        Node t = new Node("White", null, 3);
        Node u = new Node("White", null, 4);
        Node v = new Node("White", null, 5);
        Node w = new Node("White", null, 6);
        Node x = new Node("White", null, 7);
        Node y = new Node("White", null, 8);
        Node z = new Node("White", null, 9);
        graph[0].add(s);
        graph[0].add(w);
        graph[0].add(t);
        graph[1].add(u);
        graph[1].add(y);
        graph[2].add(v);
        graph[3].add(x);
        graph[3].add(y);
        graph[4].add(y);
        graph[5].add(w);
        graph[6].add(s);
        graph[7].add(z);
        graph[8].add(q);
        graph[9].add(x);
        graph[10].add(o);
        graph[11].add(p);
        Node[] array = {n,o,p,q,r,s,t,u,v,w,x,y,z};
        for(int i=0;i<array.length;i++) {
            Node curr = array[i];
            if(curr.getColor() == "White") {
                System.out.println("Running over : " + curr.getVal());
                visit(graph, curr);
                connectedComponentCounter++;
            }
        }
        System.out.println("Tree edges : ");
        for (int i=0;i<tree_edges.size();i++) {
            System.out.print(tree_edges.get(i) + "; ");
        }
        System.out.println();
        System.out.println("Back edges : ");
        for (int i=0;i<back_edges.size();i++) {
            System.out.print(back_edges.get(i) + "; ");
        }
        System.out.println();
        System.out.println("Forward edges : ");
        for (int i=0;i<forward_edges.size();i++) {
            System.out.print(forward_edges.get(i) + "; ");
        }
        System.out.println();
        System.out.println("Cross edges : ");
        for (int i=0;i<cross_edges.size();i++) {
            System.out.print(cross_edges.get(i) + "; ");
        }
        System.out.println();
        for(int j=0;j<array.length;j++) {
            Node tmp3 = array[j];
            System.out.println(tmp3.getVal() + " : " + tmp3.getColor() + "; Start : " +  tmp3.getStart() + "; End : " + tmp3.getEnd() + "; Predecessor : " + (tmp3.getPredecessor() != null ? tmp3.getPredecessor().getVal() : "NA") + "; Connected Component : " + tmp3.getConnectedComponent());
        }
        System.out.println();
    }
}
