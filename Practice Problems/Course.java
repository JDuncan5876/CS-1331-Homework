public class Course {
          protected String instructor;
          protected int number;
          protected Student[] students;

          public Course(String i) {
             instructor = i;
             number = 0;
             students = new Student[100];        //____________________ Check
          }

          public void addStudent(Student s) {
             int i;

             students[number] = s;                     //______________ Check
             System.out.println("Adding " + s);        //______________ Check
             System.out.println("with name "+s.name);  //______________ Check
             i = s.nextUp();                           //______________ Check
             System.out.println(i+" is next up");      //______________ Check
          }
        }