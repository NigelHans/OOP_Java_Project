import java.util.ArrayList;
import java.util.List;

//Patient class
public class Patient extends Person {
    private String healthCondition;
    private List<Medicine> prescriptions;

    public Patient(String name, int age, String healthCondition) {
        super(name, age);  //Calls the constructor of the parent class (Person)
        this.healthCondition = healthCondition;
        this.prescriptions = new ArrayList<>();
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public void prescribeMedicine(Medicine medicine) {
        prescriptions.add(medicine);
    }

    @Override
    public void showPersonDetails() {
        super.showPersonDetails();  //Calls the method from Person
        System.out.println("Health Condition: " + healthCondition);
        System.out.println("Prescriptions: " + prescriptions);
    }
}