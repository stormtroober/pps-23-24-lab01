package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private List<Integer> list;
    private int cursor;

    public CircularListImpl(){
        list = new ArrayList<>();
        cursor = 0;
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> nextItemOptional = Optional.empty();
        try{
            nextItemOptional = Optional.of(list.get(cursor));
            cursor++;
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
        return nextItemOptional;
    }

    //TODO: to refactor
    @Override
    public Optional<Integer> previous() {
        Optional<Integer> prevItemOptional = Optional.empty();
        int cursorCopy = cursor;
        try{
            prevItemOptional = Optional.of(list.get(--cursorCopy));
            cursor--;
        } catch(IndexOutOfBoundsException e){
            System.out.println(e);
        }
        return prevItemOptional;
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

}
