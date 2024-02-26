import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void initList(){
        list = new CircularListImpl();
    }

    @Test
    void addItemToList(){
        assertTrue(list.isEmpty());
        list.add(-10);
        assertFalse(list.isEmpty());
    }

    @Test
    void getListSize(){
        list.add(10);
        assertEquals(list.size(), 1);
    }

    @Test
    void isTheListEmpty(){
        assertTrue(list.isEmpty());
    }

    @Test
    void isTheNextElement(){
        list.add(10);
        assertEquals(list.next().get(), 10);
    }

    @Test
    void isTheNextElementWrong(){
        assertEquals(list.next(), Optional.empty());
    }

    @Test
    void isThePreviousElement(){
        list.add(10);
        assertEquals(list.previous(), Optional.empty());
        list.add(2);
        list.next();
        assertEquals(list.previous(), Optional.of(10));
    }

}
