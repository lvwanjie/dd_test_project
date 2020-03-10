package com.example.myapplication.algorithm.entity;

public class Node {

    public Node next;

    public int value;

    public void printAllLinked(){
        Node node = this;
        StringBuilder builder = new StringBuilder();
        while (node != null){
            builder.append(node.value+"->");
            node = node.next;
        }
        System.out.println(builder);
    }

    public static Node createNode(int size){
        Node node = new Node();
        Node curNode = node;
        for(int i=0;i<size; i++){
            curNode.next = new Node();
            curNode.value = i;
            curNode = curNode.next;
        }
        curNode.next = null;
        return node;
    }

    public static Node createNode(int values[]){
        Node node = new Node();
        Node curNode = node;

        for(int i= 0;i<values.length;i++){
            Node n = new Node();
            n.value = values[i];
            curNode.next = n;
            curNode = curNode.next;
        }
        return node.next;

    }
}
