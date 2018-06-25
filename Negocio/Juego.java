package Negocio;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Juego {
    private static Juego single_instance = null;
    private ArrayList<Palabra> palabras = new ArrayList<Palabra>();
    private int indexPalabras = 0;
    
    
    private Juego(){
        try {
            palabras.add(new Palabra("/Audios/prueba1.wav", recalcularImagen("/Imagenes/abeja.png")));
            palabras.add(new Palabra("/Audios/prueba2.wav", recalcularImagen("/Imagenes/caballo.png")));
            palabras.add(new Palabra("/Audios/prueba1.wav", recalcularImagen("/Imagenes/cocodrilo.png")));
            palabras.add(new Palabra("/Audios/prueba2.wav", recalcularImagen("/Imagenes/cucaracha.png")));
            palabras.add(new Palabra("/Audios/prueba1.wav", recalcularImagen("/Imagenes/gato.png")));
            palabras.add(new Palabra("/Audios/prueba2.wav", recalcularImagen("/Imagenes/guacamaya.png")));
            palabras.add(new Palabra("/Audios/prueba1.wav", recalcularImagen("/Imagenes/hormiga.png")));
            palabras.add(new Palabra("/Audios/prueba2.wav", recalcularImagen("/Imagenes/iguana.png")));
            palabras.add(new Palabra("/Audios/prueba1.wav", recalcularImagen("/Imagenes/jaguar.png")));
            palabras.add(new Palabra("/Audios/prueba2.wav", recalcularImagen("/Imagenes/mapache.png")));
            palabras.add(new Palabra("/Audios/prueba1.wav", recalcularImagen("/Imagenes/mariposa.png")));
            palabras.add(new Palabra("/Audios/prueba2.wav", recalcularImagen("/Imagenes/perezoso.png")));
            palabras.add(new Palabra("/Audios/prueba1.wav", recalcularImagen("/Imagenes/perro.png")));
            palabras.add(new Palabra("/Audios/prueba2.wav", recalcularImagen("/Imagenes/tortuga.png")));
            palabras.add(new Palabra("/Audios/prueba1.wav", recalcularImagen("/Imagenes/zorrillo.png")));
 
        } catch (Exception ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
    // static method to create instance of Singleton class
    public static Juego getInstance(){
        if (single_instance == null)
            single_instance = new Juego();
        return single_instance;
    }

    public Palabra getSiguientePalabra(){
        indexPalabras++;
        return palabras.get(indexPalabras-1);
    }
    
    public Palabra getPalabraAnterior(){
        indexPalabras--;
        return palabras.get(indexPalabras);
    }
    
    
    private Image recalcularImagen(String imagePath){
        Image img = new javax.swing.ImageIcon(getClass().getResource(imagePath)).getImage();  
        Image newimg = img.getScaledInstance( 284, 279,  java.awt.Image.SCALE_SMOOTH ) ;
        return newimg;
    }
    
    
    
}
