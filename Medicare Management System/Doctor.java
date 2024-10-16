//Doctor clas
public class Doctor extends Person {
    private String specialty;

    public Doctor(String name, int age, String specialty) {
        super(name, age);  //Calls the constructor of the Person class
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public void showPersonDetails() {
        super.showPersonDetails(); //Calls the method from Person
        System.out.println("Specialty: " + specialty);
    }
}
