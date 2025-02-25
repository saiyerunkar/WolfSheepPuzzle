package com.wolfandsheep;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '_';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setWolf(int row, int col) {
        grid[row][col] = 'w';
    }

    public void removeWolf(int row, int col) {
        grid[row][col] = '_';
    }

    public void setSheep(int row, int col) {
        grid[row][col] = 's';
    }

    public void removeSheep(int row, int col) {
        grid[row][col] = '_';
    }

    // Check if the given position is safe for placing a sheep
    public boolean isSafeForSheep(int row, int col) {
        return isSafe(row, col, 'w');
    }

    // Check if the given position is safe for placing a wolf
    public boolean isSafeForWolf(int row, int col) {
        return isSafe(row, col, 's');
    }

    // Method to check if a cell is safe from the opponent's pieces
    private boolean isSafe(int row, int col, char opponent) {
        // Check row and column for opponent presence
        for (int i = 0; i < size; i++) {
            if (grid[row][i] == opponent || grid[i][col] == opponent) return false;
        }
        // Check diagonals for opponent presence
        for (int i = -size; i <= size; i++) {
            if (isWithinBounds(row + i, col + i) && grid[row + i][col + i] == opponent) return false;
            if (isWithinBounds(row + i, col - i) && grid[row + i][col - i] == opponent) return false;
        }
        return true;
    }

    private boolean isWithinBounds(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public List<int[]> getWolvesCoordinates() {
        List<int[]> wolves = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 'w') {
                    wolves.add(new int[]{i, j});
                }
            }
        }
        return wolves;
    }

    public List<int[]> getSheepCoordinates() {
        List<int[]> sheep = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 's') {
                    sheep.add(new int[]{i, j});
                }
            }
        }
        return sheep;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
