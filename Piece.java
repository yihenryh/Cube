import java.awt.Color;


public class Piece
{
    private Color[] colors;

    private int orientation;


    public Piece( Color[] c, int o )
    {
        colors = c;
        orientation = o;
    }


    public void setColors( Color[] c )
    {
        colors = c;
    }


    public Color[] getColors()
    {
        return colors;
    }


    public Color getColor()
    {
        return colors[0];
    }


    public void setOrientation( int o )
    {
        orientation = o;
    }


    public void changeOrientation( int modifier )
    {
        orientation += modifier;
        orientation %= colors.length;
    }


    public void changeOrientationIfBottomEdge()
    {
        if ( contains( Color.BLUE ) || contains( Color.GREEN ) )
        {
            changeOrientation( 1 );
        }
    }


    public void changeOrientationIfNotBottomEdge()
    {
        if ( !contains( Color.BLUE ) && !contains( Color.GREEN ) )
        {
            changeOrientation( 1 );
        }
    }


    public int getOrientation()
    {
        return orientation;
    }


    public boolean contains( Color c )
    {
        for ( Color i : colors )
        {
            if ( i.equals( c ) )
            {
                return true;
            }
        }
        return false;
    }


    public boolean isSamePiece( Piece o )
    {
        for ( Color i : o.getColors() )
        {
            if ( !contains( i ) )
            {
                return false;
            }
        }
        return true;
    }


    public String toString()
    {
        String str = "";
        for ( Color i : colors )
        {
            if ( i.equals( Color.BLUE ) )
            {
                str += "blue ";
            }
            else if ( i.equals( Color.GREEN ) )
            {
                str += "green ";
            }
            else if ( i.equals( Color.WHITE ) )
            {
                str += "white ";
            }
            else if ( i.equals( Color.YELLOW ) )
            {
                str += "yellow ";
            }
            else if ( i.equals( Color.RED ) )
            {
                str += "red ";
            }
            else if ( i.equals( Color.ORANGE ) )
            {
                str += "orange ";
            }
        }
        str += ( orientation % colors.length ) + "\n";
        return str;
    }
}
