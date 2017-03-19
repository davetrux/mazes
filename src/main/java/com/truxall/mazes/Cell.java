package com.truxall.mazes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author trux
 */
public class Cell {

    private int row;
    private int column;
    private HashMap<Cell, Boolean> links;

    private Cell north;
    private Cell south;
    private Cell east;
    private Cell west;

    public Cell(int row, int col) {
        this.row = row;
        this.column = col;
        links = new HashMap<>();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void link(Cell cell) {
        link(cell, true);
    }

    public void link(Cell cell, Boolean biDirectional) {
        links.put(cell, true);

        if(biDirectional) {
            cell.link(this, false);
        }
    }

    public void unLink(Cell cell) {
        unLink(cell, true);
    }

    public void unLink(Cell cell, Boolean biDirectional) {
        links.remove(cell);

        if(biDirectional) {
            cell.unLink(this, false);
        }
    }

    public Set<Cell> links (){
        return links.keySet();
    }

    public boolean isLinked(Cell cell) {
        return links.containsKey(cell);
    }

    public Set<Cell> neighbors(){
        Set<Cell> result = new HashSet<>();

        addNeighbor(this.north, result);
        addNeighbor(this.south, result);
        addNeighbor(this.east, result);
        addNeighbor(this.west, result);

        return result;
    }

    private void addNeighbor(Cell cell, Set<Cell> set) {
        if(cell != null) {
            set.add(cell);
        }
    }

    public Cell getNorth() {
        return north;
    }

    public void setNorth(Cell north) {
        this.north = north;
    }

    public Cell getSouth() {
        return south;
    }

    public void setSouth(Cell south) {
        this.south = south;
    }

    public Cell getEast() {
        return east;
    }

    public void setEast(Cell east) {
        this.east = east;
    }

    public Cell getWest() {
        return west;
    }

    public void setWest(Cell west) {
        this.west = west;
    }
}
