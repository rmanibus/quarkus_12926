package org.acme.resteasy;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class TheResourceTest {

    @Inject
    EntityManager em;

    long entityId;

    @BeforeEach()
    @Transactional
    public void setup(){
        TheEntity theEntity = TheEntity.builder().field1("aaa").field2("bbb").build();
        em.persist(theEntity);
        em.flush();
        entityId = theEntity.getId();
    }
    @Test
    public void testBlaze() {
        given()
          .when().get("/resteasy/hello/" + entityId)
          .then()
             .statusCode(200)
             .body(is("{\"field1\":\"aaa\",\"field2\":\"bbb\"}"));
    }

    @Test
    public void testAbstractClass() {
        given()
                .when().get("/resteasy/hello/abstract")
                .then()
                .statusCode(200)
                .body(is("{\"field1\":\"aaa\",\"field2\":\"bbb\"}"));
    }
    @Test
    public void testInterface() {
        given()
                .when().get("/resteasy/hello/interface")
                .then()
                .statusCode(200)
                .body(is("{\"field1\":\"aaa\",\"field2\":\"bbb\"}"));
    }

}