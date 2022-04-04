package tdd.marsRover;

public class CoordinateInAnAxis{
  private int coordinate;
  private final int maxCoordinate;

  public CoordinateInAnAxis( int coordinate, int maxCoordinate ){
    this.coordinate = coordinate > maxCoordinate ? maxCoordinate : coordinate;
    this.maxCoordinate = maxCoordinate;
  }

  public int getCoordinate(){
    return coordinate;
  }

  public void setCoordinate( int coordinate ){
    this.coordinate = coordinate;
  }

  public int getMaxCoordinate(){
    return maxCoordinate;
  }

  public int getForwardCoordinateInAnAxis(){
    return (int) (getCoordinate( ) + 1) % getMaxCoordinate( );
  }

  public int getBackCoordinateInAnAxis(){
    return getCoordinate () > 0 ? (int) (getCoordinate( ) - 1) % getMaxCoordinate( ) : getMaxCoordinate( );
  }

}
