package org.parking.lot;

public class ReturnChangeState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please collect the change first");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please collect the change first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please collect the change first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product already dispensed, please collect the change first");
    }

    @Override
    public void returnChange() {
        double change =  vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        if(change > 0) {
            System.out.println("Returning change: " + change);
            vendingMachine.resetTotalPayment();
        } else {
            System.out.println("No change to return");
        }
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
