package io.safedrive.payments.paymill;

import com.paymill.context.PaymillContext;
import com.paymill.services.ClientService;

public class ClientController {

    private ClientService clientService;

    public void setClientService(PaymillContext paymillContext) {
        this.clientService = paymillContext.getClientService();        
    }
}
