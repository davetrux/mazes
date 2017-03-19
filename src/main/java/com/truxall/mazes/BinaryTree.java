package com.truxall.mazes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author trux
 */
public class BinaryTree {

    private BinaryTree(){

    }

    public static void createMaze(Grid maze) {
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
}
