package jdienst.basic;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class Cell_Test {

  @Test
  public void shouldBeDeadAfterConstruction() {
    Cell cell = new Cell();
    assertFalse("Cell is alive. But it should not be alive after construction", cell.isAlive());
  }
}
