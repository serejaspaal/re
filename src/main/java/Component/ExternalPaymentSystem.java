package Component;

import org.springframework.stereotype.Component;

@Component
public class ExternalPaymentSystem {
    public void pay(double amount) {
        System.out.println("Платеж осуществлен: " + amount);
    }
}