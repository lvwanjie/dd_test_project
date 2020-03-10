package com.example.myapplication.algorithm;

import com.example.myapplication.algorithm.entity.Node;

/**
 * 合并两个有序链表
 */
public class CombineLinked {

    private static int nums1[] ={1,3,8,9};
    private static int nums2[] ={2,3,4,5,10};

    public static void main(String args[]){
        Node node1 = Node.createNode(nums1);
        node1.printAllLinked();
        Node node2 = Node.createNode(nums2);
        node2.printAllLinked();
        Node newNode = combine(node1,node2);
        newNode.printAllLinked();
    }


    public static Node combine(Node node1,Node node2){
        Node currentNewNode = new Node();
        Node newNode = currentNewNode;

        while (node1 != null && node2 != null){
            if(node1.value < node2.value){
                currentNewNode.next = node1;
                node1 = node1.next;
            }else {
                currentNewNode.next = node2;
                node2 = node2.next;
            }
            currentNewNode = currentNewNode.next;

        }
        if(node1 != null){
            currentNewNode.next = node1;
        }

        if(node2 != null){
            currentNewNode.next = node2;
        }

        return newNode.next;
    }

}
