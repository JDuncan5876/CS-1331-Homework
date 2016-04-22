public class Driver {
    public static void main(String[] args) {
        Superclass s1 = new Superclass();
        Superclass s2 = new Subsubclass();
        System.out.println(((Subsubclass) s2).getSuperclass());
    }
}