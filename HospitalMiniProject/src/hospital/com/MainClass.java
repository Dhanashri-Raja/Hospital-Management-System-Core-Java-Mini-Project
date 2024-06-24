package hospital.com;

import java.util.InputMismatchException;
import java.util.Scanner;

//Main class
public class MainClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HospitalManagementSystem hms = new HospitalManagementSystem();
		while (true) {
			System.out.println("*****WELCOME TO RK HOSPITAL*****");
			System.out.println("Hospital Management System Entry:");
			System.out.println("1. Add Patient");
			System.out.println("2. Add Doctor");
			System.out.println("3. Schedule Appointment");
			System.out.println("4. Display Patients");
			System.out.println("5. Display Doctors");
			System.out.println("6. Display Appointments");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			try {
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					System.out.print("Enter patient name: ");
					String patientName = scanner.nextLine();
					System.out.print("Enter patient age: ");
					int patientAge = scanner.nextInt();
					scanner.nextLine();
					if (patientAge <= 0 || patientAge > 150) {
						throw new InvalidAgeException("Invalid age. Please enter a valid age.");
					}
					System.out.print("Enter patient gender: ");
					String patientGender = scanner.nextLine();
					System.out.print("Enter patient contact: ");
					String patientContact = scanner.nextLine();
					hms.addPatient(patientName, patientAge, patientGender, patientContact);
					break;
				case 2:
					System.out.print("Enter doctor name: ");
					String doctorName = scanner.nextLine();
					System.out.print("Enter doctor specialization: ");
					String doctorSpecialization = scanner.nextLine();
					System.out.print("Enter doctor contact: ");
					String doctorContact = scanner.nextLine();
					hms.addDoctor(doctorName, doctorSpecialization, doctorContact);
					break;
				case 3:
					hms.displayPatients();
					System.out.print("Enter patient index to select for appointment: ");
					int patientIndex = scanner.nextInt();
					scanner.nextLine();
					hms.displayDoctors();
					System.out.print("Enter doctor index to select for appointment: ");
					int doctorIndex = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter appointment date (YYYY-MM-DD): ");
					String appointmentDate = scanner.nextLine();
					System.out.print("Enter appointment time (HH:MM): ");
					String appointmentTime = scanner.nextLine();
					hms.scheduleAppointment(appointmentDate, appointmentTime, hms.getPatients().get(patientIndex),
							hms.getDoctors().get(doctorIndex));
					break;
				case 4:
					hms.displayPatients();
					break;
				case 5:
					hms.displayDoctors();
					break;
				case 6:
					hms.displayAppointments();
					break;
				case 7:
					System.out.println("Exiting Hospital Management System. Goodbye!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine();
			} catch (InvalidAgeException e) {
				System.out.println(e.getMessage());
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Invalid index. Please select a valid index.");
			}
		}
	}
}
