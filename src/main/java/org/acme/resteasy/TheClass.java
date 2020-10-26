package org.acme.resteasy;


import javax.json.bind.annotation.JsonbTransient;

public abstract class TheClass {
    public TheClass(){

    }
    @JsonbTransient
    public abstract String getField1();

    public abstract String getField2();
}
