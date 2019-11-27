package test.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main ( String[] args ) {
        // FileReader :
        // BufferedReader : 按行读写

        BufferedReader br = null;

        try {
            // 以读的格式打开文件
            br = new BufferedReader( new FileReader( "F:\\test.txt" ) );

            String ans = null;
            while ( (ans=br.readLine()) != null ) {
                System.out.print( ans );
            }

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
        }

    }

}
