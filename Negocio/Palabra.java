package Negocio;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;


public class Palabra {
    private Clip audio;
    private InputStream is;
    private String audioPath;
    private String imagePath;
    private String espannol;
    private String maleku;
    
    
    public Palabra(String espannol, String maleku, String audioPath, String imagePath)throws UnsupportedAudioFileException, IOException, LineUnavailableException{  
        this.espannol = espannol;
        this.maleku = maleku;
        //para la imagen 
        this.imagePath = imagePath;         
        //para el audio
        
        this.audioPath = audioPath;
   
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(audioPath);
        try {
          audio = AudioSystem.getClip();
          AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
          audio.open(ais);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
          System.err.println("ERROR: Playing sound has failed");
          e.printStackTrace();
        }
    }
    
    public void playAudio() throws UnsupportedAudioFileException, IOException,LineUnavailableException, InterruptedException{
        audio.start();
        
        //milisegundos
        Thread.sleep(audio.getMicrosecondLength()/1000);
        audio.stop();
        audio.close();
        
        //reinciar
        
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(audioPath);
        try {
          Clip clip = AudioSystem.getClip();
          AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
          clip.open(ais);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
          System.err.println("ERROR: Playing sound has failed");
          e.printStackTrace();
        }
        
        
    }
    
  

    public String getimagePath() {
        return imagePath;
    }

    public String getEspannol() {
        return espannol;
    }

    public String getMaleku() {
        return maleku;
    }
    
    
    
}




