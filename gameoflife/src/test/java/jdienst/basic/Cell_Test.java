package jdienst.basic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Cell_Test {

  @Test
  public void shouldBeDeadAfterConstruction() {
    Cell cell = new Cell(8);
    assertFalse("Cell is alive. But it should not be alive after construction", cell.isAlive());
  }

  @Test
  public void setThreeLivingNeighbors_IsDead_IsAliveInNextGeneration() {
    Cell cell = getCell(false, 8);
    Cell[] neighbors = new Cell[8];
    for (int i = 0; i < 8; i++) {
      if (i < 3) {
        neighbors[i] = getCell(true, 8);
      }
      else {
        neighbors[i] = getCell(false, 8);
      }
    }
    cell.setNeighbors(neighbors);
    assertTrue("Cell should be alive with three living neighbors", cell.isAliveInNextGeneration());
  }

  @Test
  public void setThreeLivingNeighbors_IsAlive_IsAliveNextGeneration() {
    Cell cell = getCell(true, 8);
    Cell[] neighbors = new Cell[8];
    for (int i = 0; i < 8; i++) {
      if (i < 3) {
        neighbors[i] = getCell(true, 8);
      }
      else {
        neighbors[i] = getCell(false, 8);
      }
    }
    cell.setNeighbors(neighbors);
    assertTrue("Cell should be alive with three living neighbors", cell.isAliveInNextGeneration());
  }

  @Test
  public void setEightLivingNeighbors_IsAlive_IsDeadNextGeneration() {
    Cell cell = getCell(true, 8);
    Cell[] neighbors = new Cell[8];
    for (int i = 0; i < 8; i++) {
      neighbors[i] = getCell(true, 8);
    }
    cell.setNeighbors(neighbors);
    assertFalse("Cell should be dead with eight living neighbors", cell.isAliveInNextGeneration());
  }

  public static Cell getCell(boolean alive, int neighborsCount) {
    Cell cell = new Cell(8);
    if (alive) {
      cell.enlive();
    }
    return cell;
  }
}
