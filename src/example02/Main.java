package example02;

import main.model.Link;

/**
 * Maks
 * 05.02.2020.
 */
public class Main {
    public static void main(String args[]){
        Link link = new Link("Maks", "github.com");
        Link link1 = link;
        Link link2 = new Link(link);
        System.out.println(link.getClass().getSimpleName());
        System.out.println(link.equals(link1));
        System.out.println(link.equals(link2));
        System.out.println(link);
    }
}
