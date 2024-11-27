import java.util.ArrayList;
import java.util.List;

//Patient class
public class Patient extends Person {
    private String healthCondition;
    private List<Medicine> prescriptions;

    public Patient(String name, int age, String healthCondition) {
        super(name, age);
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

    public void clearPrescriptions() {
        prescriptions.clear();
    }
    
    public List<Medicine> getPrescriptions() {
        return prescriptions;
    }

    @Override
    public void showPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Health Condition: " + healthCondition);
        System.out.println("Prescriptions: " + prescriptions);
    }
}
