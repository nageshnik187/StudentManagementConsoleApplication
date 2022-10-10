package student_manager;

import java.sql.*;

public class StudentDao {
    public static boolean insertDataIntoDB(Student student){
        boolean flag = false;
        try {
            Connection con = ConnectionProvider.getCon();
            String query = "insert into student_data(sname,snumber) values(?,?)";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1,student.getName());
            psmt.setString(2,student.getNumber());
            psmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public static void fetchDataFromDB() {
        try {
            Connection con = ConnectionProvider.getCon();
            String query = "select * from student_data";
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String number = resultSet.getString(3);

                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("Number : "+number);
                System.out.println("----------------------------");
                /* OR Student student = new Student(id,name,number);
                System.out.println(student);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static boolean removeDataFromDB(int userID) {
        boolean flag = false;
        try {
            Connection con = ConnectionProvider.getCon();
            String query = "delete from student_data where id=?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1,userID);  // OR psmt.setString(1, String.valueOf(userID));
            psmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public static boolean updateDataIntoDB(Student student1, int userID) {
        boolean flag = false;
        try {
            Connection con = ConnectionProvider.getCon();
            //UPDATE table_name SET column1 = value1, column2 = value2,...
            //WHERE condition;
            String query = "update student_data set sname = ?, snumber = ? where id=?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1,student1.getName());
            psmt.setString(2,student1.getNumber());
            psmt.setInt(3,userID); // OR psmt.setString(1, String.valueOf(userID));
            psmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
}
