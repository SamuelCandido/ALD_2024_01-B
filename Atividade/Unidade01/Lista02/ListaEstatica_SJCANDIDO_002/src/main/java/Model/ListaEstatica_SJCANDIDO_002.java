/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Model;

/**
 *
 * @author samue
 */
public class ListaEstatica_SJCANDIDO_002<AlgumaClasse> {

    private Object[] info;
    private int tamanho;
    
    public static void main(String[] args) {
        ListaEstatica_SJCANDIDO_002 lista = new ListaEstatica_SJCANDIDO_002();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.exibir();
        lista.retirar(10);
        lista.exibir();
        System.out.println("Buscar 15: " + lista.buscar(15));
        System.out.println("Buscar 10: " + lista.buscar(10));
    }

    public ListaEstatica_SJCANDIDO_002() {
        this.info = new Object[10];
        this.tamanho = 0;
    }

    private void redimencionar(){
        Object[] novo;
        int novoTamanho = tamanho + 10;
        novo = new Object[novoTamanho];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public void inserir(AlgumaClasse valor){
        if (tamanho == info.length) {
            redimencionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir(){
        System.out.println(info);
    }
 
    public int buscar(Object valor){
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)){
                return i;
            }
        }
        return -1;
    }

    public void retirar(Object valor){
        int posicao = buscar(valor);
        
        if (posicao > -1) {
            for (int i = posicao+1; i < tamanho; i++) {
                info[i-1] = info[i];
            }
            tamanho--;
        }
    }

    public void liberar(){
        info = new Object[10];
        tamanho = 0;
    }

    public Object obterElemento(int posicao){
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
    
    public void inverter(){
        //Divide por 2
        //Na metade ele ja deve ter terminado de ordenar
        for (int i = 0; i < tamanho / 2; i++) {
            //Auxiliar pra trocar os valores
            Object aux = info[i];
            info[i] = info[tamanho - 1 - i];
            info[tamanho - 1 - i] = aux;
        }
    }
}
