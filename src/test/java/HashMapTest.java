import java.util.*;

/**
 * \* project: JavaStudy
 * \* package: PACKAGE_NAME
 * \* author: Willi Wei
 * \* date: 2020-07-27 20:43:38
 * \* description:
 * \
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("bob", 18);
        map.put("Amy", 17);

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s + "-> " + map.get(s));
        }
    }
}