import java.time.LocalDate;
import java.time.Period;
import java.util.*;

abstract public class Person {
    private String name;
    private String middleName;
    private String surname;
    private LocalDate dateOfBirth;
    private String gender;
    private Set<String> phoneNumber =  new HashSet<String>();
    public static int totalPersonCount;

    public Person(String name, String middleName, String surname, LocalDate dateOfBirth, String gender) {
        Validation.validateString(name, "Person name cannot be empty or null.");
        Validation.validateString(surname, "Person surname cannot be empty or null.");
        Validation.validateString(gender, "Person gender cannot be empty or null.");
        Validation.validateBirthDate(dateOfBirth, "Person dateOfBirth cannot be empty or null.");

        this.name = name;
        this.setMiddleName(middleName);
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        totalPersonCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getMiddleName() {
        return (middleName == null || middleName.isEmpty()) ? Optional.empty() : Optional.of(middleName);
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber.add(phoneNumber);
        }
    }

    public Set<String> getPhoneNumber() {
        return Collections.unmodifiableSet(this.phoneNumber);
    }

    public static int getTotalPersonCount() {
        return totalPersonCount;
    }

    public void scheduleAppointment(Date appointmentDate) {
        scheduleAppointment(appointmentDate, "-");
    }

    public void scheduleAppointment(Date appointmentDate, String note) {
        System.out.println("Appointment date: " + appointmentDate + " | Note: " + note);
    }

    public int getAge() {
        return (dateOfBirth == null) ? 0 : Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public String getDetails(){
        return "Name: " + name + " Surname: " + surname + " Gender: " + gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
