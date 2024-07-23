package org.parking.lot;

public enum Note {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    Note(double value) {
        this.value = value;
    }

    private final double value;

    public double getValue() {
        return value;
    }
}
