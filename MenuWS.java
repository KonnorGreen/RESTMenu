package edu.tarleton.restorder;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("menu")
public class MenuWS {
    
    @EJB
    private ItemsService itemService;
    
    @GET
    @Produces("application/json")
    public Response read() {
        Collection<Item> items = itemService.selectAll();
        Item[] i = toArray(items);
        return Response.ok(i).build();
    }
    
    private Item[] toArray(Collection<Item> items) {
        Item[] i = new Item[items.size()];
        return items.toArray(i);
    }
}