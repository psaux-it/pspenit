package io.github.psauxit.pspenit.payload;

public enum Ams {
    ACTIVE("ACTIVE"),
    PASSIVE("PASSIVE");

    private final String mode;

    Ams(String s) {
        mode = s;
    }

    public String toString() {
        return this.mode;
    }
}
