package example05;

import main.model.Resume;

import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Resume> comparator = new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                System.out.println(this.getClass().getSimpleName());
                return 0;
            }
        };
        System.out.println(comparator);
    }
}
