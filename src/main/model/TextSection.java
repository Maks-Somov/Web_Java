package main.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Maks
 * 06.02.2020.
 */
public class TextSection extends Section  {
    static final long serialVersionUID = 1L;

    private String value;

    public TextSection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
