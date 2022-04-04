package tdd.marsRover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiveCommands{
  private Rover rover;

  @BeforeEach
  void setUp(){
    rover = new Rover(
        new CoordinateInAnAxis( 0, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST );
  }

  @Test
  void commandsIsEmpty_roverShouldNotMove(){
    String commands = "";
    rover.receiveCommands( commands );
    System.out.printf( rover.toString( ) );
    assertEquals( "0x0E", rover.getPosition( ) );
  }

  @Test
  void commandsContainsACommandMoveForward_F_roverShouldMoveForward(){
    String commands = "F";
    rover.receiveCommands( commands );
    assertEquals( "1x0E", rover.getPosition( ) );
  }

  @Test
  void commandsContainsACommandMoveForward_f_roverShouldMoveForward(){
    String commands = "f";
    rover.receiveCommands( commands );
    assertEquals( "1x0E", rover.getPosition( ) );
  }

  @Test
  void commandsContainsAInvalidCommand_A_roverShouldNotMoveForward(){
    String commands = "A";
    assertEquals( "0x0E", rover.getPosition( ) );
  }

  @Test
  void commands_FLBR_roverShouldMoveForward(){
    String commands = "FLBR";
    rover.receiveCommands( commands );
    assertEquals( "1x4E", rover.getPosition( ) );
  }

  @Test
  void commandsContainsInvalidCommands_FlbaR_roverShouldMoveForward(){
    String commands = "Flcr";
    rover.receiveCommands( commands );
    assertEquals( "1x0N", rover.getPosition( ) );
  }

  @Test
  void commands_FLFFFB_leadCollisionWithObstacles_roverShouldNotMove(){
    String commands = "FLFFFB";
    List<Obstacle> list = new ArrayList<Obstacle>( );
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 3, 4 ) ) );
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 1, 4 ) ) );
    list.add( new Obstacle( new CoordinateInAnAxis( 2, 4 ), new CoordinateInAnAxis( 1, 4 ) ) );
    Obstacles obstacles = new Obstacles( list );
    Rover rover1 = new Rover(
        new CoordinateInAnAxis( 1, 4 ),
        new CoordinateInAnAxis( 0, 4 ),
        Direction.EAST,
        obstacles );

    rover1.receiveCommands( commands );
    assertEquals( "1x0N", rover1.getPosition( ) );
    assertEquals( "Rover{position= 1 - 0, direction= NORTH Found Obstacle}" , rover1.toString());
  }
}
