package com.maria.lib;

import java.util.ArrayList;

public class Stack<T> {

    private static final int DEFAULT_LIMIT = 100;

    private ArrayList<T> data;        // Lista interna privada
    private ArrayList<T> historyData; // Histórico de elementos removidos (pop)
    private final int limit;          // Capacidade máxima

    public Stack() {
        this(DEFAULT_LIMIT);
    }

    public Stack(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("O limite deve ser maior que zero.");
        }
        this.limit = limit;
        this.data = new ArrayList<T>();
        this.historyData = new ArrayList<T>();
    }

    //método para inserção de dados na pilha
    public void push(T val) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia (limite: " + this.limit + "). Inserção ignorada: " + val);
        }
        this.data.add(val);
    }

    //método para remoção de dados na pilha
    public T pop() {
        if (isEmpty()) return null;
        T removed = this.data.remove(this.data.size() - 1);
        this.historyData.add(removed);
        return removed;
    }

    //retorna uma cópia do histórico de elementos removidos
    public ArrayList<T> getHistory() {
        return new ArrayList<T>(this.historyData);
    }

    //método para informar se a pilha está vazia
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    //método para informar se a pilha atingiu o limite
    public boolean isFull() {
        return this.data.size() >= this.limit;
    }

    //método para consultar o topo (última posição) da pilha (sem remover)
    public T peek() {
        if (isEmpty()) return null;
        return this.data.get(this.data.size() - 1);
    }

    // método que imprime a pilha para efeitos de depuração
    public String print() {
        return this.data.toString();
    }
}
