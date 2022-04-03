package tdd.marsRover;

public class Obstacle{
    private CoordinateInAnAxis x;
    private CoordinateInAnAxis y;

    public Obstacle( CoordinateInAnAxis x, CoordinateInAnAxis y) {
        this.x = x;
        this.y = y;
    }

    public CoordinateInAnAxis getX () {
        return x;
    }

    public void setX ( CoordinateInAnAxis x ) {
        this.x = x;
    }

    public CoordinateInAnAxis getY () {
        return y;
    }

    public void setY ( CoordinateInAnAxis y ) {
        this.y = y;
    }
    
}
