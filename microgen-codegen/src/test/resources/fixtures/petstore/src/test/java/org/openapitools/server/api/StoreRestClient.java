package org.openapitools.server.api;

import org.openapitools.server.model.Order;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.MicroGen")
@org.eclipse.microprofile.rest.client.inject.RegisterRestClient
@org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders
public interface StoreRestClient extends java.lang.AutoCloseable {

    /**
     * Delete purchase order by ID For valid response try integer IDs with positive integer value.
     * Negative or non-integer values will generate API errors
     *
     * @param orderId ID of the order that needs to be deleted (required)
     * @return {@code java.util.concurrent.CompletionStage&lt;javax.ws.rs.core.Response&gt;}
     */
    @javax.ws.rs.DELETE
    @javax.ws.rs.Path("store/order/{orderId}")
    java.util.concurrent.CompletionStage<javax.ws.rs.core.Response> deleteOrder(
            @javax.ws.rs.BeanParam DeleteOrderParams params) throws javax.ws.rs.WebApplicationException;

    class DeleteOrderParams {
        @javax.ws.rs.PathParam("orderId")
        @javax.validation.constraints.Min(1)
        public Long orderId;

        public DeleteOrderParams orderId(final Long orderId) {
            this.orderId = orderId;
            return this;
        }
    }

    /**
     * Returns pet inventories by status Returns a map of status codes to quantities
     *
     * @return {@code java.util.concurrent.CompletionStage&lt;java.util.Map&lt;String,
     *     Integer&gt;&gt;}
     */
    @javax.ws.rs.GET
    @javax.ws.rs.Path("store/inventory")
    @javax.ws.rs.Produces({"application/json"})
    java.util.concurrent.CompletionStage<java.util.Map<String, Integer>> getInventory()
            throws javax.ws.rs.WebApplicationException;

    /**
     * Find purchase order by ID For valid response try integer IDs with value &gt;&#x3D; 1 and
     * &lt;&#x3D; 10. Other values will generated exceptions
     *
     * @param orderId ID of pet that needs to be fetched (required)
     * @return {@code java.util.concurrent.CompletionStage&lt;Order&gt;}
     */
    @javax.ws.rs.GET
    @javax.ws.rs.Path("store/order/{orderId}")
    @javax.ws.rs.Produces({"application/json"})
    java.util.concurrent.CompletionStage<Order> getOrderById(
            @javax.ws.rs.BeanParam GetOrderByIdParams params) throws javax.ws.rs.WebApplicationException;

    class GetOrderByIdParams {
        @javax.ws.rs.PathParam("orderId")
        @javax.validation.constraints.Min(1)
        @javax.validation.constraints.Max(10)
        public Long orderId;

        public GetOrderByIdParams orderId(final Long orderId) {
            this.orderId = orderId;
            return this;
        }
    }

    /**
     * Place an order for a pet
     *
     * @param order order placed for purchasing the pet (required)
     * @return {@code java.util.concurrent.CompletionStage&lt;Order&gt;}
     */
    @javax.ws.rs.POST
    @javax.ws.rs.Path("store/order")
    @javax.ws.rs.Consumes({"application/json"})
    @javax.ws.rs.Produces({"application/json"})
    java.util.concurrent.CompletionStage<Order> placeOrder(
            @javax.validation.constraints.NotNull @javax.validation.Valid Order order)
            throws javax.ws.rs.WebApplicationException;
}
