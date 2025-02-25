# WolfSheepPuzzle

1. Introduction
The Wolf and Sheep Puzzle is a strategic grid-based placement problem where users interact with an  grid to position wolves and sheep while adhering to constraints:
• Wolves threaten all cells in the same row, column, and diagonal.
• Sheep can only be placed in cells that are not threatened by wolves.

The objective is to either maximize the number of sheep (when wolves are placed first) or maximize the number of wolves (when sheep are placed first). This project explores the implementation of brute force and backtracking algorithms for solving this problem.

2. Algorithms
Brute Force Algorithm:
• Explores all possible placements of wolves or sheep on the grid.
• Evaluates each placement to find the optimal configuration.
• Suitable for small grids due to its high computational cost.

Backtracking Algorithm:
• Uses recursive pruning to explore only valid configurations.
• Skips invalid placements early to reduce unnecessary computation.
• More efficient for larger grids as it significantly reduces the state space.

3. Time Complexity
Brute Force:
• Time Complexity: O(gCk)
• g : Total number of cells in the grid (n x n).
k : Number of entities (wolves or sheep) to place.
gCk : {g!}{k!(g - k)!} combinations of placing k wolves on n x n grid.
• The algorithm explores all combinations of  placements from  cells, leading to exponential growth as  and  increase.

Backtracking:
• Time Complexity: O(gCk x Pvalid)
• Pvalid : Fraction of valid states after pruning.
• The backtracking algorithm significantly reduces the state space by skipping invalid configurations, making it more efficient than brute force.
