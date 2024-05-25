package Components;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Phone phone = context.getBean(Phone.class);
        CallService callService = context.getBean(CallService.class);
        PhoneSubject phoneSubject = context.getBean(PhoneSubject.class);
        PhoneObserver phoneObserver = context.getBean(PhoneObserver.class);
        phoneSubject.attach(phoneObserver);

        UserInput userInput = new UserInput(phone, callService, phoneSubject);
        userInput.run();

        context.close();
    }
}