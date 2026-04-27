package MP1andMP2;

import java.time.LocalDate;
import java.util.*;

public class Patient extends Person {
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<Patient> patientList = new ArrayList<>();

    private ArrayList<MedicalNotes> medicalNotesList = new ArrayList<>();
    private ArrayList<Appointment> appointmentList = new ArrayList<>();

    static { loadPatient(); }

    public Patient(String name, String middleName, String surname, LocalDate dateOfBirth, String gender, Address homeAddress, String pesel) {
        super(name, middleName, surname, dateOfBirth, gender, homeAddress, pesel);

        patientList.add(this);
    }

    public List<MedicalNotes> getMedicalNotesList() {
        return Collections.unmodifiableList(medicalNotesList);
    }

    public void addMedicalNotes(MedicalNotes newMedicalNotes) {
        if (this.medicalNotesList.contains(newMedicalNotes)) return;
        Objects.requireNonNull(newMedicalNotes, "MP1andMP2.MedicalNotes cannot be null");

        this.medicalNotesList.add(newMedicalNotes);

        newMedicalNotes.setPatient(this);
    }

    public void removeMedicalNotes(MedicalNotes medicalNotes) {
        if (!this.medicalNotesList.contains(medicalNotes)) return;
        Objects.requireNonNull(medicalNotes, "MP1andMP2.MedicalNotes cannot be null");

        this.medicalNotesList.remove(medicalNotes);

        medicalNotes.delete();
    }

    public List<Appointment> getAppointmentList() {
        return Collections.unmodifiableList(appointmentList);
    }

    public void addAppointment(Appointment newAppointment) {
        if (this.appointmentList.contains(newAppointment)) return;
        Objects.requireNonNull(newAppointment, "MP1andMP2.Appointment cannot be null");

        this.appointmentList.add(newAppointment);
        newAppointment.setPatient(this);
    }

    public void removeAppointment(Appointment appointment) {
        if (!this.appointmentList.contains(appointment)) return;
        Objects.requireNonNull(appointment, "MP1andMP2.Appointment cannot be null");

        this.appointmentList.remove(appointment);

        appointment.delete();
    }

    public void delete(){
        List<MedicalNotes> notesToDelete = new ArrayList<>(this.medicalNotesList);
        List<Appointment> appointmentsToDelete = new ArrayList<>(this.appointmentList);
        for (MedicalNotes notes : notesToDelete) {
            notes.delete();
        }
        for (Appointment appointment : appointmentsToDelete) {
            appointment.delete();
        }
        patientList.remove(this);
    }

    @Override
    public String getDetails(){
        return super.getDetails() + " - MP1andMP2.Patient";
    }

    public static void loadPatient(){
        patientList = Extent.loadClassList(FILE_NAME);
    }

    public static void savePatient(){
        Extent.saveClassList(FILE_NAME, patientList);
    }

    public static List<Patient> getPatientList(){
        return Extent.getImmutableClassList(patientList);
    }
}
