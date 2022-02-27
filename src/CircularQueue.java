public class CircularQueue<T> {
    private T[] queue;
    private int size;
    private int front;
    private int rear;
    private final int Capacity=10;

    public CircularQueue(){
        queue = (T[]) new Object[Capacity];
        size=0;
        front=0;
        rear=0;

    }

    public CircularQueue(T o){
        queue = (T[]) new Object[Capacity];
        size=0;
        rear=0;
        front=0;
        offer(o);
    }

    public void offer(T o){
        rear++;
        //끝으로 가면 다시 돌아감
        if(rear==queue.length){
            rear = 0;
        }
        queue[rear] = o;
        size++;
        resize();
    }

    public T poll(){
        front++;
        // 끝까지 가면 돌아감
        if(front==queue.length){
            front=0;
        }
        T t = queue[front];
        queue[front]=null;
        size--;
        return t;
    }

    public void resize(){
        //요소들이 배열에 가득차면 배열을 늘려줌
        if(size==queue.length){
            T[] newArray = (T[]) new Object[size+Capacity];
            int size = this.size;
            for(int i=1; i<=size; i++){
                newArray[i] = poll();
            }
            front=0;
            rear=size;
            this.size=size;
            queue = newArray;
        }
        //요소가 배열의 절반만 찾을 때 배열을 줄여줌
        else if(size+Capacity*2<=queue.length){
            T[] newArray = (T[]) new Object[size+Capacity];
            int size = this.size;
            for(int i=1; i<=size; i++){
                newArray[i] = poll();
            }
            front=0;
            rear=size;
            this.size=size;
            queue = newArray;
        }
    }

    public T peek(){
        int p = front+1;
        if(p==queue.length){
            p=0;
        }
        return queue[p];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }

    public static void main(String[] args) {
        CircularQueue<String> ar = new CircularQueue<>("a");
        ar.offer("b");
        ar.offer("c");
        ar.offer("d");
        ar.offer("e");
        ar.poll();
        ar.poll();
        ar.poll();
        ar.poll();
        ar.offer("b");
        ar.offer("c");
        ar.offer("d");
        ar.offer("e");
        ar.offer("f");
        System.out.println(ar.peek());
        System.out.println(ar.poll());
        System.out.println(ar.peek());
        int size = ar.size();
        for(int i=0; i<size; i++){
            System.out.println(ar.poll());
        }
    }
}
