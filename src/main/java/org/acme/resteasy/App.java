package org.acme.resteasy;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class App {

    public static void main(String[] args) {
        Jsonb jsonb = JsonbBuilder.create();
        String abstractClassJson = jsonb.toJson(new TheClass() {

            @Override
            public String getField1() {
                return "aaa";
            }

            @Override
            public String getField2() {
                return "bbb";
            }
        });

        String interfaceJson = jsonb.toJson(new TheInterface() {

            @Override
            public String getField1() {
                return "aaa";
            }

            @Override
            public String getField2() {
                return "bbb";
            }
        });
        System.out.println(abstractClassJson);
        System.out.println(interfaceJson);
    }

}