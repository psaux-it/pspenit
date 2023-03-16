package io.github.psauxit.pspenit.payload;

public enum Dtc {
    MIXED("MIXED"),
    PASSIVE("PASSIVE"),
    AGGRESSIVE("AGGRESSIVE");

    private final String mode;

    Dtc(String s) {
        mode = s;
    }

    public String toString() {
        return this.mode;
    }
}
