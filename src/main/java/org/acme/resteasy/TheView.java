package org.acme.resteasy;


import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

import javax.json.bind.annotation.JsonbTransient;

@EntityView(TheEntity.class)
public abstract class TheView {
    public TheView(){

    }
    @JsonbTransient
    @IdMapping
    public abstract long getId();

    public abstract String getField1();

    public abstract String getField2();
}
