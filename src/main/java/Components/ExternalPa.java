package Components;


@Component
public class ExternalPa  ymentSystem {
    public void pay(double amount) {
        System.out.println("Платеж осуществлен: " + amount);
    }
}