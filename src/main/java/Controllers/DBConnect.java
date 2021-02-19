package Controllers;

import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DBConnect {

        final static String url = "jdbc:postgresql://localhost/znanya3";
        final static String username = "postgres";
        final static String password = "qwerty";


        private static final AtomicInteger count = new AtomicInteger(61);

        public Connection createConnect()  {
                try{
                        Class.forName("org.postgresql.Driver");
                        return DriverManager.getConnection(url,username,password);

                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return null;
        }

        public ResultSet getListDB(String sql) throws SQLException {
                Statement st = createConnect().createStatement();
                ResultSet rs = st.executeQuery(sql);
                return rs;
        }

        public void closeConnectionFromDB() throws SQLException {
                createConnect().close();
        }



        public void insertValuesFromDB(String tag,String text,String filename,String name) throws SQLException {
                PreparedStatement ps = createConnect().prepareStatement("" +
                        "INSERT INTO message (id,tag, text, filename,author) VALUES (?,?,?,?,?)");

                ps.setLong(1,(long) count.incrementAndGet());
                ps.setString(2,tag);
                ps.setString(3,text);
                ps.setString(4,filename);
                ps.setString(5,name);
                ps.execute();
        }

        public Long getLastID() throws SQLException {
               ResultSet rs = getListDB("Select id from message");
               Long id = null;
               while (rs.next()){
                       id = rs.getLong(1);
                       return id;

               }

               return id;
        }


}
