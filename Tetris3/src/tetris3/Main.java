/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris3;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author diana
 */
public class Main extends javax.swing.JFrame implements KeyListener {

    public Random r = new Random();
    public Field field;
    public int scale = 60;
    public int currentscore = 0;
    public String piecetypes = "OLJITSZ";
    public Color[] colors = {Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLUE, Color.MAGENTA};
    public int ticks = 0;
    public Tetromino currentpiece = new Tetromino(randomPiece(piecetypes), 4, 0, scale);
    public Tetromino nextpiece = new Tetromino(randomPiece(piecetypes), 4, 0, scale);

    public Timer clock = new Timer(100, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            tick();
            playfield.repaint();
            scorelabel.repaint();
            nextpanel.repaint();
        }
    });

    @Override
    public void keyTyped(java.awt.event.KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                currentpiece.Rotate(currentpiece, field);
                break;
            case KeyEvent.VK_DOWN:
                currentpiece.fall(field);
                break;
            case KeyEvent.VK_LEFT:
                currentpiece.MoveLeft(field);
                break;
            case KeyEvent.VK_RIGHT:
                currentpiece.MoveRight(field);
                break;
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class MyPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            field.paintField(g);
            currentpiece.paint(g);
        }
    }

    public class MyPanel2 extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            nextpiece.nextpaint(g);
        }
    }

    public void tick() {
        ticks += 1;
        currentscore = field.score;
        counter(scorelabel);

        if (ticks % 20 == 0) {
            currentpiece.fall(field);
        }
        if (currentpiece.CheckCollision(field)) {
            merge(currentpiece, field);
            currentpiece = nextpiece;
            nextpiece = new Tetromino(randomPiece(piecetypes), 4, 0, scale);

        }
        field.checkAL(field.matrix);

    }

    public void counter(JLabel l) {
        l.setText("score: " + currentscore);
    }

    public String randomPiece(String s) {
        int ind = r.nextInt(s.length());
        String ns = "" + s.charAt(ind);
        return ns;
    }

    public void merge(Tetromino t, Field f) {
        for (int i = 0; i < t.matrix.length; i++) {
            for (int j = 0; j < t.matrix[i].length; j++) {
                if (t.matrix[i][j] > 0) {
                    f.matrix.get(i + t.y)[j + t.x] = t.matrix[i][j];
                }
            }
        }
    }

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        field = new Field(10, 20, scale, currentscore);
        clock.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playfield = new MyPanel();
        tetrislabel = new javax.swing.JLabel();
        newgamebutton = new java.awt.Button();
        scorelabel = new javax.swing.JLabel();
        nextpanel = new MyPanel2();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        playfield.setBackground(new java.awt.Color(0, 0, 0));
        playfield.setPreferredSize(new java.awt.Dimension(600, 1200));
        playfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                playfieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout playfieldLayout = new javax.swing.GroupLayout(playfield);
        playfield.setLayout(playfieldLayout);
        playfieldLayout.setHorizontalGroup(
            playfieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        playfieldLayout.setVerticalGroup(
            playfieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );

        tetrislabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        tetrislabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tetrislabel.setText("TETRIS");

        newgamebutton.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        newgamebutton.setLabel("New Game");
        newgamebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newgamebuttonActionPerformed(evt);
            }
        });
        newgamebutton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newgamebuttonKeyPressed(evt);
            }
        });

        nextpanel.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout nextpanelLayout = new javax.swing.GroupLayout(nextpanel);
        nextpanel.setLayout(nextpanelLayout);
        nextpanelLayout.setHorizontalGroup(
            nextpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        nextpanelLayout.setVerticalGroup(
            nextpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tetrislabel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nextpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newgamebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(275, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(scorelabel)
                        .addGap(94, 483, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tetrislabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newgamebutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 35, Short.MAX_VALUE)
                .addComponent(scorelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newgamebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newgamebuttonActionPerformed
        // TODO add your handling code here:
        field = new Field(10, 20, scale, currentscore);
    }//GEN-LAST:event_newgamebuttonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                currentpiece.Rotate(currentpiece, field);
                break;
            case KeyEvent.VK_DOWN:
                currentpiece.fall(field);
                break;
            case KeyEvent.VK_LEFT:
                currentpiece.MoveLeft(field);
                break;
            case KeyEvent.VK_RIGHT:
                currentpiece.MoveRight(field);
                break;
        }
    }//GEN-LAST:event_formKeyPressed

    private void playfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playfieldKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                currentpiece.Rotate(currentpiece, field);
                break;
            case KeyEvent.VK_DOWN:
                currentpiece.fall(field);
                break;
            case KeyEvent.VK_LEFT:
                currentpiece.MoveLeft(field);
                break;
            case KeyEvent.VK_RIGHT:
                currentpiece.MoveRight(field);
                break;
        }
    }//GEN-LAST:event_playfieldKeyPressed

    private void newgamebuttonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newgamebuttonKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                currentpiece.Rotate(currentpiece, field);
                break;
            case KeyEvent.VK_DOWN:
                currentpiece.fall(field);
                break;
            case KeyEvent.VK_LEFT:
                currentpiece.MoveLeft(field);
                break;
            case KeyEvent.VK_RIGHT:
                currentpiece.MoveRight(field);
                break;
        }
    }//GEN-LAST:event_newgamebuttonKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button newgamebutton;
    private javax.swing.JPanel nextpanel;
    private javax.swing.JPanel playfield;
    private javax.swing.JLabel scorelabel;
    private javax.swing.JLabel tetrislabel;
    // End of variables declaration//GEN-END:variables
}
