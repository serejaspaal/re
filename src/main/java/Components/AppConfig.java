package Components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = {"Components"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

    @Bean
    public Phone phone() {
        return new Phone("123-456-7890", 10.0, 0.5);
    }

    @Bean
    public CallService callService() {
      //
        //  return CallService.createCallService();
        return new CallService();
    }

    @Bean
    public ExternalPaymentSystem externalPaymentSystem() {
        return new ExternalPaymentSystem();
    }

    @Bean
    public PaymentGateway paymentGateway(ExternalPaymentSystem externalPaymentSystem) {
        return new PaymentAdapter(externalPaymentSystem);
    }

    @Bean
    public PhoneObserver phoneObserver() {
        return new PhoneObserver("Observer");
    }

    @Bean
    public PhoneSubject phoneSubject() {
        return new PhoneSubject();
    }
}