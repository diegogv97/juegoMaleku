package GUI;


import Negocio.Juego;
import Negocio.Palabra;
import Negocio.cartasMemoria;
import Negocio.relojThread;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;


public class Menu extends javax.swing.JFrame {
    static final int SEGUNDOS_TOTALES = 90;
    
    Juego juego;
    Palabra volteadaP;
    Palabra volteada2P;
    javax.swing.JLabel volteadaLbl;
    MouseListener volteadaLblListener;
    javax.swing.JLabel volteada2Lbl;
    boolean hayVolteada = false;
    int acertadas = 0;
    int falladas = 0;
    static ArrayList<cartasMemoria> cartas;
    
    public Menu() {
        initComponents();
        juego = Juego.getInstance();
        this.setLocationRelativeTo(null);
        panelJuego.setVisible(false);
        panelResultados.setVisible(false);
        panelVocabulario.setVisible(false);
        
        cartas = new ArrayList<cartasMemoria>();
        for(int i = 0; i<14/2; i++){
            javax.swing.JLabel lbl = new javax.swing.JLabel();
            javax.swing.JLabel lbl2 = new javax.swing.JLabel();
            
            Palabra p = obtenerPalabra(cartas);
            lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
            lbl2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
            lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lbl2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            
            cartasMemoria n = new cartasMemoria(lbl,p, true);
            cartasMemoria n2 = new cartasMemoria(lbl2,p, false);
            cartas.add(n);
            cartas.add(n2);
            Collections.shuffle(cartas);
            lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btnCartasMemoriaMouseClicked(evt,lbl, p, true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            
            lbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btnCartasMemoriaMouseClicked(evt,lbl2, p, false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        btnJugar = new javax.swing.JButton();
        btnVocabulario = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        panelJuego = new javax.swing.JPanel();
        btnjuego_Menu = new javax.swing.JButton();
        lblTiempo = new javax.swing.JLabel();
        panelVocabulario = new javax.swing.JPanel();
        btnVoca_menu = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        lblEspannol = new javax.swing.JLabel();
        lblMaleku = new javax.swing.JLabel();
        btnAudio = new javax.swing.JButton();
        btnDerecha = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        panelResultados = new javax.swing.JPanel();
        btnResults_Menu = new javax.swing.JButton();
        btnRetry = new javax.swing.JButton();
        lblIntentosFallidos = new javax.swing.JLabel();
        lblParejasCorrectas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego de Malecu");
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(534, 373));
        setMinimumSize(new java.awt.Dimension(534, 373));
        setName("Menu"); // NOI18N
        setPreferredSize(new java.awt.Dimension(534, 373));
        setResizable(false);
        setSize(new java.awt.Dimension(534, 373));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setPreferredSize(new java.awt.Dimension(530, 330));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnJugar.setText("jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        panelMenu.add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 257, 120, 47));

        btnVocabulario.setText("Vocabulario");
        btnVocabulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVocabularioActionPerformed(evt);
            }
        });
        panelMenu.add(btnVocabulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 257, 154, 47));

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("imagen de logo");
        lblLogo.setAlignmentX(234.0F);
        lblLogo.setAlignmentY(237.0F);
        lblLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblLogo.setMaximumSize(new java.awt.Dimension(405, 183));
        lblLogo.setMinimumSize(new java.awt.Dimension(405, 183));
        lblLogo.setPreferredSize(new java.awt.Dimension(405, 183));
        panelMenu.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 38, -1, -1));

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 534, 333));

        panelJuego.setBackground(new java.awt.Color(255, 255, 255));
        panelJuego.setPreferredSize(new java.awt.Dimension(530, 330));
        panelJuego.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnjuego_Menu.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnjuego_Menu.setText("Menú");
        btnjuego_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnjuego_MenuActionPerformed(evt);
            }
        });
        panelJuego.add(btnjuego_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 277, 75, 35));

        lblTiempo.setFont(new java.awt.Font("Palatino Linotype", 0, 24)); // NOI18N
        panelJuego.add(lblTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, -1));

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 534, 333));

        panelVocabulario.setBackground(new java.awt.Color(255, 255, 255));
        panelVocabulario.setPreferredSize(new java.awt.Dimension(530, 330));
        panelVocabulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVoca_menu.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnVoca_menu.setText("Menú");
        btnVoca_menu.setToolTipText("Regresar al menú");
        btnVoca_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoca_menuActionPerformed(evt);
            }
        });
        panelVocabulario.add(btnVoca_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 286, 75, 35));

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setToolTipText("");
        lblImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelVocabulario.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 27, 284, 279));

        lblEspannol.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        panelVocabulario.add(lblEspannol, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        lblMaleku.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        panelVocabulario.add(lblMaleku, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        btnAudio.setToolTipText("Reproducir audio");
        btnAudio.setBorderPainted(false);
        btnAudio.setContentAreaFilled(false);
        btnAudio.setFocusPainted(false);
        btnAudio.setMaximumSize(new java.awt.Dimension(10000, 10000));
        btnAudio.setMinimumSize(new java.awt.Dimension(1, 1));
        btnAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAudioActionPerformed(evt);
            }
        });
        panelVocabulario.add(btnAudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 70, 70));

        btnDerecha.setToolTipText("Continuar con la palabra siguiente");
        btnDerecha.setBorderPainted(false);
        btnDerecha.setContentAreaFilled(false);
        btnDerecha.setFocusPainted(false);
        btnDerecha.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnDerecha.setMaximumSize(new java.awt.Dimension(1000, 1000));
        btnDerecha.setMinimumSize(new java.awt.Dimension(1, 1));
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });
        panelVocabulario.add(btnDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 85, 61));

        btnIzquierda.setBackground(new java.awt.Color(255, 255, 255));
        btnIzquierda.setToolTipText("Regresar a la palabra anterior");
        btnIzquierda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIzquierda.setBorderPainted(false);
        btnIzquierda.setContentAreaFilled(false);
        btnIzquierda.setFocusPainted(false);
        btnIzquierda.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnIzquierda.setMaximumSize(new java.awt.Dimension(85, 61));
        btnIzquierda.setMinimumSize(new java.awt.Dimension(85, 61));
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });
        panelVocabulario.add(btnIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 85, 61));

        getContentPane().add(panelVocabulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 534, 333));

        panelResultados.setBackground(new java.awt.Color(255, 255, 255));
        panelResultados.setPreferredSize(new java.awt.Dimension(530, 330));
        panelResultados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnResults_Menu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnResults_Menu.setText("Menú");
        btnResults_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResults_MenuActionPerformed(evt);
            }
        });
        panelResultados.add(btnResults_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 112, 50));

        btnRetry.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnRetry.setText("Volver a \nintentar");
        btnRetry.setToolTipText("Regresar al juego");
        btnRetry.setHideActionText(true);
        btnRetry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRetry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetryActionPerformed(evt);
            }
        });
        panelResultados.add(btnRetry, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 50));

        lblIntentosFallidos.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblIntentosFallidos.setText("Intentos fallidos:");
        panelResultados.add(lblIntentosFallidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 438, 55));

        lblParejasCorrectas.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblParejasCorrectas.setText("Parejas correctas:");
        panelResultados.add(lblParejasCorrectas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 438, 55));

        getContentPane().add(panelResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 534, 333));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        panelMenu.setVisible(false);
        int x = 25;
        int y = 30;
        for(cartasMemoria cm : cartas){
                    cm.getLbl().setIcon(new ImageIcon(juego.recalcularImagen("Imagenes/signo_pregunta.png", 82, 83)));
                    panelJuego.add(cm.getLbl(), new org.netbeans.lib.awtextra.AbsoluteConstraints(x, y, 82, 83));
                    x+= 100;
                    if(x == 525){
                        x = 25;
                        y+= 100;
                    }
                    cm.getLbl().setVisible(true);
        }
        relojThread reloj = new relojThread(SEGUNDOS_TOTALES, lblTiempo);
        reloj.start();
        panelJuego.setVisible(true);
        
        
        
        SwingWorker<Boolean, Void> sw = new SwingWorker<Boolean, Void>(){
                @Override
                protected Boolean doInBackground() throws InterruptedException{
                    
                    while(reloj.getSegundos() >= 0){Thread.sleep(500);}
                    Thread.sleep(500);
                    lblParejasCorrectas.setText("Parejas correctas: " + String.valueOf(acertadas));
                    lblIntentosFallidos.setText("Intentos fallidos: " + String.valueOf(falladas));
                    if(panelJuego.isVisible()){
                        panelJuego.setVisible(false);
                        panelResultados.setVisible(true);
                    }
                    return true;
                }

                @Override
                protected void done(){   
                }
             };
             
        sw.execute();
             
             
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnVoca_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoca_menuActionPerformed
        panelVocabulario.setVisible(false);
        panelMenu.setVisible(true);
    }//GEN-LAST:event_btnVoca_menuActionPerformed

    private void btnVocabularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVocabularioActionPerformed
        panelMenu.setVisible(false);
        panelVocabulario.setVisible(true);
        
        btnIzquierda.setVisible(true);
        btnDerecha.setVisible(true);
        btnAudio.setVisible(true);
        btnIzquierda.setIcon(new ImageIcon(juego.recalcularImagen("Imagenes/flecha_izq.png", 85, 61)));
        btnDerecha.setIcon(new ImageIcon(juego.recalcularImagen("Imagenes/flecha_der.png", 85, 61)));
        btnAudio.setIcon(new ImageIcon(juego.recalcularImagen("Imagenes/audio.png", 65, 65)));
        
        juego.palabraPrimera();
        btnIzquierda.setVisible(false);  
            
        Palabra palabraActual = juego.getPalabraActual();
        lblImagen.setIcon(new ImageIcon(juego.recalcularImagen(palabraActual.getimagePath(), 284, 279)));
        lblEspannol.setText("Español: " + palabraActual.getEspannol());
        lblMaleku.setText("Malecu: " + palabraActual.getMaleku());
        
    }//GEN-LAST:event_btnVocabularioActionPerformed

    private void btnRetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetryActionPerformed
        panelResultados.setVisible(false);
        reiniciarJuego();
        panelJuego.setVisible(true);
    }//GEN-LAST:event_btnRetryActionPerformed

    private void btnResults_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResults_MenuActionPerformed
        panelResultados.setVisible(false);
        panelMenu.setVisible(true);
    }//GEN-LAST:event_btnResults_MenuActionPerformed

    private void btnAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAudioActionPerformed
        try {
            juego.getPalabraActual().playAudio();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAudioActionPerformed

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        juego.palabraSiguiente();
        btnIzquierda.setVisible(true);
     
        if(juego.ultimaPalabra()){
            btnDerecha.setVisible(false);
        }
        Palabra palabraActual = juego.getPalabraActual();
        lblImagen.setIcon(new ImageIcon(juego.recalcularImagen(palabraActual.getimagePath(), 284, 279)));
        lblEspannol.setText("Español: " + palabraActual.getEspannol());
        lblMaleku.setText("Malecu: " + palabraActual.getMaleku());
    }//GEN-LAST:event_btnDerechaActionPerformed

    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed
        juego.palabraAnterior();
        btnDerecha.setVisible(true);
        if(juego.isPrimeraPalabra()){
            btnIzquierda.setVisible(false);
        }
        Palabra palabraActual = juego.getPalabraActual();
        lblImagen.setIcon(new ImageIcon(juego.recalcularImagen(palabraActual.getimagePath(), 284, 279)));
        lblEspannol.setText("Español: " + palabraActual.getEspannol());
        lblMaleku.setText("Malecu: " + palabraActual.getMaleku());
        
    }//GEN-LAST:event_btnIzquierdaActionPerformed

    private void btnjuego_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnjuego_MenuActionPerformed
        panelJuego.setVisible(false);
        panelMenu.setVisible(true);
    }//GEN-LAST:event_btnjuego_MenuActionPerformed
    
    private void btnCartasMemoriaMouseClicked(java.awt.event.MouseEvent evt, javax.swing.JLabel lbl, Palabra p, boolean isTexto) throws InterruptedException {                                              
        if(!isTexto){
            lbl.setIcon(new ImageIcon(juego.recalcularImagen(p.getimagePath(), 82, 84)));
        }
        else{
            lbl.setIcon(null);
            lbl.setText(p.getEspannol());
        }
        if(!hayVolteada){
             volteadaLbl = lbl;
             volteadaP = p;
             hayVolteada = true;
             for( MouseListener ml : lbl.getMouseListeners() ) {
                lbl.removeMouseListener(ml);
                volteadaLblListener = ml;
            }
         }
         else{
             volteada2P = p;
             volteada2Lbl = lbl;
             
             SwingWorker<Boolean, Void> sw = new SwingWorker<Boolean, Void>(){
                @Override
                protected Boolean doInBackground() throws InterruptedException{
                    hayVolteada = false;
                    if(juego.sonIguales(volteada2P, volteadaP)){
                        acertadas++;
                        for( MouseListener ml : volteada2Lbl.getMouseListeners() ) {
                            volteada2Lbl.removeMouseListener(ml);
                        }
                        if(acertadas == 14/2){
                            System.out.println("Acertadas: " + acertadas +"   Falladas: " + falladas);
                            reiniciarJuego();
                            return true;
                        }
                    }
                    
                    else{
                        volteadaLbl.addMouseListener(volteadaLblListener);
                        falladas++;
                        return false;
                    }
                    return true;
                }

                @Override
                protected void done(){   
                    try {
                       if(!this.get()){
                           volteada2Lbl.setIcon(new ImageIcon(juego.recalcularImagen("Imagenes/signo_pregunta.png", 82, 83)));
                           volteadaLbl.setIcon(new ImageIcon(juego.recalcularImagen("Imagenes/signo_pregunta.png", 82, 83)));
                           volteada2Lbl.setText("");
                           volteadaLbl.setText("");
                           TimeUnit.MILLISECONDS.sleep(400);
                       }
                       else{
                       }
                   }catch (InterruptedException ex) {
                       System.out.println("error");
                   }catch (ExecutionException ex) {
                       System.out.println("error");
                   }

               }
             };
             
             sw.execute();
         }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    
    private Palabra obtenerPalabra(ArrayList<cartasMemoria> cartas){
        Palabra temp = juego.getRandomPalabra();
        boolean existe = false;
        while(true){
            for (cartasMemoria cm : cartas){
                if (cm.getPalabra().getEspannol().equals(temp.getEspannol())){
                    temp = juego.getRandomPalabra();
                    existe = true;
                    break;
                }
            }
            if(!existe)
                return temp;
            existe = false;
        }
    }
    
    private void reiniciarJuego(){
        hayVolteada = false;
        acertadas = 0;
        falladas = 0;
        int i = 0;
        while(i < cartas.size()){  
            Palabra p = obtenerPalabra(cartas);
            cartasMemoria cm1 = cartas.get(i);
            i++;
            cartasMemoria cm2 = cartas.get(i);
            i++;

            cm1.setPalabra(p); cm2.setPalabra(p);
            javax.swing.JLabel lbl1 = cm1.getLbl();
            javax.swing.JLabel lbl2 = cm2.getLbl();
            
            
            for( MouseListener ml : lbl1.getMouseListeners() ) {
                lbl1.removeMouseListener(ml);
            }
            for( MouseListener m2 : lbl2.getMouseListeners() ) {
                lbl2.removeMouseListener(m2);
            }
            
            lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btnCartasMemoriaMouseClicked(evt,lbl1, p, true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            
            lbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btnCartasMemoriaMouseClicked(evt,lbl2, p, false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            cartas.set(i-2, cm1); cartas.set(i-1, cm2);
        }
        Collections.shuffle(cartas);
        
        for(cartasMemoria cm : cartas){
                    cm.getLbl().setIcon(new ImageIcon(juego.recalcularImagen("Imagenes/signo_pregunta.png", 82, 83)));
                    cm.getLbl().setVisible(true);
                    cm.getLbl().setText("");
                    cm.getLbl().setFocusable(true);
        }
        relojThread reloj = new relojThread(SEGUNDOS_TOTALES, lblTiempo);
        reloj.start();
        SwingWorker<Boolean, Void> sw = new SwingWorker<Boolean, Void>(){
                @Override
                protected Boolean doInBackground() throws InterruptedException{
                    
                    while(reloj.getSegundos() >= 0){Thread.sleep(500);}
                    lblParejasCorrectas.setText("Parejas correctas: " + String.valueOf(acertadas));
                    lblIntentosFallidos.setText("Intentos fallidos: " + String.valueOf(falladas));
                    if(panelJuego.isVisible()){
                        panelJuego.setVisible(false);
                        panelResultados.setVisible(true);
                    }
                    return true;
                }

                @Override
                protected void done(){   
                }
             };
             
        sw.execute();
        
        
    }
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAudio;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnResults_Menu;
    private javax.swing.JButton btnRetry;
    private javax.swing.JButton btnVoca_menu;
    private javax.swing.JButton btnVocabulario;
    private javax.swing.JButton btnjuego_Menu;
    private javax.swing.JLabel lblEspannol;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblIntentosFallidos;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMaleku;
    private javax.swing.JLabel lblParejasCorrectas;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JPanel panelVocabulario;
    // End of variables declaration//GEN-END:variables
}
