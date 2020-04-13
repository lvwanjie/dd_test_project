package com.example.myapplication.algorithm;


import com.example.myapplication.algorithm.entity.Node;

/**
 * 给出一个链表 ，以及 一个k 值 每k个值做翻转
 * 例 1，2，3，4，5  k= 2
 * 结果 2，1，4，3，5
 *
 */
public class ReverseKNode {

    public static int num[] ={1,2,3,4,5};

    public static void main(String args[]){

       Node node = Node.createNode(num);
       node.printAllLinked();
//       Node newNode = reverse(node);
//       newNode.printAllLinked();

       Node newNode = reverse(node,2);
       newNode.printAllLinked();

    }

    public static Node reverse(Node node , int k){

        Node countNode = node;
        int nodeCount = 0;
        while (countNode != null){
            nodeCount++;
            countNode = countNode.next;
        }

        int n = nodeCount/k;
        int m = nodeCount%k;
        Node cNode = null;
        Node sNode = null;
        for(int i= 0;i < n;i++){
            Node kNode = reverse(node,i*k,(i+1)*k-1);
            if(cNode == null){
                cNode = kNode;
                sNode = kNode;
            }else {
                Node pNode = sNode;
                while (pNode.next != null){
                    pNode= pNode.next;
                }
                pNode.next = kNode;
                sNode = kNode;
            }
        }
        if(m > 0){
            Node kNode = reverse(node,n*k,n*k+m);
            Node pNode = sNode;
            while (pNode.next != null){
                pNode= pNode.next;
            }
            pNode.next = kNode;
        }

        return cNode;

    }




    public static Node reverse(Node node,int start,int end){
        Node startNode = null;
        if(start == 0){
            startNode = node;
        }else {
            Node countNode = node;
            while (countNode != null && start !=0 ){
                countNode = countNode.next;
                start --;
            }
            if(start != 0){
                return null;
            }else {
                startNode = countNode;
            }
        }
        Node curNode = startNode;
        Node preNode = null;
        int count = start;
        while (curNode != null && count < end){
            count ++;
            Node next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        if(count < end){
            return startNode;
        }else {
            return preNode;
        }

    }



    public static Node reverse(Node node){
        Node preNode = null;
        while (node!= null){
            Node next = node.next;
            node.next = preNode;
            preNode = node;
            node = next;
        }
        return preNode;
    }
}
