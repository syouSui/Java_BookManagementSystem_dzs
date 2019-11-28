package test.file;

import test.file.testEntity.Person;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectInputDemo {

    static ObjectInputStream ois = null;


    public static void ObjectInputStreamTest ( ) {

        ArrayList<Person> person = new ArrayList<Person>( );

        try {
            ois = new ObjectInputStream( new FileInputStream( "D:\\person_date.txt" ) );
            person = (ArrayList<Person>)ois.readObject();

        } catch ( Exception e ) {
            e.printStackTrace( );
        }

        for ( Person p : person ) {
            System.out.println(
                    "no :" + p.getNo() +"\n"+
                    "name: " + p.getName() +"\n"+
                    "age: " +p.getAge() +"\n" );
        }
    }

    public static void main ( String[] args ) {

        ObjectInputStreamTest();

        // FileInputStream / ObjectInputSream

//        ArrayList<Person> person = new ArrayList<Person>( );
//
//        try {
//            ois = new ObjectInputStream( new FileInputStream( "D:\\person_date.txt" ) );
//
//            Object obj = null;
//            while ( (obj=ois.readObject()) != null ) {
//                person.add( (Person)obj );
//            }
//
//            for ( Person p : person ) {
//                System.out.println(
//                        "no :" + p.getNo() +"\n"+
//                        "name: " + p.getName() +"\n"+
//                        "age: " +p.getAge() +"\n" );
//            }
//
//        } catch ( Exception e ) {
//            e.printStackTrace( );
//        }

    }
}
 