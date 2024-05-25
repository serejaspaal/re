package Components;

import java.util.Scanner;

public class UserInput {
    private Phone phone;
    private CallService callService;
    private PhoneSubject phoneSubject;

    public UserInput(Phone phone, CallService callService, PhoneSubject phoneSubject) {
        this.phone = phone;
        this.callService = callService;
        this.phoneSubject = phoneSubject;
    }

    public void run() {
        Scanner scan = new Scanner(System.in);

        int c = 0;
        while (c != 6) {
            System.out.println(phone instanceof PhoneDecorator ?
                    "Меню:\n1)Позвонить\n2)Пополнить баланс\n3)Проверить баланс\n4)Пополнить баланс внешней платежной системой\n5)Состояние телефона\n6)Выключить телефон\n" :
                    "Меню:\n1)Позвонить\n2)Пополнить баланс\n3)Проверить баланс\n4)Улучшить телефон\n5)Состояние телефона\n6)Выключить телефон\n");

                    try{
                        c = Integer.valueOf(scan.next());
                    } catch (NumberFormatException e){
                        c = 0;
                    }
                    Menu menu = new Menu();
                    switch (c){
                        case 1:
                            menu.MakeCall(callService, phone, phoneSubject);
                            break;
                        case 2:
                            menu.UpBalance(phone, phoneSubject);
                            break;
                        case 3:
                            System.out.println("Ваш баланс = " + phone.getBalance());
                            break;
                        case 4:
                            if (phone instanceof PhoneDecorator){
                                menu.InhancedBalance(phone, phoneSubject);
                            }
                            else{
                                // menu.UpgradePhone(phone);
                                PhoneDecorator smartPhone = new PhoneDecorator(phone);
                                phone = smartPhone;
                            }
                            break;
                        case 5:
                            System.out.println(phoneSubject.getState());
                            break;
                        case 6:
                        System.out.println("Выключение телефона");
                            break;
                        default:
                            System.out.println("Выберите функцию от 1 до 6");
                            break;
                    }
                }
                scan.close();
    }
}