public class CircularQueue<T> {
    private T[] queue;
    private int size;
    private int front;
    private int rear;
    private final int Capacity=10;

    public CircularQueue(){
        queue = (T[]) new Object[];
        size=0;
    }

    public CircularQueue(T o){
        queue = (T[]) new Object[];
        size=1;
        queue[rear]=o;
    }

    public void add(T o){

    }

    public void poll(){

    }

    public void peek(){

    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {

    }
}
