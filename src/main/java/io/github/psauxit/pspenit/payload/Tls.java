package io.github.psauxit.pspenit.payload;

public enum Tls {
    DISABLE("DISABLE");

    private final String mode;

    Tls(String s) {
        mode = s;
    }

    public String toString() {
        return this.mode;
    }
}
