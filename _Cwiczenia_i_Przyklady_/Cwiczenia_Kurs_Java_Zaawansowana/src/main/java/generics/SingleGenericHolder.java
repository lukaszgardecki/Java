package generics;

public class SingleGenericHolder<T> {
    T obj;

    SingleGenericHolder(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public static void main(String[] args) {
        SingleGenericHolder<Integer> iObj = new SingleGenericHolder<Integer>(10);
        System.out.println(iObj.getObj());

        SingleGenericHolder<String> sObj = new SingleGenericHolder<String>("jakiœ tekst");
        System.out.println(sObj.getObj());
    }
}
