package Lambda;

import jdk.nashorn.internal.objects.annotations.Getter;
import kotlin.jvm.internal.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MyLambda{
    int findBig();
}
@FunctionalInterface
interface cheak{
    boolean cheak(Person p);
}

public class exam {
    public static void main(String[] args) {
        List<Person> lis= Arrays.asList(
                new Person("aaa","bbb",10),
                new Person("msf","zzz",100),
                new Person("zby","ccc",3)
        );
        cheak lambda=(s)->s.getLastName().startsWith("z");
        for(Person p:lis){
            if(lambda.cheak(p)) System.out.println(p.getFirstName());
        }

    }
}
class Person{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
