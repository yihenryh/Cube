import java.awt.Color;
import java.util.ArrayList;


public class CubeSolver
{
    private Cube cube;

    private boolean flip = false;


    public CubeSolver( Cube c )
    {
        cube = c;
    }


    public void solve()
    {
        cross();
        System.out.println();
        System.out.println();
        corners();
        System.out.println();
        System.out.println();
        secondLayer();
        System.out.println();
        System.out.println();
        topCross();
        System.out.println();
        System.out.println();
        permuteCross();
        System.out.println();
        System.out.println();
        System.out.println( "Now permuting corners" );
        permuteCorners();
        System.out.println();
        System.out.println();
        System.out.println( "Now orienting corners" );
        orientCorners();
        System.out.println();
        System.out.println();
    }


    public void cross()
    {
        System.out.println( "Now solving cross" );
        for ( int i = 0; i < 4; i++ )
        {
            crossStep();
            algHandler( "x" );
        }
    }


    private void crossStep()
    {
        int[] p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
            cube.getCenter( 5 ) ) );

        if ( p[0] == 5 || p[0] == 7 || p[0] == 10 )
        {
            int c = 0;
            while ( p[0] != 2 )
            {
                System.out.print( "r " );
                cube.rightTurn();
                c++;
                p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
                    cube.getCenter( 5 ) ) );
            }
            System.out.print( "u " );
            cube.upTurn();
            for ( int i = 0; i < c; i++ )
            {
                System.out.print( "r' " );
                cube.rightReverseTurn();
            }
        }
        else if ( p[0] == 4 || p[0] == 6 || p[0] == 9 )
        {
            int c = 0;
            while ( p[0] != 1 )
            {
                System.out.print( "l " );
                cube.leftTurn();
                c++;
                p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
                    cube.getCenter( 5 ) ) );
            }
            System.out.print( "u " );
            cube.upTurn();
            for ( int i = 0; i < c; i++ )
            {
                System.out.print( "l' " );
                cube.leftReverseTurn();
            }
        }
        else if ( p[0] == 8 )
        {
            System.out.print( "b2 u b2 " );
            cube.backDoubleTurn();
            cube.upTurn();
            cube.backDoubleTurn();
        }

        p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
            cube.getCenter( 5 ) ) );

        while ( p[0] != 3 && p[0] != 11 )
        {
            System.out.print( "u " );
            cube.upTurn();
            p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
                cube.getCenter( 5 ) ) );
        }

        if ( p[0] == 3 && p[1] == 0 )
        {
            algHandler( "f f " );
        }
        else if ( p[0] == 3 && p[1] == 1 )
        {
            algHandler( "f r u r' f2" );
        }
        else if ( p[0] == 11 && p[1] == 1 )
        {
            algHandler( "f' r u r' f2" );
        }

        System.out.println();
    }


    private Piece buildEdge( Piece c1, Piece c2 )
    {
        return new Piece( new Color[] { c1.getColor(), c2.getColor() }, 0 );
    }


    public void corners()
    {
        System.out.println( "Now solving corners" );
        for ( int i = 0; i < 4; i++ )
        {
            cornersStep();
            algHandler( "x" );
        }
    }


    public void cornersStep()
    {
        int[] p = cube.getLocOriCorner( buildCorner( cube.getCenter( 4 ),
            cube.getCenter( 5 ),
            cube.getCenter( 3 ) ) );
        if ( p[0] == 7 )
        {
            while ( p[1] != 0 )
            {
                algHandler( "r u r' u' r u r' u'" );
                p[1] = cube.getCorner( 7 ).getOrientation();
            }
            System.out.println();
            return;
        }
        else if ( p[0] == 4 )
        {
            algHandler( "l u l'" );
        }
        else if ( p[0] == 6 )
        {
            algHandler( "l' u' l" );
        }
        else if ( p[0] == 5 )
        {
            algHandler( "r' u r" );
        }

        p = cube.getLocOriCorner( buildCorner( cube.getCenter( 4 ),
            cube.getCenter( 5 ),
            cube.getCenter( 3 ) ) );

        while ( p[0] != 3 )
        {
            algHandler( "u " );
            p = cube.getLocOriCorner( buildCorner( cube.getCenter( 4 ),
                cube.getCenter( 5 ),
                cube.getCenter( 3 ) ) );
        }

        if ( p[1] == 0 )
        {
            algHandler( "r u2 r' u' r u r'" );
        }
        else if ( p[1] == 1 )
        {
            algHandler( "f' u' f" );
        }
        else if ( p[1] == 2 )
        {
            algHandler( "r u r'" );
        }
        System.out.println();
    }


    private Piece buildCorner( Piece c1, Piece c2, Piece c3 )
    {
        return new Piece( new Color[] { c1.getColor(), c2.getColor(),
            c3.getColor() }, 0 );
    }


    public void secondLayer()
    {
        System.out.println( "Now solving second layer" );
        for ( int i = 0; i < 4; i++ )
        {
            secondLayerStep();
            algHandler( "x" );
        }
    }


    public void secondLayerStep()
    {
        int[] p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
            cube.getCenter( 3 ) ) );
       /* if ( flip )
        {
            if ( p[1] == 0 )
            {
                p[1] = 1;
            }
            else
            {
                p[1] = 0;
            }
        }*/

        if ( p[0] == 5 )
        {
            algHandler( "x u r u' r' u' f' u f x'" );
        }
        else if ( p[0] == 4 )
        {
            algHandler( "x2 u r u' r' u' f' u f x2" );
        }
        else if ( p[0] == 6 )
        {
            algHandler( "x' u r u' r' u' f' u f x" );
        }
        else if ( p[0] == 7 && p[1] == 0 )
        {
            return;
        }
        else if ( p[0] == 7 && p[1] == 1 )
        {
            algHandler( "u r u' r' u' f' u f" );
        }
        p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
            cube.getCenter( 3 ) ) );

        /*if ( flip )
        {
            if ( p[1] == 0 )
            {
                p[1] = 1;
            }
            else
            {
                p[1] = 0;
            }
        }*/

        if ( p[1] == 0 )
        {
            while ( p[0] != 0 )
            {
                algHandler( "u" );
                p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
                    cube.getCenter( 3 ) ) );
            }

            algHandler( "f' u f u r u' r'" );
        }
        else if ( p[1] == 1 )
        {
            while ( p[0] != 1 )
            {
                algHandler( "u" );
                p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
                    cube.getCenter( 3 ) ) );
            }

            algHandler( "r u' r' u' f' u f" );
        }
        System.out.println();
        flip = !flip;
    }


    public void topCross()
    {
        System.out.println( "Now solving top cross" );
        ArrayList<Integer> edges = getOrientedEdges();

        if ( edges.size() == 4 )
        {
            return;
        }
        else if ( edges.isEmpty() )
        {
            algHandler( "f r u r' u' f' u2 f u r u' r' f'" );
        }
        else if ( edges.contains( 0 ) && edges.contains( 3 ) )
        {
            algHandler( "u f r u r' u' f'" );
        }
        else if ( edges.contains( 1 ) && edges.contains( 2 ) )
        {
            algHandler( "f r u r' u' f'" );
        }
        else
        {
            while ( !edges.contains( 0 ) || !edges.contains( 1 ) )
            {
                algHandler( "u" );
                edges = getOrientedEdges();
            }
            algHandler( "f u r u' r' f'" );
        }
    }


    private ArrayList<Integer> getOrientedEdges()
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for ( int i = 0; i < 4; i++ )
        {
            if ( cube.getEdge( i ).getOrientation() == 0 )
            {
                nums.add( i );
            }
        }
        return nums;
    }


    public void permuteCross()
    {
        System.out.println( "Now permuting cross" );
        int[] p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
            cube.getCenter( 0 ) ) );
        while ( p[0] != 3 )
        {
            algHandler( "u" );
            p = cube.getLocOriEdge( buildEdge( cube.getCenter( 4 ),
                cube.getCenter( 0 ) ) );
        }
        if ( cube.getLocOriEdge( buildEdge( cube.getCenter( 2 ),
            cube.getCenter( 0 ) ) )[0] == 1 )
        {
            algHandler( "u2 r u r' u r u2 r' u'" );
        }
        else if ( cube.getLocOriEdge( buildEdge( cube.getCenter( 1 ),
            cube.getCenter( 0 ) ) )[0] == 0 )
        {
            algHandler( "r u r' u' r' f r2 u' r' u' r u r' f'" );
        }
        else if ( cube.getLocOriEdge( buildEdge( cube.getCenter( 3 ),
            cube.getCenter( 0 ) ) )[0] == 2 )
        {
            algHandler( "u' r u r' u r u2 r' u2" );
        }
        else
        {
            while ( cube.getLocOriEdge( buildEdge( cube.getCenter( 3 ),
                cube.getCenter( 0 ) ) )[0] != 2 )
            {
                algHandler( "r u r' u r u2 r'" );
            }
        }
        System.out.println();
    }


    public void permuteCorners()
    {
        int tries = 0;
        while ( tries < 4 && !isCornerCorrect() )
        {
            algHandler("x");
            tries++;
        }
        if(tries == 4){
            algHandler( "u r u' l' u r' u' l" );
            permuteCorners();
        }
        else {
            algHandler( "u r u' l' u r' u' l" );
            if(!areAllCornersCorrect()){
                algHandler( "u r u' l' u r' u' l" );
            }
        }
    }


    private boolean isCornerCorrect()
    {
        return cube.getCorner( 3 )
            .isSamePiece( buildCorner( cube.getCenter( 0 ),
                cube.getCenter( 3 ),
                cube.getCenter( 4 ) ) );
    }


    private boolean areAllCornersCorrect()
    {
        return cube.getCorner( 0 )
            .isSamePiece( buildCorner( cube.getCenter( 0 ),
                cube.getCenter( 1 ),
                cube.getCenter( 2 ) ) )
            && cube.getCorner( 1 )
                .isSamePiece( buildCorner( cube.getCenter( 0 ),
                    cube.getCenter( 1 ),
                    cube.getCenter( 3 ) ) )
            && cube.getCorner( 2 )
                .isSamePiece( buildCorner( cube.getCenter( 0 ),
                    cube.getCenter( 2 ),
                    cube.getCenter( 4 ) ) )
            && cube.getCorner( 3 )
                .isSamePiece( buildCorner( cube.getCenter( 0 ),
                    cube.getCenter( 3 ),
                    cube.getCenter( 4 ) ) );
    }


    public void orientCorners()
    {
        for(int i=0;i<4;i++){
            while(cube.getCorner( 3 ).getOrientation() != 0){
                algHandler("r' d' r d r' d' r d");
            }
            System.out.println();
            algHandler("u");
        }
    }


    public void algHandler( String alg )
    {
        System.out.print( alg + " " );
        String[] moves = alg.split( " " );
        for ( String move : moves )
        {
            if ( move.equalsIgnoreCase( "u" ) )
            {
                cube.upTurn();
            }
            else if ( move.equalsIgnoreCase( "u'" ) )
            {
                cube.upReverseTurn();
            }
            else if ( move.equalsIgnoreCase( "u2" ) )
            {
                cube.upDoubleTurn();
            }
            else if ( move.equalsIgnoreCase( "d" ) )
            {
                cube.downTurn();
            }
            else if ( move.equalsIgnoreCase( "d'" ) )
            {
                cube.downReverseTurn();
            }
            else if ( move.equalsIgnoreCase( "d2" ) )
            {
                cube.downDoubleTurn();
            }
            else if ( move.equalsIgnoreCase( "r" ) )
            {
                cube.rightTurn();
            }
            else if ( move.equalsIgnoreCase( "r'" ) )
            {
                cube.rightReverseTurn();
            }
            else if ( move.equalsIgnoreCase( "r2" ) )
            {
                cube.rightDoubleTurn();
            }
            else if ( move.equalsIgnoreCase( "l" ) )
            {
                cube.leftTurn();
            }
            else if ( move.equalsIgnoreCase( "l'" ) )
            {
                cube.leftReverseTurn();
            }
            else if ( move.equalsIgnoreCase( "l2" ) )
            {
                cube.leftDoubleTurn();
            }
            else if ( move.equalsIgnoreCase( "f" ) )
            {
                cube.frontTurn();
            }
            else if ( move.equalsIgnoreCase( "f'" ) )
            {
                cube.frontReverseTurn();
            }
            else if ( move.equalsIgnoreCase( "f2" ) )
            {
                cube.frontDoubleTurn();
            }
            else if ( move.equalsIgnoreCase( "b" ) )
            {
                cube.backTurn();
            }
            else if ( move.equalsIgnoreCase( "b'" ) )
            {
                cube.backReverseTurn();
            }
            else if ( move.equalsIgnoreCase( "b2" ) )
            {
                cube.backDoubleTurn();
            }
            else if ( move.equalsIgnoreCase( "x" ) )
            {
                cube.cubeTurn();
            }
            else if ( move.equalsIgnoreCase( "x'" ) )
            {
                cube.cubeReverseTurn();
            }
            else if ( move.equalsIgnoreCase( "x2" ) )
            {
                cube.cubeDoubleTurn();
            }
        }
    }
}
