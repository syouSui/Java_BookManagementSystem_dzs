package test.file;

import java.io.*;

public class _myFileDemo {

    static BufferedWriter bw = null;
    static BufferedReader br = null;

    public static void init ( ) {
        try {
            bw = new BufferedWriter( new FileWriter( "D://test.txt" ) );

            bw.write( "Hello java!" );
            bw.newLine();
//            bw.write( "Hello BufferedWriter !" );
//            bw.newLine();

        } catch ( IOException e ) {
            e.printStackTrace( );
        } finally {
            if ( bw!=null ) {
                try {
                    bw.close();
                } catch ( IOException e ) {
                    e.printStackTrace( );
                }
            }
        }


    }

    public static void copy ( ) {
        BufferedWriter temp = null;
        try {
            br = new BufferedReader( new FileReader( "D://test.txt" ) );

            temp = new BufferedWriter( new FileWriter( "E://test.txt" ) );

            String line = null;
            while ( (line = br.readLine( )) != null ) {
//                System.out.println( line );
                temp.write( line );
                temp.newLine();
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace( );
        } catch ( IOException e ) {
            e.printStackTrace( );
        } finally {
            if ( br != null ) {
                try {
                    br.close( );
                } catch ( IOException e ) {
                    e.printStackTrace( );
                }
            }
            if ( temp != null ) {
                try {
                    temp.close();
                } catch ( IOException e ) {
                    e.printStackTrace( );
                }
            }
        }
    }

    public static void delete ( String path ) {
        new File ( path ).delete();

    }

    public static void main ( String[] args ) {
//        init( );

        copy( );

        delete( "D://test.txt" );
//        delete( "E://test.txt" );

    }
}
