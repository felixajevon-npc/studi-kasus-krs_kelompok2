import java.util.Scanner;

public class menu1 {
    public static void dataKrs() {
        Scanner sc = new Scanner(System.in);

        String namaMahasiswa, namaMataKuliah, pilihan, kodeMataKuliah;
        int nim, jumlahSKS;
        int totalSKS = 0;

        System.out.println("--- Tambah Data KRS ---");
        System.out.print("Nama mahasiswa: ");
        namaMahasiswa = sc.nextLine();
        System.out.print("NIM: ");
        nim = sc.nextInt();
        sc.nextLine();

        do {
            System.out.print("Kode Mata Kuliah: ");
            kodeMataKuliah = sc.nextLine();
            System.out.print("Nama Mata Kuliah: ");
            namaMataKuliah = sc.nextLine();
            do {
                System.out.print("Jumlah SKS (1-3): ");
                jumlahSKS = sc.nextInt();
                sc.nextLine();

                if (jumlahSKS < 1 || jumlahSKS > 3) {
                    System.out.print("Jumlah SKS tidak valid! Silakan input kembali. ");
                }
            } while (jumlahSKS < 1 || jumlahSKS > 3);

            totalSKS += jumlahSKS;

            System.out.print("Tambah Mata Kuliah lain? (y/n): ");
            pilihan = sc.nextLine();
        } while (pilihan.equalsIgnoreCase("y"));

        System.out.println("\nNama mahasiswa: " + namaMahasiswa);
        System.out.println("NIM: " + nim);
        System.out.println("Kode Mata Kuliah: " + kodeMataKuliah);
        System.out.println("Nama Mata Kuliah: " + namaMataKuliah);
        System.out.println("Total SKS: " + totalSKS);
        System.out.println("Data Kuliah Berhasil Ditambahkan.");
    }

    public static void main(String[] args) {
        dataKrs();
    }
}