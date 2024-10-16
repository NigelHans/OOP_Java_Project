import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// UserManager class to handle user operations
public class UserManager {
    private static final String USER_FILE_PATH = "users.txt"; // File to save users info
    private static final String PATIENT_FILE_PATH = "patients.txt"; // File to save patient details
    private static List<Patient> patients = new ArrayList<>(); // List to store patients

    public static void main(String[] args) {
        loadPatients(); // Load existing patients from file
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Medicare User Manager");
            System.out.println("Please choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting Medicare. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void register(Scanner scanner) {
        System.out.println("Designate your Identity:");
        System.out.println("1. Doctor");
        System.out.println("2. Patient");
        System.out.print("Enter your choice: ");
    
        int identityChoice = scanner.nextInt();
        scanner.nextLine();
    
        if (identityChoice == 1) {
            System.out.print("Enter doctor's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter doctor's age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter doctor's specialty: ");
            String specialty = scanner.nextLine();
            System.out.print("Set a password for the doctor: ");
            String password = scanner.nextLine();
    
            Doctor doctor = new Doctor(name, age, specialty);
            saveUserData("Doctor", doctor.getName(), password);
            System.out.println("Doctor registered successfully!");
            doctor.showPersonDetails();
        } else if (identityChoice == 2) {
            System.out.print("Enter patient's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter patient's age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter patient's health condition: ");
            String healthCondition = scanner.nextLine();
            System.out.print("Set a password for the patient: ");  // Ask for a password
            String password = scanner.nextLine();  // Store patient's password
    
            Patient patient = new Patient(name, age, healthCondition);
            patients.add(patient);
            saveUserData("Patient", patient.getName(), password);  // Save the password
            savePatientData(patient);  // Save the patient data to the file
            System.out.println("Patient registered successfully!");
            patient.showPersonDetails();
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void saveUserData(String identity, String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH, true))) {
            writer.write(identity + "," + username + "," + password);
            writer.newLine();
            System.out.println("User data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    private static void savePatientData(Patient patient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENT_FILE_PATH, true))) {
            writer.write(patient.getName() + "," + patient.getAge() + "," + patient.getHealthCondition());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving patient data: " + e.getMessage());
        }
    }

    private static void loadPatients() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENT_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] patientDetails = line.split(",");
                if (patientDetails.length == 3) {
                    String name = patientDetails[0];
                    int age = Integer.parseInt(patientDetails[1]);
                    String healthCondition = patientDetails[2];

                    Patient patient = new Patient(name, age, healthCondition);
                    patients.add(patient);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading patient data: " + e.getMessage());
        }
    }

    private static void login(Scanner scanner) {
        System.out.println("Designate your Identity:");
        System.out.println("1. Doctor");
        System.out.println("2. Patient");
        System.out.print("Enter your choice: ");

        int identityChoice = scanner.nextInt();
        scanner.nextLine();

        String identity = (identityChoice == 1) ? "Doctor" : (identityChoice == 2) ? "Patient" : null;

        if (identity != null) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (validateCredentials(identity, username, password)) {
                System.out.println("Login successful! Welcome, " + username + ".");
                if (identity.equals("Doctor")) {
                    doctorMenu(scanner); // Go to the Doctor's menu
                } else {
                    patientMenu(scanner, username); // Go to the Patient's menu
                }
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void doctorMenu(Scanner scanner) {
        boolean doctormain = true;

        while (doctormain) {
            System.out.println("\nDoctor Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Prescribe Medicine");
            System.out.println("3. Show Patient Details");
            System.out.println("4. Update Patient Details");
            System.out.println("5. View All Patients");
            System.out.println("6. Remove Patient");
            System.out.println("7. Exit to User Manager");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    prescribeMedicine(scanner);
                    break;
                case 3:
                    showPatientDetails(scanner);
                    break;
                case 4:
                    updatePatientDetails(scanner);
                    break;
                case 5:
                    viewAllPatients();
                    break;
                case 6:
                    removePatient(scanner);
                    break;
                case 7:
                    doctormain = false; // Exit to User Manager
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void patientMenu(Scanner scanner, String username) {
        boolean patientMain = true;

        while (patientMain) {
            System.out.println("\nPatient Menu:");
            System.out.println("1. View Your Details");
            System.out.println("2. Update Your Details");
            System.out.println("3. Exit to User Manager");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    viewYourDetails(username);
                    break;
                case 2:
                    updateYourDetails(scanner, username);
                    break;
                case 3:
                    patientMain = false; // Exit to User Manager
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static boolean validateCredentials(String identity, String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 3) {
                    if (userDetails[0].equals(identity) && userDetails[1].equals(username) && userDetails[2].equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error validating credentials: " + e.getMessage());
        }
        return false;
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter patient's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter patient's health condition: ");
        String healthCondition = scanner.nextLine();

        Patient patient = new Patient(name, age, healthCondition);
        patients.add(patient);
        savePatientData(patient);
        System.out.println("Patient added successfully!");
    }

    private static void prescribeMedicine(Scanner scanner) {
        System.out.print("Enter the patient's name: ");
        String patientName = scanner.nextLine();
        Patient patient = findPatientByName(patientName);
        
        if (patient != null) {
            System.out.print("Enter medicine name: ");
            String medicineName = scanner.nextLine();
            System.out.print("Enter dosage: ");
            String dosage = scanner.nextLine();
            Medicine medicine = new Medicine(medicineName, dosage);
            patient.prescribeMedicine(medicine);
            System.out.println("Medicine prescribed to " + patient.getName() + " successfully!");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void showPatientDetails(Scanner scanner) {
        System.out.print("Enter the patient's name: ");
        String patientName = scanner.nextLine();
        Patient patient = findPatientByName(patientName);
        
        if (patient != null) {
            patient.showPersonDetails();
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void updatePatientDetails(Scanner scanner) {
        System.out.print("Enter the patient's name to update: ");
        String patientName = scanner.nextLine();
        Patient patient = findPatientByName(patientName);
        
        if (patient != null) {
            System.out.print("Enter new age: ");
            int newAge = scanner.nextInt();
            scanner.nextLine();
            patient.setAge(newAge);
            System.out.print("Enter new health condition: ");
            String newCondition = scanner.nextLine();
            patient.setHealthCondition(newCondition);
            System.out.println("Patient details updated successfully!");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void viewAllPatients() {
        System.out.println("All Patients:");
        for (Patient patient : patients) {
            patient.showPersonDetails();
        }
    }

    private static void removePatient(Scanner scanner) {
        System.out.print("Enter the patient's name to remove: ");
        String patientName = scanner.nextLine();
        Patient patientToRemove = findPatientByName(patientName);
        
        if (patientToRemove != null) {
            patients.remove(patientToRemove);
            System.out.println("Patient " + patientName + " removed successfully!");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static Patient findPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    private static void viewYourDetails(String username) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(username)) {
                patient.showPersonDetails();
                return;
            }
        }
        System.out.println("Patient details not found.");
    }

    private static void updateYourDetails(Scanner scanner, String username) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(username)) {
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                patient.setAge(newAge);
                System.out.print("Enter new health condition: ");
                String newCondition = scanner.nextLine();
                patient.setHealthCondition(newCondition);
                System.out.println("Your details updated successfully!");
                return;
            }
        }
        System.out.println("Patient details not found.");
    }
}