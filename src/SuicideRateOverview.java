import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SuicideRateOverview {
    private int id;
    private String country;
    private int year;
    private String sex;
    private int age;
    private float suicideNum;
    private String generation;

    public SuicideRateOverview(String country, int year, String sex, int age, float suicideNum, String generation) throws SQLException {
        setCountry(country);
        setYear(year);
        setSex(sex);
        setAge(age);
        setSuicideNum(suicideNum);
        setGeneration(generation);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static List<String> getsex(){
        List<String> sex = Arrays.asList("male","female","other");
        Collections.sort(sex);
        return sex;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {
        if(getSex().contains(sex)) {
            this.sex = sex;
        }
        else{
            throw new IllegalArgumentException("invalid list!list must be:"+ getSex());
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSuicideNum() {
        return suicideNum;
    }

    public void setSuicideNum(float suicideNum) {
        this.suicideNum = suicideNum;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
