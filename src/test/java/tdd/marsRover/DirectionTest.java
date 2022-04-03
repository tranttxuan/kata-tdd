package tdd.marsRover;

import jdk.jfr.Description;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest{

  @Before
  @Description("When current direction is North"  )
  public void init() {
  }

  @Test
  @Description("if directionStep is 1, direction changes from North to East like action turn right"  )
  void changeDirection_shouldReturnEast_WhenWeWannaTurnRight_GivenCurrentDirectionIsNorth(){
    Direction currentDirection = Direction.NORTH;
    Direction newDirection = currentDirection.changeDirection(1);
    assertEquals( Direction.EAST, newDirection );

    Direction currentDirection2 = Direction.NORTH;
    Direction newDirection2 = currentDirection2.changeDirection(-3);
    assertEquals( Direction.EAST, newDirection2 );
  }
  @Test
  @Description( "if directionStep is -1 or 3, direction changes from North to West like action turn left" )
  void changeDirection_shouldReturnEast_WhenWeWannaTurnLeft_GivenCurrentDirectionIsNorth(){
    Direction currentDirection = Direction.NORTH;
    Direction newDirection = currentDirection.changeDirection(-1);
    assertEquals( Direction.WEST, newDirection );

    Direction currentDirection2 = Direction.NORTH;
    Direction newDirection2 = currentDirection2.changeDirection(3);
    assertEquals( Direction.WEST, newDirection2);
  }
  @Test
  @Description( "if directionStep is 2 or -2, direction changes from North to South like action turn about" )
  void changeDirection_shouldReturnEast_WhenWeWannaTurnAbout_GivenCurrentDirectionIsNorth(){
    Direction currentDirection = Direction.NORTH;
    Direction newDirection = currentDirection.changeDirection(-2);
    assertEquals( Direction.SOUTH, newDirection );

    Direction currentDirection2 = Direction.NORTH;
    Direction newDirection2 = currentDirection2.changeDirection(2);
    assertEquals( Direction.SOUTH, newDirection2 );
  }

}