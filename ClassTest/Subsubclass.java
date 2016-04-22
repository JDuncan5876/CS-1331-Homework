public class Subsubclass extends Subclass {
    public Subsubclass() {super();}

    public String getSuperclass() {
        return super.getClass().getName();
    }
}