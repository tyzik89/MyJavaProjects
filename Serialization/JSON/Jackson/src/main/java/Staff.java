import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties("secretOtherInfo")
public class Staff {

    @JsonProperty("custom_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonView(CompanyViews.Normal.class)
    private String name;

    @JsonView(CompanyViews.Normal.class)
    private int age;

    @JsonView(CompanyViews.Manager.class)
    private String[] position;

    @JsonView(CompanyViews.Manager.class)
    private List<String> skills;

    @JsonView(CompanyViews.Manager.class)
    private Map<String, BigDecimal> salary;

    @JsonIgnore
    private String secretInfo;

    private String secretOtherInfo;

    public Staff() {
    }

    public Staff(String name, int age, String[] position, List<String> skills, Map<String, BigDecimal> salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.skills = skills;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getPosition() {
        return position;
    }

    public void setPosition(String[] position) {
        this.position = position;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Map<String, BigDecimal> getSalary() {
        return salary;
    }

    public void setSalary(Map<String, BigDecimal> salary) {
        this.salary = salary;
    }

    public String getSecretInfo() {
        return secretInfo;
    }

    public void setSecretInfo(String secretInfo) {
        this.secretInfo = secretInfo;
    }

    public String getSecretOtherInfo() {
        return secretOtherInfo;
    }

    public void setSecretOtherInfo(String secretOtherInfo) {
        this.secretOtherInfo = secretOtherInfo;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position=" + Arrays.toString(position) +
                ", skills=" + skills +
                ", salary=" + salary +
                ", secretInfo='" + secretInfo + '\'' +
                ", secretOtherInfo='" + secretOtherInfo + '\'' +
                '}';
    }
}
