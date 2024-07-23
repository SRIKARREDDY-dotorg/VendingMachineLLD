package org.parking.lot;

public class IdleState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if(vendingMachine.inventory.isAvailable(product)) {
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getReadyState());
            System.out.println("Product selected" + product.getName());
        } else {
            System.out.println("Product not available");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select the product first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select the product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select the product and make payment");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return");
    }
}
