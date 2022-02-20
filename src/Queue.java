class QueueNode<T>{
    private T value;
    private QueueNode<T> next;

    public QueueNode(T value, QueueNode next){
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public QueueNode getNext(){
        return this.next;
    }

    public void setNext(QueueNode next){
        this.next = next;
    }
}

public class Queue<T> {
    //linkedList로 구현
    private int size;
    private QueueNode head;
    private QueueNode tail;

    public Queue(){
        size=0;
        //dummyNode 사용 <- 코드 간결화
        head=new QueueNode(null,null);
        tail=head;
    }

    //값 삽입
    public void offer(T o){
        QueueNode<T> newNode = new QueueNode<>(o, null);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    //값 가져옴(삭제x)
    public T peek(){
        QueueNode<T> cursor = head.getNext();
        return cursor.getValue();
    }

    //값 가져옴(삭제o)
    public T poll(){
        if(size>0){
            QueueNode<T> cursor = head.getNext();
            T value = cursor.getValue();
            head.setNext(cursor.getNext());
            size--;
            return value;
        }
        return null;
    }

    //비움
    public void clear(){
        head=null;
        tail=null;
        size=0;
    }

    //사이즈 리턴
    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
        Queue<String> ar = new Queue<>();
        ar.offer("a");
        ar.offer("b");
        ar.offer("c");
        ar.offer("d");
        System.out.println(ar.poll());
        System.out.println(ar.peek());
        System.out.println(ar.peek());
        System.out.println(ar.poll());
        System.out.println(ar.poll());
        System.out.println(ar.poll());
        System.out.println(ar.poll());
    }
}
