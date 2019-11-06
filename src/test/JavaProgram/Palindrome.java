package test.JavaProgram;

public class Palindrome {

//    final int MAXN = (int)1e5;

    public static void main ( String[] args ) {
        int[] d = new int[5];

        int counter = 0;
        boolean flag = false;
        int i = 10000;
        for ( ; i < 100000; ++i ) {
            int idx = 0;
            int num = i;
            while ( num!= 0 ) {
                d[idx++] = num%10;
                num /= 10;
            }
            if ( d[0]==d[4] && d[1]==d[3] ) {
                counter++;
                flag = true;
                System.out.print( i );
                if ( counter%5==0 ) System.out.println();
            }
        }
        System.out.print( counter );




    }
}
