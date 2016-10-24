package text;

/**
 * Created by wq on 16-8-17.
 */
public class A extends Object{
    private int a;
    private int b;
    public String str=null;
    public A(int a , int b){
        this.a = a ;
        this.b = b;
    }

    public int hashCode(){
        return a+b;
    }

    public boolean equals(Object obj){
        if(obj instanceof A){
            return ((A) obj).a == this.a &&  ((A) obj).a == this.b;
        }
        return false;
    }



}
