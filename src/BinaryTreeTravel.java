import java.util.Arrays;
import java.util.ArrayList;

public class BinaryTreeTravel<T> {
    //배열로 구현(index 0부터 삽입)(부모 : (i-1)/2, 우측 자식 : 2i+1, 좌측 자식 : 2i+2)
    //포화 이진 트리 (Full Binary Tree)
    private ArrayList<T> binaryTree;
    private int size;

    public BinaryTreeTravel(){
        binaryTree = new ArrayList<>();
        size = 0;
    }

    public BinaryTreeTravel(T o){
        binaryTree = new ArrayList<T>(Arrays.asList(o));
        size=1;
    }

    public void add(T o){
        binaryTree.add(o);
        size++;
    }

    //전위 순회 (자신-> 왼쪽 자식 -> 오른쪽 자식)
    public void preorderTravel(int i){
        System.out.print(binaryTree.get(i)+" ");
        if(2*i+1<size) preorderTravel(2*i+1);
        if(2*i+2<size) preorderTravel(2*i+2);
    }


    //중위 순회 (왼쪽 자식 -> 자신 -> 오른쪽 자식)
    public void inorderTravel(int i){
        if(2*i+1<size) inorderTravel(2*i+1);
        System.out.print(binaryTree.get(i)+" ");
        if(2*i+2<size) inorderTravel(2*i+2);
    }

    //후위 순회 (왼쪽 자식 -> 오른쪽 자식 -> 자신)
    public void postorderTravel(int i){
        if(2*i+1<size) postorderTravel(2*i+1);
        if(2*i+2<size) postorderTravel(2*i+2);
        System.out.print(binaryTree.get(i)+" ");
    }

    public T get(int index){
        return binaryTree.get(index);
    }

    public static void main(String[] args) {
        BinaryTreeTravel<String> ar = new BinaryTreeTravel<>("a");
        ar.add("b");
        ar.add("c");
        ar.add("d");
        ar.add("e");
        ar.add("f");
        ar.add("g");
        ar.add("h");
        ar.add("i");
        ar.add("j");
        ar.add("k");
        ar.preorderTravel(0);
        System.out.println();
        ar.inorderTravel(0);
        System.out.println();
        ar.postorderTravel(0);
    }

}
