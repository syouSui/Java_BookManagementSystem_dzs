package test.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class fileDemo {

    static Scanner sc = new Scanner( System.in );

    public static void main ( String[] args ) {

        String pathName = "";
        File file = new File( pathName );
        if ( !file.exists() ) {
            try {
                file.createNewFile();
            } catch ( IOException e ) {
                e.printStackTrace( );
            }
        }

        System.out.println( "文件是否存在? " + file.exists() );
        System.out.println( "是文件吗? " + file.isFile() );
        System.out.println( "是目录吗? " + file.isDirectory() );
        System.out.println( "名称? " + file.getName() );
        System.out.println( "路径? " + file.getPath() );
        System.out.println( "绝对略经? " + file.getAbsolutePath() );
        System.out.println( "最后修改时间? " + new java.util.Date(file.lastModified()).toString() );

    }
}
