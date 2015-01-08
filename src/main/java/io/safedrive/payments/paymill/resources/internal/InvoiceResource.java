package io.safedrive.payments.paymill.resources.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
public class InvoiceResource {

    public static final String INVOICE_PAYMILL = "paymill";
    public static final String INVOICE_WIRECARD = "wirecard";
    public static final String INVOICE_ACCEPTANCE = "acceptance";

    @JsonProperty("invoice_nr")
    private String invoiceNumber;
    @JsonProperty("netto")
    private Integer netto;
    @JsonProperty("brutto")
    private Integer brutto;
    @JsonProperty("status")
    private String status;
    @JsonProperty("period_from")
    private Date peroidFrom;
    @JsonProperty("period_until")
    private Date peroidUntil;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("vat_rate")
    private Integer vat;
    @JsonProperty("billing_date")
    private Integer billingDate;
    @JsonProperty("invoice_type")
    private String invoiceType;
    @JsonProperty("last_reminder_date")
    private Date lastReminder;
}
