package org.mps.deque;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
        Casos
        -getItem
            +Devuelve el valor del nodo
        -setItem
            +Cambia el valor del nodo
        -getPrevious
            +Si el nodo no es el primero, devuelve el nodo anterior
            +Si el nodo es el primero devuelve null
        -setPrevious
            +Se le da un objeto cualquiera
            +Se le da valor null
        -getNext
            +Si el nodo no es el ultimo, devuelve el nodo siguiente
            +Si el nodo es el ultimo devuelve null
        -setNext
            +Se le da un objeto cualquiera
            +Se le da valor null
        -isFirst
            +Devuelve el primero(devuelve true)
            +En caso de ser ultimo(devuelve false)
            +En caso de ser nodo intermedio(devuelve false)
        -isLast
            +Devuelve ultimo(devuelve true)
            +En caso de ser primer(devuelve false)
            +En caso de ser nodo intermedio(devuelve false)
        -isNotATerminalNode
            +Devuelve al no ser ni primero ni ultimo(devuelve true)
            +En caso de que sea el primero(devuelve false)
            +En caso de que sea el ultimo(devuelve false)
 */

@Nested
@DisplayName("DequeNode class has an item a reference to the next and a reference to the previous Node")
public class DequeNodeTest {
    DequeNode<Object> node;
    @AfterEach
    void shutdown(){
        node = null;
    }

    @Test
    void getItemNotNull(){
        node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
        Object actualValue = node.getItem();
        assertEquals(13,actualValue);
    }

    @Test
    void setItemWorks(){
        node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
        node.setItem(28);
        Object actualValue = node.getItem();
        assertEquals(28,actualValue);
    }

    @Test
    void getPreviousNotFirst(){
        DequeNode<Object> aux = new DequeNode<Object>(12, null, null);
        DequeNode<Object> node = new DequeNode<Object>(13,aux, null);
        DequeNode<Object> actualValue = node.getPrevious();
        assertEquals(aux,actualValue);
    }

    @Test
    void getPreviousFirst(){
        DequeNode<Object> node = new DequeNode<Object>(13,null,null);
        DequeNode<Object> actualValue = node.getPrevious();
        assertNull(actualValue);
    }

    @Test
    void setPreviousToSomeThing(){
        DequeNode<Object> aux = new DequeNode<Object>(12, null, null);
        DequeNode<Object> node = new DequeNode<Object>(13, null, null);
        node.setPrevious(aux);
        DequeNode<Object> actualValue = node.getPrevious();
        assertEquals(aux,actualValue);
    }

    @Test
    void setPreviousNull(){
        DequeNode<Object> node = new DequeNode<Object>(13, new DequeNode<Object>(12, null, null), null);
        node.setPrevious(null);
        DequeNode<Object> actualValue = node.getPrevious();
        assertNull(actualValue);
    }

    @Test
    void getNextNotLast(){
        DequeNode<Object> aux = new DequeNode<Object>(12, null, null);
        DequeNode<Object> node = new DequeNode<Object>(13,null, aux);
        DequeNode<Object> actualValue = node.getNext();
        assertEquals(aux,actualValue);
    }

    @Test
    void getNextLast(){
        DequeNode<Object> node = new DequeNode<Object>(13,null,null);
        DequeNode<Object> actualValue = node.getNext();
        assertNull(actualValue);
    }

    @Test
    void setNextToSomeThing(){
        DequeNode<Object> aux = new DequeNode<Object>(12, null, null);
        DequeNode<Object> node = new DequeNode<Object>(13, null, null);
        node.setNext(aux);
        DequeNode<Object> actualValue = node.getNext();
        assertEquals(aux,actualValue);
    }

    @Test
    void setNextNull(){
        DequeNode<Object> node = new DequeNode<Object>(13, null, new DequeNode<Object>(12, null, null));
        node.setNext(null);
        DequeNode<Object> actualValue = node.getNext();
        assertNull(actualValue);
    }

    @Test
    void isFirstFirstNode(){
        node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isFirstNode();
        assertEquals(true,actualValue);
    }

    @Test
    void isFirstLastNode(){
        node = new DequeNode<Object>(13, new DequeNode<Object>(12,null,null), null);
        Boolean actualValue = node.isFirstNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isFirstMiddleNode(){
        node = new DequeNode<Object>(13,new DequeNode<Object>(12,null,null) , new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isFirstNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isLastLastNode(){
        node = new DequeNode<Object>(13,new DequeNode<Object>(12,null,null),null);
        Boolean actualValue = node.isLastNode();
        assertEquals(true,actualValue);
    }

    @Test
    void isLastFirstNode(){
        node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isLastNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isLastMiddleNode(){
        node = new DequeNode<Object>(13,new DequeNode<Object>(11,null,null),new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isLastNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isNotATerminalNodeLastNode(){
        node = new DequeNode<Object>(13,new DequeNode<Object>(12,null,null),null);
        Boolean actualValue = node.isNotATerminalNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isNotATerminalNodeFirstNode(){
        node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isNotATerminalNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isNotATerminalNodeMiddleNode(){
        node = new DequeNode<Object>(13,new DequeNode<Object>(11,null,null),new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isNotATerminalNode();
        assertEquals(true,actualValue);
    }
}
