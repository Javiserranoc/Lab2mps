package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {

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
        // TODO
    }

    @Override
    public void deleteFirst() {
        if(this.first == null){
            throw new DoubleEndedQueueException("Error deletefirst: No se puede eliminar de una cola vacía")
        }else{
            DequeNode aux = this.first.getNext();
            aux.setPrevious(null);
            this.first = aux;
            this.size--;
        }
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        return this.first.getItem();
    }

    @Override
    public T last() {
        return this.last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}
