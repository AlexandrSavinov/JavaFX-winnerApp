package Controllers;

import java.sql.*;

public class DBConnect {
        //закрытый констркутор для реализации паттерна Singelton
        private DBConnect(){}

        // Данные для подключения к БД
        private final static String url = "jdbc:postgresql://localhost/znanya3";
        private final static String username = "postgres";
        private final static String password = "qwerty";

        private static DBConnect dbConnect;

        //реализация паттернна Singelton
        public static synchronized DBConnect getDBConnet(){
                if(dbConnect == null){
                        dbConnect = new DBConnect();
                }
                return dbConnect;
        }

        public static Connection createConnect()  {
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



        public boolean insertValuesFromDB(String tag,String text,String filename,String name) throws SQLException {
                PreparedStatement ps = createConnect().prepareStatement("" +
                        "INSERT INTO message (id,tag, text, filename,author) VALUES (?,?,?,?,?)");
                ps.setLong(1,getLastID()+1);
                ps.setString(2,tag);
                ps.setString(3,text);
                ps.setString(4,filename);
                ps.setString(5,name);
                return ps.execute();
        }

        public static Long getLastID() throws SQLException {

                Statement st = createConnect().createStatement();
               ResultSet rs = st.executeQuery("Select id from message ORDER BY id desc ");
               Long id = null;
               while (rs.next()){
                       id = rs.getLong(1);
                       return id;

               }
                System.out.println("Current id="+id);
               return id;
        }


}
