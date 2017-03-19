package com.truxall.mazes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author trux
 */
public class Grid {

    private int rows;
    private int columns;
    private Cell[][] grid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.columns = cols;
        grid = prepareGrid();
        configureCells();
    }

    protected Cell[][] prepareGrid() {
        Cell[][] result = new Cell[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = new Cell(i, j);
            }
        }
        return result;
    }

    protected void configureCells() {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++) {

                //North neighbor
                if(i - 1 < 0) {
                    grid[i][j].setNorth(null);
                } else {
                    grid[i][j].setNorth(grid[i-1][j]);
                }

                //South neighbor
                if(i + 1 >= rows) {
                    grid[i][j].setSouth(null);
                } else {
                    grid[i][j].setSouth(grid[i+1][j]);
                }

                //East neighbor
                if(j + 1 >= columns) {
                    grid[i][j].setEast(null);
                } else {
                    grid[i][j].setEast(grid[i][j+1]);
                }

                //West neighbor
                if(j - 1 < 0) {
                    grid[i][j].setWest(null);
                } else {
                    grid[i][j].setWest(grid[i][j-1]);
                }
            }
        }
    }

    public Cell randomCell() {
        Random generator = new Random();
        int rowIndex = generator.nextInt(rows);
        int colIndex = generator.nextInt(columns);

        return grid[rowIndex][colIndex];
    }

    public int getSize() {
        return rows * columns;
    }

    public List<Cell> eachRow(int rowIndex) {
        List<Cell> result = new ArrayList<>();

        result.addAll(Arrays.asList(grid[rowIndex]).subList(0, columns));

        return result;
    }

    public List<Cell> eachCell() {
        List<Cell> result = new ArrayList<>();

        for(int i = 0; i < rows; i++){
            result.addAll(Arrays.asList(grid[i]).subList(0, columns));
        }
        return result;
    }

    public String toString() {

        final StringBuilder result = new StringBuilder();

        //Top
        result.append("+");
        for(int i = 0; i < columns; i++) {
            result.append("---+");
        }
        result.append("\n");

        //Rows
        for(int i=0; i < rows; i++) {
            final StringBuilder top = new StringBuilder();
            top.append("|");
            final StringBuilder bottom = new StringBuilder();
            bottom.append("+");
            List<Cell> row = eachRow(i);
            for(Cell cell : row) {
                top.append("   ");
                if(cell.getEast() == null) {
                    top.append("|");
                } else {
                    if(cell.isLinked(cell.getEast())){
                        top.append(" ");
                    } else {
                        top.append("|");
                    }
                }
                if(cell.getSouth() == null) {
                    bottom.append("---+");
                } else {
                    if(cell.isLinked(cell.getSouth())) {
                        bottom.append("   +");
                    } else {
                        bottom.append("---+");
                    }
                }
            }
            top.append("\n");
            bottom.append("\n");
            result.append(top.toString());
            result.append(bottom.toString());
        }

        return result.toString();
    }
}
