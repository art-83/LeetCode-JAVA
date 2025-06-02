package com.mysolutions.leetcode;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode();

        node.inserir(3);
        node.inserir(2);
        node.inserir(1);

        s.sortNode(node);
        node.imprimir();
    }
}