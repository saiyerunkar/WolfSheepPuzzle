package com.wolfandsheep;

import java.util.List;

public interface Solver {
    void solve(Board board, int numEntities, List<int[]> initialPositions, boolean isWolf);
}
