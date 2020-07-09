import java.util.ArrayList;
import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: PACKAGE_NAME
 * \* author: Willi Wei
 * \* date: 2020-07-08 22:26:45
 * \* description:
 * \
 */
public class TestList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Integer integer : list) {
            if (integer.equals(3)){
                list.remove(integer);
            }
        }
    }
}