package com.truxall.mazes.test;

import com.truxall.mazes.MazeMaker;
import com.truxall.mazes.Grid;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author trux
 */
public class MazeMakerTest {

    @Test
    public void testBinaryTreeCreate(){
        Grid newMaze = new Grid(10,10);

        MazeMaker.createBinaryTree(newMaze);

        String result = newMaze.toString();

        System.out.print(result);

        assertNotNull(result);
    }

    @Test
    public void testSidewinderCreate(){
        Grid newMaze = new Grid(10,10);

        MazeMaker.createSideWinder(newMaze);

        String result = newMaze.toString();

        System.out.println();
        System.out.println();
        System.out.print(result);

        assertNotNull(result);
    }
}
