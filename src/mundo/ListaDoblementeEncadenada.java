/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.Iterator;

/**
 *
 * @author SG702-03
 */
public class ListaDoblementeEncadenada<E> implements Iterable<E> {

    //Atributos
    Node<E> first;
    Node<E> last;

    private class Node<E> {

        //Atributos
        E element;
        Node<E> next;
        Node<E> previous;

        //Constructor
        public Node(E element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }
        //get y set

        public Node() {
        }

        public E getItem() {
            return element;
        }

        public void setItem(E element) {
            this.element = element;
        }

    }
    //Constructor

    public ListaDoblementeEncadenada() {
        first = null;
        last = null;
    }

    public void addLast(E element) {
        Node<E> nuevo = new Node<E>(element);
        if (isEmpty()) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.previous = last;
            last.next = nuevo;
            last = nuevo;
        }
    }

    public void addFirst(E element) {
        Node<E> nuevo = new Node<E>(element);
        if (isEmpty()) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.next = first;
            first.previous = nuevo;
            first = nuevo;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        Node<E> tmp = first;
        int i = 0;
        while (tmp != null) {
            tmp = tmp.next;
            i++;
        }
        return i;
    }

    public void showList() {

        Node<E> tmp = first;
        while (tmp != null) {
            System.out.println(tmp.getItem());
            tmp = tmp.next;
        }
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node<E> tmp = first;
            Node<E> before = null;
            while (tmp.next != null) {
                before = tmp;
                tmp = tmp.next;
            }
            if (before != null) {
                before.next = null;
            }
            return tmp.element;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        }
        Node<E> nodo = first;
        first = first.next;

        if (first != null) {
            first.previous = null;
        }

        return nodo.element;
    }

    public void eliminarElemento(E element) {
        Node<E> current = first;

        // Buscar el elemento en la lista
        while (current != null) {
            if (current.element.equals(element)) {
                // Elemento encontrado, vamos a eliminarlo

                // Caso especial: si es el primer elemento
                if (current == first) {
                    first = current.next;
                    if (first != null) {
                        first.previous = null;
                    } else {
                        // Si la lista queda vacía
                        last = null;
                    }
                } else {
                    // Actualizar el nodo siguiente y el nodo anterior
                    current.previous.next = current.next;
                    if (current.next != null) {
                        current.next.previous = current.previous;
                    } else {
                        // Si es el último elemento
                        last = current.previous;
                    }
                }

                return; // Elemento eliminado, salimos del método
            }
            current = current.next;
        }

        // Si llegamos aquí, el elemento no se encontró en la lista
        // Puedes manejar este caso según tus necesidades (lanzar una excepción, imprimir un mensaje, etc.).
    }

    public Iterator<E> iterator() {
        return new ListIterator<E>(first);
    }

    private class ListIterator<E> implements Iterator<E> {

        private Node<E> current;

        public ListIterator(Node<E> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                return null;
            }
            E item = current.element;
            current = current.next;
            return item;
        }

    }

}
