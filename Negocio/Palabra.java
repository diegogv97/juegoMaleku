package Negocio;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;


public class Palabra {
    private Clip audio;
    private AudioInputStream audioInputStream;
    private String audioPath;
    private Image imagen;

    
    public Palabra(String audioPath, Image imagen)throws UnsupportedAudioFileException, IOException, LineUnavailableException{  
        //para la imagen 
        this.imagen = imagen;         
        //para el audio
        this.audioPath = audioPath;
        audioInputStream = AudioSystem.getAudioInputStream(new File(this.audioPath).getAbsoluteFile());
        audio = AudioSystem.getClip();
        audio.open(audioInputStream); 
    }
    
    public void playAudio() throws UnsupportedAudioFileException, IOException,LineUnavailableException, InterruptedException{
        audio.start();
        
        //milisegundos
        Thread.sleep(audio.getMicrosecondLength()/1000);
        audio.stop();
        audio.close();
        
        //reinciar
        audioInputStream = AudioSystem.getAudioInputStream(new File(audioPath).getAbsoluteFile());
        audio.open(audioInputStream);
        audio.setMicrosecondPosition(0);
    }
    
  

    public Image getImagen() {
        return imagen;
    }
    
    
    
}




