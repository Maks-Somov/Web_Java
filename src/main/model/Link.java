package main.model;

import java.util.Objects;

/**
 * Maks
 * 05.02.2020.
 */
public class Link {
    private static Link EMPTY = new Link();
    private final String name;
    private final String url;

    public Link() {
        this("", null);
    }

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Link(Link link) {
        this(link.name,link.url);
    }

    public static Link empty(){
        return EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!name.equals(link.name)) return false;
        return url != null ? url.equals(link.url) : link.url == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
