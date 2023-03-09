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

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A DoubleLinkedListDeque")
public class DoubleLinkedListDequeTest {
    DoublyLinkedListDeque<Object> list;

    @Nested
    @DisplayName("Empty list")
    class EmptyList{
        @BeforeEach
        void setUp(){
            list = new DoublyLinkedListDeque<>();
        }
        @Test
        @DisplayName("returns 0 when the list is empty")
        void constructorStartEmptySize(){
            assertEquals(0,list.size());
        }

        @Test
        @DisplayName("puts the node in the first place of an empty list")
        void prependEmptyList(){
            DequeNode<Object> node =new DequeNode<Object>(1,null,null);
            list.prepend(node);
            assertEquals(node,list.first());
        }

        @Test
        @DisplayName("puts the node in the last place of an empty list")
        void appendEmptyList(){
            DequeNode<Object> node =new DequeNode<Object>(1,null,null);
            list.append(node);
            assertEquals(node,list.last());
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when there is no first node to delete")
        void deleteFirstEmptyList(){
            assertThrows(DoubleEndedQueueException.class,() -> list.deleteFirst());
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when there is no last node to delete")
        void deleteLastEmptyList(){
            assertThrows(DoubleEndedQueueException.class,() -> list.deleteLast());
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when there is no last node")
        void lastEmptyList(){
            assertThrows(DoubleEndedQueueException.class, () -> list.last());
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when there is no first node")
        void firstEmptyList(){
            assertThrows(DoubleEndedQueueException.class, () -> list.first());
        }
    }

    @Nested
    @DisplayName("The list have one or more nodes")
    class SomethingInTheList{
        @BeforeEach
        void setUp(){
            list = new DoublyLinkedListDeque<>();
        }

        @Test
        @DisplayName("puts the node in the first place")
        void prependWorks(){
            DequeNode<Object> node =new DequeNode<Object>(1,null,null);
            list.prepend(new DequeNode<Object>(2,null,null));
            list.prepend(node);
            assertEquals(node,list.first());
        }

        @Test
        @DisplayName("puts the node in the last place")
        void appendWorks(){
            DequeNode<Object> node =new DequeNode<Object>(1,null,null);
            list.append(new DequeNode<Object>(2,null,null));
            list.append(node);
            assertEquals(node,list.last());
        }

        @Test
        @DisplayName("deletes the first node")
        void deleteFirstWorks(){
            DequeNode<Object> node =new DequeNode<Object>(1,null,null);
            list.append(new DequeNode<Object>(2,null,null));
            list.append(node);
            list.deleteFirst();
            assertEquals(node,list.first());
        }

        @Test
        @DisplayName("deletes the last node")
        void deleteLastWorks(){
            DequeNode<Object> node =new DequeNode<Object>(1,null,null);
            list.append(node);
            list.append(new DequeNode<Object>(2,null,null));
            list.deleteLast();
            assertEquals(node,list.last());
        }

        @Test
        @DisplayName("returns the last node of the list")
        void lastWorks(){
            DequeNode<Object> node =new DequeNode<Object>(1,null,null);
            list.append(node);
            assertEquals(node,list.last());
        }

        @Test
        @DisplayName("returns the first node of the list")
        void firstWorks(){
            DequeNode<Object> node =new DequeNode<Object>(1,null,null);
            list.append(node);
            assertEquals(node,list.first());
        }

        @Test
        @DisplayName("returns the list's size")
        void sizeColaConDosElemenos(){
            list.prepend(new DequeNode<Object>(1,null,null));
            list.append(new DequeNode<Object>(3,null,null));
            assertEquals(2,list.size());
        }
    }

}