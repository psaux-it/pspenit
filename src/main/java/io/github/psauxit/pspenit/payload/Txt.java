package io.github.psauxit.pspenit.payload;

public enum Txt {
    DMARC("DMARC"),
    SPF("SPF"),
    MX("MX"),
    NS("NS"),
    A("A"),
    REVERSE("REVERSE");

    private final String mode;

    Txt(String s) {
        mode = s;
    }

    public String toString() {
        return this.mode;
    }
}
