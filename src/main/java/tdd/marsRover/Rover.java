
package tdd.marsRover;

//kata: https://kata-log.rocks/mars-rover-kata

public class Rover{
  private Direction direction;
  private CoordinateInAnAxis x;
  private CoordinateInAnAxis y;


  public Rover( CoordinateInAnAxis x, CoordinateInAnAxis y, Direction direction ){
    this.direction = direction;
    this.x = x;
    this.y = y;
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

  public int getX(){
    return x.getCoordinate( );
  }

  public int getY(){
    return y.getCoordinate( );
  }

  public String getPosition(){
    return getX()  +"x"+ getY() + getDirection().getShortName();
  }

  @Override
  public String toString(){
    return "Rover{" +
        "position= " + getX( ) + " - " + getY( ) +
        ", direction= " + getDirection( ) +
        '}';
  }

  public void move( Direction direction ){
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
    setX( xCoordinate );
    setY( yCoordinate );
  }

  public void moveForward(){
    move( direction );
  }

  public void moveBack(){
    move( direction.getBackwardDirection( ) );
  }

  public void turnLeft(){
    Direction newDirection = direction.changeDirection( -1 );
    setDirection( newDirection );
  }

  public void turnRight(){
    Direction newDirection = direction.changeDirection( 1 );
    setDirection( newDirection );
  }

  public void receiveACommand( char command ){
    switch(command){
      case Command.MOVE_FORWARD:{
        moveForward( );
        return;
      }
      case Command.MOVE_BACK:{
        moveBack( );
        return;
      }
      case Command.TURN_LEFT:{
        turnLeft( );
        return;
      }
      case Command.TURN_RIGHT:{
        turnRight( );
        return;
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
        receiveACommand( Character.toUpperCase( command ) );
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}

