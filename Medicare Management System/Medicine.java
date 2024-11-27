//Medicine class to show the medication
public class Medicine {
    private String name;
    private String dosage;

    public Medicine(String name, String dosage) {
        this.name = name;
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Medicine: " + name + " (" + dosage + ")";
    }
}
