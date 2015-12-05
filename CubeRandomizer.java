public class CubeRandomizer
{
    private Cube cube;

    private final static int UP = 0;

    private final static int DOWN = 1;

    private final static int RIGHT = 2;

    private final static int LEFT = 3;

    private final static int FRONT = 4;

    private final static int BACK = 5;


    public CubeRandomizer( Cube c )
    {
        cube = c;
    }


    public void randomize( int steps )
    {
        for ( int i = 0; i < steps; i++ )
        {
            int id = (int)( Math.random() * 6 );
            int times = (int)( Math.random() * 3 ) + 1;
            for(int j=0;j<times;j++){
                step(id);
            }
            System.out.println();
        }
        System.out.print( "\n\n" );
    }


    public void step( int id )
    {
        switch ( id )
        {
            case UP:
                System.out.print( "U " );
                cube.upTurn();
                break;
            case DOWN:
                System.out.print( "D' " );
                cube.downReverseTurn();
                break;
            case RIGHT:
                System.out.print( "R " );
                cube.rightTurn();
                break;
            case LEFT:
                System.out.print( "L' " );
                cube.leftReverseTurn();
                break;
            case FRONT:
                System.out.print( "F " );
                cube.frontTurn();
                break;
            case BACK:
                System.out.print( "B' " );
                cube.backReverseTurn();
                break;
        }
    }
}
