package io.safedrive.payments.paymill;

import com.paymill.context.PaymillContext;
import com.paymill.models.Payment;
import com.paymill.models.Transaction;
import com.paymill.services.PaymentService;
import com.paymill.services.TransactionService;
import io.safedrive.payments.paymill.resources.LogResource;
import io.safedrive.payments.paymill.resources.TokenResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

    private PaymentService paymentService;
    private TransactionService transactionService;

    public void setPaymentService(PaymillContext paymillContext) {
        this.paymentService = paymillContext.getPaymentService();
        this.transactionService = paymillContext.getTransactionService();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public @ResponseBody
    LogResource chargePayment(@RequestBody TokenResource token) {
        Payment payment = paymentService.createWithToken(token.getCardToken());        
        /*
         * You can charge the ammount from the payment object fields that are mandatory and hidden in the form but we don't wanna do that
         * It's not safe. The user might change the amount in the form
         * We'll use a payment object just as a credit/debit card info
         */
        int amount = 10000; //this is actually 100.00
        Transaction transaction = transactionService.createWithPayment(payment, 10000, "RON");
        LogResource response = new LogResource();
        {
            response.setSuccessful(transaction.isSuccessful());
            if (transaction.isSuccessful()) {
                response.setMessage("Your " + payment.getCardType().name() + " has been successfuly charged with " + (transaction.getAmount()/100) + " " + transaction.getCurrency());
            } else {
                response.setMessage(transaction.getResponseCodeDetail());
            }
        }
        return response;
    }
}
