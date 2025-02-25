package com.wolfandsheep;

import java.util.List;
import java.util.Scanner;

public class GameMode {
    public static void playGame(Scanner scanner) {
        System.out.println("Welcome to the Wolf-Sheep Game Mode!");
        System.out.println("Enter grid size (n):");
        int n = scanner.nextInt();

        Grid grid = new Grid(n);

        System.out.println("Choose mode:");
        System.out.println("1. Place Wolves First");
        System.out.println("2. Place Sheep First");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter number of wolves:");
            int numWolves = scanner.nextInt();

            System.out.println("Enter positions for wolves (row and column):");
            for (int i = 0; i < numWolves; i++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                grid.placeEntity(row, col, 'w');
            }

            System.out.println("Enter number of sheep:");
            int numSheep = scanner.nextInt();

            System.out.println("Enter positions for sheep (row and column):");
            for (int i = 0; i < numSheep; i++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                grid.placeEntity(row, col, grid.isSafeForSheep(row, col) ? 's' : 'd');
            }

        } else if (choice == 2) {
            System.out.println("Enter number of sheep:");
            int numSheep = scanner.nextInt();

            System.out.println("Enter positions for sheep (row and column):");
            for (int i = 0; i < numSheep; i++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                grid.placeEntity(row, col, 's');
            }

            System.out.println("Enter number of wolves:");
            int numWolves = scanner.nextInt();

            System.out.println("Enter positions for wolves (row and column):");
            for (int i = 0; i < numWolves; i++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                grid.placeEntity(row, col, grid.isSafeForWolf(row, col) ? 'w' : 'x');
            }
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.println("Final Board:");
        grid.printBoard();
        System.out.println("Wolves Positions: " + formatCoordinates(grid.getCoordinates('w')));
        System.out.println("Sheep Positions: " + formatCoordinates(grid.getCoordinates('s')));
    }

    private static String formatCoordinates(List<int[]> coordinates) {
        StringBuilder sb = new StringBuilder();
        for (int[] coord : coordinates) {
            sb.append("(").append(coord[0]).append(", ").append(coord[1]).append(") ");
        }
        return sb.toString();
    }
}