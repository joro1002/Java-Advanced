package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T getElementFirst = elements.get(firstIndex);
        T getElementSecond = elements.get(secondIndex);

        elements.add(firstIndex, getElementSecond);
        this.elements.remove(firstIndex + 1);
        elements.add(secondIndex, getElementFirst);
        this.elements.remove(secondIndex + 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T element : elements) {
            builder.append(String.format("%s: %s", element.getClass().getName(), element));
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
