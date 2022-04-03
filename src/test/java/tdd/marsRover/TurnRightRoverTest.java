package tdd.marsRover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TurnRightRoverTest {

  @Test
  void turnRight_roverShouldFaceSouth_GivenRoverIsFacingEast() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST);
    rover.turnRight();
    assertEquals(rover.getDirection(), Direction.SOUTH);
  }
  @Test
  void turnRight_roverShouldFaceWest_GivenRoverIsFacingSouth() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.SOUTH);
    rover.turnRight();
    assertEquals(rover.getDirection(), Direction.WEST);
  }
  @Test
  void turnRight_roverShouldFaceEast_GivenRoverIsFacingNorth() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.NORTH);
    rover.turnRight();
    assertEquals(rover.getDirection(), Direction.EAST);
  }

  @Test
  void turnRight_roverShouldFaceNorth_GivenRoverIasFacingWest() {
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.WEST);
    rover.turnRight();
    assertEquals(rover.getDirection(), Direction.NORTH);
  }
}
