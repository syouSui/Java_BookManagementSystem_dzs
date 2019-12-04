package test.JavaProgram;

public class BaiQianMaiBaiJi {

    public static void main ( String[] args ) {
    // g 5 -1
    // m 3 -1
    // x 1 -3

    int cnt = 0;
    for ( int x =0; x <= 20; ++x ) {
        for ( int y = 0; y <= 33; ++y ) { 
            int z = 100-x-y;
            if ( z%3==0 && 5*x+3*y+z/3==100 ) {
                cnt++;
                System.out.println( "GongJi : " + x + "\t" + "MuJi : " + y + "\t" + "XiaoJi" + z );
            }
        }
    }
    System.out.println( "\n" + cnt );

    }
}
