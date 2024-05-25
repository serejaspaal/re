package Components;

import org.springframework.stereotype.Component;

@Component
public class PaymentAdapter implements PaymentGateway {
    private final ExternalPaymentSystem externalPaymentSystem;

    public PaymentAdapter(ExternalPaymentSystem externalPaymentSystem) {
        this.externalPaymentSystem = externalPaymentSystem;
    }

    @Override
    public void makePayment(double amount) {
        externalPaymentSystem.pay(amount);
    }
}