import java.util.*;
import java.util.ArrayList;

class A implements Cloneable{
    int a;
    int b;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        A a=new A();
        a.a = this.a;
        a.b = this.b;
        return a;
    }
}

class B implements Cloneable{
    A aa;
    String name;

    public B(){
        aa = new A();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        B c = (B) super.clone();
        c.aa = (A) this.aa.clone();
        return c;
    }
}
public class useCloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        B bb = new B();
        bb.aa.a=1;
        bb.aa.b=2;
        bb.name="가";
        B cc = (B) bb.clone();
        cc.aa.a=3;
        cc.name="나";
        System.out.println(bb.aa.a);
        System.out.println(bb.aa.b);
        System.out.println(bb.name);
        System.out.println(cc.aa.a);
        System.out.println(cc.aa.b);
        System.out.println(cc.name);
    }
}
