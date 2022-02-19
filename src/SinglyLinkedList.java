class Node{
    private Node next;
    private Object value;

    public Node(Object value){
        this.value = value;
        this.next = null;
    }
    //다음 값 지정
    public void setNext(Node next){
        this.next = next;
    }
}

public class SinglyLinkedList<T> {
    //요소
    private T t;
    private int size;
    private SinglyLinkedList<T> next;

    //추가
    public void add(T o){

    }

    //삭제
    public void delete(int index){

    }

    //

    public static void main(String[] args) {

    }
}
