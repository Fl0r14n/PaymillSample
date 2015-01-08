package io.safedrive.payments.paymill.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The clients object is used to edit, delete, update clients as well as to
 * permit refunds, subscriptions, insert credit card details for a client, edit
 * client details and of course make transactions. Clients can be created
 * individually by you or they will be automatically generated with the
 * transaction if there is no client ID transmitted.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClientResource extends Resource {

    @JsonProperty("email")
    private String email;
    @JsonProperty("description")
    private String description;
    @JsonProperty("payment")
    private ArrayList<PaymentResource> payments;
    @JsonProperty("subscription")
    private ArrayList<SubscriptionResource> subscriptions;
}
