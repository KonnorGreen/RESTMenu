package edu.tarleton.restorder;

import java.util.Collection;
import javax.ejb.EJB;
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

    @EJB
    private OrdersService ordersService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Orders order) {
        ordersService.insert(order);
        return Response.ok(order).build();
    }

    @GET
    public Response readAll() {
        Collection<Orders> orders = ordersService.selectAll();
        Orders[] o = toArray(orders);
        return Response.ok(o).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response delete(@PathParam("id") Integer id) {
        ordersService.selectId(id);
        ordersService.removeOrder(id);
        return readAll();
    }

    private Orders[] toArray(Collection<Orders> orders) {
        Orders[] o = new Orders[orders.size()];
        return orders.toArray(o);
    }
}
