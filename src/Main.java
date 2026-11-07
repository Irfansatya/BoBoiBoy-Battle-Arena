
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    // ======================================
    // INPUT ANGKA
    // ======================================

    public static int bacaAngka(int min, int max) {
        int pilihan;

        while (true) {
            System.out.print("Masukkan pilihan: ");
            String teks = input.nextLine();

            try {
                pilihan = Integer.parseInt(teks);

                if (pilihan >= min && pilihan <= max) {
                    return pilihan;
                }

                System.out.println(
                        "Pilihan harus berada antara " + min + " dan " + max + "."
                );

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    // ======================================
    // PEMILIHAN KUBU
    // ======================================

    public static int pilihKubuPemainPertama() {
        System.out.println("\n================================");
        System.out.println(" PEMILIHAN KUBU PEMAIN 1");
        System.out.println("================================");
        System.out.println("1. Kubu BoBoiBoy");
        System.out.println("2. Kubu Musuh");

        return bacaAngka(1, 2);
    }

    public static int pilihKubuPemainKedua(int kubuPemainPertama) {
        System.out.println("\n================================");
        System.out.println(" PEMILIHAN KUBU PEMAIN 2");
        System.out.println("================================");
        System.out.println("1. Kubu BoBoiBoy");
        System.out.println("2. Kubu Musuh");

        int pilihan;

        do {
            pilihan = bacaAngka(1, 2);

            if (pilihan == kubuPemainPertama) {
                System.out.println(
                        "Kubu tidak tersedia! Pilih kubu yang berbeda dari Pemain 1."
                );
            }

        } while (pilihan == kubuPemainPertama);

        return pilihan;
    }

    public static String namaKubu(int kubu) {
        if (kubu == 1) {
            return "BoBoiBoy";
        }

        return "Musuh";
    }

    // ======================================
    // PEMILIHAN KARAKTER BOBOIBOY
    // ======================================

    public static Karakter pilihKarakterBoBoiBoy() {
        System.out.println("\n================================");
        System.out.println(" DAFTAR KARAKTER BOBOIBOY");
        System.out.println("================================");
        System.out.println("1. BoBoiBoy Gempa");
        System.out.println("2. BoBoiBoy Halilintar");
        System.out.println("3. BoBoiBoy Solar");
        System.out.println("4. BoBoiBoy Ice");
        System.out.println("5. Fang");
        System.out.println("6. Gopal");

        int pilihan = bacaAngka(1, 6);

        switch (pilihan) {
            case 1:
                return new KarakterBoBoiBoy(
                        "B-01", "BoBoiBoy Gempa",
                        150, 100, 22, 45, "Tinju Gempa"
                );

            case 2:
                return new KarakterBoBoiBoy(
                        "B-02", "BoBoiBoy Halilintar",
                        120, 100, 28, 50, "Sambaran Petir"
                );

            case 3:
                return new KarakterBoBoiBoy(
                        "B-03", "BoBoiBoy Solar",
                        125, 100, 25, 48, "Solar Flare"
                );

            case 4:
                return new KarakterBoBoiBoy(
                        "B-04", "BoBoiBoy Ice",
                        135, 100, 23, 42, "Serangan Es"
                );

            case 5:
                return new KarakterBoBoiBoy(
                        "B-05", "Fang",
                        130, 100, 25, 46, "Serangan Bayangan"
                );

            case 6:
                return new KarakterBoBoiBoy(
                        "B-06", "Gopal",
                        145, 100, 20, 40, "Serangan Makanan"
                );

            default:
                return null;
        }
    }

    // ======================================
    // PEMILIHAN KARAKTER MUSUH
    // ======================================

    public static Karakter pilihKarakterMusuh() {
        System.out.println("\n================================");
        System.out.println(" DAFTAR KARAKTER MUSUH");
        System.out.println("================================");
        System.out.println("1. Ejo Jo");
        System.out.println("2. Adudu");
        System.out.println("3. Probe");
        System.out.println("4. Retak'ka");
        System.out.println("5. Bora Ra");

        int pilihan = bacaAngka(1, 5);

        switch (pilihan) {
            case 1:
                return new KarakterMusuh(
                        "M-01", "Ejo Jo",
                        130, 100, 25, 45, "Serangan Teknologi"
                );

            case 2:
                return new KarakterMusuh(
                        "M-02", "Adudu",
                        115, 100, 22, 40, "Serangan Senjata"
                );

            case 3:
                return new KarakterMusuh(
                        "M-03", "Probe",
                        120, 100, 24, 43, "Serangan Laser"
                );

            case 4:
                return new KarakterMusuh(
                        "M-04", "Retak'ka",
                        170, 100, 30, 55, "Kekuatan Elemen"
                );

            case 5:
                return new KarakterMusuh(
                        "M-05", "Bora Ra",
                        150, 100, 27, 48, "Serangan Bora Ra"
                );

            default:
                return null;
        }
    }

    // ======================================
    // PEMILIHAN KARAKTER BERDASARKAN KUBU
    // ======================================

    public static Karakter pilihKarakter(int kubu) {
        if (kubu == 1) {
            return pilihKarakterBoBoiBoy();
        }

        return pilihKarakterMusuh();
    }

    // ======================================
    // 9. PENGUJIAN POLIMORFISME INTERFACE
    // ======================================

    public static void ujiPolimorfismeInterface() {
        System.out.println("\n================================");
        System.out.println(" 9. POLIMORFISME INTERFACE");
        System.out.println("================================");

        // Objek target untuk pengujian
        Karakter target = new KarakterMusuh(
                "M-TEST",
                "Musuh Pengujian",
                500,
                100,
                20,
                40,
                "Serangan Pengujian"
        );

        /*
         * Referensi bertipe interface Penyerang
         * dapat menampung objek KarakterBoBoiBoy.
         */
        Penyerang objGempa = new KarakterBoBoiBoy(
                "B-TEST",
                "BoBoiBoy Gempa",
                150,
                100,
                22,
                45,
                "Tinju Gempa"
        );

        /*
         * Referensi bertipe interface Penyerang
         * juga dapat menampung objek KarakterMusuh.
         */
        Penyerang objRetakka = new KarakterMusuh(
                "M-TEST2",
                "Retak'ka",
                170,
                100,
                30,
                55,
                "Kekuatan Elemen"
        );

        // Memanggil method melalui referensi interface
        System.out.println("\nPengujian objek BoBoiBoy Gempa:");
        objGempa.serang(target);

        System.out.println("\nPengujian objek Retak'ka:");
        objRetakka.serang(target);

        System.out.println("\nStatus target setelah pengujian:");
        target.tampilkanStatus();
    }

    // ======================================
    // MENU AKSI PEMAIN
    // ======================================

    public static void jalankanAksi(
            Karakter pemain,
            Karakter lawan,
            String namaPemain
    ) {
        boolean selesaiMemilih = false;

        while (!selesaiMemilih) {
            System.out.println("\n================================");
            System.out.println(" GILIRAN " + namaPemain.toUpperCase());
            System.out.println("================================");

            System.out.println("Karakter: " + pemain.getNama());
            System.out.println("Lawan   : " + lawan.getNama());

            System.out.println("\n1. Serang");
            System.out.println("2. Gunakan Kemampuan Khusus");
            System.out.println("3. Bertahan");
            System.out.println("4. Lihat Status");

            int pilihan = bacaAngka(1, 4);

            switch (pilihan) {
                case 1:
                    /*
                     * Polimorfisme interface:
                     * objek diperlakukan sebagai Penyerang.
                     */
                    Penyerang penyerang = (Penyerang) pemain;
                    penyerang.serang(lawan);

                    selesaiMemilih = true;
                    break;

                case 2:
                    /*
                     * Polimorfisme interface:
                     * objek diperlakukan sebagai KemampuanKhusus.
                     */
                    KemampuanKhusus kemampuan =
                            (KemampuanKhusus) pemain;

                    kemampuan.gunakanKemampuan(lawan);

                    selesaiMemilih = true;
                    break;

                case 3:
                    /*
                     * Polimorfisme interface:
                     * objek diperlakukan sebagai Bertahan.
                     */
                    Bertahan pertahanan = (Bertahan) pemain;
                    pertahanan.bertahan();

                    selesaiMemilih = true;
                    break;

                case 4:
                    System.out.println("\n--- STATUS PEMAIN ---");
                    pemain.tampilkanStatus();

                    System.out.println("\n--- STATUS LAWAN ---");
                    lawan.tampilkanStatus();

                    System.out.println(
                            "\nSilakan pilih aksi kembali. Giliran belum berakhir."
                    );
                    break;
            }
        }
    }

    // ======================================
    // MEKANISME PERTARUNGAN
    // ======================================

    public static void mulaiPertarungan(
            Karakter pemain1,
            Karakter pemain2
    ) {
        int giliran = 1;

        System.out.println("\n================================");
        System.out.println("       PERTARUNGAN DIMULAI");
        System.out.println("================================");

        System.out.println(
                "Pemain 1 menggunakan: " + pemain1.getNama()
        );

        System.out.println(
                "Pemain 2 menggunakan: " + pemain2.getNama()
        );

        while (
                pemain1.hitungPersentaseHP() > 0
                        && pemain2.hitungPersentaseHP() > 0
        ) {
            System.out.println("\n\n================================");
            System.out.println("          GILIRAN KE-" + giliran);
            System.out.println("================================");

            // Giliran Pemain 1
            if (
                    pemain1.hitungPersentaseHP() > 0
                            && pemain2.hitungPersentaseHP() > 0
            ) {
                jalankanAksi(pemain1, pemain2, "Pemain 1");
            }

            // Periksa apakah pertarungan sudah berakhir
            if (
                    pemain1.hitungPersentaseHP() <= 0
                            || pemain2.hitungPersentaseHP() <= 0
            ) {
                break;
            }

            // Giliran Pemain 2
            jalankanAksi(pemain2, pemain1, "Pemain 2");

            giliran++;
        }

        // ======================================
        // HASIL PERTARUNGAN
        // ======================================

        System.out.println("\n\n================================");
        System.out.println("       PERTARUNGAN SELESAI");
        System.out.println("================================");

        System.out.println("\n--- STATUS AKHIR PEMAIN 1 ---");
        pemain1.tampilkanStatus();

        System.out.println("\n--- STATUS AKHIR PEMAIN 2 ---");
        pemain2.tampilkanStatus();

        System.out.println("\n================================");
        System.out.println("          HASIL AKHIR");
        System.out.println("================================");

        if (
                pemain1.hitungPersentaseHP() <= 0
                        && pemain2.hitungPersentaseHP() <= 0
        ) {
            System.out.println("Pertarungan berakhir seri!");

        } else if (pemain2.hitungPersentaseHP() <= 0) {
            System.out.println("PEMENANG: PEMAIN 1");
            System.out.println("Karakter: " + pemain1.getNama());

        } else {
            System.out.println("PEMENANG: PEMAIN 2");
            System.out.println("Karakter: " + pemain2.getNama());
        }

        System.out.println("================================");
    }

    // ======================================
    // MAIN PROGRAM
    // ======================================

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("       BOBOIBOY BATTLE ARENA");
        System.out.println("================================");
        System.out.println("Game pertarungan dua pemain");
        System.out.println("Pilih karakter dan jadilah pemenang!");

        // Pengujian polimorfisme interface secara eksplisit
        // ujiPolimorfismeInterface();

        // ======================================
        // PEMILIHAN KUBU
        // ======================================

        int kubuPemain1 = pilihKubuPemainPertama();
        int kubuPemain2 = pilihKubuPemainKedua(kubuPemain1);

        System.out.println("\n================================");
        System.out.println("         KUBU TERPILIH");
        System.out.println("================================");

        System.out.println(
                "Pemain 1 memilih kubu " + namaKubu(kubuPemain1)
        );

        System.out.println(
                "Pemain 2 memilih kubu " + namaKubu(kubuPemain2)
        );

        // ======================================
        // PEMILIHAN KARAKTER
        // ======================================

        System.out.println("\n================================");
        System.out.println("       PEMILIHAN KARAKTER");
        System.out.println("================================");

        System.out.println("\nPemain 1 memilih karakter:");
        Karakter pemain1 = pilihKarakter(kubuPemain1);

        System.out.println("\nPemain 2 memilih karakter:");
        Karakter pemain2 = pilihKarakter(kubuPemain2);

        // ======================================
        // KONFIRMASI KARAKTER
        // ======================================

        System.out.println("\n================================");
        System.out.println("       KARAKTER TERPILIH");
        System.out.println("================================");

        System.out.println("\nPemain 1:");
        pemain1.tampilkanStatus();

        System.out.println("\nPemain 2:");
        pemain2.tampilkanStatus();

        // ======================================
        // MEMULAI PERTARUNGAN
        // ======================================

        System.out.println("\nTekan Enter untuk memulai pertarungan...");
        input.nextLine();

        mulaiPertarungan(pemain1, pemain2);

        System.out.println("\nTerima kasih telah memainkan");
        System.out.println("BOBOIBOY BATTLE ARENA!");

        input.close();
    }
}
