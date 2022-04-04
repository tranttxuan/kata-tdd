package tdd.marsRover;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveACommand{

  @Test
  void receiveACommandMoveForward_RoverShouldMoveForward_WhenRoverIsFacingEast(){
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST );
    rover.receiveACommand( Command.MOVE_FORWARD );
    assertEquals( rover.getX( ), 1 );
    assertEquals( rover.getY( ), 0 );
    assertEquals( rover.getDirection( ), Direction.EAST );
  }

  @Test
  void receiveACommandMoveBack_RoverShouldMoveBack_WhenRoverIsFacingEast(){
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST );
    rover.receiveACommand( Command.MOVE_BACK );
    assertEquals( rover.getX( ), 4 );
    assertEquals( rover.getY( ), 0 );
    assertEquals( rover.getDirection( ), Direction.EAST );
  }

  @Test
  void receiveACommandTurnLeft_RoverShouldTurnLeft_WhenRoverIsFacingEast(){
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST );
    rover.receiveACommand( Command.TURN_LEFT );
    assertEquals( rover.getX( ), 0 );
    assertEquals( rover.getY( ), 0 );
    assertEquals( rover.getDirection( ), Direction.NORTH );
  }

  @Test
  void receiveACommandTurnRight_RoverShouldTurnRight_WhenRoverIsFacingEast(){
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST );
    rover.receiveACommand( Command.TURN_RIGHT );
    assertEquals( rover.getX( ), 0 );
    assertEquals( rover.getY( ), 0 );
    assertEquals( rover.getDirection( ), Direction.SOUTH );
  }

  @Test
  void receiveAInvalidCommand_RoverShouldNotMove_WhenRoverIsFacingEast(){
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST );
    assertThrows( IllegalStateException.class, () -> rover.receiveACommand( 'I' ), "I is invalid command" );
  }

  @Test
  void receiveACommand_MoveToAPositionWhereThereIsAnObstacle_ButRoverShouldNotMove_WhenRoverIsFacingEast(){
    List<Obstacle> list = new ArrayList<>( );
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 0, 4 ) ) );
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 1, 4 ) ) );
    list.add( new Obstacle( new CoordinateInAnAxis( 2, 4 ), new CoordinateInAnAxis( 2, 4 ) ) );
    Obstacles obstacles = new Obstacles( list );
    Rover rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST,
        obstacles );

   boolean didMovedForward =  rover.receiveACommand( 'F' );
   assertFalse(didMovedForward);
  }
}
