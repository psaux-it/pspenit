package io.github.psauxit.pspenit.payload;

public enum Dns {
    AXFR("AXFR"),
    ZONEWALK("ZONEWALK"),
    BRUTE("BRUTE");

    private final String mode;

    Dns(String s) {
        mode = s;
    }

    public String toString() {
        return this.mode;
    }
}
