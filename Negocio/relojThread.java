package Negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class relojThread extends Thread {
    private int segundos;
    javax.swing.JLabel label;

    
    
    public relojThread(int segundos, JLabel volteadaLbl) {
        this.segundos = segundos;
        this.label = volteadaLbl;
    }



    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    
    @Override
    public void run(){
        try {
            int minutos = segundos / 60;
            int segReales = segundos - (minutos * 60);
            while(segundos >= 0){
                if (segReales <= 9){
                    label.setText(String.valueOf(minutos) + ":0" + String.valueOf(segReales));
                }
                else{
                    label.setText(String.valueOf(minutos) + ":" + String.valueOf(segReales));
                }
                Thread.sleep(1000);
                segundos--;
                segReales = segundos - (minutos * 60);
                if(segReales == -1){
                    segReales = 59;
                }
                minutos = segundos / 60;
            }
             segundos = -1;
             Thread.sleep(1);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
