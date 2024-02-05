package ru.fafurin.lesson4;

public enum PhoneCode {
    RUS(7, "Russia"),
    USA(1, "USA"),
    CHN(86, "China"),
    MEX(52, "Mexico"),
    GRC(30, "Greece"),
    FRA(33, "France"),
    EGY(20, "Egypt"),
    SWE(46, "Sweden"),
    SGP(65, "Singapore"),
    PRK(850, "North Korea"),
    TUR(90, "Турция"),
    MAR(212, "Morocco");

    private int code;
    private String name;

    PhoneCode(int code, String name) {
        this.code = code;
        this.name = name;
    }
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
