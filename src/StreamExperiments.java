import java.util.ArrayList;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExperiments {
    public static void main(String[] args) {
        ArrayList<Customer> customers = DBUtility.getCustomers();

        System.out.printf("There are %d customers.%n", customers.size());


        //challenge 1 - create a method that will return the number
        //of male customers
        System.out.printf("There are %d male customers. %n",
                getNumOfCustomerByGender(customers,"male"));

        //challenge 2 - create a method that will return the number
        //of female customers
        System.out.printf("There are %d female customers. %n",
                getNumOfCustomersWithStream(customers, "female"));

        //challenge 3 - what is the % of male to female customers
        System.out.printf("The %% of male customers is: %.1f%% %n",
                ((double) getNumOfCustomerByGender(customers, "male")/customers.size()*100));


        OptionalDouble avgAge = customers.stream()
                .mapToDouble(Customer::getAge)
                .average();
        if (avgAge.isPresent())
            System.out.printf("The average age of customers is %.1f years%n",avgAge.getAsDouble());


        //get the number of customers for each province
        TreeMap<String, Integer> provinceCounts = DBUtility.getProvinceCounts();
        System.out.println(provinceCounts);

        //creating the same type of information (a map with province name and customer counts
        Map<String, Long> provinceCountByStream = customers.stream()
                .map(Customer::getProvince)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        System.out.println(provinceCountByStream);

        //create a stream that returns the counts of each blood type
        Map<String, Long> bloodTypesByStream = customers.stream()
                .map(Customer::getBloodType)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        System.out.println(bloodTypesByStream);
    }

    private static int getNumOfCustomerByGender(ArrayList<Customer> customers, String gender)
    {
        int count = 0;
        for (Customer customer : customers)
        {
            if (customer.getGender().equals(gender))
                count++;
        }
        return count;
    }

    /**
     * The same kind of method as the previous one, but using Streams
     */
    public static long getNumOfCustomersWithStream(ArrayList<Customer> customers, String gender)
    {
        return customers.stream()
                .filter(customer -> customer.getGender().equals(gender))
                .count();
    }
}
