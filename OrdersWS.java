package edu.tarleton.restorder;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("orders")
public class OrdersWS {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Order order) {
        Database.addOrder(order);
        return Response.ok(order).build();
    }

    @GET
    public Response readAll() {
        Order[] orders = toArray(Database.getOrders());
        return Response.ok(orders).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response delete(@PathParam("id")String id) {
        Database.deleteOrder(id);
        return readAll();
    }

    private Order[] toArray(List<Order> orders) {
        Order[] p = new Order[orders.size()];
        for (int i = 0; i < p.length; i++) {
            p[i] = orders.get(i);
        }
        return p;
    }
}
