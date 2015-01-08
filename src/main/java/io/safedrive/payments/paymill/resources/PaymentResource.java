package io.safedrive.payments.paymill.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Payment object represents a payment with a credit card or via direct
 * debit. It is used for several function calls (e.g. transactions,
 * subscriptions, clients, ...). To be PCI compliant these information is
 * encoded by our Paymill PSP. You only get in touch with safe data (token) and
 * needn’t care about the security problematic of informations like credit card
 * data.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonTypeInfo(use = Id.NAME, include = As.WRAPPER_OBJECT, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = CreditCardPaymentResource.class, name = PaymentResource.CREDIT_CARD),
    @JsonSubTypes.Type(value = DebitCardPaymentResource.class, name = PaymentResource.DEBIT_CARD)
})
public abstract class PaymentResource extends Resource {

    public static final String CREDIT_CARD = "creditcard";
    public static final String DEBIT_CARD = "debit";

    @JsonProperty("type")
    private String type;
    @JsonProperty("app_id")
    private Boolean isRecurring;
    @JsonProperty("is_usable_for_preauthorization")
    private Boolean supportsPreauthorization;

}
