import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImplementation;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;
    private int number = 10;

    @BeforeEach
    void initList(){
        list = new CircularListImplementation();
    }

    @Test
    void addItemToList(){
        genList(number);
        assertTrue(!list.isEmpty());
    }

    @Test
    void getListSize(){
        genList(number);
        assertEquals(list.size(), number);
    }

    @Test
    void isTheNextElement(){
        genList(number);
        list.next();
        assertEquals(list.next(), Optional.of(number));
    }

    @Test
    void isTheNextElementWrong(){
        assertEquals(list.next(), Optional.empty());
    }

    @Test
    void testPreviousWithEmptyList(){
        assertEquals(list.previous(), Optional.empty());
    }

    @Test
    void testPreviousWithElements(){
        genList(number);
        list.next();
        list.next();
        assertEquals(list.previous(), Optional.of(number));
    }

    @Test
    void resetCursor(){
        genList(number);
        list.next();
        list.reset();
        list.next();
        assertEquals(list.next(), Optional.of(number));
    }

    private void genList(int size){
        for(int i = 0; i < size; i++){
            list.add(number * i);
        }
    }

}
