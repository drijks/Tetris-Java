/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris3;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author diana
 */
public class Tetromino {

    public String type;
    public int[][] matrix;
    public int x;
    public int y;
    public int scale;
    public Color c;
    public Color[] colors = {Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLUE, Color.MAGENTA};

    public Tetromino(String type, int x, int y, int scale) {
        this.type = type;
        this.matrix = CreateMatrix(type);
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    g.setColor(colors[matrix[i][j]]);
                    g.fillRect((i + x) * scale, (j + y) * scale, scale, scale);
                }
            }
        }
    }
    
    public void nextpaint(Graphics g) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    g.setColor(colors[matrix[i][j]]);
                    g.fillRect(i * scale, j * scale, scale, scale);
                }
            }
        }
    }

    public boolean CheckCollision(Field f) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (f.matrix.get(i + y)[j + x] > 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public void fall(Field f) {
        if (y + matrix.length < f.y) {
            y += 1;
        }
    }

    public void MoveLeft(Field f) {
        if (x > 0) {
            x -= 1;
        }
    }

    public void MoveRight(Field f) {
        if (x + matrix.length < f.x) {
            x += 1;
        }
    }

    public void Rotate(Tetromino t) {
        int[][] r2 = new int[t.matrix[0].length][t.matrix.length];
        for (int i = 0; i < t.matrix[0].length; i++) {
            for (int j = 0; j < t.matrix.length; j++) {
                r2[i][j] = t.matrix[t.matrix.length-1-j][i];
            }
        }
        t.matrix = r2;
    }

    public int[][] CreateMatrix(String t) {
        int[][] newMatrix;
        switch (t) {
            default:
                newMatrix = new int[3][3];
                newMatrix[0][0] = 0;
                newMatrix[1][0] = 0;
                newMatrix[2][0] = 0;
                newMatrix[0][1] = 0;
                newMatrix[1][1] = 0;
                newMatrix[2][1] = 0;
                newMatrix[0][2] = 0;
                newMatrix[1][2] = 0;
                newMatrix[2][2] = 0;
                break;
            case "F":
                newMatrix = new int[1][1];
                newMatrix[0][0] = 1;
                break;
            case "O":
                newMatrix = new int[2][2];
                newMatrix[0][0] = 1;
                newMatrix[0][1] = 1;
                newMatrix[1][0] = 1;
                newMatrix[1][1] = 1;
                break;
            case "L":
                newMatrix = new int[3][2];
                newMatrix[0][0] = 0;
                newMatrix[0][1] = 2;
                newMatrix[1][0] = 0;
                newMatrix[1][1] = 2;
                newMatrix[2][0] = 2;
                newMatrix[2][1] = 2;
                break;
            case "J":
                newMatrix = new int[3][2];
                newMatrix[0][0] = 3;
                newMatrix[0][1] = 0;
                newMatrix[1][0] = 3;
                newMatrix[1][1] = 0;
                newMatrix[2][0] = 3;
                newMatrix[2][1] = 3;
                break;
            case "I":
                newMatrix = new int[1][4];
                newMatrix[0][0] = 4;
                newMatrix[0][1] = 4;
                newMatrix[0][2] = 4;
                newMatrix[0][3] = 4;
                break;
            case "T":
                newMatrix = new int[3][2];
                newMatrix[0][0] = 5;
                newMatrix[0][1] = 0;
                newMatrix[1][0] = 5;
                newMatrix[1][1] = 5;
                newMatrix[2][0] = 5;
                newMatrix[2][1] = 0;
                break;
            case "S":
                newMatrix = new int[2][3];
                newMatrix[0][0] = 0;
                newMatrix[0][1] = 6;
                newMatrix[0][2] = 6;
                newMatrix[1][0] = 6;
                newMatrix[1][1] = 6;
                newMatrix[1][2] = 0;
                break;
            case "Z":
                newMatrix = new int[2][3];
                newMatrix[0][0] = 7;
                newMatrix[0][1] = 7;
                newMatrix[0][2] = 0;
                newMatrix[1][0] = 0;
                newMatrix[1][1] = 7;
                newMatrix[1][2] = 7;
                break;
        }
        return newMatrix;
    }

}
