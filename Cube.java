import java.awt.Color;


public class Cube
{

    public final static byte BLUE = 0;

    public final static byte GREEN = 1;

    public final static byte WHITE = 2;

    public final static byte YELLOW = 3;

    public final static byte RED = 4;

    public final static byte ORANGE = 5;

    public static Color[] colors = { Color.BLUE, Color.GREEN, Color.WHITE,
        Color.YELLOW, Color.RED, Color.ORANGE };

    private Side[] sides = new Side[6];

    private Piece[] corners = new Piece[8];

    private Piece[] edges = new Piece[12];

    private Piece[] centers = new Piece[6];


    /**
     * Constructs a solved cube
     */
    public Cube()
    {
        for ( int i = 0; i < 6; i++ )
        {
            sides[i] = new Side( colors[i] );
        }

        corners[0] = new Piece( new Color[] { Color.BLUE, Color.ORANGE,
            Color.YELLOW }, 0 );
        corners[1] = new Piece( new Color[] { Color.BLUE, Color.RED,
            Color.YELLOW }, 0 );
        corners[2] = new Piece( new Color[] { Color.BLUE, Color.ORANGE,
            Color.WHITE }, 0 );
        corners[3] = new Piece( new Color[] { Color.BLUE, Color.RED,
            Color.WHITE }, 0 );
        corners[4] = new Piece( new Color[] { Color.GREEN, Color.ORANGE,
            Color.YELLOW }, 0 );
        corners[5] = new Piece( new Color[] { Color.GREEN, Color.RED,
            Color.YELLOW }, 0 );
        corners[6] = new Piece( new Color[] { Color.GREEN, Color.ORANGE,
            Color.WHITE }, 0 );
        corners[7] = new Piece( new Color[] { Color.GREEN, Color.RED,
            Color.WHITE }, 0 );

        edges[0] = new Piece( new Color[] { Color.BLUE, Color.YELLOW }, 0 );
        edges[1] = new Piece( new Color[] { Color.BLUE, Color.ORANGE }, 0 );
        edges[2] = new Piece( new Color[] { Color.BLUE, Color.RED }, 0 );
        edges[3] = new Piece( new Color[] { Color.BLUE, Color.WHITE }, 0 );
        edges[4] = new Piece( new Color[] { Color.ORANGE, Color.YELLOW }, 0 );
        edges[5] = new Piece( new Color[] { Color.YELLOW, Color.RED }, 0 );
        edges[6] = new Piece( new Color[] { Color.WHITE, Color.ORANGE }, 0 );
        edges[7] = new Piece( new Color[] { Color.WHITE, Color.RED }, 0 );
        edges[8] = new Piece( new Color[] { Color.GREEN, Color.YELLOW }, 0 );
        edges[9] = new Piece( new Color[] { Color.GREEN, Color.ORANGE }, 0 );
        edges[10] = new Piece( new Color[] { Color.GREEN, Color.RED }, 0 );
        edges[11] = new Piece( new Color[] { Color.GREEN, Color.WHITE }, 0 );

        centers[0] = new Piece( new Color[] { Color.BLUE }, 0 );
        centers[1] = new Piece( new Color[] { Color.YELLOW }, 0 );
        centers[2] = new Piece( new Color[] { Color.ORANGE }, 0 );
        centers[3] = new Piece( new Color[] { Color.RED }, 0 );
        centers[4] = new Piece( new Color[] { Color.WHITE }, 0 );
        centers[5] = new Piece( new Color[] { Color.GREEN }, 0 );
    }


    public void upTurn()
    {
        Piece temp = corners[0];
        corners[0] = corners[2];
        corners[2] = corners[3];
        corners[3] = corners[1];
        corners[1] = temp;

        temp = edges[0];
        edges[0] = edges[1];
        edges[1] = edges[3];
        edges[3] = edges[2];
        edges[2] = temp;
    }


    public void upReverseTurn()
    {
        upTurn();
        upTurn();
        upTurn();
    }


    public void upDoubleTurn()
    {
        upTurn();
        upTurn();
    }


    public void downTurn()
    {
        downReverseTurn();
        downReverseTurn();
        downReverseTurn();
    }


    public void downDoubleTurn()
    {
        downReverseTurn();
        downReverseTurn();
    }


    public void downReverseTurn()
    {
        Piece temp = corners[4];
        corners[4] = corners[6];
        corners[6] = corners[7];
        corners[7] = corners[5];
        corners[5] = temp;

        temp = edges[8];
        edges[8] = edges[9];
        edges[9] = edges[11];
        edges[11] = edges[10];
        edges[10] = temp;
    }


    public void rightTurn()
    {
        Piece temp = corners[1];
        corners[1] = corners[3];
        corners[3] = corners[7];
        corners[7] = corners[5];
        corners[5] = temp;

        temp = edges[2];
        edges[2] = edges[7];
        edges[7] = edges[10];
        edges[10] = edges[5];
        edges[5] = temp;

        corners[1].changeOrientation( 2 );
        corners[3].changeOrientation( 1 );
        corners[5].changeOrientation( 1 );
        corners[7].changeOrientation( 2 );
    }


    public void rightReverseTurn()
    {
        rightTurn();
        rightTurn();
        rightTurn();
    }


    public void rightDoubleTurn()
    {
        rightTurn();
        rightTurn();
    }


    public void leftTurn()
    {
        leftReverseTurn();
        leftReverseTurn();
        leftReverseTurn();
    }


    public void leftDoubleTurn()
    {
        leftReverseTurn();
        leftReverseTurn();
    }


    public void leftReverseTurn()
    {
        Piece temp = corners[0];
        corners[0] = corners[2];
        corners[2] = corners[6];
        corners[6] = corners[4];
        corners[4] = temp;

        temp = edges[1];
        edges[1] = edges[6];
        edges[6] = edges[9];
        edges[9] = edges[4];
        edges[4] = temp;

        corners[0].changeOrientation( 1 );
        corners[2].changeOrientation( 2 );
        corners[4].changeOrientation( 2 );
        corners[6].changeOrientation( 1 );
    }


    public void frontTurn()
    {
        Piece temp = corners[2];
        corners[2] = corners[6];
        corners[6] = corners[7];
        corners[7] = corners[3];
        corners[3] = temp;

        temp = edges[3];
        edges[3] = edges[6];
        edges[6] = edges[11];
        edges[11] = edges[7];
        edges[7] = temp;

        corners[2].changeOrientation( 1 );
        corners[3].changeOrientation( 2 );
        corners[6].changeOrientation( 2 );
        corners[7].changeOrientation( 1 );

        edges[3].changeOrientation( 1 );
        edges[6].changeOrientation( 1 );
        edges[7].changeOrientation( 1 );
        edges[11].changeOrientation( 1 );
    }


    public void frontReverseTurn()
    {
        frontTurn();
        frontTurn();
        frontTurn();
    }


    public void frontDoubleTurn()
    {
        frontTurn();
        frontTurn();
    }


    public void backReverseTurn()
    {
        Piece temp = corners[0];
        corners[0] = corners[4];
        corners[4] = corners[5];
        corners[5] = corners[1];
        corners[1] = temp;

        temp = edges[0];
        edges[0] = edges[4];
        edges[4] = edges[8];
        edges[8] = edges[5];
        edges[5] = temp;

        corners[0].changeOrientation( 2 );
        corners[1].changeOrientation( 1 );
        corners[4].changeOrientation( 1 );
        corners[5].changeOrientation( 2 );

        edges[0].changeOrientation( 1 );
        edges[4].changeOrientation( 1 );
        edges[5].changeOrientation( 1 );
        edges[8].changeOrientation( 1 );
    }


    public void backTurn()
    {
        backReverseTurn();
        backReverseTurn();
        backReverseTurn();
    }


    public void backDoubleTurn()
    {
        backReverseTurn();
        backReverseTurn();
    }


    public void middleTurn()
    {
        Piece temp = edges[4];
        edges[4] = edges[6];
        edges[6] = edges[7];
        edges[7] = edges[5];
        edges[5] = temp;

        temp = centers[1];
        centers[1] = centers[2];
        centers[2] = centers[4];
        centers[4] = centers[3];
        centers[3] = temp;

        edges[4].changeOrientationIfBottomEdge();
        edges[5].changeOrientationIfBottomEdge();
        edges[6].changeOrientationIfBottomEdge();
        edges[7].changeOrientationIfBottomEdge();

        edges[0].changeOrientationIfNotBottomEdge();
        edges[1].changeOrientationIfNotBottomEdge();
        edges[2].changeOrientationIfNotBottomEdge();
        edges[3].changeOrientationIfNotBottomEdge();
        
        edges[8].changeOrientationIfNotBottomEdge();
        edges[9].changeOrientationIfNotBottomEdge();
        edges[10].changeOrientationIfNotBottomEdge();
        edges[11].changeOrientationIfNotBottomEdge();
    }


    public void middleDoubleTurn()
    {
        middleTurn();
        middleTurn();
    }


    public void middleReverseTurn()
    {
        middleTurn();
        middleTurn();
        middleTurn();
    }


    public void cubeTurn()
    {
        upTurn();
        downReverseTurn();
        middleTurn();
    }


    public void cubeDoubleTurn()
    {
        cubeTurn();
        cubeTurn();
    }


    public void cubeReverseTurn()
    {
        cubeTurn();
        cubeTurn();
        cubeTurn();
    }


    public int[] getLocOriEdge( Piece p )
    {
        for ( int i = 0; i < edges.length; i++ )
        {
            if ( p.isSamePiece( edges[i] ) )
            {
                return new int[] { i, edges[i].getOrientation() }; // index,
                                                                   // orientation
            }
        }
        return new int[] {};
    }


    public int[] getLocOriEdge( Color[] p )
    {
        for ( int i = 0; i < edges.length; i++ )
        {
            if ( new Piece( p, 0 ).isSamePiece( edges[i] ) )
            {
                return new int[] { i, edges[i].getOrientation() };
            }
        }
        return new int[] {};
    }


    public int[] getLocOriCorner( Piece p )
    {
        for ( int i = 0; i < corners.length; i++ )
        {
            if ( p.isSamePiece( corners[i] ) )
            {
                return new int[] { i, corners[i].getOrientation() };
            }
        }
        return new int[] {};
    }


    public Piece getEdge( int index )
    {
        return edges[index];
    }


    public Piece getCorner( int index )
    {
        return corners[index];
    }


    public Piece getCenter( int index )
    {
        return centers[index];
    }


    public String toString()
    {
        String str = "";
        int c = 0;
        for ( Piece i : corners )
        {
            str += "Corner " + c++ + ": " + i;
        }
        c = 0;
        str += "\n\n";

        for ( Piece i : edges )
        {
            str += "Edge " + c++ + ": " + i;
        }

        c = 0;
        str += "\n\n";
        for ( Piece i : centers )
        {
            str += "Center " + c++ + ": " + i;
        }

        return str;
    }
}
