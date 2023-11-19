import java.util.*;

 public class calculator
 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        boolean student=true;
        int num;
        String name="";
        String grade="";
        String answer="";
        while(student)
        {
            System.out.println("Enter the number of subjects");
            num=sc.nextInt();
            System.out.println("\n Enter the name of the student");
           name=sc.nextLine();
           sc.nextLine();
            String subject[]=new String[num];
            int marks[]=new int[num];
            for(int i=0;i<num;i++)
            {
                System.out.println("\n Enter the name of subject");
                subject[i]=sc.nextLine();
                System.out.println("\n Enter the marks out of 100");
                marks[i]=sc.nextInt();
                sc.nextLine();
            }
            double total=0.0;
            double avg=0.0;
           System.out.println("This is the log for "+ name);
           System.out.println("\tSUBJECT\t\t\t\tMARKS");
           for(int i =0;i<num;i++)
           {
            System.out.println("\t"+subject[i]+"\t\t\t\t"+marks[i]);
            total=marks[i]+total;
           }
           avg=total/num;
           if(avg<=100 && avg>=90)
           grade="A";
           if(avg<90 && avg>=80)
           grade="B";
           if(avg<80 && avg>=70)
           grade="C";
           if(avg<70 && avg>=60)
           grade="D";
           if(avg<60 && avg>=50)
           grade="E";
           if(avg<50)
           grade="F";
           System.out.println("The total is "+total);
           System.out.println("The average percentage is "+avg+"%");
           System.out.println("The grade is "+grade);
            System.out.println("Do you want to create another log?");
            answer=sc.nextLine();
            student=YesNoToBooleanConverter.convertYesNoToBoolean(answer);
        }
        System.out.println("\n No more logs are created");
      }
 }
