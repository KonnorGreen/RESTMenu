package edu.tarleton.restorder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("menu")
public class MenuWS {
    
    @GET
    @Produces("application/json")
    public Response read() {
        String[] menu = {"Water", "Pizza", "Hamburger", "Beer"};
        return Response.ok(menu).build();
    }
}