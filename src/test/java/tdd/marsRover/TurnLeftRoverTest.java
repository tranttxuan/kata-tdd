package tdd.marsRover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TurnLeftRoverTest {

    @Test
    void turnLeft_roverShouldFaceNorth_GivenRoverIsFacingEast() {
      Rover rover = new Rover(
          new CoordinateInAnAxis( 0, 4 ),
          new CoordinateInAnAxis( 0, 4 ),
          Direction.EAST );
        rover.turnLeft();
        assertEquals(rover.getDirection(), Direction.NORTH);
    }
    @Test
    void turnLeft_roverShouldFaceEast_GivenRoverIsFacingSouth() {
      Rover rover = new Rover(
          new CoordinateInAnAxis( 0, 4 ),
          new CoordinateInAnAxis( 0, 4 ),
          Direction.SOUTH );
        rover.turnLeft();
        assertEquals(rover.getDirection(), Direction.EAST);
    }
    @Test
    void turnLeft_roverShouldFaceWest_GivenRoverIsFacingNorth() {
      Rover rover = new Rover(
          new CoordinateInAnAxis( 0, 4 ),
          new CoordinateInAnAxis( 0, 4 ),
          Direction.NORTH );
        rover.turnLeft();
        assertEquals(rover.getDirection(), Direction.WEST);
    }

    @Test
    void turnLeft_roverShouldFaceSouth_GivenRoverIasFacingWest() {
      Rover rover = new Rover(
          new CoordinateInAnAxis( 0, 4 ),
          new CoordinateInAnAxis( 0, 4 ),
          Direction.WEST );
        rover.turnLeft();
        assertEquals(rover.getDirection(), Direction.SOUTH);
    }
}
