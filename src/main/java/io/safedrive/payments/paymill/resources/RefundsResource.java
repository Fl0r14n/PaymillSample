package io.safedrive.payments.paymill.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Refunds are own objects with own calls for existing transactions.
 * The refunded amount will be credited to the account of the client.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RefundsResource extends Resource {
    
    public static final String STATUS_OPEN = "open";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_REFUNDED = "refunded";
    
    @JsonProperty("transaction")
    private TransactionResource transaction;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("status")
    private String status;
    @JsonProperty("description")
    private String description;
    @JsonProperty("livemode")
    private Boolean liveMode;
    
}
