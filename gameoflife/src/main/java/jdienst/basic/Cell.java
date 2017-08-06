package jdienst.basic;

public class Cell {

  private boolean isAlive = false;
  private Cell[] neighbors;

  public Cell(int neighborCount) {
    neighbors = new Cell[neighborCount];
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void enlive() {
    isAlive = true;
  }

  public Cell setNeighbors(Cell[] neighbors) {
    this.neighbors = neighbors;
    return this;
  }

  public boolean isAliveInNextGeneration() {
    int livingNeighbors = 0;
    for (Cell cell : neighbors) {
      if (cell.isAlive()) {
        livingNeighbors++;
      }
    }

    if (!isAlive && livingNeighbors == 3) {
      return true;
    }
    else if (isAlive && livingNeighbors <= 3) {
      return true;
    }

    return false;
  }
}
