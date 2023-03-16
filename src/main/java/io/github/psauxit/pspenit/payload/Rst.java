package io.github.psauxit.pspenit.payload;

public enum Rst {
    ENABLE("ENABLE");

    private final String mode;

    Rst(String s) {
        mode = s;
    }

    public String toString() {
        return this.mode;
    }
}
