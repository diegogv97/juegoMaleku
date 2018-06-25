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
            
            palabras.add(new Palabra("Abeja","Porróporr","Audios/prueba1.wav", recalcularImagen("Imagenes/abeja.png", 284, 279)));
            palabras.add(new Palabra("Caballo","Cóyonh","Audios/prueba2.wav", recalcularImagen("Imagenes/caballo.png", 284, 279)));
            palabras.add(new Palabra("Cocodrilo","Úju","Audios/prueba1.wav", recalcularImagen("Imagenes/cocodrilo.png", 284, 279)));
            palabras.add(new Palabra("Cucaracha","Jáca","Audios/prueba2.wav", recalcularImagen("Imagenes/cucaracha.png", 284, 279)));
            palabras.add(new Palabra("Gato","Tafáo/tafá óra","Audios/prueba1.wav", recalcularImagen("Imagenes/gato.png", 284, 279)));
            palabras.add(new Palabra("Guacamaya","Óla","Audios/prueba2.wav", recalcularImagen("Imagenes/guacamaya.png", 284, 279)));
            palabras.add(new Palabra("Hormiga","Ténanh","Audios/prueba1.wav", recalcularImagen("Imagenes/hormiga.png", 284, 279)));
            palabras.add(new Palabra("Iguana","Errá","Audios/prueba2.wav", recalcularImagen("Imagenes/iguana.png", 284, 279)));
            palabras.add(new Palabra("Jaguar","Yári","Audios/prueba1.wav", recalcularImagen("Imagenes/jaguar.png", 284, 279)));
            palabras.add(new Palabra("Mapache","Tíu inhánhe","Audios/prueba2.wav", recalcularImagen("Imagenes/mapache.png", 284, 279)));
            palabras.add(new Palabra("Mariposa","Fúfu","Audios/prueba1.wav", recalcularImagen("Imagenes/mariposa.png", 284, 279)));
            palabras.add(new Palabra("Perezoso","Nharáchunh","Audios/prueba2.wav", recalcularImagen("Imagenes/perezoso.jpg", 284, 279)));
            palabras.add(new Palabra("Perro","Aúsi","Audios/prueba1.wav", recalcularImagen("Imagenes/perro.png", 284, 279)));
            palabras.add(new Palabra("Tortuga","Páparunh","Audios/prueba2.wav", recalcularImagen("Imagenes/tortuga.jpg", 284, 279)));
            palabras.add(new Palabra("Zorrillo","Támerréja","Audios/prueba1.wav", recalcularImagen("Imagenes/zorrillo.png", 284, 279)));
           
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
    
    
    
    public Image recalcularImagen(String imagePath, int width, int height){
        ClassLoader classLoader = getClass().getClassLoader();
        Image img = new javax.swing.ImageIcon(classLoader.getResource(imagePath)).getImage();  
        Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;
        return newimg;
    }
    
    
    
}
