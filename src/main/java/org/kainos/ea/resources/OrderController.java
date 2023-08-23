package org.kainos.ea.resources;


import io.swagger.annotations.Api;
import org.kainos.ea.api.OrderService;
import org.kainos.ea.client.*;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.InvalidPropertiesFormatException;

@Api("Engineering Academy Dropwizard Product API")
@Path("/api")
public class OrderController {
    private OrderService orderService = new OrderService();

    @GET
    @Path("/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder() {
        try {
            return Response.ok(orderService.getAllOrders()).build();
        } catch (FailedToGetOrdersException e) {
            System.err.println(e.getMessage());
        }
        return Response.serverError().build();


    }

    @GET
    @Path("/orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("id") int id) {
        try {
            return Response.ok(orderService.getOrderById(id)).build();

        } catch (FailedToGetOrdersException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (OrderDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
   
}