package hospital.com;

import java.util.ArrayList;

public class HospitalManagementSystem {

	private ArrayList<Patient> patients;
	private ArrayList<Doctor> doctors;
	private ArrayList<Appointment> appointments;

	public HospitalManagementSystem() {
		patients = new ArrayList<>();
		doctors = new ArrayList<>();
		appointments = new ArrayList<>();
	}

	// add a new patient
	public void addPatient(String name, int age, String gender, String contact) throws InvalidAgeException {
		if (age <= 0 || age > 150) {
			throw new InvalidAgeException("Invalid age. Please enter a valid age.");
		}
		Patient patient = new Patient(name, age, gender, contact);
		patients.add(patient);
		System.out.println("Patient added successfully.");
	}

	// add a new doctor
	public void addDoctor(String name, String specialization, String contact) {
		Doctor doctor = new Doctor(name, specialization, contact);
		doctors.add(doctor);
		System.out.println("Doctor added successfully.");
	}

	// schedule an appointment
	public void scheduleAppointment(String date, String time, Patient patient, Doctor doctor) {
		Appointment appointment = new Appointment(date, time, patient, doctor);
		appointments.add(appointment);
		System.out.println("Appointment scheduled successfully.");
	}

	// Display of Patient
	public void displayPatients() {
		System.out.println("List of Patients:");
		for (Patient patient : patients) {
			System.out.println("Name: " + patient.getName() + ", Age: " + patient.getAge() + ", Gender: "
					+ patient.getGender() + ", Contact: " + patient.getContact());
		}
	}

	// Display of Doctor
	public void displayDoctors() {
		System.out.println("List of Doctors:");
		for (Doctor doctor : doctors) {
			System.out.println("Name: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization()
					+ ", Contact: " + doctor.getContact());
		}
	}

	// DISPLAY OF APPOINTMENTS
	public void displayAppointments() {
		System.out.println("List of Appointments:");
		for (Appointment appointment : appointments) {
			System.out.println("Date: " + appointment.getDate() + ", Time: " + appointment.getTime() + ", Patient: "
					+ appointment.getPatient().getName() + ", Doctor: " + appointment.getDoctor().getName());
		}
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}
}
