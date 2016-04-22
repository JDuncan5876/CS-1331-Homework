//********************************************************************
//  GrizzlyBear.java       Author: Stasko
//
//  Demonstrates the basic structure of a Java application.
//********************************************************************

public class GrizzlyBear implements Comparable<GrizzlyBear>
{
   protected String name;


   public GrizzlyBear(String n) {
      name = n;
   }

   public String toString() {
      return name;
      }

   public boolean equals(Object o) {
      GrizzlyBear gb;

      if (o instanceof GrizzlyBear)
         gb = (GrizzlyBear)o;
      else
         return false;

      if (name.equals(gb.name))
        return true;
      else
        return false;
   }

   public int compareTo(GrizzlyBear g) {
      return this.toString().compareTo(g.toString());
   }

   public static void main (String[] args){
       String s = "gabe";

       GrizzlyBear gb1 = new GrizzlyBear("Gabe");
       System.out.println (gb1);
       GrizzlyBear gb2 = new GrizzlyBear("Gabe");
       if (gb1.equals(gb2))
          System.out.println("Same");
       else
          System.out.println("Different");

   }

}
