package io.safedrive.payments.paymill.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * If you’d like to reserve some money from the client’s credit card but you’d
 * also like to execute the transaction itself a bit later, then use
 * preauthorizations. This is NOT possible with direct debit. A preauthorization
 * is valid for 7 days.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PreauthorizationResource extends Resource {
    
    public static final String STATUS_OPEN = "open";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_CLOSED = "closed";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_DELETED = "deleted";
    public static final String STATUS_PREAUTHORIZED = "preauth";
    
    @JsonProperty("description")
    private String description;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("status")
    private String status;
    @JsonProperty("livemode")
    private Boolean liveMode;
    @JsonProperty("payment")
    private PaymentResource payment;
    @JsonProperty("client")
    private ClientResource client;
    @JsonProperty("transaction")
    private TransactionResource transaction;
}
