/**
 * I worked on this assignment alone, using only course materials
 * @author Jared Duncan
 */
public class Business {
    private Item[] inventory;
    private String name;
    private double totalSales;
    private int totalTransactions;

    public Business(String[][] data) {
        inventory = new Item[10];
        name = data[0][0];
        totalSales = 0.0;
        totalTransactions = 0;

        String itemName;
        double price;
        int quantity;
        for (int i = 1; i < data.length; i++) {
            itemName = data[i][0];
            price = Double.parseDouble(data[i][1]);
            quantity = Integer.parseInt(data[i][2]);

            addItem(new Item(itemName, quantity, price));
        }
    }

    public String getName() {
        return name;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public Item getBestSellingItem() {
        Item bestItem = inventory[0];
        for (Item item : inventory) {
            if (item != null && item.numAttempts() > bestItem.numAttempts()) {
                bestItem = item;
            }
        }
        return bestItem;
    }

    public void sell(Person person, Item item, int quantity) {
        item.increaseAttemptsBy(1);
        if (item.getQuantity() >= quantity
            && person.getBalance() >= item.getPrice() * quantity) {
            for (int i = 0; i < quantity; i++) {
                person.purchase(item);
            }
            item.setQuantity(item.getQuantity() - quantity);
            item.increaseNumSold(quantity);
            totalSales += quantity * item.getPrice();
            totalTransactions++;
        }
    }

    public boolean addItem(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return true;
            } else if (inventory[i].equals(item)) {
                return false;
            }
        }

        Item[] oldInventory = inventory;
        inventory = new Item[2 * inventory.length];
        for (int i = 0; i < oldInventory.length; i++) {
            inventory[i] = oldInventory[i];
        }
        inventory[oldInventory.length] = item;
        return true;
    }

    public String getReport(int days, double execTime) {
        int numItems = 0;
        for (Item item : inventory) {
            if (item != null) {
                numItems += item.getQuantity();
            }
        }

        String unit;
        if (execTime < 1000) {
            unit = "ns";
        } else if (execTime * Math.pow(10, -3) < 1000) {
            execTime *= Math.pow(10, -3);
            unit = "us";
        } else if (execTime * Math.pow(10, -6) < 1000) {
            execTime *= Math.pow(10, -6);
            unit = "ms";
        } else {
            execTime *= Math.pow(10, -9);
            unit = "s";
        }

        String report = "Simulation Report: " + name + "\n";
        report += String.format("Execution time: %1.2f%s%n", execTime, unit);
        report += "==================================================\n";
        report += "Days of simulation:           " + days + "\n";
        report += "Total Transactions:           " + totalTransactions + "\n";
        report += String.format("Total Revenue:                $%1.2f%n",
            totalSales);
        report += "Number of Items in stock:     " + numItems + "\n";
        report += "Best selling Item:            \"" + getBestSellingItem()
            + "\"\n";
        report += "==================================================\n";
        return report;
    }
}