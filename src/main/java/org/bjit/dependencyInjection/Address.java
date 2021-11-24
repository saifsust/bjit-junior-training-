package org.bjit.dependencyInjection;

public class Address {
    private String village ;
    private String zila;
    private String division;

    public Address() {
    }

    public Address(String village, String zila, String division) {
        this.village = village;
        this.zila = zila;
        this.division = division;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getZila() {
        return zila;
    }

    public void setZila(String zila) {
        this.zila = zila;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "Address{" +
                "village='" + village + '\'' +
                ", zila='" + zila + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
