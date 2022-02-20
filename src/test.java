import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue ar = new LinkedList<>();
        ar.offer("a");
        System.out.println(ar.poll());
        System.out.println(ar.poll());
    }
}
