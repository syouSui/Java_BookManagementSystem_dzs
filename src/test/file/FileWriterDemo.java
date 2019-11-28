package test.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

    public static void main ( String[] args ) {
        // FileWrieter / BufferedWriter : 按行读写

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter( new FileWriter( "F:\\test.txt" ) );
            String line = System.getProperty( "line.separator" );
            bw.write( "Hello World !" + line );
            bw.write( "Hello Java !" + line );
            bw.flush( );
        } catch ( Exception e ) {
            e.printStackTrace( );
        } finally {
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
