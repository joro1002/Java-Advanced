package CustomList;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        return this.elements.remove(index);
    }


    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int indexFirst, int indexSecond) {
        T firstElement = this.elements.get(indexFirst);
        T secondElement = this.elements.get(indexSecond);

        this.elements.set(indexFirst, secondElement);
        this.elements.set(indexSecond, firstElement);

    }

    public int countGreaterThan(T element) {
        return (int) this.elements
                .stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return this.elements
                .stream()
                .max((f, s) -> f.compareTo(s))
                .get();
    }

    public T getMin() {
        return this.elements
                .stream()
                .min((f, s) -> f.compareTo(s))
                .get();
    }
}
