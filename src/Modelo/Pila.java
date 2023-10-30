/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jeamp
 */
public class Pila<T> {

    NodoSE<T> tope;

    public Pila() {
        tope = null;
    }

    public void push(T valor) {
        if (tope == null) {
            tope = new NodoSE<>(valor);
        } else {
            NodoSE<T> nuevo = new NodoSE<>(valor);
            nuevo.setSig(tope);
            tope = nuevo;
        }
    }

    public T pop() {
        T res = null;
        if (tope != null) {
            res = tope.getDato();
            tope = tope.getSig();

        }
        return res;
    }

    public T peek() {
        T res = null;
        if (tope != null) {
            res = tope.getDato();
        }
        return res;
    }

    public boolean isEmpty() {
        return tope == null;
    }

}
