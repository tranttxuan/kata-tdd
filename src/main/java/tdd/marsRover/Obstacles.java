package tdd.marsRover;

import java.util.ArrayList;
import java.util.List;

public class Obstacles{
  public final List<Obstacle> obstacles = new ArrayList<>( );

  public Obstacles( int maxXAxis, int maxYAxis, int numberObstacles ){
    if(numberObstacles > 0){
      createAnObstacle( maxXAxis, maxYAxis, numberObstacles );
    }
  }

  public Obstacles( int maxXAxis, int maxYAxis ){
    int numberObstacles = (int) Math.random( );
    createAnObstacle( maxXAxis, maxYAxis, numberObstacles );
  }

  public Obstacles( List<Obstacle> list ){
    list.forEach( obstacle -> {
      if(!hasObstacle( obstacle.getX( ), obstacle.getY( ) )) obstacles.add( obstacle );
    } );
  }

  public Obstacles(){
  }

  private void createAnObstacle( int maxXAxis, int maxYAxis, int numberObstacles ){
    for(int i = 0; i < numberObstacles; i++){
      int xCoordinate = (int) Math.floor( Math.random( ) * (maxXAxis + 1) );
      int yCoordinate = (int) Math.floor( Math.random( ) * (maxYAxis + 1) );
      CoordinateInAnAxis x = new CoordinateInAnAxis( xCoordinate, maxXAxis );
      CoordinateInAnAxis y = new CoordinateInAnAxis( yCoordinate, maxYAxis );
      Obstacle newObstacle = new Obstacle( x, y );
      if(!hasObstacle( xCoordinate, yCoordinate )) obstacles.add( newObstacle );
    }
  }

  public boolean hasObstacle( int xCoordinateObstacle, int yCoordinateObstacle ){
    return obstacles.stream( ).anyMatch( o -> o.getX( ) == xCoordinateObstacle && o.getY( ) == yCoordinateObstacle );
  }

  public int size(){
    return obstacles.size( );
  }

  public List<Obstacle> getObstacles(){
    return obstacles;
  }

}