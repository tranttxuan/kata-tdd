package tdd.marsRover;

public class Obstacle{
  private CoordinateInAnAxis x;
  private CoordinateInAnAxis y;

  public Obstacle( CoordinateInAnAxis x, CoordinateInAnAxis y ){
    this.x = x;
    this.y = y;
  }

  public int getX(){
    return x.getCoordinate();
  }

  public void setX( CoordinateInAnAxis x ){
    this.x = x;
  }

  public int getY(){
    return y.getCoordinate();
  }

  public void setY( CoordinateInAnAxis y ){
    this.y = y;
  }
}
