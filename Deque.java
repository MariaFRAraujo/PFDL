package com.maria.lib;

import java.util.ArrayList;

public class Deque<T> {

    private static final int DEFAULT_LIMIT = 100;

    private ArrayList<T> data;
    private final int limit;

    public Deque() {
        this(DEFAULT_LIMIT);
    }

    public Deque(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("O limite deve ser maior que zero.");
        }
        this.limit = limit;
        this.data = new ArrayList<T>();
    }

    // Valida as regras de inserção: capacidade e unicidade
    private void validateInsertion(T val) {
        if (isFull()) {
            throw new IllegalStateException("Deque cheio (limite: " + this.limit + "). Inserção ignorada: " + val);
        }
        if (this.data.contains(val)) {
            throw new IllegalArgumentException("Elemento duplicado. Inserção ignorada: " + val);
        }
    }

    //método para inserção no inicio da estrutura
    public void insertFront(T val) {
        validateInsertion(val);
        this.data.add(0, val);
    }

    //método para inserção no final da estrutura
    public void insertBack(T val) {
        validateInsertion(val);
        this.data.add(val);
    }

    //método para remoção no início da estrutura
    public T removeFront() {
        if (isEmpty()) {
            return null;
        }
        return this.data.remove(0);
    }

    //método para remoção no final da estrutura
    public T removeBack() {
        if (isEmpty()) {
            return null;
        }
        return this.data.remove(this.data.size() - 1);
    }

    //método para consultar o inicio da estrutura(sem remover)
    public T peekFront() {
        if (isEmpty()) {
            return null;
        }
        return this.data.get(0);
    }

    //método para consultar o final da estrutura(sem remover)
    public T peekBack() {
        if (isEmpty()) {
            return null;
        }
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public boolean isFull() {
        return this.data.size() >= this.limit;
    }

    //método que imprimi a estrutura (para efeitos de depuração)
    public String print() {
        StringBuilder output = new StringBuilder("[ ");
        for (int i = 0; i < this.data.size(); i++) {
            if (output.length() > 2) {
                output.append(", ");
            }
            output.append("(")
                    .append(i)
                    .append("): ")
                    .append(this.data.get(i));
        }
        output.append(" ]");
        return output.toString();
    }
}
