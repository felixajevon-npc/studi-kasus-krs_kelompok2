import java.util.Scanner;

public class menu2 {
    static String[][] daftarKrs = new String[100][5];
    static int jumlahData = 0;

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

    public static void tampilkanDaftarKRS() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Tampilkan Daftar KRS Mahasiswa ---");
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = sc.nextLine();

        System.out.println("-------------------------------------------------------------");
        System.out.println("NIM       \tNama        \tKode MK\tNama Mata Kuliah    \tSKS");
        System.out.println("-------------------------------------------------------------");

        boolean ditemukan = false;
        int totalSKS = 0;

        for (int i = 0; i < jumlahData; i++) {
            if (daftarKrs[i][0].equals(nim)) {
                System.out.printf("%-10s\t%-10s\t%-8s\t%-20s\t%s\n",
                        daftarKrs[i][0], daftarKrs[i][1], daftarKrs[i][2], daftarKrs[i][3], daftarKrs[i][4]);
                totalSKS += Integer.parseInt(daftarKrs[i][4]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data KRS tidak ditemukan.");
        } else {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Total SKS: " + totalSKS);
        }
    }
}