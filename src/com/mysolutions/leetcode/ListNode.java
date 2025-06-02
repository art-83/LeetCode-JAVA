package com.mysolutions.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Método para inserir um novo nó no final da lista
    public void inserir(int novoValor) {
        ListNode atual = this;
        while (atual.next != null) {
            atual = atual.next;
        }
        atual.next = new ListNode(novoValor);
    }

    // Método para imprimir todos os valores da lista
    public void imprimir() {
        ListNode atual = this;
        while (atual != null) {
            System.out.print(atual.val + " -> ");
            atual = atual.next;
        }
        System.out.println("null");
    }
}
