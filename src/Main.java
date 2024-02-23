import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama: ");
        String agus = scanner.nextLine();

        String gender;
        while (true) {
            System.out.print("Jenis Kelamin (L/P): ");
            gender = scanner.nextLine();
            switch (gender.toLowerCase()) {
                case "l":
                case "laki-laki":
                case "p":
                case "perempuan":
                    break;
                default:
                    System.out.println("Input salah, silakan masukkan kembali (L/P)");
                    continue;
            }
            break;
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate;
        while (true) {
            try {
                System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
                String birthDateInput = scanner.nextLine();
                birthDate = LocalDate.parse(birthDateInput, dateFormatter);
                break;
            } catch (Exception e) {
                System.out.println("Format tanggal salah, silakan masukkan kembali");
            }
        }

        LocalDate currentDate = LocalDate.now();
        Period agePeriod = Period.between(birthDate, currentDate);

        System.out.println("Nama: " +agus );
        System.out.println("Jenis Kelamin: " + (gender.equalsIgnoreCase("L") ? "Laki-laki" : "Perempuan"));
        System.out.println("Umur Anda: " + agePeriod.getYears() + " tahun " + agePeriod.getMonths() + " bulan");
    }
}