package main.model;

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
}
