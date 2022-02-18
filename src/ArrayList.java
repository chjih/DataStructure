public class ArrayList<T> {
    //리스트 용량
    private int capacity;
    //요소 개수
    private int size;
    private Object[] array;

    public ArrayList(){
        capacity = 1;
        array = new Object[capacity];
        size=0;
    }

    public ArrayList(int n){
        capacity=n;
        array = new Object[capacity];
        size=0;
    }

    //요소 추가(맨 끝에)
    public void add(T o){
        array[size++] = o;
        resize();
        for(int i=0; i<size; i++){
            System.out.println(array[i]);
        }
    }

    //요소 추가(특정 인덱스 값에)
    public void add(int index, T o){
        size++;
        resize();
        //요소를 집어넣을 인덱스 다음 요소부터 한칸씩 뒤로 미룬다
        for(int i=size; i>index; i--){
            array[i]=array[i-1];
        }
        array[index]=0;
    }

    //요소 삭제(인덱스 값)
    public void remove(int index){
        for(int i=index; i<size-1; i++){
            array[i]=array[i+1];
        }
        size--;
    }

    //요소 삭제(해당 객체)
    public void remove(T o){
        int i;
        for(i=0; i<size; i++){
            if(o.equals(array[i])) break;
        }
        remove(i);
        size--;
    }

    //포함 유무
    public boolean contains(T o){
        for(int i=0; i<size; i++){
            if(o.equals(array[i])) return true;
        }
        return false;
    }

    //인덱스 값 가져오기
    public int indexOf(T o){
        for(int i=0; i<size; i++){
            if(o.equals(array[i])) return i;
        }
        //존재하지 않을 시
        return -1;
    }

    //요소 교체
    public void set(int index, T o){
        array[index]=o;
    }

    //요소값 가져오기
    public T get(int index){
        return (T)array[index];
    }

    //저장공간 재설정(요소의 개수와 같으면 늘리기, 요소의 개수 절반보다 더 작으면 줄이기, 없으면 생성)
    //외부에서 접근 불가능
    private void resize(){
        if(capacity==size){
            System.out.println("늘립니다.");
            Object[] newArray = new Object[capacity*2];
            this.copy(newArray);
            capacity*=2;
        }
        else if(size<=(capacity/2)){
            Object[] newArray = new Object[capacity/2];
            capacity/=2;
            this.copy(newArray);
        }
    }

    //배열 복사
    private void copy(Object[] array){
        for(int i=0; i<capacity; i++){
            array[i]=this.array[i];
        }
        this.array = array;
    }

    //배열 초기화
    public void clear(){
        capacity=0;
        size=0;
        array=new Object[0];
    }

    //배열 크기 리턴
    public int size(){
        return size;
    }

    //비어있는가?
    public boolean isEmpty(){
        return size==0;
    }

    public T[] clone(){
        Object[] newArray = new Object[capacity];
        for(int i=0; i<size; i++){
            newArray[i]=array[i];
        }
        return (T[]) newArray;
    }

    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<>();
        System.out.println("첫번쩨");
        ar.add("r");
        System.out.println("두번쩨");
        ar.add("r");
        System.out.println("세번쩨");
        ar.add("r");
        System.out.println("네번쩨");
        ar.add("r");
    }
}
