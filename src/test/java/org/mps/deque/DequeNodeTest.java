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

@DisplayName("A DequeNode has an item, a previous and a next reference")
public class DequeNodeTest {
    DequeNode<Object> node;
    @AfterEach
    void shutdown(){
        node = null;
    }

    @Nested
    @DisplayName("When DequeNode has some item")
    class WhenNodeNotNull{
        @Test
        @DisplayName("returns the node value when getItem method is used")
        void getItemNotNull(){
            node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
            Object actualValue = node.getItem();
            assertEquals(13,actualValue);
        }
        @DisplayName("returns the node modified with the new value or null specified when setItem method is used")
        @Test
        void setItemWorks(){
            node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
            node.setItem(28);
            Object actualValue = node.getItem();
            assertEquals(28,actualValue);
        }
    }

    @Nested
    @DisplayName("When DequeNode is first")
    class WhenNodeIsFirst{
        @DisplayName("returns null when getPrevious method is used")
        @Test
        void getPreviousFirst(){
            DequeNode<Object> node = new DequeNode<Object>(13,null,null);
            DequeNode<Object> actualValue = node.getPrevious();
            assertNull(actualValue);
        }
        @DisplayName("returns true when isFirst method is used")
        @Test
        void isFirstFirstNode(){
            node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
            Boolean actualValue = node.isFirstNode();
            assertEquals(true,actualValue);
        }

        @DisplayName("returns false when isLast method is used")
        @Test
        void isLastFirstNode(){
            node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
            Boolean actualValue = node.isLastNode();
            assertEquals(false,actualValue);
        }
        @DisplayName("returns false when isNotATerminalNode method is used")
        @Test
        void isNotATerminalNodeFirstNode(){
            node = new DequeNode<Object>(13,null,new DequeNode<Object>(12,null,null));
            Boolean actualValue = node.isNotATerminalNode();
            assertEquals(false,actualValue);
        }

    }
    @Nested
    @DisplayName("When DequeNode is the last")
    class WhenNodeIsLast{
        @DisplayName("returns null when getNext method is used")
        @Test
        void getNextLast(){
            DequeNode<Object> node = new DequeNode<Object>(13,null,null);
            DequeNode<Object> actualValue = node.getNext();
            assertNull(actualValue);
        }
        @DisplayName("returns false when isFirst method is used")
        @Test
        void isFirstLastNode(){
            node = new DequeNode<Object>(13, new DequeNode<Object>(12,null,null), null);
            Boolean actualValue = node.isFirstNode();
            assertEquals(false,actualValue);
        }
        @DisplayName("returns true when isLast method is used")
        @Test
        void isLastLastNode(){
            node = new DequeNode<Object>(13,new DequeNode<Object>(12,null,null),null);
            Boolean actualValue = node.isLastNode();
            assertEquals(true,actualValue);
        }
        @DisplayName("returns false when isNotATerminalNode method is used")
        @Test
        void isNotATerminalNodeLastNode(){
            node = new DequeNode<Object>(13,new DequeNode<Object>(12,null,null),null);
            Boolean actualValue = node.isNotATerminalNode();
            assertEquals(false,actualValue);
        }

    }

    @Nested
    @DisplayName("When it is not first either last node")
    class NotFirstNotLast{
        @DisplayName("returns true when isNotATerminalNode method is used")
        @Test
        void isNotATerminalNodeMiddleNode(){
            node = new DequeNode<Object>(13,new DequeNode<Object>(11,null,null),new DequeNode<Object>(12,null,null));
            Boolean actualValue = node.isNotATerminalNode();
            assertEquals(true,actualValue);
        }
        @DisplayName("returns false when isLast method is used")
        @Test
        void isLastMiddleNode(){
            node = new DequeNode<Object>(13,new DequeNode<Object>(11,null,null),new DequeNode<Object>(12,null,null));
            Boolean actualValue = node.isLastNode();
            assertEquals(false,actualValue);
        }
        @DisplayName("returns false when isFirst method is used")
        @Test
        void isFirstMiddleNode(){
            node = new DequeNode<Object>(13,new DequeNode<Object>(12,null,null) , new DequeNode<Object>(12,null,null));
            Boolean actualValue = node.isFirstNode();
            assertEquals(false,actualValue);
        }

    }

    @Nested
    @DisplayName("When we use the methods setPrevious or setNext")
    class whenSetPreviousOrSetNext{
        @DisplayName("set previous to 'something' modifies the previous reference of the DequeNode to 'something'")
        @Test
        void setPreviousToSomeThing(){
            DequeNode<Object> aux = new DequeNode<Object>(12, null, null);
            DequeNode<Object> node = new DequeNode<Object>(13, null, null);
            node.setPrevious(aux);
            DequeNode<Object> actualValue = node.getPrevious();
            assertEquals(aux,actualValue);
        }

        @DisplayName("set previous to null modifies the previous reference of the DequeNode to null")
        @Test
        void setPreviousNull(){
            DequeNode<Object> node = new DequeNode<Object>(13, new DequeNode<Object>(12, null, null), null);
            node.setPrevious(null);
            DequeNode<Object> actualValue = node.getPrevious();
            assertNull(actualValue);
        }

        @DisplayName("set next to 'something' modifies the next reference of the DequeNode to 'something'")
        @Test
        void setNextToSomeThing(){
            DequeNode<Object> aux = new DequeNode<Object>(12, null, null);
            DequeNode<Object> node = new DequeNode<Object>(13, null, null);
            node.setNext(aux);
            DequeNode<Object> actualValue = node.getNext();
            assertEquals(aux,actualValue);
        }
        @DisplayName("set next to null modifies the next reference of the DequeNode to null")
        @Test
        void setNextNull(){
            DequeNode<Object> node = new DequeNode<Object>(13, null, new DequeNode<Object>(12, null, null));
            node.setNext(null);
            DequeNode<Object> actualValue = node.getNext();
            assertNull(actualValue);
        }

    }

    @Nested
    @DisplayName("When we use the methods getNext and getPrevious with not last node and not first node respectively")
    class getNextNotLastGetPreviousNotFirst {
        @DisplayName("getNext method will returns the next")
        @Test
        void getNextNotLast() {
            DequeNode<Object> aux = new DequeNode<Object>(12, null, null);
            DequeNode<Object> node = new DequeNode<Object>(13, null, aux);
            DequeNode<Object> actualValue = node.getNext();
            assertEquals(aux, actualValue);
        }
        @DisplayName("getPrevious method returns the previous")
        @Test
        void getPreviousNotFirst() {
            DequeNode<Object> aux = new DequeNode<Object>(12, null, null);
            DequeNode<Object> node = new DequeNode<Object>(13, aux, null);
            DequeNode<Object> actualValue = node.getPrevious();
            assertEquals(aux, actualValue);
        }
    }




}
