package gestion_pret_boutiquier.Core;

import java.sql.*;

public class DataBaseImpl  implements DataBase{

private final String url = "jdbc:mysql://localhost:3306/gest_pret_boutiquier";
private final String user = "root";
private final String password = "";
protected PreparedStatement ps;
protected Connection conn = null;
@Override
public void getConnection() throws SQLException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection(url,user,password);

    }catch (ClassNotFoundException e) {
        e.printStackTrace();
        ;

        }
       
       
}
@Override
public void closeConnection() throws SQLException {
   if (conn!=null && !conn.isClosed()) {
    conn.close();
   }
}
@Override
public ResultSet executeQuery(String sql) throws SQLException {
    this.initPreparedStatenent(sql);
    return ps.executeQuery();
}


@Override
public int executeUpdate(String sql) throws SQLException {
    this.initPreparedStatenent(sql);
    return ps.executeUpdate();
}
@Override
public void initPreparedStatenent(String sql) throws SQLException {
    ps = conn.prepareStatement(sql);
}
    
}
