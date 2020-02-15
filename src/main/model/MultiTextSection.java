package main.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Maks
 * 06.02.2020.
 */
public class MultiTextSection extends Section {
    static final long serialVersionUID = 1L;

    private List<String> values;

    public MultiTextSection(String... values) {
        this(new LinkedList<>(Arrays.asList(values)));
    }

    public MultiTextSection(List<String> values){
        this.values=values;
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiTextSection that = (MultiTextSection) o;
        return values.equals(that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
