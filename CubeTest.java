public class CubeTest
{
    public static void main( String args[] )
    {
       for(int i=0;i<3000;i++){
            Cube cube = new Cube();
            
            System.out.println("cube");
            
            CubeRandomizer ran = new CubeRandomizer( cube );
            ran.randomize( 10 );
            CubeSolver solve = new CubeSolver( cube );

            solve.solve();
            System.out.print( cube );
        }
    }
}
