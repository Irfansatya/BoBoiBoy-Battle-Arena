public class KarakterMusuh extends Karakter
        implements Penyerang, KemampuanKhusus, Bertahan {

    // Constructor pertama
    public KarakterMusuh(
            String nama,
            int hp,
            int energi,
            int damageSerangan,
            int damageKemampuan,
            String namaKemampuan
    ) {

        super(
                nama,
                hp,
                energi,
                damageSerangan,
                damageKemampuan,
                namaKemampuan
        );

    }

    // Constructor kedua (overloading)
    public KarakterMusuh(
            String id,
            String nama,
            int hp,
            int energi,
            int damageSerangan,
            int damageKemampuan,
            String namaKemampuan
    ) {

        super(
                id,
                nama,
                hp,
                energi,
                damageSerangan,
                damageKemampuan,
                namaKemampuan
        );

    }

    // =========================
    // METHOD SERANG
    // =========================

    @Override
    public void serang(Karakter target) {

        if (this.isAktif() && target.isAktif()) {

            System.out.println(
                    "\n" + this.getNama()
                            + " melakukan serangan dasar!"
            );

            target.terimaSerangan(
                    this.getDamageSerangan()
            );

        } else {

            System.out.println(
                    "Serangan tidak dapat dilakukan!"
            );

        }

    }

    // =========================
    // ABSTRACT METHOD
    // KEMAMPUAN KHUSUS
    // =========================

    @Override
    public void gunakanKemampuan(Karakter target) {

        System.out.println(
                "\n" + this.getNama()
                        + " mengeluarkan kemampuan "
                        + this.getNamaKemampuan() + "!"
        );

        if (!this.isAktif() || !target.isAktif()) {

            System.out.println(
                    "Kemampuan tidak dapat digunakan!"
            );

        } else if (
                this.getEnergi() >= GameConfig.BIAYA_KEMAMPUAN
        ) {

            this.setEnergi(
                    this.getEnergi() - GameConfig.BIAYA_KEMAMPUAN
            );

            target.terimaSerangan(
                    this.getDamageKemampuan()
            );

            System.out.println(
                    "Energi tersisa: " + this.getEnergi()
            );

        } else {

            System.out.println(
                    "Energi tidak mencukupi!"
            );

            this.pulihkanEnergi();

        }

    }

    // =========================
    // METHOD BERTAHAN
    // =========================

    @Override
    public void bertahan() {

        if (this.isAktif()) {

            this.setSedangBertahan(true);

            System.out.println(
                    this.getNama()
                            + " mengaktifkan pertahanan!"
            );

            System.out.println(
                    "Damage serangan berikutnya berkurang "
                            + GameConfig.PENGURANGAN_DAMAGE + "%."
            );

        } else {

            System.out.println(
                    "Karakter sudah kalah dan tidak dapat bertahan."
            );

        }

    }

    // =========================
    // METHOD OVERRIDING
    // =========================

    @Override
    public void tampilkanStatus() {

        System.out.println("\n=== STATUS KUBU MUSUH ===");

        super.tampilkanStatus();

    }

}