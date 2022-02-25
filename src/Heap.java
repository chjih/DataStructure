import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> implements Comparator<T>{
    //배열을 사용해 구현한 힙 (우선순위 큐)
    //최대 힙 구현 (큰 수일수록 우선순위가 커지는 것)
    private ArrayList<T> heap;
    private int size;

    //인덱스 1부터 삽입 시작 -> 부모 노드 i/2, 왼쪽 자식 노드 2i, 오른쪽 자식 노드 2i+1
    public Heap(){
        heap = new ArrayList<>();
        heap.add(null);
        size = 0;
    }

    public Heap(T o){
        heap = new ArrayList<>();
        heap.add(null);
        heap.add(o);
        size = 1;
    }

    public void add(T o){
        heap.add(o);
        size++;
        shiftUp(size);
    }

    private void shiftUp(int size){
        if(size/2>=1){
            if(compare(heap.get(size), heap.get(size/2))>0){
                T t = heap.get(size/2);
                heap.set(size/2, heap.get(size));
                heap.set(size, t);
                shiftUp(size/2);
            }
        }
    }

    public T poll(){
        T f = heap.get(1);
        heap.set(1, heap.get(size));
        heap.remove(size--);
        shiftDown(1);
        return f;
    }

    private void shiftDown(int size){
        if(this.size>=size*2) {
            if (compare(heap.get(size), heap.get(size * 2))<0 && compare(heap.get(size * 2 + 1), heap.get(size * 2))<=0){
                T t = heap.get(size);
                heap.set(size, heap.get(size * 2));
                heap.set(size * 2, t);
                shiftDown(size*2);
            }
        }
        if(this.size>=size*2+1){
            if(compare(heap.get(size), heap.get(size*2+1))<0&&compare(heap.get(size*2+1), heap.get(size*2))>0){
                T t = heap.get(size);
                heap.set(size, heap.get(size*2+1));
                heap.set(size*2+1, t);
                shiftDown(size*2+1);
            }
        }

    }

    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }

    public int size(){
        return this.size;
    }

    @Override
    public int compare(T o1, T o2) {

        return (int)o1 - (int) o2;
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.add(1);
        heap.add(10);
        heap.add(3);
        heap.add(2);
        heap.add(5);
        heap.add(2);
        heap.add(8);
        heap.add(6);
        heap.add(7);
        int n = heap.size();
        for(int i=0; i<n; i++){
            System.out.println(heap.poll());
        }
    }


}
