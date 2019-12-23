package test.file;

import test.file.testEntity.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ObjectOutputDemo {

    static ObjectOutputStream oos = null;

    public static void ObjectOutputStreamTest ( ) {
//
//        ArrayList<Person> person = new ArrayList<Person>(
//            Arrays.asList( //new Person[] {
//                new Person( "001", "hhh", 12 ),
//                new Person( "003", "iii", 18 ),
//                new Person( "002", "aaa", 13 )
//            /*}*/ )
//        );
        ArrayList<Person> person = new ArrayList();
        person.addAll( new ArrayList<Person>(
                Arrays.asList( //new Person[] {
                        new Person( "001", "hhh", 12 ),
                        new Person( "003", "iii", 18 ),
                        new Person( "002", "aaa", 13 )
                        /*}*/ )
        ));






        try {
            oos = new ObjectOutputStream( new FileOutputStream( "D:\\person_date.txt" ) );
            oos.writeObject( person );
            oos.flush();
        } catch ( Exception e ) {
            e.printStackTrace( );
        }
    }

    public static void main ( String[] args ) {

        ObjectOutputStreamTest();

        // FileOutputStream / ObjectOutputSream

//        Person[] person = new Person[] {
//                new Person( "001", "hhh", 12 ),
//                new Person( "003", "iii", 18 ),
//                new Person( "002", "aaa", 13 ),
//                null
//        };
//
//        try {
//            oos = new ObjectOutputStream( new FileOutputStream( "D:\\person_date.txt" ) );
//            for ( Person p : person ) {
//                oos.writeObject( p );
//            }
//            oos.flush();
//        } catch ( Exception e ) {
//            e.printStackTrace( );
//        }

    }
}
