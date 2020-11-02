import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
    /**
     * TO RETURN ALL DATA
     */
    public static ArrayList<SuicideRateOverview> getAllDataFromDB() throws SQLException {
        ArrayList<SuicideRateOverview> Overview = new ArrayList<>();
        Connection conn = null;
        Statement statement   = null;
        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysqlServer://localhost:3306/SuicideCasesSurvey",user,password);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM survey LIMIT 20");

            while(resultSet.next()) {
                SuicideRateOverview newData = new SuicideRateOverview(
                        resultSet.getInt("id"),
                        resultSet.getString("country"),

                        resultSet.getInt("year"),
                        resultSet.getString("sex"),
                        resultSet.getInt("age"),
                        resultSet.getFloat("suicideNum"),
                        resultSet.getString("gender")


                ) ;
                Overview.add(newData);
                           }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
            return Overview;
        }
    }

    }


