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
    
    
    public Juego(){
        try {
            
            palabras.add(new Palabra("Abeja","Porróporr","Audios/prueba1.wav", "Imagenes/abeja.png"));
            palabras.add(new Palabra("Caballo","Cóyonh","Audios/prueba2.wav", "Imagenes/caballo.png"));
            palabras.add(new Palabra("Cocodrilo","Úju","Audios/prueba1.wav", "Imagenes/cocodrilo.png"));
            palabras.add(new Palabra("Cucaracha","Jáca","Audios/prueba2.wav", "Imagenes/cucaracha.png"));
            palabras.add(new Palabra("Gato","Tafáo/tafá óra","Audios/prueba1.wav", "Imagenes/gato.png"));
            palabras.add(new Palabra("Guacamaya","Óla","Audios/prueba2.wav", "Imagenes/guacamaya.png"));
            palabras.add(new Palabra("Hormiga","Ténanh","Audios/prueba1.wav", "Imagenes/hormiga.png"));
            palabras.add(new Palabra("Iguana","Errá","Audios/prueba2.wav", "Imagenes/iguana.png"));
            palabras.add(new Palabra("Jaguar","Yári","Audios/prueba1.wav", "Imagenes/jaguar.png"));
            palabras.add(new Palabra("Mapache","Tíu inhánhe","Audios/prueba2.wav", "Imagenes/mapache.png"));
            palabras.add(new Palabra("Mariposa","Fúfu","Audios/prueba1.wav", "Imagenes/mariposa.png"));
            palabras.add(new Palabra("Perezoso","Nharáchunh","Audios/prueba2.wav", "Imagenes/perezoso.jpg"));
            palabras.add(new Palabra("Perro","Aúsi","Audios/prueba1.wav", "Imagenes/perro.png"));
            palabras.add(new Palabra("Tortuga","Páparunh","Audios/prueba2.wav", "Imagenes/tortuga.jpg"));
            palabras.add(new Palabra("Zorrillo","Támerréja","Audios/prueba1.wav", "Imagenes/zorrillo.png"));
          
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

    public void palabraSiguiente(){
        indexPalabras++;
    }
    
    public void palabraAnterior(){
        indexPalabras--;
    }
    
    public void palabraPrimera(){
        indexPalabras = 0;
    }
    
    public Palabra getPalabraActual(){
        return palabras.get(indexPalabras);
    }
    
    public boolean ultimaPalabra(){
        if(indexPalabras == palabras.size()-1){
            return true;
        }
        return false;
    }
    
    public boolean isPrimeraPalabra(){
        if(indexPalabras == 0){
            return true;
        }
        return false;
    }
    
    public Palabra getRandomPalabra(){
        int random = (int )(Math.random() * 14);
        return palabras.get(random);
    }
    
    public Image recalcularImagen(String imagePath, int width, int height){
        ClassLoader classLoader = getClass().getClassLoader();
        Image img = new javax.swing.ImageIcon(classLoader.getResource(imagePath)).getImage();  
        Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;
        return newimg;
    }
    
    
    
}
