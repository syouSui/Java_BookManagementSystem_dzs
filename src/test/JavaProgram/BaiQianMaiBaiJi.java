package test.JavaProgram;

public class BaiQianMaiBaiJi {

    public static void main ( String[] args ) {
    // g 5
    // m 3
    // x 0.5

    int cnt = 0;
    for ( int x =0; x <= 20; ++x ) {
        for ( int y = 0; y <= 33; ++y ) { 
            int z = 100-x-y;
            if ( z%2==0 && 5*x+3*y+z*0.5==100 ) {
                cnt++;
                System.out.println( "GongJi : " + x + "\t" + "MuJi : " + y + "\t" + "XiaoJi" + z );
            }
        }
    }
    System.out.println( "\n" + cnt );

    }
}
