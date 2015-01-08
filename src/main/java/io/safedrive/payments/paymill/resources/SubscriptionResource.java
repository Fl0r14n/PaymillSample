package io.safedrive.payments.paymill.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Subscriptions allow you to charge recurring payments on a client’s credit
 * card / to a client’s direct debit. A subscription connects a client to the
 * offers-object. A client can have several subscriptions to different offers,
 * but only one subscription to the same offer.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SubscriptionResource extends Resource {

    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_INACTIVE = "inactive";
    public static final String STATUS_EXPIRED = "expired";
    public static final String STATUS_FAILED = "failed";
    
    @JsonProperty("livemode")
    private Boolean liveMode;
    @JsonProperty("offer")
    private OfferResource offer;
    @JsonProperty("ammount")
    private Integer ammount;
    @JsonProperty("temp_ammount")
    private Integer temporaryAmmount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("name")
    private String name;
    @JsonProperty("trial_start")
    private Date trialStart;
    @JsonProperty("trial_end")
    private Date trialEnd;
    @JsonProperty("period_of_validity")
    private String validity;
    @JsonProperty("end_of_period")
    private Date expiringDate;
    @JsonProperty("next_capture_at")
    private Date nextCharge;
    @JsonProperty("payment")
    private PaymentResource payment;
    @JsonProperty("client")
    private ClientResource client;
    @JsonProperty("is_canceled")
    private Boolean isCanceled;
    @JsonProperty("is_deleted")
    private Boolean isDeleted;
    @JsonProperty("status")
    private String status;
}
