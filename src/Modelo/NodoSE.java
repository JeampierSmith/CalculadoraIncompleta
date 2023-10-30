
package Modelo;

public class NodoSE <T>{
    private T dato;
    private NodoSE<T> sig;

    public NodoSE() {
        this.dato = null;
        this.sig = null;
    }

    public NodoSE(T dato) {
        this.dato = dato;
        this.sig = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoSE<T> getSig() {
        return sig;
    }

    public void setSig(NodoSE<T> sig) {
        this.sig = sig;
    }

    public boolean vacia() {
        return dato == null;
    }
}
