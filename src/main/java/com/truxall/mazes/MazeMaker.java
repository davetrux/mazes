package com.truxall.mazes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author trux
 */
public class MazeMaker {

    private MazeMaker(){

    }

    public static void createBinaryTree(Grid maze) {
        Random generator = new Random();

        for(Cell cell : maze.eachCell()) {
            List<Cell> neighbors = new ArrayList<>();

            if(cell.getNorth() != null) {
                neighbors.add(cell.getNorth());
            }

            if(cell.getEast() != null) {
                neighbors.add(cell.getEast());
            }

            if(neighbors.size() > 0) {
                int index = generator.nextInt(neighbors.size());

                cell.link(neighbors.get(index));
            }
        }
    }

    public static void createSideWinder(Grid maze) {
        Random rand = new Random();

        for(List<Cell> row : maze.eachRow()) {
            List<Cell> run = new ArrayList<>();

            for(Cell cell : row) {
                run.add(cell);

                boolean isEastBoundary = cell.getEast() == null;
                boolean isNorthBoundary = cell.getNorth() == null;
                boolean shouldCloseOut = isEastBoundary || (!isNorthBoundary && rand.nextInt(2) ==  0 );

                if(shouldCloseOut) {
                    Cell member = run.get(rand.nextInt(run.size()));
                    if (member.getNorth() != null) {
                        member.link(member.getNorth());
                    }
                    run.clear();
                }
                else {
                   cell.link(cell.getEast());
                }
            }
        }
    }
}
