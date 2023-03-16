package io.github.psauxit.pspenit.payload.testssl;

public enum NoDns {
    MIN("min"), NONE("none");

    private final String mode;

    NoDns(String s) {
        mode = s;
    }

    public String toString() {
        return this.mode;
    }
}