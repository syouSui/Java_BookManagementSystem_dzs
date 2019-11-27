package test.file;

import test.file.testEntity.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputDemo {

    static ObjectInputStream ois = null;

    public static void main ( String[] args ) {

        // FileInputStream / ObjectInputSream

        Person[] person = null;
        int person_tot = 0;

        try { 
            ois = new ObjectInputStream( new FileInputStream( "D:\\person_datre.txt" ) );
            
            Object obj = null;
            while ( (obj=ois.readObject()) != null ) {
                person[person_tot] = new Person();
                person[person_tot++] = (Person)ois.readObject();
            }

        } catch ( Exception e ) {
            e.printStackTrace( );
        }

    }
}
 