package BackJun_10814;

import java.util.*;

public class Main {
    static int N;
    static ArrayList<Person> arr = new ArrayList<Person>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        for(int i=0; i<N; i++){
            arr.add(new Person(input.nextInt(), input.next()));
        }

        Collections.sort(arr, new PersonComparator());

        for(Person p : arr){
            System.out.println(p.age + " " + p.name);
        }
    }
}

class Person{
    int age;
    String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("Person[age=%d, name=%s]",this.age, this.name);
    }


}
class PersonComparator implements Comparator<Person>{
    @Override
    public int compare(Person p1, Person p2){
        return p1.age-p2.age;
    }
}