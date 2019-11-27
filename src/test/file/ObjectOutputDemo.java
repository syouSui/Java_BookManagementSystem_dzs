package test.file;

import test.file.testEntity.Person;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputDemo {

    static ObjectOutputStream oos = null;

    public static void main ( String[] args ) {

        // FileOutputStream / ObjectOutputSream

        Person[] person = new Person[] {
            new Person( "001", "hhh", 12 ),
                    new Person( "003", "iii", 18 ),
                    new Person( "002", "aaa", 13 )
        };

        try {
            oos = new ObjectOutputStream( new FileOutputStream( "D:\\person_datre.txt" ) );
            for ( Person p : person ) {
                oos.writeObject( p );
            }
            oos.flush();
        } catch ( Exception e ) {
            e.printStackTrace( );
        }

    }
}
