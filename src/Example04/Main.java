package Example04;

import main.model.Link;
import main.model.Organization;
import main.model.Resume;

import java.util.HashMap;
import java.util.Map;

/**
 * Maks
 * 07.02.2020.
 */
public class Main {
    public static void main(String[] args) {
//        new Organization().new Period();//for inner class
        new Organization.Period();//for static inner class
        Map<String,Resume> map =  new HashMap<String, Resume>();
        map.put("uuid", new Resume("uuid", "Vitebsk"));
        map.put("uiuid", new Resume("uuid", "Minsk"));
        for(Map.Entry<String,Resume> entry:map.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
}
