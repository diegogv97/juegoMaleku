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
            
            palabras.add(new Palabra("Abeja","Porróporr","Audios/prueba.wav", "Imagenes/abeja.png"));
            palabras.add(new Palabra("Caballo","Cóyonh","Audios/prueba.wav", "Imagenes/caballo.png"));
            palabras.add(new Palabra("Cocodrilo","Úju","Audios/prueba.wav", "Imagenes/cocodrilo.png"));
            palabras.add(new Palabra("Cucaracha","Jáca","Audios/prueba.wav", "Imagenes/cucaracha.png"));
            palabras.add(new Palabra("Gato","tafá óra","Audios/prueba.wav", "Imagenes/gato.png"));
            palabras.add(new Palabra("Guacamaya","Óla","Audios/prueba.wav", "Imagenes/guacamaya.png"));
            palabras.add(new Palabra("Hormiga","Ténanh","Audios/prueba.wav", "Imagenes/hormiga.png"));
            palabras.add(new Palabra("Iguana","Errá","Audios/prueba.wav", "Imagenes/iguana.png"));
            palabras.add(new Palabra("Jaguar","Yári","Audios/prueba.wav", "Imagenes/jaguar.png"));
            palabras.add(new Palabra("Mapache","Tíu inhánhe","Audios/prueba.wav", "Imagenes/mapache.png"));
            palabras.add(new Palabra("Mariposa","Fúfu","Audios/prueba.wav", "Imagenes/mariposa.png"));
            palabras.add(new Palabra("Perezoso","Nharáchunh","Audios/prueba.wav", "Imagenes/perezoso.jpg"));
            palabras.add(new Palabra("Perro","Aúsi","Audios/prueba.wav", "Imagenes/perro.png"));
            palabras.add(new Palabra("Zorrillo","Támerréja","Audios/prueba.wav", "Imagenes/zorrillo.png"));
          
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
    
    public boolean sonIguales(Palabra p1, Palabra p2){
        if(p1.getEspannol().equals(p2.getEspannol())){
            if(p1.getMaleku().equals(p2.getMaleku())){
                if(p1.getimagePath().equals(p2.getimagePath())){
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
