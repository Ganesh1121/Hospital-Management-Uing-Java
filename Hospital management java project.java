import java.util.ArrayList;
import java.util.Scanner;

class Person {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Patient extends Person {
    String disease;
    
    Patient(String name, int age, String disease) {
        super(name, age);
        this.disease = disease;
    }
    
    public String toString() {
        return "Patient: " + name + ", Age: " + age + ", Disease: " + disease;
    }
}

class Doctor extends Person {
    String specialty;
    
    Doctor(String name, int age, String specialty) {
        super(name, age);
        this.specialty = specialty;
    }
    
    public String toString() {
        return "Doctor: " + name + ", Age: " + age + ", Specialty: " + specialty;
    }
}

class Appointment {
    Patient patient;
    Doctor doctor;
    
    Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }
    
    public String toString() {
        return "Appointment: " + patient.name + " with Dr. " + doctor.name;
    }
}

public class HospitalManagement {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addPatient(); break;
                case 2: viewPatients(); break;
                case 3: addDoctor(); break;
                case 4: viewDoctors(); break;
                case 5: bookAppointment(); break;
                case 6: viewAppointments(); break;
                case 7: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void addPatient() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();
        patients.add(new Patient(name, age, disease));
        System.out.println("Patient added successfully!");
    }
    
    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }
    
    static void addDoctor() {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.nextLine();
        doctors.add(new Doctor(name, age, specialty));
        System.out.println("Doctor added successfully!");
    }
    
    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            for (Doctor d : doctors) {
                System.out.println(d);
            }
        }
    }
    
    static void bookAppointment() {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Cannot book appointment. Add patients and doctors first.");
            return;
        }
        
        System.out.println("Select Patient:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).name);
        }
        int patientIndex = scanner.nextInt() - 1;
        
        System.out.println("Select Doctor:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". Dr. " + doctors.get(i).name);
        }
        int doctorIndex = scanner.nextInt() - 1;
        
        appointments.add(new Appointment(patients.get(patientIndex), doctors.get(doctorIndex)));
        System.out.println("Appointment booked successfully!");
    }
    
    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            for (Appointment a : appointments) {
                System.out.println(a);
            }
        }
    }
}