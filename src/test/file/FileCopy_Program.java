package test.file;

import java.io.*;

public class FileCopy_Program {

    static BufferedReader br = null;
    static BufferedWriter bw = null;

    public static void main ( String[] args ) {

        try {
            br = new BufferedReader( new FileReader( "D:\\test.txt" ) );
            bw = new BufferedWriter( new FileWriter( "E:\\test.txt" ) );

            String line = System.getProperty( "line.separator" );

            String ans = null;
            while ( (ans=br.readLine()) != null ) {
                bw.write( ans +line );
            }
            bw.flush( );

        } catch ( Exception e ) {
            e.printStackTrace( );
        } finally {
            if( br!=null ) {
                try {
                    br.close();
                } catch ( IOException e ) {
                    e.printStackTrace( );
                }
            }
            if( bw!=null ) {
                try {
                    bw.close();
                } catch ( IOException e ) {
                    e.printStackTrace( );
                }
            }
        }


    }
}
