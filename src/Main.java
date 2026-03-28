import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- KALICILIK (PERSISTENCE) TESTİ ---\n");

        // Sistemdeki mevcut hastaları al (Patient sınıfındaki static block sayesinde otomatik yüklenir)
        List<Patient> patients = Patient.getPatientList();

        // Eğer liste boşsa (ilk çalışma veya dosya silinmişse)
        if (patients.isEmpty()) {
            System.out.println(" Durum: Sistemde hiç hasta bulunamadı (Dosya boş veya yok).");
            System.out.println(" Eylem: Yeni hastalar oluşturuluyor ve kaydediliyor...\n");

            // 1. Yeni veriler oluştur
            Address address1 = new Address("Poland", "Warsaw", "Polwar", "8/10", "01-234");
            Patient patient1 = new Patient("John", "Robert", "Doe", LocalDate.of(1985, 8, 15), "Male", address1);
            patient1.addPhoneNumber("+15551234567");

            Address address2 = new Address("Turkey", "Istanbul", "Kadikoy", "12/4", "34000");
            Patient patient2 = new Patient("Jane", "", "Smith", LocalDate.of(1992, 11, 23), "Female", address2);

            // DİKKAT: Sınıflarındaki constructor'larda save() metodunu çağırmadığın için
            // nesne oluşturduktan sonra ilk kaydı manuel tetiklememiz gerekiyor.
            Patient.savePatient();
            Person.savePerson();

            System.out.println(" Sonuç: Yeni hastalar başarıyla oluşturuldu ve serileştirildi!");
            System.out.println(" TEST ADIMI: Şimdi programı durdurun ve HİÇBİR KODU DEĞİŞTİRMEDEN tekrar çalıştırın.");

        }
        // Eğer liste doluysa (ikinci veya sonraki çalışmalar)
        else {
            System.out.println(" Durum: Önceki kayıtlar dosyadan başarıyla yüklendi!");
            System.out.println(" Yüklenen Hasta Sayısı: " + patients.size());
            System.out.println(" Static Sayaç (totalPatientCount): " + Patient.getTotalPatients() + "\n");

            System.out.println("--- Yüklenen Hastaların Detayları ---");
            for (Patient p : patients) {
                System.out.println(p.getDetails());
                System.out.println("   Yaş: " + p.getAge());
                System.out.println("   Telefon: " + (p.getPhoneNumber().isEmpty() ? "Yok" : p.getPhoneNumber()));
                System.out.println("   İkinci Ad: " + p.getMiddleName().orElse("Belirtilmemiş"));
                System.out.println("-------------------------------------");
            }

            System.out.println("\n Test Başarılı! Nesneler program kapatılıp açılmasına rağmen korunuyor.");
        }
    }
}