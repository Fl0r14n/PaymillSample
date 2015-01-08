package io.safedrive.payments.paymill.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonTypeName(PaymentResource.CREDIT_CARD)
public class CreditCardPaymentResource extends PaymentResource {

    @JsonProperty("client")
    private ClientResource client;
    @JsonProperty("card_type")
    private String cardType;
    @JsonProperty("contry")
    private String country;
    @JsonProperty("expire_month")
    private String expireMonth;
    @JsonProperty("expire_year")
    private String expireYear;
    @JsonProperty("card_holder")
    private String cardHolder;
    @JsonProperty("last4")
    private String last4;
}
