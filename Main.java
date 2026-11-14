package com.maria;

import com.maria.lib.Deque;
import com.maria.lib.LinkedList;
import com.maria.lib.Queue;
import com.maria.lib.Stack;

public class Main {

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
        ex8();
        ex9();
        ex10();
    }

    private static void titulo(String t) {
        System.out.println("\n===== " + t + " =====");
    }

    private static void ex1() {
        titulo("Ex 1: Fila de atendimento com contador de operações");
        Queue<String> fila = new Queue<>();
        fila.enqueue("Ana");
        fila.enqueue("Bruno");
        fila.enqueue("Carla");
        fila.enqueue("Diego");
        System.out.println("Fila: " + fila.print());
        System.out.println("Atendido: " + fila.dequeue());
        System.out.println("Atendido: " + fila.dequeue());
        System.out.println("Fila: " + fila.print());
        System.out.println("Total de operações: " + fila.getOperationCount());
    }

    private static void ex2() {
        titulo("Ex 2: Pilha de navegação com histórico de remoções");
        Stack<String> paginas = new Stack<>();
        paginas.push("google.com");
        paginas.push("youtube.com");
        paginas.push("github.com");
        paginas.push("stackoverflow.com");
        System.out.println("Pilha: " + paginas.print());
        System.out.println("Voltar (pop): " + paginas.pop());
        System.out.println("Voltar (pop): " + paginas.pop());
        System.out.println("Pilha: " + paginas.print());
        System.out.println("Histórico: " + paginas.getHistory());
    }

    private static void ex3() {
        titulo("Ex 3: Deque com capacidade limitada (5)");
        Deque<Integer> deque = new Deque<>(5);
        for (int i = 1; i <= 6; i++) {
            try {
                if (i % 2 == 0) deque.insertFront(i); else deque.insertBack(i);
                System.out.println("Inserido: " + i);
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
        System.out.println("Deque: " + deque.print());
    }

    private static void ex4() {
        titulo("Ex 4: Pilha de desfazer (Undo) com capacidade 5");
        Stack<String> undo = new Stack<>(5);
        String[] acoes = {"digitar 'Olá'", "negrito", "colar texto", "apagar linha", "itálico", "sublinhar"};
        for (String acao : acoes) {
            try {
                undo.push(acao);
                System.out.println("Ação registrada: " + acao);
            } catch (IllegalStateException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
        System.out.println("Pilha Undo: " + undo.print());
        System.out.println("Desfazendo: " + undo.pop());
    }

    private static void ex5() {
        titulo("Ex 5: Deque de carrinho com itens únicos");
        Deque<String> carrinho = new Deque<>();
        String[] itens = {"Notebook", "Mouse", "Teclado", "Mouse", "Monitor", "Notebook"};
        for (String item : itens) {
            try {
                carrinho.insertBack(item);
                System.out.println("Adicionado: " + item);
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
        System.out.println("Carrinho: " + carrinho.print());
    }

    private static void ex6() {
        titulo("Ex 6: Histórico de remoções na lista encadeada");
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 10; i <= 50; i += 10) lista.insertTail(i);
        System.out.println(lista.print());
        lista.remove(2);
        lista.removeHead();
        lista.removeTail();
        System.out.println(lista.print());
        System.out.println("Histórico de remoções: " + lista.getHistory());
    }

    private static void ex7() {
        titulo("Ex 7: Reversão in loco");
        LinkedList<String> lista = new LinkedList<>();
        for (String s : new String[]{"A", "B", "C", "D", "E"}) lista.insertTail(s);
        System.out.println("Antes:  " + lista.print());
        lista.reverse();
        System.out.println("Depois: " + lista.print());
        System.out.println("Head: " + lista.peekHead() + ", Tail: " + lista.peekTail());
        lista.insertTail("F"); // confirma que tail está correto
        System.out.println("Após insertTail(F): " + lista.print());
    }

    private static void ex8() {
        titulo("Ex 8: Contagem de ocorrências");
        LinkedList<Integer> lista = new LinkedList<>();
        for (int v : new int[]{1, 2, 2, 3, 2, 4, 3}) lista.insertTail(v);
        System.out.println(lista.print());
        for (int v : new int[]{1, 2, 3, 9})
            System.out.println("Ocorrências de " + v + ": " + lista.countOccurrences(v));
    }

    private static void ex9() {
        titulo("Ex 9: Remoção de todas as ocorrências");
        LinkedList<Integer> lista = new LinkedList<>();
        for (int v : new int[]{7, 7, 1, 7, 2, 7, 3, 7, 7}) lista.insertTail(v);
        System.out.println("Antes:  " + lista.print());
        int removidos = lista.removeAll(7);
        System.out.println("Removidos: " + removidos);
        System.out.println("Depois: " + lista.print());
        lista.insertTail(99); // confirma tail
        System.out.println("Após insertTail(99): " + lista.print());

        LinkedList<Integer> igual = new LinkedList<>();
        igual.insertTail(5); igual.insertTail(5);
        igual.removeAll(5);
        System.out.println("Lista só com 5s após removeAll(5): " + igual.print() + " | vazia? " + igual.isEmpty());
    }

    private static void ex10() {
        titulo("Ex 10: Lista encadeada para ArrayList");
        LinkedList<String> lista = new LinkedList<>();
        for (String s : new String[]{"Java", "Python", "C", "Rust"}) lista.insertTail(s);
        System.out.println("Lista: " + lista.print());
        System.out.println("ArrayList: " + lista.toArray());
    }
}
