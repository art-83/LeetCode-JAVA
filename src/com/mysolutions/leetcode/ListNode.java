package com.mysolutions.leetcode;

public class ListNode {
    int val;
    ListNode next;

    // Flag para saber se o nó foi inicializado com um valor válido
    private boolean inicializado = false;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.inicializado = true;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
        this.inicializado = true;
    }

    // Método para inserir um novo nó no final da lista
    public void inserir(int novoValor) {
        if (!inicializado) {
            this.val = novoValor;
            this.inicializado = true;
            return;
        }

        ListNode atual = this;
        while (atual.next != null) {
            atual = atual.next;
        }
        atual.next = new ListNode(novoValor);
    }

    // Método para imprimir todos os valores da lista
    public void imprimir() {
        if (!inicializado) {
            System.out.println("Lista vazia");
            return;
        }

        ListNode atual = this;
        while (atual != null) {
            System.out.print(atual.val + " -> ");
            atual = atual.next;
        }
        System.out.println("null");
    }
}
