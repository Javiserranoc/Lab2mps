package org.mps.deque;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
        Casos
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

public class DequeNodeTest {

    @Test
    void isLastLastNode(){
        DequeNode<Object> node = new DequeNode<Object>(13,new DequeNode<Object>(12,null,null),null);
        Boolean actualValue = node.isLastNode();
        assertEquals(true,actualValue);
    }

    @Test
    void isLastFirstNode(){
        DequeNode<Object> node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isLastNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isLastMiddleNode(){
        DequeNode<Object> node = new DequeNode<Object>(13,new DequeNode<Object>(11,null,null),new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isLastNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isNotATerminalNodeLastNode(){
        DequeNode<Object> node = new DequeNode<Object>(13,new DequeNode<Object>(12,null,null),null);
        Boolean actualValue = node.isNotATerminalNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isNotATerminalNodeFirstNode(){
        DequeNode<Object> node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isNotATerminalNode();
        assertEquals(false,actualValue);
    }

    @Test
    void isNotATerminalNodeMiddleNode(){
        DequeNode<Object> node = new DequeNode<Object>(13,new DequeNode<Object>(11,null,null),new DequeNode<Object>(12,null,null));
        Boolean actualValue = node.isNotATerminalNode();
        assertEquals(true,actualValue);
    }
}
