package grade_Activity;
//sourceCodeChapter11
/**
   This program demonstrates the toString and equals
   methods that are inherited from the Object class.
*/
public class ObjectMethods_
{
   public static void main(String[] args)
   {
      // Create two objects.
      PassFailExam_ exam1 = 
                   new PassFailExam_(0, 0, 0);
      PassFailExam_ exam2 =
                   new PassFailExam_(0, 0, 0);

      // Send the objects to println, which
      // will call the toString method.
      System.out.println(exam1);
      System.out.println(exam2);

      // Test the equals method.
      if (exam1.equals(exam2))
         System.out.println("They are the same.");
      else
         System.out.println("They are not the same.");
   }
}
