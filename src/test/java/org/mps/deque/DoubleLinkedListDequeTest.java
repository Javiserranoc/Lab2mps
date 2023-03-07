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
        +devuelve null si la lista esta vacia
        +devuelve el primer objeto de la lista si tiene elementos
    -last
        +devuelve null si la lista esta vacia
        +devuelve el ultimo objeto de la lista si tiene elementos
    -size
        +devuelve la longitud de la lista

 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class DoubleLinkedListDequeTest {
    DoublyLinkedListDeque<Object> list;
    @BeforeEach
    void setUp(){
        list = new DoublyLinkedListDeque<>();
    }
}
