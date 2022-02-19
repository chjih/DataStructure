import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Node<T>{
    private Node next;
    private T value;

    public Node(){

    }
    public Node(T value){
        this.value = value;
        this.next = null;
    }
    //다음 값 지정
    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public T getValue(){
        return value;
    }
}

public class SinglyLinkedList<T> {
    //가장 첫 노드를 가르키는 변수
    private Node<T> head;
    //가장 마지막 노드를 가르키는 변수
    private Node<T> tail;
    //노드 개수를 저장하는 변수
    private int size;

    public SinglyLinkedList(){
        //dummyNode 사용
        this.head = new Node<>();
        this.tail = head;
        this.size = 0;
    }

    public SinglyLinkedList(List ar){
        //dummyNode 사용
        this.head = new Node<>();
        this.tail = head;
        for(int i=0; i<ar.size(); i++){
            add((T) ar.get(i));
        }
    }

    //객체 추가(추가 성공 시 true 반환)
    public boolean add(T o){
        Node<T> newNode = new Node<>(o);
        //마지막 노드의 next 값에 새로운 노드를 집어넣는다.
        this.tail.setNext(newNode);
        this.tail = newNode;
        size++;
        return true;
    }

    //객체 추가(index)
    public void add(int index, T o){
        Node<T> newNode = new Node<>(o);
        Node cursor = head.getNext();
        for(int i=0; i<index; i++){
            cursor = cursor.getNext();
        }
        newNode.setNext(cursor.getNext());
        cursor.setNext(newNode);
        size++;
    }

    //삭제(가장 앞에 있는 요소)(head와 가까운 요소)
    public void remove(){
        Node cursor = head;
        cursor.setNext(cursor.getNext().getNext());
        size--;
    }

    //삭제(인덱스)
    public void remove(int index){
        Node cursor = head.getNext();
        if(index==0){
            remove();
            return;
        }
        for(int i=0; i<index-1; i++){
            cursor = cursor.getNext();
        }
        if(cursor.getNext()==null) cursor.setNext(null);
        else{
            cursor.setNext(cursor.getNext().getNext());
        }
        size--;
    }

    //삭제(객체)
    public void remove(T o){
        Node cursor = head.getNext();
        int i;
        for(i=0; i<size; i++){
            if(o.equals(cursor.getValue())) break;
            cursor = cursor.getNext();
        }
        remove(i);
    }

    //모두 비우기
    public void clear(){
        head = null;
        tail = head;
        size = 0;
    }

    //사이즈 리턴
    public int size(){
        return this.size;
    }

    //인덱스 값 리턴
    public int indexOf(T o){
        Node cursor = head.getNext();
        int i;
        for(i=0; i<size; i++){
            if(o.equals(cursor.getValue())) break;
            cursor = cursor.getNext();
        }
        return i;
    }

    //인덱스에 해당하는 값 가져오기
    public T get(int index){
        Node cursor = head.getNext();
        for(int i=0; i<index; i++) cursor = cursor.getNext();
        return (T) cursor.getValue();
    }

    //비었는지 유무
    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }

    //포함되어있는지 유쿠
    public boolean contains(T o){
        Node cursor = head.getNext();
        for(int i=0; i<size; i++){
            if(o.equals(cursor.getValue())) return true;
            cursor = cursor.getNext();
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> ar = new SinglyLinkedList<>(Arrays.asList("가","나","다"));
        System.out.println(ar.get(2));
        ar.add("라");
        ar.add("마");
        ar.add("바");
        for(int i=0; i<ar.size(); i++) System.out.println(ar.get(i));
        ar.remove(5);
        for(int i=0; i<ar.size(); i++) System.out.println(ar.get(i));
        System.out.println(ar.indexOf("가"));
        System.out.println(ar.contains("바"));
    }
}
