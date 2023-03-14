package org.mps.deque;

import java.util.Comparator;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        DequeNode aux = new DequeNode(value,null,null);
        if (this.first == null){
            this.first = aux;
            this.last = aux;
            this.size += 1;
        }else{
            this.first.setPrevious(aux);
            aux.setNext(this.first);
            this.first = aux;
            this.size += 1;
        }
    }

    @Override
    public void append(T value) {
        DequeNode<T> aux = new DequeNode<T>(value,null,null);
       if(this.first == null){
          this.first = aux;
          this.last = aux;
          this.size ++;
       }else{
           this.last.setNext(aux);
           this.size ++;
           aux.setPrevious(this.last);
           this.last = aux;
       }
    }

    @Override
    public void deleteFirst() {
        if(this.first == null){
            throw new DoubleEndedQueueException("Error deletefirst: No se puede eliminar de una cola vacía");
        }else{
            DequeNode aux = this.first.getNext();
            aux.setPrevious(null);
            this.first = aux;
            this.size--;
        }
    }

    @Override
    public void deleteLast() {
        if(this.last == null){
            throw new DoubleEndedQueueException("Error deleteLast: No se puede eliminar de una cola vacía");
        }else{
            DequeNode<T> aux = this.last.getPrevious();
            aux.setNext(null);
            this.last = aux;
            this.size--;
        }
    }

    @Override
    public T first() {
        if(this.first == null){
            throw new DoubleEndedQueueException("Error en first: first es nulo");
        }else{
            return this.first.getItem();
        }
    }

    @Override
    public T last() {
        if(this.last == null){
            throw new DoubleEndedQueueException("Error en last: last es nulo");
        }else{
            return this.last.getItem();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get (int index){
        if (index < 0 || index >= this.size){
            throw new DoubleEndedQueueException("El indice introducido ha de ser correcto");
        }else{
            DequeNode<T> aux = this.first;
            for (int cont = 0; cont < index; cont++){
                aux = aux.getNext();
            }
            return aux.getItem();
        }
    }
   
    

    @Override
    public boolean contains(T value) {
        boolean found = false;
        if(this.first.getItem() == value){
            found = true;
        }else{
            DequeNode<T> aux = this.first;
            while(aux.getItem() != value){
                aux = aux.getNext();
            }
            if(aux.getItem() == value){
                found = true;
            }
        }
        return found;
    }

    @Override
    public void remove(T value) {
        boolean found = false;
        DequeNode<T> aux = this.first;
        while(!found && aux != null){
            if(aux.getItem().equals(value)){
                found = true;
                aux.getPrevious().setNext(aux.getNext());
                aux.getNext().setPrevious(aux.getPrevious());
                this.size--;
            }else{
                aux = aux.getNext();
            }
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if(this.size > 1){
            DequeNode<T> aux = this.first;
            DequeNode<T> aux2 = this.first.getNext();
            while(aux2 != null){
                if(comparator.compare(aux.getItem(),aux2.getItem()) > 0){
                    T aux3 = aux.getItem();
                    aux.setItem(aux2.getItem());
                    aux2.setItem(aux3);
                    aux = this.first;
                    aux2 = this.first.getNext();
                }else{
                    aux = aux.getNext();
                    aux2 = aux2.getNext();
                }
            }
        }
    }


}
