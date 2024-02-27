package tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


public class CircularListImplementation implements CircularList{

    private List<Integer> list;
    private int cursor;

    public CircularListImplementation(){
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
        return
            (cursor < list.size()) ?
                Optional.of(list.get(cursor++)) : Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        return 
            (cursor > 0) ?
                Optional.of(list.get(--cursor)) : Optional.empty();
    }

    @Override
    public void reset() {
        cursor = 0;
    }

}
