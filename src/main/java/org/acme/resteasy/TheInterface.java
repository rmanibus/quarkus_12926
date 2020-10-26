package org.acme.resteasy;

import javax.json.bind.annotation.JsonbTransient;

public interface TheInterface {

    @JsonbTransient
    String getField1();

    String getField2();
}
