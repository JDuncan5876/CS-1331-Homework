/**
 *I worked on this assignment alone, using only course materials.
 *
 * @author Jared Duncan
 */
public class Person {
    private String name;
    private double balance;

    public Person(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean purchase(Item item) {
        boolean canBuy = item.getPrice() <= balance;
        if (canBuy) {
            balance -= item.getPrice();
        }
        return canBuy;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}