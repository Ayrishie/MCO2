import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class representing a special vending machine with additional features.
 */
public class SpecialVendingMachine extends RegularVendingMachine {


    /**
     * Constructs a SpecialVendingMachine object by calling the constructor of the parent class.
     */
    public SpecialVendingMachine() {
        super();

    }

    // Other methods related to item management (addItem, updateItemPrice, etc.) remain unchanged...

    /**
     * Allows the user to select items and prepare the product multiple times.
     * The user can keep selecting items until they choose to pay and dispense the product.
     */
    public void selectItemsAndPrepareProduct() {
        Scanner scanner = new Scanner(System.in);

        boolean continueSelecting = true;
        while (continueSelecting) {
            prepareProduct();

            System.out.println("Do you want to continue selecting items? (Y/N):");
            String choice = scanner.next().trim().toUpperCase();
            if (choice.equals("N")) {
                continueSelecting = false;
            }
        }

        // The user has finished selecting items, proceed with payment and dispensing if required.
        // You can implement the payment and dispensing logic here.
    }

    /**
     * Prepares a selected product based on the choices of items and their calorie counts.
     * It calculates the total calorie count of the selected items and displays how the final product is prepared.
     */
    public void prepareProduct() {
        List<Integer> chosenItems = new ArrayList<>();
        int totalCalories = 0;

        // Display available items
        System.out.println("Available Items:");
        displayItems();

        Scanner scanner = new Scanner(System.in);

        // Ask the user to make choices of items for the product
        System.out.println("Enter the slot numbers of items to include in the product (separate with spaces):");
        String input = scanner.nextLine();
        String[] slotNumbers = input.split(" ");

        // Parse the user input and get the chosen items
        for (String slotNumberStr : slotNumbers) {
            int slotNumber = Integer.parseInt(slotNumberStr);
            if (slotNumber >= 1 && slotNumber <= getSlotCount()) {
                chosenItems.add(slotNumber);
                totalCalories += getItemCalories().get(slotNumber - 1);
            }
        }

        // Display the selected items and their calorie counts
        System.out.println("Selected Items and Their Calorie Counts:");
        for (int slotNumber : chosenItems) {
            String item = getItemSlots().get(slotNumber - 1);
            int calories = getItemCalories().get(slotNumber - 1);
            System.out.println(item + " - " + calories + " calories");
        }

        // Display the total calorie count of the product
        System.out.println("Total Calorie Count of the Product: " + totalCalories);
    }




}
