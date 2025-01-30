

public class DiffusionGrid {
    private static final int GRID_SIZE = 100;
    private double[][] diffusionGrid;

    public DiffusionGrid() {
        diffusionGrid = new double[GRID_SIZE][GRID_SIZE];
    }

    public void addPollutionToCell(int row, int col, double pollution) {
        this.diffusionGrid[row][col] += pollution;
    }

    public double getPollution(int row, int col) {
        return this.diffusionGrid[row][col];
    }


    public double createDiffusion() {
        double[][] newDiffusionGrid = new double[GRID_SIZE][GRID_SIZE];
        double newTotalDiffusion = 0;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                double sum = diffusionGrid[i][j];

                //top
                if (i > 0) sum += diffusionGrid[i - 1][j];
                //bottom
                if (i < GRID_SIZE - 1) sum += diffusionGrid[i + 1][j];

                //left
                if (j > 0) sum += diffusionGrid[i][j - 1];

                //right
                if (j < GRID_SIZE - 1) sum += diffusionGrid[i][j + 1];

                newDiffusionGrid[i][j] = sum / 5;

                 newTotalDiffusion += newDiffusionGrid[i][j];

            }
        }

        diffusionGrid = newDiffusionGrid;
        return newTotalDiffusion;
    }


}
