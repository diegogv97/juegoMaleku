
package Negocio;

import javax.swing.JLabel;



public class cartasMemoria {
    private javax.swing.JLabel lbl;
    private Palabra palabra;
    private boolean isTexto;

    public javax.swing.JLabel getLbl() {
        return lbl;
    }

    public void getLbl(javax.swing.JLabel lbl) {
        this.lbl = lbl;
    }

    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }

    public boolean isIsTexto() {
        return isTexto;
    }

    public cartasMemoria(javax.swing.JLabel lbl, Palabra palabra, boolean isTexto) {
        this.lbl = lbl;
        this.palabra = palabra;
        this.isTexto = isTexto;
    }
    
}
