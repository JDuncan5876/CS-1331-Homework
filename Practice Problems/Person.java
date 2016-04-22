public class Person implements Taxable {
    public Person(){}

    public double calculate(int balance) {
        return balance * RATE;
    }
}