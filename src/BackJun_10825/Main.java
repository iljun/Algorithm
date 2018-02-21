package BackJun_10825;

import java.util.*;

public class Main {
    static int N;
    static List<Student> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        for(int i=0; i<N; i++){
            list.add(new Student(input.next(), input.nextInt(), input.nextInt(), input.nextInt()));
        }

        Collections.sort(list,new StudentSort());

        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i).name);

    }
}

class Student{
    String name;
    int language;
    int english;
    int math;

    public Student(String name, int language, int english, int math){
        this.name = name;
        this.language = language;
        this.english = english;
        this.math = math;
    }
}

class StudentSort implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2){
        if(s1.language==s2.language){
            if(s1.english==s2.english){
                if(s1.math==s2.math){
                    return s1.name.compareTo(s2.name);
                }else {
                    return s2.math-s1.math;
                }
            }else{
                return s1.english-s2.english;
            }
        }else
            return s2.language-s1.language;
    }
}