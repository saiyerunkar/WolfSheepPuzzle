package com.wolfandsheep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Wolf-Sheep Puzzle!");
        // System.out.println("Choose mode:");
        // System.out.println("1. Execute Algorithms");
        // System.out.println("2. Play Game");
        // int modeChoice = scanner.nextInt();

        // if (modeChoice == 1) {
            executeAlgorithms(scanner);
        // } else if (modeChoice == 2) {
        //     GameMode.playGame(scanner);
        // } else {
        //     System.out.println("Invalid choice!");
        // }

        scanner.close();
    }

    private static void executeAlgorithms(Scanner scanner) {
        System.out.println("Enter grid size (n):");
        int n = scanner.nextInt();

        System.out.println("Choose a scenario:");
        System.out.println("1. Scenario 1 (No of wolves)");
        System.out.println("2. Scenario 2 (No of sheep)");
        int scenarioChoice = scanner.nextInt();

        Grid grid = new Grid(n);

        if (scenarioChoice == 1) {
            System.out.println("Enter the number of wolves:");
            int numWolves = scanner.nextInt();

            // System.out.println("Enter the positions of wolves (row and column):");
            // for (int i = 0; i < numWolves; i++) {
            //     int row = scanner.nextInt();
            //     int col = scanner.nextInt();
            //     grid.placeEntity(row, col, 'w');
            // }

            System.out.println("Choose algorithm:");
            System.out.println("1. Brute Force");
            System.out.println("2. Backtracking");
            int algoChoice = scanner.nextInt();

            if (algoChoice == 1) {
                // BruteForceSolver bruteForceSolver = new BruteForceSolver(grid);
                // bruteForceSolver.solveScenario1();
                // System.out.println("Do you want to optimize the placement? (yes/no)");
                // String optimizeChoice = scanner.next();
                // if (optimizeChoice.equalsIgnoreCase("yes")) {
                    OptimalBruteForceSolver optimalSolver = new OptimalBruteForceSolver(grid);
                    optimalSolver.solveScenario1(numWolves);
                // }
            } else if (algoChoice == 2) {
                // BacktrackingSolver backtrackingSolver = new BacktrackingSolver(grid);
                // backtrackingSolver.solveScenario1();
                // System.out.println("Do you want to optimize the placement? (yes/no)");
                // String optimizeChoice = scanner.next();
                // if (optimizeChoice.equalsIgnoreCase("yes")) {
                    OptimalBacktrackingSolver optimalSolver = new OptimalBacktrackingSolver(grid);
                    optimalSolver.solveScenario1(numWolves);
                // }
            } else {
                System.out.println("Invalid algorithm choice!");
            }


        } else if (scenarioChoice == 2) {
            System.out.println("Enter the number of sheep:");
            int numSheep = scanner.nextInt();

            // System.out.println("Enter the positions of sheep (row and column):");
            // for (int i = 0; i < numSheep; i++) {
            //     int row = scanner.nextInt();
            //     int col = scanner.nextInt();
            //     grid.placeEntity(row, col, 's');
            // }

            System.out.println("Choose algorithm:");
            System.out.println("1. Brute Force");
            System.out.println("2. Backtracking");
            int algoChoice = scanner.nextInt();

            if (algoChoice == 1) {
                // BruteForceSolver bruteForceSolver = new BruteForceSolver(grid);
                // bruteForceSolver.solveScenario2();
                // System.out.println("Do you want to optimize the placement? (yes/no)");
                // String optimizeChoice = scanner.next();
                // if (optimizeChoice.equalsIgnoreCase("yes")) {
                    OptimalBacktrackingSolver optimalSolver = new OptimalBacktrackingSolver(grid);
                    optimalSolver.solveScenario2(numSheep);
            //}
        } else if (algoChoice == 2) {
                // BacktrackingSolver backtrackingSolver = new BacktrackingSolver(grid);
                // backtrackingSolver.solveScenario2();

                // System.out.println("Do you want to optimize the placement? (yes/no)");
                // String optimizeChoice1 = scanner.next();
                // if (optimizeChoice1.equalsIgnoreCase("yes")) {
                    OptimalBacktrackingSolver optimalSolver = new OptimalBacktrackingSolver(grid);
                    optimalSolver.solveScenario2(numSheep);
               // }
            } else {
                System.out.println("Invalid algorithm choice!");
            }
            }

        else {
            System.out.println("Invalid scenario choice!");
        }
    }
}
