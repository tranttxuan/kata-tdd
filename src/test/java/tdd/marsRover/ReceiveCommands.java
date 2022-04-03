package tdd.marsRover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
  void commandsContainsInvalidCommands_FlbaR_roverShouldMoveForward() throws Exception{
    String commands = "FlcbaR";
    rover.receiveCommands( commands );
    assertEquals( "1x4E", rover.getPosition( ) );
  }
}
