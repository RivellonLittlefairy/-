package Bag;

import java.util.Iterator;

//实现背包的数据结构
//为了在图的邻接表中使用
//练习迭代器的实现
public class Bag<E> implements Iterable<E>{
    int size=0;
    class node<E>{
        E data;
        node next;
        node(){}
        node(E d){
            data=d;
        }
        node(E d,node n){
            data=d;
            next=n;
        }

    }
    node<E> firmark;
    node<E> fir;
    public void add(E e){

        node old=fir;
        fir=new node(e,old);
        size++;
    }
/*错误示范
   public void add(E e){
        fir=new node(e);
        fir=fir.next;
    }
    错误原因   fir是个引用，将引用a赋值给引用b时候，并不会改变引用b原先指向的对象
 */
    public boolean isEmpty(){
        if(fir==null) return true;
        return false;
    }
    public int size(){
        return size;
    }
    public Iterator<E> iterator() {
        firmark=fir;
       Iterator<E>  it=new a();
       return it;
    }
    class a implements Iterator<E>{
        public boolean hasNext() {
            if(fir==null) {
                fir=firmark;
                return false;
            }
            return true;
        }

        public E next() {
            E e=fir.data;
            fir=fir.next;
            return e;
        }
    }
}
