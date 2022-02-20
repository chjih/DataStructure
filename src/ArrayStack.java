public class ArrayStack<T> {
    private Object[] stack;
    private int topIndex;

    public ArrayStack(){
        topIndex=0;
        stack = new Object[1];
    }

    public ArrayStack(int size){
        topIndex=0;
        stack = new Object[size];
    }

    //데이터 추가(최상위)
    public void push(T o){
        stack[topIndex++] = o;
        resize();
    }

    //최상위 데이터 추출 후 삭제
    public T pop(){
        T r = (T) stack[--topIndex];
        stack[topIndex] = null;
        return r;
    }

    //최상위 데이터 추출, 삭제x
    public T peek(){
        return (T) stack[topIndex-1];
    }

    public void clear(){
        stack = null;
        topIndex = 0;
    }

    public boolean empty(){
        if(topIndex==0) return true;
        return false;
    }

    public void resize(){
        if(stack.length<=topIndex){
            Object[] newStack = new Object[topIndex*2];
            for(int i=0; i<topIndex; i++){
                newStack[i] = this.stack[i];
            }
            this.stack = newStack;
        }
    }

    public static void main(String[] args){
        ArrayStack<String> arr = new ArrayStack<>();
        arr.push("가");
        arr.push("나");
        arr.push("다");
        arr.push("라");
        System.out.println(arr.peek());
        System.out.println(arr.pop());
        System.out.println(arr.pop());
        arr.push("a");
        System.out.println(arr.pop());
    }
}
