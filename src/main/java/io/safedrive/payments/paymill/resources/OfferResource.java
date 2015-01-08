package io.safedrive.payments.paymill.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * An offer is a recurring plan which a user can subscribe to. You can create
 * different offers with different plan attributes e.g. a monthly or a yearly
 * based paid offer/plan.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OfferResource extends Resource {

    @Data
    public static class SubscriptionCountResource {

        @JsonProperty("active")
        private String active;
        @JsonProperty("inactive")
        private Integer inactive;
    }

    @JsonProperty("name")
    private String name;
    //(e.g. 42.00 = 4200)
    @JsonProperty("amount")
    private Integer amount;
    //Format: number DAY | WEEK | MONTH | YEAR Example: 2 DAY
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("trial_period_days")
    private Integer trialPeriodInDays;
    @JsonProperty("subscription_count")
    private SubscriptionCountResource subscriptionCount;
}
