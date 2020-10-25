package org.acme.resteasy;

import com.blazebit.persistence.view.IdMapping;

import javax.json.bind.annotation.JsonbTransient;

public interface TheInterface {

    @JsonbTransient
    @IdMapping
    long getId();

    String getField1();

    String getField2();
}
