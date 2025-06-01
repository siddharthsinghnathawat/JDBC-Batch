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

        try(
            Connection connection = DriverManager.getConnection(url,username,password);
            Scanner scanner=new Scanner(System.in);
        ){
            String query="INSERT INTO stud(name,age,marks)VALUES(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            

            while (true){
                System.out.print("Enter Name: ");
                String name=scanner.next();
                System.out.print("Enter Age: ");
                int age=scanner.nextInt();
                System.out.print("Enter Marks: ");
                Double marks=scanner.nextDouble();
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,age);
                preparedStatement.setDouble(3,marks);
                System.out.print("Enter more data(Y/N): ");
                String choice=scanner.next();
                
                PreparedStatement.addBatch();
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
           int[] result=preparedStatement.executeBatch();
         System.out.println(result.length + " record(s) inserted.");



        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
