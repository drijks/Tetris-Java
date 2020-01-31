/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author diana
 */
public class Field {

    public int x;
    public int y;
    public int scale;
    public ArrayList<int[]> matrix;
    public Random r = new Random();
    public Color[] colors = {Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLUE, Color.MAGENTA};

    public Field(int x, int y, int scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.matrix = CreateField(x, y);

    }

    public ArrayList<int[]> CreateField(int x, int y) {
        ArrayList<int[]> newfield = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            int[] temp = new int[x];
            for (int j = 0; j < x; j++) {
                temp[j] = r.nextInt(8);
                if (i < 7) {
                    temp[j] = 0;
                }
            }
            newfield.add(temp);
        }
        return newfield;
    }

    public static void checkAL(ArrayList<int[]> al) {
        int nonzeroes = 0;
        int deletedrows = 0;
        int x = al.size();
        int y = al.get(0).length;
        ArrayList<int[]> temp = al;
        for (int i = al.size() - 1; i >= 0; i--) {
            nonzeroes = 0;
            for (int j = 0; j < al.get(i).length; j++) {
                if (al.get(i)[j] == 0) {
                    continue;
                }
                nonzeroes += 1;
            }
            if (nonzeroes == y) {
                temp.remove(i);
                deletedrows += 1;
            }
        }
        for (int i = 0; i < deletedrows; i++) {
            temp.add(i, new int[y]);
        }
        al = temp;
    }
    
        public void paintField(Graphics g) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).length; j++) {
                g.setColor(colors[matrix.get(i)[j]]);
                g.fillRect(j*scale, i*scale, scale, scale);
            }
        }
    }

}
