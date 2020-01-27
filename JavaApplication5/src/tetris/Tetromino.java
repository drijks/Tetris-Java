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
public class Tetromino {

    public String type;
    public int[][] matrix;
    public int[] position;
    public int scale;
    public Color c;
    public Color[] colors = {Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLUE, Color.MAGENTA};

    public Tetromino(String type, int[] position, int scale) {
        this.type = type;
        this.matrix = CreateMatrix(type);
        this.position = position;
        this.scale = scale;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                g.setColor(colors[matrix[i][j]]);
                g.fillRect((i + position[0]) * scale, (j + position[1]) * scale, scale, scale);
            }
        }
    }

    public void CheckCollision(Tetromino t, Field f) {

    }
    
    public void fall(Field f) {
        if ((position[1]) < f.height) {
            position[1] += 1;
        }
    }

    public void Rotate(Tetromino t) {
        int[][] oldmatrix;
        if (t.type.equals("I")) {
            oldmatrix = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    oldmatrix[i][j] = t.matrix[i][j];
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    t.matrix[i][j] = oldmatrix[3 - j][i];
                }
            }
        } else {
            oldmatrix = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    oldmatrix[i][j] = t.matrix[i][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    t.matrix[i][j] = oldmatrix[2 - j][i];
                }
            }
        }
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
            case "O":
                newMatrix = new int[3][3];
                newMatrix[0][0] = 0;
                newMatrix[1][0] = 0;
                newMatrix[2][0] = 0;
                newMatrix[0][1] = 0;
                newMatrix[1][1] = 1;
                newMatrix[2][1] = 1;
                newMatrix[0][2] = 0;
                newMatrix[1][2] = 1;
                newMatrix[2][2] = 1;
                break;
            case "L":
                newMatrix = new int[3][3];
                newMatrix[0][0] = 0;
                newMatrix[1][0] = 2;
                newMatrix[2][0] = 0;
                newMatrix[0][1] = 0;
                newMatrix[1][1] = 2;
                newMatrix[2][1] = 0;
                newMatrix[0][2] = 0;
                newMatrix[1][2] = 2;
                newMatrix[2][2] = 2;
                break;
            case "J":
                newMatrix = new int[3][3];
                newMatrix[0][0] = 0;
                newMatrix[1][0] = 3;
                newMatrix[2][0] = 0;
                newMatrix[0][1] = 0;
                newMatrix[1][1] = 3;
                newMatrix[2][1] = 0;
                newMatrix[0][2] = 3;
                newMatrix[1][2] = 3;
                newMatrix[2][2] = 0;
                break;
            case "I":
                newMatrix = new int[4][4];
                newMatrix[0][0] = 0;
                newMatrix[1][0] = 4;
                newMatrix[2][0] = 0;
                newMatrix[3][0] = 0;
                newMatrix[0][1] = 0;
                newMatrix[1][1] = 4;
                newMatrix[2][1] = 0;
                newMatrix[3][1] = 0;
                newMatrix[0][2] = 0;
                newMatrix[1][2] = 4;
                newMatrix[2][2] = 0;
                newMatrix[3][2] = 0;
                newMatrix[0][3] = 0;
                newMatrix[1][3] = 4;
                newMatrix[2][3] = 0;
                newMatrix[3][3] = 0;
                break;
            case "T":
                newMatrix = new int[3][3];
                newMatrix[0][0] = 0;
                newMatrix[1][0] = 0;
                newMatrix[2][0] = 0;
                newMatrix[0][1] = 5;
                newMatrix[1][1] = 5;
                newMatrix[2][1] = 5;
                newMatrix[0][2] = 0;
                newMatrix[1][2] = 5;
                newMatrix[2][2] = 0;
                break;
            case "S":
                newMatrix = new int[3][3];
                newMatrix[0][0] = 0;
                newMatrix[1][0] = 0;
                newMatrix[2][0] = 0;
                newMatrix[0][1] = 0;
                newMatrix[1][1] = 6;
                newMatrix[2][1] = 6;
                newMatrix[0][2] = 6;
                newMatrix[1][2] = 6;
                newMatrix[2][2] = 0;
                break;
            case "Z":
                newMatrix = new int[3][3];
                newMatrix[0][0] = 0;
                newMatrix[1][0] = 0;
                newMatrix[2][0] = 0;
                newMatrix[0][1] = 7;
                newMatrix[1][1] = 7;
                newMatrix[2][1] = 0;
                newMatrix[0][2] = 0;
                newMatrix[1][2] = 7;
                newMatrix[2][2] = 7;
                break;
        }
        return newMatrix;
    }

}
