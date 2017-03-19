package com.truxall.mazes.test;

import com.truxall.mazes.BinaryTree;
import com.truxall.mazes.Grid;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author trux
 */
public class BinaryTreeTest {

    @Test
    public void testGridCreate(){
        Grid newMaze = new Grid(5,5);

        BinaryTree.createMaze(newMaze);

        String result = newMaze.toString();

        System.out.print(result);

        assertNotNull(result);
    }
}
