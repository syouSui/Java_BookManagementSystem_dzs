package test.JavaProgram;

public class ShuiXianHua {

    public static void main ( String argc[] ) {

        int counter = 0;
        for ( int i = 100; i <= 999; ++i ) {
            int a = i/100;
            int b = i%100/10;
            int c = i%10;
            if ( Math.pow( a, 3) + Math.pow( b, 3 ) + Math.pow( c, 3 ) == i ) {
                counter++;
                System.out.print( i + "\t" );
                if ( counter%5==0 ) System.out.println();
            }
        }
        System.out.println( "\n" + counter );
    }
}
