package com.mysolutions.leetcode;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode();

        node.inserir(1);
        node.inserir(1);
        node.inserir(2);

        node.imprimir();

        node = s.deleteDuplicates(node);

        node.imprimir();
    }
}
