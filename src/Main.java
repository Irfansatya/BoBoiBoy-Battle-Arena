import java.util.Scanner;

public class Main {

    // Scanner untuk input
    private static final Scanner input = new Scanner(System.in);

    // Membaca angka dengan validasi
    public static int bacaAngka(int min, int max) {
        while (true) {
            System.out.print("Pilihan: ");

            try {
                int pilihan = Integer.parseInt(input.nextLine());

                if (pilihan >= min && pilihan <= max) {
                    return pilihan;
                }

                System.out.println(
                        "Pilihan harus antara " + min + " - " + max + "."
                );

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    // Memilih kubu pemain
    public static int pilihKubu(String namaPemain) {
        System.out.println("\n================================");
        System.out.println(" PILIH KUBU " + namaPemain);
        System.out.println("================================");
        System.out.println("1. BoBoiBoy");
        System.out.println("2. Musuh");

        return bacaAngka(1, 2);
    }

    // Kubu pemain kedua otomatis berbeda
    public static int pilihKubuPemainKedua(int kubuPemain1) {
        System.out.println("\n================================");
        System.out.println(" PILIH KUBU PEMAIN 2");
        System.out.println("================================");

        if (kubuPemain1 == 1) {
            System.out.println(
                    "Pemain 2 otomatis menggunakan kubu Musuh."
            );
            return 2;
        } else {
            System.out.println(
                    "Pemain 2 otomatis menggunakan kubu BoBoiBoy."
            );
            return 1;
        }
    }

    // Memilih karakter BoBoiBoy
    public static Karakter pilihKarakterBoBoiBoy() {
        System.out.println("\n================================");
        System.out.println(" PILIH KARAKTER BOBOIBOY");
        System.out.println("================================");
        System.out.println("1. BoBoiBoy Gempa");
        System.out.println("2. BoBoiBoy Halilintar");
        System.out.println("3. BoBoiBoy Solar");
        System.out.println("4. BoBoiBoy Ice");
        System.out.println("5. Fang");
        System.out.println("6. Gopal");

        int pilihan = bacaAngka(1, 6);

        switch (pilihan) {
            case 1: {
                Penyerang penyerang =
                        new KarakterBoBoiBoy(
                                "B-001",
                                "BoBoiBoy Gempa",
                                150,
                                100,
                                22,
                                45,
                                "Tinju Gempa"
                        );
                return (Karakter) penyerang;
            }

            case 2: {
                Penyerang penyerang =
                        new KarakterBoBoiBoy(
                                "B-002",
                                "BoBoiBoy Halilintar",
                                120,
                                100,
                                28,
                                50,
                                "Sambaran Petir"
                        );
                return (Karakter) penyerang;
            }

            case 3: {
                Penyerang penyerang =
                        new KarakterBoBoiBoy(
                                "B-003",
                                "BoBoiBoy Solar",
                                125,
                                100,
                                25,
                                48,
                                "Solar Flare"
                        );
                return (Karakter) penyerang;
            }

            case 4: {
                Penyerang penyerang =
                        new KarakterBoBoiBoy(
                                "B-004",
                                "BoBoiBoy Ice",
                                135,
                                100,
                                23,
                                42,
                                "Serangan Es"
                        );
                return (Karakter) penyerang;
            }

            case 5: {
                Penyerang penyerang =
                        new KarakterBoBoiBoy(
                                "B-005",
                                "Fang",
                                130,
                                100,
                                25,
                                46,
                                "Serangan Bayangan"
                        );
                return (Karakter) penyerang;
            }

            case 6: {
                Penyerang penyerang =
                        new KarakterBoBoiBoy(
                                "B-006",
                                "Gopal",
                                145,
                                100,
                                20,
                                40,
                                "Serangan Makanan"
                        );
                return (Karakter) penyerang;
            }

            default:
                return null;
        }
    }

    // Memilih karakter musuh
    public static KarakterMusuh pilihKarakterMusuh() {
        System.out.println("\n================================");
        System.out.println(" PILIH KARAKTER MUSUH");
        System.out.println("================================");
        System.out.println("1. Ejo Jo");
        System.out.println("2. Adudu");
        System.out.println("3. Probe");
        System.out.println("4. Retak'ka");
        System.out.println("5. Bora Ra");

        int pilihan = bacaAngka(1, 5);

        switch (pilihan) {
            case 1: {
                Penyerang penyerang =
                        new KarakterMusuh(
                                "M-001",
                                "Ejo Jo",
                                130,
                                100,
                                25,
                                45,
                                "Serangan Teknologi"
                        );
                return (KarakterMusuh) penyerang;
            }

            case 2: {
                Penyerang penyerang =
                        new KarakterMusuh(
                                "M-002",
                                "Adudu",
                                115,
                                100,
                                22,
                                40,
                                "Serangan Senjata"
                        );
                return (KarakterMusuh) penyerang;
            }

            case 3: {
                Penyerang penyerang =
                        new KarakterMusuh(
                                "M-003",
                                "Probe",
                                120,
                                100,
                                24,
                                43,
                                "Serangan Laser"
                        );
                return (KarakterMusuh) penyerang;
            }

            case 4: {
                Penyerang penyerang =
                        new KarakterMusuh(
                                "M-004",
                                "Retak'ka",
                                170,
                                100,
                                30,
                                55,
                                "Kekuatan Elemen"
                        );
                return (KarakterMusuh) penyerang;
            }

            case 5: {
                Penyerang penyerang =
                        new KarakterMusuh(
                                "M-005",
                                "Bora Ra",
                                150,
                                100,
                                27,
                                48,
                                "Serangan Bora Ra"
                        );
                return (KarakterMusuh) penyerang;
            }

            default:
                return null;
        }
    }

    // Memilih karakter sesuai kubu
    public static Karakter pilihKarakter(int kubu) {
        if (kubu == 1) {
            return pilihKarakterBoBoiBoy();
        } else {
            return pilihKarakterMusuh();
        }
    }

    // Membuat referensi interface Penyerang
    public static Penyerang sebagaiPenyerang(Karakter karakter) {
        if (karakter instanceof Penyerang) {
            return (Penyerang) karakter;
        }

        return null;
    }

    // Menampilkan status pertarungan
    public static void tampilkanStatusPertarungan(
            Karakter pemain1,
            Karakter pemain2
    ) {
        System.out.println("\n================================");
        System.out.println("       STATUS PERTARUNGAN");
        System.out.println("================================");

        System.out.println("\nPEMAIN 1:");
        pemain1.tampilkanStatus();

        System.out.println("\nPEMAIN 2:");
        pemain2.tampilkanStatus();
    }

    // Menampilkan menu aksi
    public static void menuAksi() {
        System.out.println("\nPILIH AKSI:");
        System.out.println("1. Serang");
        System.out.println("2. Kemampuan Khusus");
        System.out.println("3. Bertahan");
        System.out.println("4. Lihat Status");
    }

    // Proses pertarungan
    public static void mulaiPertarungan(
            Karakter pemain1,
            Karakter pemain2
    ) {
        int giliran = 1;

        Penyerang penyerangPemain1 =
                sebagaiPenyerang(pemain1);

        Penyerang penyerangPemain2 =
                sebagaiPenyerang(pemain2);

        System.out.println("\n================================");
        System.out.println("       PERTARUNGAN DIMULAI");
        System.out.println("================================");

        while (pemain1.isAktif() && pemain2.isAktif()) {
            Karakter pemainAktif;
            Karakter target;
            Penyerang penyerangAktif;

            if (giliran == 1) {
                pemainAktif = pemain1;
                target = pemain2;
                penyerangAktif = penyerangPemain1;
            } else {
                pemainAktif = pemain2;
                target = pemain1;
                penyerangAktif = penyerangPemain2;
            }

            System.out.println("\n================================");
            System.out.println(" GILIRAN PEMAIN " + giliran);
            System.out.println("================================");

            System.out.println(
                    "Karakter: " + pemainAktif.getNama()
            );
            System.out.println(
                    "HP: " + pemainAktif.getHp()
            );
            System.out.println(
                    "Energi: " + pemainAktif.getEnergi()
            );

            menuAksi();

            int aksi = bacaAngka(1, 4);

            switch (aksi) {
                // Polimorfisme interface
                case 1:
                    penyerangAktif.serang(target);
                    break;

                case 2:
                    KemampuanKhusus kemampuan;

                    if (giliran == 1) {
                        kemampuan =
                                (KemampuanKhusus) pemain1;
                    } else {
                        kemampuan =
                                (KemampuanKhusus) pemain2;
                    }

                    kemampuan.gunakanKemampuan(target);
                    break;

                case 3:
                    Bertahan pertahanan;

                    if (giliran == 1) {
                        pertahanan =
                                (Bertahan) pemain1;
                    } else {
                        pertahanan =
                                (Bertahan) pemain2;
                    }

                    pertahanan.bertahan();
                    break;

                case 4:
                    tampilkanStatusPertarungan(
                            pemain1,
                            pemain2
                    );

                    // Melihat status tidak menghabiskan giliran
                    continue;
            }

            // Memeriksa pertarungan
            if (!pemain1.isAktif() || !pemain2.isAktif()) {
                break;
            }

            giliran = giliran == 1 ? 2 : 1;
        }

        // Menentukan pemenang
        tampilkanPemenang(
                pemain1,
                pemain2
        );
    }

    // Menampilkan pemenang
    public static void tampilkanPemenang(
            Karakter pemain1,
            Karakter pemain2
    ) {
        System.out.println("\n================================");
        System.out.println("       HASIL PERTARUNGAN");
        System.out.println("================================");

        if (pemain1.isAktif()) {
            System.out.println(
                    "PEMENANG: PEMAIN 1"
            );
            System.out.println(
                    "Karakter: " + pemain1.getNama()
            );
        } else {
            System.out.println(
                    "PEMENANG: PEMAIN 2"
            );
            System.out.println(
                    "Karakter: " + pemain2.getNama()
            );
        }

        System.out.println("\nStatus akhir:");
        pemain1.tampilkanStatus();
        pemain2.tampilkanStatus();

        // GAME OVER dihapus agar tampilan tetap seperti sebelumnya
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("       BOBOIBOY BATTLE ARENA");
        System.out.println("======================================");

        System.out.println(
                "Pertarungan antara BoBoiBoy dan Musuh!"
        );
        System.out.println(
                "Pilih karaktermu dan menangkan pertarungan!"
        );

        // Pemain 1 memilih kubu
        int kubuPemain1 =
                pilihKubu("PEMAIN 1");

        // Pemain 2 memilih kubu
        int kubuPemain2 =
                pilihKubuPemainKedua(kubuPemain1);

        // Pemain 1 memilih karakter
        System.out.println(
                "\nPEMAIN 1 MEMILIH KARAKTER"
        );

        Karakter pemain1 =
                pilihKarakter(kubuPemain1);

        // Pemain 2 memilih karakter
        System.out.println(
                "\nPEMAIN 2 MEMILIH KARAKTER"
        );

        Karakter pemain2 =
                pilihKarakter(kubuPemain2);

        // Menampilkan karakter terpilih
        System.out.println("\n================================");
        System.out.println("       KARAKTER TERPILIH");
        System.out.println("================================");

        System.out.println(
                "Pemain 1: " + pemain1.getNama()
        );
        System.out.println(
                "Pemain 2: " + pemain2.getNama()
        );

        // Menunggu Enter sebelum pertarungan
        System.out.println(
                "\nTekan ENTER untuk memulai pertarungan..."
        );

        input.nextLine();

        // Memulai pertarungan
        mulaiPertarungan(
                pemain1,
                pemain2
        );

        input.close();
    }
}