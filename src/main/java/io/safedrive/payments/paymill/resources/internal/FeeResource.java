package io.safedrive.payments.paymill.resources.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
public class FeeResource {

    @JsonProperty("type")
    private String type;
    @JsonProperty("application")
    private String applicationName;
    @JsonProperty("payment")
    private String paymentId;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("billed_at")
    private Date billedAt;
}
