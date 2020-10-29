import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class DBCases {

private static String user ="root";
private static String password = "";

public static int  insertNewCases( SuicideRateOverview newCases) throws SQLException {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int id = -1;
    try{
        conn = DriverManager.getConnection("jdbc:mysqlServer://localhost:3306/SuicideCasesSurvey",user,password);
        String sql = "insert into survey (country,year,sex,"
        +"age,suicideNum,generation) values (?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql,new String[]{"id"});
        ps.setString(1,newCases.getCountry());
        ps.setInt(2,newCases.getYear());
        ps.setString(3,newCases.getSex());
        ps.setInt(4,newCases.getAge());
        ps.setFloat(5,newCases.getSuicideNum());
        ps.setString(6,newCases.getGeneration());
        ps.executeUpdate();
        rs = ps.getGeneratedKeys();
        while(rs.next()){
            id = rs.getInt(1);
        }


}catch (SQLException e){
        e.printStackTrace();
    }finally {
        if(conn != null)
            conn.close();
        if(ps != null)
            ps.close();
        if( rs != null)
            rs.close();
        return id;
    }
    }
}

