package tdd.marsRover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateInADimensionTest{

  @Test
  void createCoordinateObject_shouldHaveCoordinateParameterEqualOrLessThanMaxCoordinateParameter(){
    CoordinateInAnAxis x = new CoordinateInAnAxis( 0, 4 );
    assertEquals( 0, x.getCoordinate() );

    CoordinateInAnAxis y = new CoordinateInAnAxis( 5, 4 );
    assertEquals( 4, y.getCoordinate() );
  }

  @Test
  void getForwardCoordinateInAnAxis_shouldReturnNewCoordinate1_whenCurrentCoordinateIsInRoot(){
    CoordinateInAnAxis x = new CoordinateInAnAxis( 0, 4 );
    int newX = x.getForwardCoordinateInAnAxis();
    assertEquals( 1, newX );
  }
  @Test
  void getForwardCoordinateInAnAxis_shouldReturnNewCoordinateInRoot_whenCurrentCoordinateIsInBorder(){
    CoordinateInAnAxis x = new CoordinateInAnAxis( 4, 4 );
    int newX = x.getForwardCoordinateInAnAxis();
    assertEquals( 1, newX );
  }
  @Test
  void getForwardCoordinateInAnAxis_shouldReturnNewCoordinate3_whenCurrentCoordinateIsInCenter(){
    CoordinateInAnAxis x = new CoordinateInAnAxis( 2, 4 );
    int newX = x.getForwardCoordinateInAnAxis();
    assertEquals( 3, newX );
  }

  @Test
  void getBackCoordinateInAnAxis_shouldReturnNewCoordinateInBorder_whenCurrentCoordinateIsInRoot(){
    CoordinateInAnAxis x = new CoordinateInAnAxis( 0, 4 );
    int newX = x.getBackCoordinateInAnAxis();
    assertEquals( 4, newX );
  }
  @Test
  void getBackCoordinateInAnAxis_shouldReturnNewCoordinate3_whenCurrentCoordinateIsInBorder(){
    CoordinateInAnAxis x = new CoordinateInAnAxis( 4, 4 );
    int newX = x.getBackCoordinateInAnAxis();
    assertEquals( 3, newX );
  }
  @Test
  void getBackCoordinateInAnAxis_shouldReturnNewCoordinate_whenCurrentCoordinateIsInCenter(){
    CoordinateInAnAxis x = new CoordinateInAnAxis( 2, 4 );
    int newX = x.getBackCoordinateInAnAxis();
    assertEquals( 1, newX );
  }

}