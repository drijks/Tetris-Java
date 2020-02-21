/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris3;

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
    public static int score;
    public ArrayList<int[]> matrix;
    public Random r = new Random();
    public Color[] colors = {Color.BLACK, new Color(75, 0, 130), new Color(255, 105, 180), new Color(255, 153, 255), new Color(153, 204, 255), new Color(153, 153, 255), Color.BLUE, Color.MAGENTA, Color.GRAY};

//    public Color[] colors = {Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.GRAY};
    public Field(int x, int y, int scale, int score) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.score = score;
        this.matrix = CreateField(x, y);

    }

    public ArrayList<int[]> CreateField(int x, int y) {
        ArrayList<int[]> newfield = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            int[] temp = new int[x];
            for (int j = 0; j < x; j++) {
//                temp[j] = r.nextInt(8);
//                if (i < 10) {
//                    temp[j] = 0;
//                }
                if (i == y - 1) {
                    temp[j] = 8;
                }
            }
            newfield.add(temp);
        }
        return newfield;
    }

    public static void checkAL(ArrayList<int[]> al) {
        int nonzeroes = 0;
        int deletedrows = 0;
        int y = al.get(0).length;
        ArrayList<int[]> temp = al;
        for (int i = al.size() - 2; i >= 0; i--) {
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
        score += scoreMultiplier(deletedrows);
    }

    public static int scoreMultiplier(int rows) {
        if (rows == 1) {
            return 100;
        } else if (rows == 2) {
            return 300;
        } else if (rows == 3) {
            return 500;
        } else if (rows == 4) {
            return 800;
        }
        return 0;
    }

    public void paintField(Graphics g) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).length; j++) {
                g.setColor(colors[matrix.get(i)[j]]);
                g.fillRect(j * scale, i * scale, scale, scale);
            }
        }
    }

}
