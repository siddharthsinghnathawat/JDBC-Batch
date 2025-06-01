import java.net.SocketOption;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

class Main{
    private static final String url="your workspace url";
    private static final String username="root";
    private static final String password="your password";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            Scanner scanner=new Scanner(System.in);

            while (true){
                System.out.print("Enter Name: ");
                String name=scanner.next();
                System.out.print("Enter Age: ");
                int age=scanner.nextInt();
                System.out.print("Enter Marks: ");
                Double marks=scanner.nextDouble();
                System.out.print("Enter more data(Y/N): ");
                String choice=scanner.next();
                String query=String.format("INSERT INTO stud(name,age,marks)VALUES('%s',%d,%f)",name,age,marks);
                statement.addBatch(query);
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
           int[] arr=statement.executeBatch();





        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
