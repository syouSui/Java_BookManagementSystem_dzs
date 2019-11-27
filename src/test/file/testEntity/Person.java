package test.file.testEntity;

import java.io.Serializable;

public class Person implements Serializable {

    private String no;
    private String name;
    private int age;


    public Person ( ) {
        super();
    };
    public Person ( String no, String name, int age ) {
        super();
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public void setNo ( String no ) {
        this.no = no;
    }
    public String getNo ( ) {
        return this.no;
    }
    public void setName ( String name ) {
        this.name = name;
    }
    public String getName ( ) {
        return this.name;
    }
    public void setAge ( int age ) {
        this.age = age;
    }
    public int getAge ( ) {
        return this.age;
    }
}
