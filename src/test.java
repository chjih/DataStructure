import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;


public class test {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(3);
        ar.add(2);
        ar.add(4);
        ar.add(5);
        ar.remove(2);
        System.out.println(ar.get(2));
    }
}
