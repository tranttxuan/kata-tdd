package tdd.marsRover;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class hasObstacleTest{
  private Obstacles obstacles;
  private Rover rover;

  @BeforeEach
  void setUp(){
    List<Obstacle> list = new ArrayList<>( );
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 0, 4 ) ) );
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 1, 4 ) ) );
    list.add( new Obstacle( new CoordinateInAnAxis( 2, 4 ), new CoordinateInAnAxis( 2, 4 ) ) );
    obstacles = new Obstacles( list );
    rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST,
        obstacles );
  }

  @Test
  void testRoverWillCollideWithObstacles_IfRoverMoveForward_WhenItIsFacingWest(){
    boolean isCollision = rover.hasObstacle( rover.getXCoordinateInAnAxis().getForwardCoordinateInAnAxis(), rover.getY() );
    assertTrue( isCollision );
  }

  @Test
  void moveForward_RoverWillCollideWithAnObstacle_SoRoverShouldNotMove_WhenItIsFacingWest(){
    boolean didMovedBack = rover.moveForward();
    assertEquals( rover.getX( ), 0 );
    assertEquals( rover.getY( ), 0 );
    assertEquals( rover.getDirection( ), Direction.EAST );
    assertFalse(didMovedBack);
  }
  @Test
  void moveBack_SoRoverShouldNotMove_WhenItIsFacingWest(){
    boolean didMovedBack = rover.moveBack();
    assertEquals( rover.getX( ), 4 );
    assertEquals( rover.getY( ), 0 );
    assertEquals( rover.getDirection( ), Direction.EAST );
    assertTrue(didMovedBack);
  }
}
