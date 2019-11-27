package test.file;

import java.io.File;

public class FileListDemo {

    public static void main ( String[] args ) {
        String filePath = new String( "C:\\Program Files\\Java\\jdk1.8.0_65" );
        File file = new File( filePath );
        if ( file.isDirectory() ) { // 是文件夹
            String[] fileNames = file.list();
            for ( String name : fileNames ) {
                System.out.println( name );
            }
        }
    }

}
