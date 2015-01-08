package io.safedrive.payments.paymill.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonTypeName(PaymentResource.DEBIT_CARD)
public class DebitCardPaymentResource {
    @JsonProperty("code")
    private String code;
    @JsonProperty("account")
    private String account;
    @JsonProperty("holder")
    private String holder;
}
