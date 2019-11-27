package test.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main ( String[] args ) {
        String filePath = "F://test.txt";
        FileInputStream fi = null;

        try {
            // 1) 以 写 的格式, 创建一个新文件
            fi = new FileInputStream( filePath );
            // 2)
//            for ( int i = 0; i < 10; ++i ) {
//                System.out.print( (char)fi.read( ) );
//            }
            int ans = 0;
            while ( (ans=fi.read()) != -1 ) {
                System.out.print( (char)ans );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
             if ( fi!=null ) {
                 try {
                     fi.close();
                 } catch ( IOException e ) {
                     e.printStackTrace( );
                 }
             }
        }

    }
}
