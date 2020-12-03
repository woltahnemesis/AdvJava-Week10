import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class Customer {
    private String firstName, lastName, province, gender, bloodType;
    private LocalDate birthday;

    public Customer(String firstName, String lastName, String province, String gender,
                    String birthday, String bloodtype) {
        setFirstName(firstName);
        setLastName(lastName);
        setProvince(province);
        setGender(gender);
        setBirthday(birthday);
        setBloodType(bloodtype);
    }

    public String getFirstName() {
        return firstName;
    }

    private boolean validateName(String name)
    {
        return name.length()>=1 && name.length()<=40;
    }

    public void setFirstName(String firstName) {
        if (validateName(firstName))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("first name must be 1-40 characters");

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (validateName(lastName))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("last name must be 1 to 40 characters");
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {

        List<String> provinces = Arrays.asList("ON", "QC", "AB", "NS","YT", "BC", "PE", "NU", "SK", "NT", "NB", "MB", "NL");
        if (provinces.contains(province))
            this.province = province;
        else
        {
            System.out.printf("'%s'",province);
            throw new IllegalArgumentException("province must be in the list: "+provinces);
        }

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))
            this.gender = gender;
        else
            throw new IllegalArgumentException("gender must be male or female");
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        List<String> bloodTypes = Arrays.asList("B+", "O+", "AB+", "O-", "A+", "B-", "A-", "AB-");
        if (bloodTypes.contains(bloodType))
            this.bloodType = bloodType;
        else
            throw new IllegalArgumentException("blood type must be in the list: "+bloodTypes);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        String[] birthdayArray = birthday.split("/");
        int month = Integer.parseInt(birthdayArray[0]);
        int day = Integer.parseInt(birthdayArray[1]);
        int year = Integer.parseInt(birthdayArray[2]);

        this.birthday = LocalDate.of(year, month, day);
    }

    public int getAge()
    {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}