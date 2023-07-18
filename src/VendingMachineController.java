
public class VendingMachineController {
    private VendingMachineGui gui;
    private Menu menu;

    public VendingMachineController() {
        gui = new VendingMachineGui();
        menu = new Menu();
        gui.addButtonCreateListener(e -> menu.createVendingMachine());
        gui.addButtonTestListener(e -> menu.testVendingMachineSubMenu());
        gui.addButtonExitListener(e -> exitProgram());
    }

    private void exitProgram() {
        System.exit(0);
    }

    public static void main(String[] args) {
        VendingMachineController controller = new VendingMachineController();
    }
}
