package com.latlng.bolt;

public class AddressModel {
    public String add1;
    public String add2;
    public String add3;

    public AddressModel(String add1, String add2, String add3) {
        this.add1 = add1;
        this.add2 = add2;
        this.add3 = add3;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }
}
