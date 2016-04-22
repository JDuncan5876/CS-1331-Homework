public interface Taxable {
    public static final double RATE = 0.06;
    public abstract double calculate(int amount);
}