package test.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main ( String[] args ) {
        String filePath = new String( "F://test.txt" );
        FileOutputStream fo = null;

        try {
            // 1) 以 写 的格式, 创建一个新文件
            fo = new FileOutputStream( filePath );
            // 2)
            for ( int i = 0; i < 10; ++i ) {
                fo.write( 65+i );

            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
             if ( fo!=null ) {
                 try {
                     fo.close();
                 } catch ( IOException e ) {
                     e.printStackTrace( );
                 }
             }
        }

    }
}
