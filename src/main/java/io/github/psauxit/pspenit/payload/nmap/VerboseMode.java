package io.github.psauxit.pspenit.payload.nmap;

public enum VerboseMode {
    SINGLE("-v"), DOUBLE("-vv");

    private final String mode;

    VerboseMode(String s) {
        mode = s;
    }

    public String toString() {
        return this.mode;
    }
}