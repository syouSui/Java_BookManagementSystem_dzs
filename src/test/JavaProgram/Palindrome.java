package test.JavaProgram;

public class Palindrome {

        public static void num_methon( ) {
            int[] d = new int[5];

            int counter = 0;
            boolean flag = false;
            int i = 10000;
            for ( ; i < 100000; ++i ) {
                int idx = 0;
                int num = i;
                while ( num != 0 ) {
                    d[idx++] = num % 10;
                    num /= 10;
                }
                if ( d[0] == d[4] && d[1] == d[3] ) {
                    counter++;
                    flag = true;
                    System.out.print( i );
                    if ( counter % 5 == 0 ) System.out.println( );
                }
            }
            System.out.print( counter );

        }

        public static void str_method ( ) {

            int cnt = 0;
            for ( int i = 10000; i <= 99999; ++i ) {
                String str = new String( Integer.toString(i) );
                if ( str.charAt(0)==str.charAt(4) && str.charAt(1)==str.charAt(3) ) {
                    System.out.println( str );
                    cnt++;
                }
            }
        }

        public static void StringBuilder_methond ( ) {
            // 懒得写了... 就这么个情况
            String s1 = Integer.toString( 11111 );
            String s2 = new StringBuilder(s1).reverse().toString();
            // s1.equals( s2 )
        }

        public static void main ( String[] args ) {




    }
}
