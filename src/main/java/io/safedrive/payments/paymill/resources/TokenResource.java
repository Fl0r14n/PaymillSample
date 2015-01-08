package io.safedrive.payments.paymill.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenResource {

    @JsonProperty("token")
    private String cardToken;
    @JsonProperty("client")
    private String clientToken;
}
