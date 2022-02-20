class BinaryTreeNode<T>{
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value){ this.value = value; }

    public void setLeft(BinaryTreeNode<T> left) { this.left = left;    }

    public void setRight(BinaryTreeNode<T> right){ this.right = right;    }

    public T getValue(){ return value; }

    public BinaryTreeNode<T> getRight(){return right;}

    public BinaryTreeNode<T> getLeft(){return left;}
}

public class BinaryTree<T> {
    private BinaryTreeNode head;

    public BinaryTree(T o){
        this.head = new BinaryTreeNode(o);
    }

    //노드를 트리에 추가
    public void push(T o){

    }

    //노드를 트리에서 제거
    public T pop(){
        return ;
    }

    //노드가 트리에 있는지 확인
    public boolean contain(){
        return false;
    }

    public static void main(String[] args) {

    }
}
