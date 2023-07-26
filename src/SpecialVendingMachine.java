import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class representing a special vending machine with additional features.
 */
public class SpecialVendingMachine extends RegularVendingMachine {

    private double totalCost;

    /**
     * Constructs a SpecialVendingMachine object by calling the constructor of the parent class.
     */
    public SpecialVendingMachine() {
        super();

    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    // Other methods related to item management (addItem, updateItemPrice, etc.) remain unchanged...
    @Override
    public boolean processTransaction(int slot, int paymentDenomination) throws IllegalArgumentException {
        double price = getItemPrices().get(slot);
        if (price == DEFAULT_PRICE) {
            System.out.println("Item price not set.");
            return false;
        }

        int quantity = itemQuantities.get(slot);
        if (quantity <= 0) {
            System.out.println("Item out of stock.");
            return false;
        }

        double paymentAmount = denominationValues.get(paymentDenomination - 1); // Retrieve payment amount based on denomination

        while (paymentAmount < price) {
            System.out.println("Current payment: " + paymentAmount);
            System.out.println("Remaining amount: " + (price - paymentAmount));
            System.out.println("Please enter the additional payment denomination (1-9):");

            int additionalPaymentDenomination = scanner.nextInt();
            if ((additionalPaymentDenomination < 1) || (additionalPaymentDenomination > 9)) {
                System.out.println("Invalid denomination. Please enter a valid denomination.");
                continue; // Ask for the denomination again
            }

            double additionalPayment = denominationValues.get(additionalPaymentDenomination - 1); // Retrieve payment amount based on additional payment denomination
            paymentAmount += additionalPayment;
        }

        double change = paymentAmount - price; // Calculate the change

        if (change < 0) {
            System.out.println("Insufficient payment. Please add more to the payment or enter 0 to cancel.");
            int additionalPaymentDenomination = scanner.nextInt();
            if (additionalPaymentDenomination == 0) {
                System.out.println("Transaction canceled.");
                return false;
            }

            if ((additionalPaymentDenomination < 1) || (additionalPaymentDenomination > 9)) {
                System.out.println("Invalid denomination. Transaction canceled.");
                return false;
            }

            double additionalPayment = denominationValues.get(additionalPaymentDenomination - 1); // Retrieve payment amount based on additional payment denomination
            paymentAmount += additionalPayment;
            change = paymentAmount - price;

            if (change < 0) {
                System.out.println("Still insufficient payment. Transaction canceled.");
                return false;
            }
        }

        // Prompt for the quantity of the selected denomination
        System.out.print("Enter the quantity for denomination " + paymentDenomination + ": ");
        quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (quantity < 0) {
            System.out.println("Invalid quantity. Please enter a non-negative value.");
            return false;
        }

        // Calculate the total amount paid
        int totalPayment = paymentDenomination * quantity;

        System.out.println("Total Amount Paid: " + totalPayment);

        if (totalCost <= totalPayment) {
            // Update the denomination quantities and calculate the change amount
            giveChange(change);

            itemQuantities.set(slot, quantity - 1);
            transactionCount++;
            totalSales += totalPayment - change;
            int initialQuantity = initialItemQuantities.get(slot);
            int soldQuantity = soldItemQuantities.get(slot);
            initialItemQuantities.set(slot, initialQuantity - 1);
            soldItemQuantities.set(slot, soldQuantity + 1);

            printReceipt(slot, quantity - 1, change); // Pass the updated quantity of the item
            displayItems(); // Call the displayItems() function to show the updated item quantities

            return true;
        } else {
            System.out.println("Insufficient payment. Transaction failed.");
            return false;
        }
    }


}
