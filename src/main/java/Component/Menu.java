package Component;

import java.util.Scanner;


public class Menu {
    public void MakeCall(CallService call, Phone phone, PhoneSubject subject){
        Scanner scan = new Scanner(System.in);
        if(call.initiateCall(phone)){
            subject.setState("Звонок");
            System.out.println("Нажмите 1 чтобы ответить или 2 чтобы завершить звонок");
            int zvonok;
            try{
                zvonok = Integer.valueOf(scan.next());
            } catch (NumberFormatException e){
                zvonok = 0;
            }
            switch (zvonok){
                case 1:
                    call.receiveCall(phone);
                    BrosilDruga hehe = new BrosilDruga();
                    DrugBrosil plaki = new DrugBrosil();
                    subject.setState("Разговор");
                    System.out.println("Нажмите любую кнопку чтобы закончить разговор");
                    hehe.start();
                    plaki.start();
                    while(true){
                        if(!plaki.isAlive()){
                            hehe.interrupt();
                            scan.reset();
                            break;
                        }
                        if(!hehe.isAlive()){
                            plaki.interni();
                            break;
                        }
                    }
                    call.terminateCall(phone);
                    subject.setState("Ожидание");
                    break;
                case 2:
                    call.terminateCall(phone);
                    subject.setState("Ожидание");
                    break;
                default:
                    System.out.println("Выберите функцию от 1 до 2");
                    break;
            }
            
        }
        else{
            subject.setState("Заблокирован");
        }
    }

    public void UpBalance(Phone phone, PhoneSubject subject){
        Double money = 0.0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сумму на которую вы хотите пополнить баланс:");
        try{
            money = Double.valueOf(scan.next());
        } catch (NumberFormatException e){
            System.out.println("Ошибка. Введена некорректная сумма");
            money = 0.0;
        }
        phone.recharge(money);
        subject.setState("Баланс пополнен");
    }

    public void UpgradePhone(Phone phone){
        PhoneDecorator smartPhone = new PhoneDecorator(phone);
        phone = smartPhone;
    }

    public void InhancedBalance(Phone phone, PhoneSubject subject){
        Scanner scan = new Scanner(System.in);
        ExternalPaymentSystem externalPaymentSystem = new ExternalPaymentSystem();
        PaymentGateway paymentGateway = new PaymentAdapter(externalPaymentSystem);
        System.out.println("Введите сумму на которую вы хотите пополнить баланс:");
        double money;
        try{
            money = Double.valueOf(scan.next());
        } catch (NumberFormatException e){
            System.out.println("Ошибка. Введена некорректная сумма");
            money = 0.0;
        }
        ((PhoneDecorator)phone).rechargeViaPaymentGateway(paymentGateway, money);
        subject.setState("Баланс пополнен");
    }
}
