package org.parking.lot;

public class ReadyState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted" + coin.getValue());
        checkPayment();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted" + note.getValue());
        checkPayment();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make the payment first");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        if(change > 0) {
            System.out.println("Returning change: " + change);
            vendingMachine.resetTotalPayment();
        } else {
            System.out.println("No change to return");
        }
        vendingMachine.setState(vendingMachine.getIdleState());
    }

    private void checkPayment() {
        if(vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }
}
