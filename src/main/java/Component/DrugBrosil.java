package Component;
import java.time.Duration;

public class DrugBrosil extends Thread {
    
    public void DrugBrosil(){}
    
    public void interni(){
        interrupt();
    }

    @Override
    public void run(){
        for(int i = 0; i < 30; i++){
            try {
                Thread.sleep(Duration.ofMillis(100).toMillis());
            }
            catch (InterruptedException e) {
                interrupt();
                break;
            }
            // if(isInterrupted()) {
            //     break;
            // }
        }

        if(!isInterrupted()){
            System.out.println("Ваш друг бросил трубку((");
        }
    }
}

