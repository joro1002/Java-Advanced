package CustomListSorter;

public class Sorter {
    public static void sort(Box<String> box) {
        int size = box.getElements().size();
        for (int i = 0; i < size; i++) {
            String element = (String) box.getElements().get(i);
            for (int j = i + 1; j < size; j++) {
                String nextElement = (String) box.getElements().get(j);
                if (element.compareTo(nextElement) > 0){
                    box.swap(i, j);
                }
            }
        }
    }
}
