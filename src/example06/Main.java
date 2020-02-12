package example06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        Iterator<String> it = Files.lines(Paths.get("d:\\ex.txt"), StandardCharsets.UTF_8).iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
