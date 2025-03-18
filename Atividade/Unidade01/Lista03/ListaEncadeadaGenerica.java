package com.algoritmos.listas.listaencadeada.generica;

public class ListaEncadeadaGenerica<T> {
    private NoLista<T> primeiro;
    
    public ListaEncadeadaGenerica() {
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<T>();

        novo.setInfo(valor);
        novo.setProximo(this.primeiro);
        this.primeiro = novo;

    }

    public void exibir(){
        NoLista<T> p = this.primeiro;

        while (p != null){
            System.out.println(p.getInfo());
            p = p.getProximo(); // p = p.proximo
        }
    }

    public boolean estaVazia(){
        if (this.primeiro == null){
            return true;
        }
        else{
            return false;
        }
    }

    public NoLista<T> buscar(T valor){
        NoLista<T> p = this.primeiro;

        while (p != null){
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor){
        NoLista<T> p = this.primeiro;
        NoLista<T> anterior = null;

        // procura nó que contém dado a ser removido,
        // guardando o anterior
        while (p != null && p.getInfo() != valor){
            anterior = p;
            p = p.getProximo();
        }

        // Se achou nó, retira-o da lista
        if (p != null){
            if (p == this.primeiro){
                this.primeiro = p.getProximo();
            }
            else{
                anterior.setProximo(p.getProximo());
            }
        }
                }


    public int obterComprimento(){
        NoLista<T> p = this.primeiro;

        int cont = 0;
        while (p != null){
            cont++;
            p = p.getProximo();
        }
        return cont;
    }
    
    public NoLista<T> obterNo(int idx){
        NoLista<T> p = this.primeiro;

        if (idx < 0 || idx >= obterComprimento()) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }

        int cont = 0;
        while (p != null && cont < idx){
            cont++;
            p = p.getProximo();
        }
        return p;
    }
    
    public String toString(){
        String string = "";
        NoLista<T> p = this.primeiro;
        while (p != null){
            string = string + p.getInfo() + ",";
            p = p.getProximo();
        }
        return string;
    }

    public ListaEncadeadaGenerica<T> criarInvertida(){
        ListaEncadeadaGenerica<T> invertida = new ListaEncadeadaGenerica<T>();
        NoLista<T> p = this.primeiro;
        
        while (p != null){
            invertida.inserir(p.getInfo());
            p = p.getProximo();
        }
        return invertida;
    }

    public ListaDupla<T> clonar() {
        ListaDupla<T> clone = new ListaDupla<>();
        NoLista<T> atual = this.primeiro;
        NoListaDupla<T> ultimo = null;

        while (atual != null) {
            NoListaDupla<T> novo = new NoListaDupla<T>();
            novo.setInfo(atual.getInfo());

            if (clone.getPrimeiro() == null) {
                clone.setPrimeiro(novo);
            } 
            else {
                ultimo.setProximo(novo); 
                novo.setAnterior(ultimo);
            }
            ultimo = novo;
            atual = atual.getProximo();
        }
        return clone;
    }
}


