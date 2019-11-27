package test.file;

import java.io.File;

public class FileListFileDemo {

    public static void main ( String[] args ) {
        String filePath = new String( "C:\\Program Files\\Java\\jdk1.8.0_65" );
        File file = new File( filePath );
        if ( file.isDirectory() ) { // 是文件夹
            File[] files = file.listFiles();
            for ( File f : files ) {
                System.out.println( f.isFile() ? "文件: " : "目录: " + f );
            }
        }
    }

}
