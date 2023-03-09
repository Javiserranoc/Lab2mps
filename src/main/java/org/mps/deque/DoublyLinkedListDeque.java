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


}
