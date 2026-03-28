import java.time.LocalDate;
import java.time.Period;
import java.util.*;

abstract public class Person implements Extent {
    private static final String FILE_NAME = "Person.ser";
    private static ArrayList<Person> personList = new ArrayList<>();

    static { loadPerson(); }

    private String name;
    private String middleName;
    private String surname;
    private LocalDate dateOfBirth;
    private String gender;
    private Set<String> phoneNumber =  new HashSet<String>();
    private Address homeAddress;

    public Person(String name, String middleName, String surname, LocalDate dateOfBirth, String gender, Address homeAddress) {
        Validation.validateString(name, "Person name cannot be empty or null.");
        Validation.validateString(surname, "Person surname cannot be empty or null.");
        Validation.validateString(gender, "Person gender cannot be empty or null.");
        Validation.validateBirthDate(dateOfBirth, "Person dateOfBirth cannot be empty or null.");

        this.name = name;
        this.setMiddleName(middleName);
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.homeAddress = homeAddress;

        personList.add(this);
        savePerson();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Validation.validateString(name, "Person name cannot be empty or null.");
        this.name = name;
        savePerson();
    }

    public Optional<String> getMiddleName() {
        return (middleName == null || middleName.isEmpty()) ? Optional.empty() : Optional.of(middleName);
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
        savePerson();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        Validation.validateString(surname, "Person surname cannot be empty or null.");
        this.surname = surname;
        savePerson();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        Validation.validateBirthDate(dateOfBirth, "Person dateOfBirth cannot be empty or null.");
        this.dateOfBirth = dateOfBirth;
        savePerson();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        Validation.validateString(gender, "Person gender cannot be empty or null.");
        this.gender = gender;
        savePerson();
    }

    public void addPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber.add(phoneNumber);
            savePerson();
        }
    }

    public Set<String> getPhoneNumber() {
        return Collections.unmodifiableSet(this.phoneNumber);
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
        return "Name: " + name + " - Surname: " + surname + " - Gender: " + gender;
    }

    public static void loadPerson(){
        personList = Extent.loadClassList(FILE_NAME);
    }

    public static List<Person> getPersonList(){
        return Extent.getImmutableClassList(personList);
    }

    public static void savePerson(){
        Extent.saveClassList(FILE_NAME, personList);
    }
}
