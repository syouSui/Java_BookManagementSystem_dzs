package test.JavaProgram;

public class FibDemo {

    public static void main ( String[] args ) {
        int[] fib= new int[20];

        fib[0] = 1;
        fib[1] = 1;

        System.out.print( fib[0] +" "+ fib[1] + " " );
        for ( int i = 2; i < 20; ++i ) {
            fib[i] = fib[i-2]+fib[i-1];
            if ( i%5==0 ) System.out.println( );
            System.out.print( fib[i] +" ");
        }

    }

}
