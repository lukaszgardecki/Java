package com.hexagon.shop.adapter.in.rest.cart;

import com.hexagon.shop.application.port.in.cart.EmptyCartUseCase;
import com.hexagon.shop.model.customer.CustomerId;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import static com.hexagon.shop.adapter.in.rest.common.CustomerIdParser.parseCustomerId;

@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
public class EmptyCartController {

    private final EmptyCartUseCase emptyCartUseCase;

    public EmptyCartController(EmptyCartUseCase emptyCartUseCase) {
        this.emptyCartUseCase = emptyCartUseCase;
    }

    @DELETE
    @Path("/{customerId}")
    public void deleteCart(@PathParam("customerId") String customerIdString) {
        CustomerId customerId = parseCustomerId(customerIdString);
        emptyCartUseCase.emptyCart(customerId);
    }
}
