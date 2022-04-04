package tdd.marsRover;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObstaclesTest{

  @Test
  void createAListOfRandomObstacles(){
    Obstacles obstacles = new Obstacles( 4, 4, 2 );
    assertEquals( obstacles.size( ), 2 );
  }

  @Test
  void createAListOfObstacles(){
    List<Obstacle> list = new ArrayList<Obstacle>( );
    list.add( new Obstacle( new CoordinateInAnAxis( 0, 4 ), new CoordinateInAnAxis( 0, 4 ) ));
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 1, 4 ) ));
    Obstacles obstacles = new Obstacles( list );
    assertEquals( obstacles.size( ), 2 );
  }
  @Test
  void createAListOfDifferentObstacles(){
    List<Obstacle> list = new ArrayList<Obstacle>( );
    list.add( new Obstacle( new CoordinateInAnAxis( 0, 4 ), new CoordinateInAnAxis( 0, 4 ) ));
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 1, 4 ) ));
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 1, 4 ) ));
    list.add( new Obstacle( new CoordinateInAnAxis( 1, 4 ), new CoordinateInAnAxis( 1, 4 ) ));
    Obstacles obstacles = new Obstacles( list );
    assertEquals( obstacles.size( ), 2 );
  }
}