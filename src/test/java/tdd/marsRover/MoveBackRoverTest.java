package tdd.marsRover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveBackRoverTest {

  @Test
  void moveBack_roverShouldHaveNewCoordinateInXAxis_whenRoverIsInRootAndFacingEast() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST);
    rover.moveBack();
    assertEquals(rover.getX(), 4);
    assertEquals(rover.getY(), 0);
  }
  @Test
  void moveBack_roverShouldHaveNewCoordinateInYAxis_whenRoverIsInRootAndFacingSouth() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.SOUTH);
    rover.moveBack();
    assertEquals(rover.getX(), 0);
    assertEquals(rover.getY(), 1);
  }
  @Test
  void moveBack_roverShouldHaveNewCoordinateInYAxis_whenRoverIsInRootAndFacingNorth() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.NORTH);
    rover.moveBack();
    assertEquals(rover.getX(), 0);
    assertEquals(rover.getY(), 4);
  }

  @Test
  void moveBack_roverShouldHaveNewCoordinateInXAxis_whenRoverIsInRootAndFacingWest() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.WEST);
    rover.moveBack();
    assertEquals(rover.getX(), 1);
    assertEquals(rover.getY(), 0);
  }

  @Test
  void moveBack_roverShouldHaveNewCoordinateInXAxis_whenRoverIsInCenterAndFacingEast() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 2, 4 ),
        new CoordinateInAnAxis( 2, 4 ),
        Direction.EAST);
    rover.moveBack();
    assertEquals(rover.getX(), 1);
    assertEquals(rover.getY(), 2);
  }
  @Test
  void moveBack_roverShouldHaveNewCoordinateInYAxis_whenRoverIsInCenterAndFacingSouth() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 2, 4 ),
        new CoordinateInAnAxis( 2, 4 ),
        Direction.SOUTH);
    rover.moveBack();
    assertEquals(rover.getX(), 2);
    assertEquals(rover.getY(), 3);
  }
  @Test
  void moveBack_roverShouldHaveNewCoordinateInYAxis_whenRoverIsInCenterAndFacingNorth() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 2, 4 ),
        new CoordinateInAnAxis( 2, 4 ),
        Direction.NORTH);
    rover.moveBack();
    assertEquals(rover.getX(), 2);
    assertEquals(rover.getY(), 1);
  }

  @Test
  void moveBack_roverShouldHaveNewCoordinateInXAxis_whenRoverIsInCenterAndFacingWest() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 2, 4 ),
        new CoordinateInAnAxis( 2, 4 ),
        Direction.WEST);
    rover.moveBack();
    assertEquals(rover.getX(), 3);
    assertEquals(rover.getY(), 2);
  }
}