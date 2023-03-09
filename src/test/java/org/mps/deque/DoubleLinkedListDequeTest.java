package org.mps.deque;
/*
                            Casos
    -Al llamar al constructor inicia una lista vacia
    -prepend
        +pone el objeto el primero en la lista cuando esta vacia
        +pone el objeto el primero en la lista cuando tiene elementos
    -append
        +pone el objeto el ultimo en la lista cuando esta vacia
        +pone el objeto el ultimo en la lista cuando tiene elementos
    -deleteFirst
        +salta Exception cuando la lista esta vacia
        +elimina el primer objeto de la lista
    -deleteLast
        +salta Exception cuando la lista esta vacia
        +elimina el ultimo objeto de la lista
    -first
        +lanza exception si la lista esta vacia
        +devuelve el primer objeto de la lista si tiene elementos
    -last
        +lanza exception si la lista esta vacia
        +devuelve el ultimo objeto de la lista si tiene elementos
    -size
        +devuelve la longitud de la lista

 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListDequeTest {
    DoublyLinkedListDeque<Object> list;
    @BeforeEach
    void setUp(){
        list = new DoublyLinkedListDeque<>();
    }

    @Test
    void constructorStartEmptySize(){
        assertEquals(0,list.size());
    }

    @Test
    void prependEmptyList(){
        DequeNode<Object> node =new DequeNode<Object>(1,null,null);
        list.prepend(node);
        assertEquals(node,list.first());
    }

    @Test
    void prependWorks(){
        DequeNode<Object> node =new DequeNode<Object>(1,null,null);
        list.prepend(new DequeNode<Object>(2,null,null));
        list.prepend(node);
        assertEquals(node,list.first());
    }

    @Test
    void appendEmptyList(){
        DequeNode<Object> node =new DequeNode<Object>(1,null,null);
        list.append(node);
        assertEquals(node,list.last());
    }

    @Test
    void appendWorks(){
        DequeNode<Object> node =new DequeNode<Object>(1,null,null);
        list.append(new DequeNode<Object>(2,null,null));
        list.append(node);
        assertEquals(node,list.last());
    }

    @Test
    void deleteFirstEmptyList(){
        assertThrows(DoubleEndedQueueException.class,() -> list.deleteLast());
    }

    @Test
    void deleteFirstWorks(){
        DequeNode<Object> node =new DequeNode<Object>(1,null,null);
        list.append(new DequeNode<Object>(2,null,null));
        list.append(node);
        list.deleteFirst();
        assertEquals(node,list.first());
    }


    @Test
    void deleteLastEmptyList(){
        assertThrows(DoubleEndedQueueException.class,() -> list.deleteLast());
    }

    @Test
    void deleteLastWorks(){
        DequeNode<Object> node =new DequeNode<Object>(1,null,null);
        list.append(node);
        list.append(new DequeNode<Object>(2,null,null));
        list.deleteLast();
        assertEquals(node,list.last());
    }

    @Test
    void lastEmptyList(){
        assertThrows(DoubleEndedQueueException.class, () -> list.last());
    }

    @Test
    void lastWorks(){
        DequeNode<Object> node =new DequeNode<Object>(1,null,null);
        list.append(node);
        assertEquals(node,list.last());
    }

    @Test
    void firstEmptyList(){
        assertThrows(DoubleEndedQueueException.class, () -> list.first());
    }

    @Test
    void firstWorks(){
        DequeNode<Object> node =new DequeNode<Object>(1,null,null);
        list.append(node);
        assertEquals(node,list.first());
    }

    @Test
    void sizeColaConDosElemenos(){
        list.prepend(new DequeNode<Object>(1,null,null));
        list.append(new DequeNode<Object>(3,null,null));
        assertEquals(2,list.size());
    }

   /* @Test
    void firstReturnTheFirstIfThereAreMultiplesNodes(){
        DequeNode<Object> node1 =new DequeNode<Object>(1,null,null);
        DequeNode<Object> node2 = new DequeNode(12,null,null);
        list.prepend(node1);
        list.prepend(node2);
        //assertEquals(node1,list.first());
    }*/

}
