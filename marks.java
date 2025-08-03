import java.util.Scanner;

public class Marks{
 public static void main(String args[]){
  Scanner sc=new Scanner(System.in);
    int n;
   System.out.print("Enter number of students: ");
   n=sc.nextInt();
   sc.nextLine();
  int [][]  marks = new int[n][3];
  boolean[] exist =new boolean[n];

  System.out.println("\n\nMenu");
  System.out.println("add [studentID]");
  System.out.println("update [studentID] [subjectID]");
  System.out.println("average_s [subjectID]"); 
  System.out.println("average [studentID]");
  System.out.println("total [studenID]");
  System.out.println("grades");
  System.out.println("exit \n");
while(true){
System.out.print("Enter command: ");  
String inp=sc.nextLine();
String[] input=inp.split(" ");
String command = input[0];
  int stID = -1;
  int subjectID = -1;
  switch(command){
   case "add": 
     if(input.length ==2){
     stID=Integer.parseInt(input[1])-1; 
   }
      if(stID <0 || stID >=n){
     System.out.println("Invalid student ID");
     break;       
   }
  System.out.print("Enter math mark: ");
  marks[stID][0]=sc.nextInt();
  System.out.print("Enter chemistry mark: ");
  marks[stID][1]=sc.nextInt();
  System.out.print("Enter physics mark: ");
  marks[stID][2]=sc.nextInt();
 sc.nextLine();
 exist[stID]=true;
 break;
 case "update":
     if(input.length ==3){
          stID=Integer.parseInt(input[1])-1; 
          subjectID=Integer.parseInt(input[2])-1;
     }
        if(stID <0 || stID >=n || subjectID <0 || subjectID >=3){
     System.out.println("Invalid studentID or subject_no");
     break;       
   }
if(!exist[stID]){
System.out.println("marks not added");
break;
}
  System.out.print("Enter new mark: ");
  marks[stID][subjectID]=sc.nextInt(); 
  sc.nextLine();
  break;

 case "average_s":
     if(input.length ==2){
          subjectID=Integer.parseInt(input[1])-1; ;
     }
   if(subjectID<0 || subjectID>=3){
   System.out.println("Invalid subject_no");
}
     int SubjectSum=0,count=0;
     for(int i=0;i<n;i++){
         if(exist[i]){
    SubjectSum += marks[i][subjectID];
    count++; 
 }
}
    double average_S= (double) SubjectSum/count;
    System.out.printf("average for subject no %d= %.2f\n",subjectID+1,average_S);
    break;
case "average":
    if(input.length ==2){
     stID=Integer.parseInt(input[1])-1; 
   }
     if(stID <0 || stID >=n){
   System.out.println("Invalid studentID");
   break;
} 
  int sum=marks[stID][0] +marks[stID][1]+marks[stID][2];
   double average=(double) sum/3;
  System.out.printf("average of studentID %d= %.2f\n",stID +1,average);
  break;
case "total":
    if(input.length ==2){
     stID=Integer.parseInt(input[1])-1; 
   }
  if(stID <0 || stID >=n){
   System.out.println("Invalid studentID");
   break;
}
 int total=marks[stID][0] +marks[stID][1]+marks[stID][2];
 System.out.printf("total of studentID %d= %d\n",stID +1,total);
 break;
case "grades":
    System.out.printf("%-12s%-12s%-12s%-12s%n", "Student", "Math", "Chemistry", "Physics");
    for(int i=0;i<n;i++){
        System.out.printf("%-12d", i + 1);
        for(int j=0;j<3;j++){
            int mark=marks[i][j];
            String grade= "";
            if(mark>=90)  grade
            ="grade A";
            else if(mark>=80 && mark <=89) 
            grade ="grade B";
            else if(mark>=70 && mark <=79) 
            grade ="grade C";
            else if(mark>=60 && mark <=69) 
            grade ="grade D";
            else grade ="fail";
            System.out.printf("%-12s", grade);
        }
        System.out.printf("\n");
    }
    break;
case "exit":
    System.out.println("exited");
    sc.close();
    return;
default:
  System.out.println("invalid command");
  break;
 }
}
}
}