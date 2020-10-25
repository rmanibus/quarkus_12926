package org.acme.resteasy;

import com.blazebit.persistence.view.EntityViewManager;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resteasy/hello")
public class TheResource {

    @Inject
    EntityManager em;
    @Inject
    EntityViewManager evm;
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response withBlaze(@PathParam("id") long id) {
        //return em.find(TheEntity.class, id);
        return Response.ok(evm.find(em, TheView.class, id)).build();
    }
    @GET
    @Path("/abstract")
    @Produces(MediaType.APPLICATION_JSON)
    public Response withAbstract(@PathParam("id") long id) {
        return Response.ok(new TheView(){

            @Override
            public long getId() {
                return 30;
            }

            @Override
            public String getField1() {
                return "aaa";
            }

            @Override
            public String getField2() {
                return "bbb";
            }
        }).build();
    }

    @GET
    @Path("/interface")
    @Produces(MediaType.APPLICATION_JSON)
    public Response withInterface(@PathParam("id") long id) {
        return Response.ok(new TheInterface(){

            @Override
            public long getId() {
                return 30;
            }

            @Override
            public String getField1() {
                return "aaa";
            }

            @Override
            public String getField2() {
                return "bbb";
            }
        }).build();
    }
}