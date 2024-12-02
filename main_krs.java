import java.util.Scanner;

public class main_krs {
    static String[][] daftarKrs = new String[100][5];
    static int jumlahData = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ulang = true;

        while (ulang) {
            System.out.println("=== Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah Data KRS");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4) : ");
            int pilihMenu = sc.nextInt();

            if (pilihMenu < 1 || pilihMenu > 4) {
                System.out.println("Pilihan Menu Tidak Valid! Tolong Input Ulang.");
                continue;
            }

            switch (pilihMenu) {
                case 1:
                    tambahDataKRS();
                    break;
                case 2:
                    tampilkanDaftarKRS();
                    break;
                case 3:
                    analisisDataKRS();
                    break;
                case 4:
                    System.out.print("Apakah Anda Yakin Ingin Keluar? (y/n): ");
                    sc.nextLine();
                    String konfirmasi = sc.nextLine();
                    if (konfirmasi.equalsIgnoreCase("y")) {
                        ulang = false;
                        System.out.println("Program Selesai.");
                    } else {
                        System.out.println("Kembali ke Menu Utama.");
                    }
                    break;
            }
        }
    }

    public static void tambahDataKRS() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Tambah Data KRS ---");
        System.out.print("Nama mahasiswa: ");
        String namaMahasiswa = sc.nextLine();
        System.out.print("NIM: ");
        String nim = sc.nextLine();

        int totalSKS = 0;
        String pilihan;

        do {
            System.out.print("Kode Mata Kuliah: ");
            String kodeMataKuliah = sc.nextLine();
            System.out.print("Nama Mata Kuliah: ");
            String namaMataKuliah = sc.nextLine();

            int jumlahSKS;
            do {
                System.out.print("Jumlah SKS (1-3): ");
                jumlahSKS = sc.nextInt();
                sc.nextLine();

                if (jumlahSKS < 1 || jumlahSKS > 3) {
                    System.out.println("Jumlah SKS tidak valid! Silakan input kembali.");
                }
            } while (jumlahSKS < 1 || jumlahSKS > 3);

            if (totalSKS + jumlahSKS > 24) {
                System.out.println("Error: Total SKS yang diambil mahasiswa tidak boleh lebih dari 24.");
                System.out.println("Silakan kurangi jumlah SKS atau ganti mata kuliah.");
            } else {
                daftarKrs[jumlahData][0] = nim;
                daftarKrs[jumlahData][1] = namaMahasiswa;
                daftarKrs[jumlahData][2] = kodeMataKuliah;
                daftarKrs[jumlahData][3] = namaMataKuliah;
                daftarKrs[jumlahData][4] = String.valueOf(jumlahSKS);

                totalSKS += jumlahSKS;
                jumlahData++;
            }

            System.out.print("Tambah Mata Kuliah lain? (y/n): ");
            pilihan = sc.nextLine();
        } while (pilihan.equalsIgnoreCase("y"));

        System.out.println("Data KRS Berhasil Ditambahkan!");
    }

    public static void tampilkanDaftarKRS() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Tampilkan Daftar KRS Mahasiswa ---");
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = sc.nextLine();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-25s %s\n",
                "NIM", "Nama", "Kode MK", "Nama Mata Kuliah", "SKS");
        System.out.println("---------------------------------------------------------------------------------------");

        boolean ditemukan = false;
        int totalSKS = 0;

        for (int i = 0; i < jumlahData; i++) {
            if (daftarKrs[i][0].equals(nim)) {
                System.out.printf("%-10s %-15s %-15s %-25s %s\n",
                        daftarKrs[i][0], daftarKrs[i][1], daftarKrs[i][2], daftarKrs[i][3], daftarKrs[i][4]);
                totalSKS += Integer.parseInt(daftarKrs[i][4]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data KRS tidak ditemukan.");
        } else {
            System.out
                    .println("---------------------------------------------------------------------------------------");
            System.out.println("Total SKS: " + totalSKS);
        }
    }

    public static void analisisDataKRS() {
        System.out.println("\n--- Analisis Data KRS: Mahasiswa dengan Total SKS < 20 ---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s\n", "NIM", "Nama", "Total SKS");
        System.out.println("---------------------------------------------------------------------------------------");

        String[][] mahasiswa = new String[jumlahData][3];
        int jumlahMahasiswa = 0;

        for (int i = 0; i < jumlahData; i++) {
            String nim = daftarKrs[i][0];
            String nama = daftarKrs[i][1];
            int sks = Integer.parseInt(daftarKrs[i][4]);

            boolean sudahDihitung = false;

            for (int j = 0; j < jumlahMahasiswa; j++) {
                if (mahasiswa[j][0].equals(nim)) {
                    mahasiswa[j][2] = String.valueOf(Integer.parseInt(mahasiswa[j][2]) + sks);
                    sudahDihitung = true;
                    break;
                }
            }

            if (!sudahDihitung) {
                mahasiswa[jumlahMahasiswa][0] = nim;
                mahasiswa[jumlahMahasiswa][1] = nama;
                mahasiswa[jumlahMahasiswa][2] = String.valueOf(sks);
                jumlahMahasiswa++;
            }
        }

        boolean ditemukan = false;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            int totalSKS = Integer.parseInt(mahasiswa[i][2]);
            if (totalSKS < 20) {
                System.out.printf("%-10s %-15s %-15d\n", mahasiswa[i][0], mahasiswa[i][1], totalSKS);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada mahasiswa yang mengambil SKS kurang dari 20.");
        }

        System.out.println("---------------------------------------------------------------------------------------");
    }

}
