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
    -get

    -contains
        +No lo encuentra(devuelve false)
            +lista vacia
            +lista con objetos
        +Lo encuentra(devuelve true)
    -remove
    -sort
        +lista ordenada(devuelve la misma lista)
        +lista desorderdenada(devuelve la lista ordenada)
        +lista vacia(devuelve la misma lista)
        +lista con un objeto(devuelve la misma lista)
 */

import org.junit.jupiter.api.*;

import java.util.Comparator;

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

        @Test
        @DisplayName("returns false because it contains nothing")
        void containsEmptyList(){
            assertEquals(false,list.contains(1));
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

        @Test
        void getWithNegativeIndex(){
            list.append(1);
            assertThrows(DoubleEndedQueueException.class, () -> list.get(-1));
        }

        @Test
        void getWithIndexGreaterThanListSize(){
            list.append(1);
            assertThrows(DoubleEndedQueueException.class, () -> list.get(1));
        }

        @Test
        void getWithIndexInBounds(){
            list.append(4);
            assertEquals(4 , list.get(0));
        }

        @Test
        void getWithIndexUpperLimit(){
            list.append(1);
            list.append(2);
            list.append(3);
            assertEquals(2 , list.get(1));
        }

        @Test
        void removeVoidList(){
            DoublyLinkedListDeque nodeList = new DoublyLinkedListDeque();
            nodeList.remove(1);
            assertEquals(0, list.size());
        }

        @Test
        void removeFromListAValueThatIsActuallyListed(){
            DoublyLinkedListDeque nodeList = new DoublyLinkedListDeque();
            nodeList.append(1);
            nodeList.append(2);
            nodeList.append(3);
            nodeList.append(2);
            nodeList.remove(2);
            assertEquals(1,nodeList.get(0));
            assertEquals(3,nodeList.get(1));
            assertEquals(2,nodeList.get(2));
            assertEquals(3, nodeList.size());
        }

        @Test
        void removeFromListAValueThatIsNotContainedIn(){
            DoublyLinkedListDeque nodeList = new DoublyLinkedListDeque();
            nodeList.append(1);
            nodeList.append(2);
            nodeList.append(3);
            nodeList.remove(4);
            assertEquals(1,nodeList.get(0));
            assertEquals(2, nodeList.get(1));
            assertEquals(3,nodeList.get(2));
            assertEquals(3,nodeList.size());
        }


    }

        @Test
        @DisplayName("returns false because the value is not in the list")
        void containsNotFound(){
            list.prepend(1);
            list.append(3);
            assertEquals(false,list.contains(2));
        }
        @Test
        @DisplayName("returns true, it founds the value in the list")
        void containsFound(){
            list.prepend("a");
            assertEquals(true,list.contains("a"));
        }

        @Test
        @DisplayName("the size of the list still 0")
        void sortEmptyList(){
            DoublyLinkedListDeque<Integer> deque = new DoublyLinkedListDeque<>();
            deque.sort(Comparator.naturalOrder());
            assertEquals(0, deque.size());
        }

        @Test
        @DisplayName("with one element, the list still the same")
        void sortOneElement(){
            DoublyLinkedListDeque<Integer> deque = new DoublyLinkedListDeque<>();
            deque.append(1);
            deque.sort(Comparator.naturalOrder());
            assertEquals(1,deque.first());
        }

        @Test
        @DisplayName("with disordered list it returns the list in order")
        void sortDisorderedList(){
            DoublyLinkedListDeque<Integer> deque = new DoublyLinkedListDeque<>();
            deque.append(3);
            deque.append(4);
            deque.append(1);
            deque.append(2);
            deque.sort(Comparator.naturalOrder());
            assertEquals(1,deque.first());
            assertEquals(2,deque.get(1));
            assertEquals(3,deque.get(2));
            assertEquals(4,deque.last());
        }

        @Test
        @DisplayName("with the ordered list returns the same list")
        void sortOrderedList(){
            DoublyLinkedListDeque<Integer> deque = new DoublyLinkedListDeque<>();
            deque.append(4);
            deque.append(3);
            deque.append(2);
            deque.append(1);
            deque.sort(Comparator.naturalOrder());
            assertEquals(1,deque.first());
            assertEquals(2,deque.get(1));
            assertEquals(3,deque.get(2));
            assertEquals(4,deque.last());
        }
    }
