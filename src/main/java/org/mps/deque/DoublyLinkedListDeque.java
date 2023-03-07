package org.mps.deque;

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
        // TODO
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
        // TODO
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
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
