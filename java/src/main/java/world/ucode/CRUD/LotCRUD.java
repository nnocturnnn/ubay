package world.ucode.CRUD;

import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.http.codec.json.Jackson2JsonEncoder;

import org.json.JSONObject;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class LotCRUD {
    private static String url = "jdbc:mysql://localhost:3306/ubay";
    private static String userName = "root";
    private static String bdPassword = "";

    private Connection conn = null;
    private Statement statement;
    public void getConnection() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
        try {
            this.conn = DriverManager.getConnection(this.url, this.userName, this.bdPassword);
            statement = this.conn.createStatement();
            System.out.println("Ok");
        } catch (SQLException throwables) {
            System.out.println("Problem" + throwables);
        }
    }

    public void create(String title, Double startPrice, Double bidStep, Integer duration, String description, String category, Integer startTime, Integer finishTime, Integer active) throws SQLException {
        String query = "INSERT into ubay.lots(title, startPrice, bidStep, duration, description, category, startTime, finishTime, active) values(\'" + title + "\', \'" + startPrice + "\', \'" + bidStep + "\', \'" + duration + "\', \'" + description + "\', \'" + category + "\', \'" + startTime + "\', \'" + finishTime + "\', \'" + active + "\');";
        statement.executeUpdate(query);
    }
    public JSONObject getData() throws SQLException {
        String query = "select * from ubay.lots";
        ResultSet res = statement.executeQuery(query);
        JSONObject info = new JSONObject();
        while (res.next()) {
            info.put("title", res.getString(2));
            info.put("startPrise", res.getDouble(3));
            info.put("bidStep", res.getDouble(4));
            info.put("duration", res.getInt(5));
            info.put("description", res.getString(6));
            info.put("category", res.getString(7));
            info.put("startTime", res.getInt(8));
            info.put("finishTime", res.getInt(9));
            info.put("active", res.getInt(10));
        }
        return info;
    }

}