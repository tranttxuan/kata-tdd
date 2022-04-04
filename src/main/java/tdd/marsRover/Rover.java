
package tdd.marsRover;

//kata: https://kata-log.rocks/mars-rover-kata

public class Rover{
  private Direction direction;
  private CoordinateInAnAxis x;
  private CoordinateInAnAxis y;
  private final Obstacles obstacles;
private boolean foundObstacle = false;
  public Rover( CoordinateInAnAxis x, CoordinateInAnAxis y, Direction direction ){
    this.direction = direction;
    this.x = x;
    this.y = y;
    this.obstacles = new Obstacles( );
  }

  public Rover( CoordinateInAnAxis x, CoordinateInAnAxis y, Direction direction, Obstacles obstacles ){
    this.direction = direction;
    this.x = x;
    this.y = y;
    this.obstacles = obstacles;
  }

  public void setDirection( Direction direction ){
    this.direction = direction;
  }

  public void setX( int x ){
    this.x.setCoordinate( x );
  }

  public void setY( int y ){
    this.y.setCoordinate( y );
  }

  public Direction getDirection(){
    return direction;
  }

  public CoordinateInAnAxis getXCoordinateInAnAxis(){
    return x;
  }
  public int getX(){
    return x.getCoordinate( );
  }

  public int getY(){
    return y.getCoordinate( );
  }

  public String getPosition(){
    return getX( ) + "x" + getY( ) + getDirection( ).getShortName( );
  }

  @Override
  public String toString(){
    String status = "";
    if (foundObstacle) {
      status = " Found Obstacle";
    }
    return "Rover{" +
        "position= " + getX( ) + " - " + getY( ) +
        ", direction= " + getDirection( ) + status +
        '}';
  }

  public boolean move( Direction direction ){
    int xCoordinate = getX( );
    int yCoordinate = getY( );
    switch(direction){
      case NORTH:{
        yCoordinate = y.getForwardCoordinateInAnAxis( );
        break;
      }
      case SOUTH:{
        yCoordinate = y.getBackCoordinateInAnAxis( );
        break;
      }
      case EAST:{
        xCoordinate = y.getForwardCoordinateInAnAxis( );
        break;
      }
      case WEST:{
        xCoordinate = x.getBackCoordinateInAnAxis( );
        break;
      }
    }
    if(!hasObstacle( xCoordinate, yCoordinate )){
      setX( xCoordinate );
      setY( yCoordinate );
      foundObstacle = false;
      return true;
    }else{
      foundObstacle = true;
      return false;
    }
  }

  public boolean moveForward(){
    return move( direction );
  }

  public boolean moveBack(){
  return move( direction.getBackwardDirection( ) );
  }

  public boolean turnLeft(){
    Direction newDirection = direction.changeDirection( -1 );
    setDirection( newDirection );
    return true;
  }

  public boolean turnRight(){
    Direction newDirection = direction.changeDirection( 1 );
    setDirection( newDirection );
    return true;
  }

  public boolean receiveACommand( char command ){
    switch(command){
      case Command.MOVE_FORWARD:{
        return moveForward( );
      }
      case Command.MOVE_BACK:{
        return moveBack( );
      }
      case Command.TURN_LEFT:{
        return turnLeft( );
      }
      case Command.TURN_RIGHT:{
        return turnRight( );
      }
      default:{
        throw new IllegalStateException( command + " is invalid command" );
      }
    }
  }

  public void receiveCommands( String commands ){
    if(commands.isEmpty( )){
      return;
    }
    for(char command : commands.toCharArray( )){
    try{
        if(!receiveACommand( Character.toUpperCase( command ) )){
          foundObstacle = true;
          throw new IllegalStateException( "Rover will be collision with an obstacle if " + command );
        }
    }catch(Exception e){
        e.printStackTrace( );
        break;
      }
    }
  }

  public boolean hasObstacle( int x, int y ){
    return obstacles.hasObstacle( x, y );
  }
}

