package cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @auth wcy on 2019/10/24.
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        AtomicReference<Person> ar = new AtomicReference<>();
        Person person = new Person("wcy",18);
        ar.set(person);

        Person upPerson = new Person("aaa",19);
        person.age = 21;

        ar.compareAndSet(person,upPerson);
        System.out.println(ar.get().getAge());



    }

    static class Person{
        private String name;
        private int age;

        Person(){

        }

        Person(String name,int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
