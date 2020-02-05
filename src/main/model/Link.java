package main.model;

import java.util.Objects;

/**
 * Maks
 * 05.02.2020.
 */
public class Link {
    private final String name;
    private final String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Link(Link link) {
        this.name = link.name;
        this.url = link.url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(name, link.name) &&
                url.equals(link.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }
}
