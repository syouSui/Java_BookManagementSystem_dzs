package test.JavaProgram;

import java.util.Iterator;
import java.util.ArrayList;

public class Jhosefu {

    public static int jhosefu ( int n, int k ) {

        ArrayList<Integer> myList = new ArrayList<>();
        for ( int i = 1; i <= n; ++i ) myList.add(i);
 
        int cnt  = 0;
        for ( int i = 0; myList.size()!=1; ++i ) {
            if( i==myList.size() ) i = 0;
            cnt ++;
            if ( cnt%k==0 ) myList.remove( i-- );
        }

        return myList.get(0);
    }

    public static void main( String[] args) {
        
        System.out.println( jhosefu( 10, 3 ) );
    }
}
