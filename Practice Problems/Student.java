public class Student {
         protected String name;
         private int id;

         public Student(String n, int id) {
             name = n;      //_____________________________ Check
             this.id = id;
         }

         public void enroll(int Course) {
            summarize(100.0);       //____________________ Check
            System.out.println(name + " " + id);
         }

         protected int nextUp() {
            return id+1;                      //____________________ Check
         }

         public static void summarize(double d) {
            double x;

            x = d*d;                 //____________________ Check
         }


         public static void main(String[] args) {
            Student s1,s2,s3;
            int i;

            s1 = new Student("Kelly", 23);     //____________________ Check
            s2 = new Student("Jon", 24);                //____________________ Check
            s3 = new Student("Kelly", 23);              //____________________ Check

            i = s3.nextUp();                   //____________________ Check
            s1.enroll(1331);                   //____________________ Check
            Student.summarize(200.0);          //____________________ Check
            s1.summarize(100.0);               //____________________ Check
          }
       }