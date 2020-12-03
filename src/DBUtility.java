import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;

public class DBUtility {
    private static String user = "student";
    private static String password = "student";
    private static String connString = "jdbc:mysql://localhost:3306/F20COMP1011Test2";

    public static ArrayList<Customer> getCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<>();

        //try with resources.  The objects in the () all have a close() method that
        //will automatically be closed when the method finishes
        try (
                Connection conn = DriverManager.getConnection(connString, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet =  statement.executeQuery("SELECT * FROM customers");
        )
        {
            while (resultSet.next())
            {
                customers.add(new Customer(
                        resultSet.getString("givenname"),
                        resultSet.getString("surname"),
                        resultSet.getString("province"),
                        resultSet.getString("gender"),
                        resultSet.getString("birthday"),
                        resultSet.getString("bloodtype")));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return customers;
    }

    public static TreeMap<String, Integer> getProvinceCounts()
    {
        TreeMap<String, Integer> provinceCountsMap = new TreeMap<>();
        try (
                Connection conn = DriverManager.getConnection(connString, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet =  statement.executeQuery("SELECT province, COUNT(postal_code) " +
                        "FROM customers GROUP BY province");
        )
        {
            while (resultSet.next())
            {
                provinceCountsMap.put(resultSet.getString("province"), resultSet.getInt(2));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return provinceCountsMap;
    }
}
