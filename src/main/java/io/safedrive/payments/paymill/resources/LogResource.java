package io.safedrive.payments.paymill.resources;

import lombok.Data;

@Data
public class LogResource {
    Boolean successful;
    Integer status;
    String message;
}
