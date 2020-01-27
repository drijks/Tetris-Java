/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author diana
 */
public class Field {
    public int width;
    public int height;
    public int[][] field;
    public int scale = 60;
    public Color[] colors = {Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLUE, Color.MAGENTA};

    
    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new int[height][width];
    }
    
    public void paint(Graphics g) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                g.setColor(colors[field[i][j]]);
                g.fillRect(i * scale, j * scale, scale, scale);
            }
        }
    }
    
    public void Sweep(){
        int[][] newfield;
        outer: for (int i = height - 1; i > 0; i--) {
            for (int j = 0; j < width; j++) {
                if (field[i][j] == 0) {
                    continue outer;
                }
            }
            newfield = field.clone();
        }
    }
    
    public int[][] Shift(int[][] f) {
        int[][] newf = new int[f.length][width];
        for (int i = 0; i < f.length - 1; i++) {
            for (int j = 0; j < width; j++) {
                newf[i+1][j] = f[i][j];
            }
        }
        return newf;
    }
    
}
