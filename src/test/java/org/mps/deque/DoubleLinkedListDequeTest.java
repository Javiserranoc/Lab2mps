package org.mps.deque;
/**
 * @author Juan José Torres y Javier Serrano
 */
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
        +lanza excepcion cuando la lista esta vacia
        +lanza excepcion cuando el indice indicado en get es menor que 0
        +lanza excepcion cuando el indice indicado en get es >= que el tamaño de la lista
        +devuelve el ultimo item cuando el indice indicado es tamaño de la lista menos 1
        +devuelve el primer item cuando el indice indicado es 0
        +devuelve el item que se encuentre en el indice indicado, teniendo en cuenta que este sea correcto
    -contains
        +lista con objetos pero no está el que se busca, entonces devuelve False
        +lista vacia lanza excepciion
        +lista con objetos y lo encuentra en la primera posicion, entonces devuelve True.
        +lista con objetos y lo encuentra en cualquier otra posicion, entonces devuelve True.
    -remove
        +lanza excepcion cuando la lista esta vacia
        +elimina el primer nodo de la lista que contenga el item indicado y actualiza el tamaño de la lista
        +si el item indicado no está en la lista, se queda igual
    -sort
        +lista ordenada(devuelve la misma lista)
        +lista desorderdenada(devuelve la lista ordenada ascendentemente)
        +lista vacia(lanza excepcion)
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
        @DisplayName("throws DoubleEndedQueueException when try to use get")
        void getWithIndexFromEmptyList(){
            assertThrows(DoubleEndedQueueException.class, () -> list.get(0));
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when try to use contains")
        void containsEmptyList(){
            assertThrows(DoubleEndedQueueException.class, () -> list.contains(1));
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when try to remove")
        void removeEmptyList(){
            assertThrows(DoubleEndedQueueException.class, () -> list.remove(1));
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when try to sort")
        void sortEmptyList(){
            DoublyLinkedListDeque<Integer> deque = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () ->   deque.sort(Comparator.naturalOrder()));
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
        @DisplayName("throw DoubleEndedQueueException when the index specified for get method is negative")
        void getWithNegativeIndex(){
            list.append(1);
            assertThrows(DoubleEndedQueueException.class, () -> list.get(-1));
        }

        @Test
        @DisplayName("throw DoubleEndedQueueException when the index specified for get method is greater or equals than list's size")
        void getWithIndexGreaterThanListSize(){
            list.append(1);
            assertThrows(DoubleEndedQueueException.class, () -> list.get(1));
        }

        @Test
        @DisplayName("returns the last item when index specified for get method is list's size minus one")
        void getWithIndexInBounds(){
            list.append(4);
            Object expectedValue = 4;
            Object actualValue = list.get(0);
            assertEquals(expectedValue , actualValue);
        }

        @Test
        @DisplayName("returns the item that is in the index position specified for get method")
        void getWithIndexOfMiddleNode(){
            list.append(1);
            list.append(2);
            list.append(3);
            Object expectedValue = 2;
            Object actualValue = list.get(1);
            assertEquals(expectedValue , actualValue);
        }

        @Test
        @DisplayName("returns the list without the first node that had the item indicated in remove method")
        void removeFromListAValueThatIsActuallyListed(){
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(2);
            list.remove(2);
            assertEquals(1,list.get(0));
            assertEquals(3,list.get(1));
            assertEquals(2,list.get(2));
            assertEquals(3, list.size());
        }

        @Test
        @DisplayName("when try to remove a item that is not in the list, the list remains the same")
        void removeFromListAValueThatIsNotContainedIn(){
            list.append(1);
            list.append(2);
            list.append(3);
            list.remove(4);
            assertEquals(1,list.get(0));
            assertEquals(2, list.get(1));
            assertEquals(3,list.get(2));
            assertEquals(3,list.size());
        }

        @Test
        @DisplayName("returns false because the value is not in the list")
        void containsNotFound(){
            list.prepend(1);
            list.append(3);
            assertEquals(false,list.contains(2));
        }

        @Test
        @DisplayName("returns true, it founds the value in the first node")
        void containsFoundFirst(){
            list.prepend("a");
            assertEquals(true,list.contains("a"));
        }

        @Test
        @DisplayName("returns true, it founds the value in the list")
        void containsFound(){
            list.prepend("a");
            list.prepend("v");
            list.prepend("f");
            list.prepend("y");
            assertEquals(true,list.contains("f"));
        }

        @Test
        @DisplayName("with one element, the list still the same (ordered)")
        void sortOneElement(){
            DoublyLinkedListDeque<Integer> deque = new DoublyLinkedListDeque<>();
            deque.append(1);
            deque.sort(Comparator.naturalOrder());
            assertEquals(1,deque.first());
        }

        @Test
        @DisplayName("with disordered list it returns the list in ascending order")
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
            deque.append(1);
            deque.append(2);
            deque.append(3);
            deque.append(4);
            deque.sort(Comparator.naturalOrder());
            assertEquals(1,deque.first());
            assertEquals(2,deque.get(1));
            assertEquals(3,deque.get(2));
            assertEquals(4,deque.last());
        }
    }
}
