/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listaestatica_sjcandido_001;

/**
 *
 * @author samue
 */
public class ListaEstatica_SJCANDIDO_001 {

    private int[] info;
    private int tamanho;
    
    public static void main(String[] args) {
        ListaEstatica_SJCANDIDO_001 lista = new ListaEstatica_SJCANDIDO_001();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.exibir();
        lista.retirar(10);
        lista.exibir();
        System.out.println("Buscar 15: " + lista.buscar(15));
        System.out.println("Buscar 10: " + lista.buscar(10));
    }

    public ListaEstatica_SJCANDIDO_001() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    private void redimencionar(){
        int[] novo;
        int novoTamanho = info.length + 10;
        novo = new int[novoTamanho];
        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public void inserir(int valor){
        if (tamanho == info.length) {
            redimencionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir(){
        System.out.println(info);
    }
 
    public int buscar(int valor){
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor){
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor){
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor){
                for (int j = i; j < tamanho - 1; j++) {
                    info[j] = info[j + 1];
                }
                tamanho--;
                i--;              
            }
        }
    }

    public void liberar(){
        info = new int[10];
        tamanho = 0;
    }

    public int obterElemento(int posicao){
        if (posicao < 0 || posicao >= tamanho ) {
            throw new IndexOutOfBoundsException("Posicao " + posicao + " invalida");
        }
        return info[posicao];
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String ListaString = "";
    
        for (int i = 0; i < tamanho; i++) {
            ListaString += info[i];
            if (i < tamanho - 1) {
                ListaString += ","; 
            }
        }
        return ListaString;
    }
}
