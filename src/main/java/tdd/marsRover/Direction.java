package tdd.marsRover;

public enum Direction {
    //Value of a direction is defined according to clockwise
    NORTH(0, "N"),
    EAST(1, "E"),
    SOUTH(2, "S"),
    WEST(3, "W");

    private int value;
    private String shortName;

    private Direction ( int value, String shortName ) {
        this.value = value;
        this.shortName = shortName;
    }

    public int getValue () {
        return value;
    }

    public String getShortName () {
        return shortName;
    }

    public void setValue( int value ){
        this.value = value;
    }

    public void setShortName( String shortName ){
        this.shortName = shortName;
    }

    // When current direction is North
    // if directionStep is 1, direction changes from North to East like action turn right
    // if directionStep is -1, direction changes from North to West like action turn left
    // if directionStep is 2 or -2, direction changes from North to South like action turn about
    public Direction changeDirection( int directionStep ){
        if(directionStep > 0){
            return values ()[(getValue() + directionStep) % 4];
        }else{
            return values( )[(4 + directionStep + getValue()) % 4];
        }
    }

    public Direction getBackwardDirection(){
       return changeDirection( 2 );
    }
}
