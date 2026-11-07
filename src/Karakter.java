public abstract class Karakter {

    // Atribut immutable
    private final String id;

    // Atribut karakter
    private String nama;
    private int hp;
    private int hpMaksimal;
    private int energi;
    private int energiMaksimal;
    private int damageSerangan;
    private int damageKemampuan;
    private String namaKemampuan;

    private boolean aktif;
    private boolean sedangBertahan;

    // Constructor pertama
    public Karakter(
            String nama,
            int hp,
            int energi,
            int damageSerangan,
            int damageKemampuan,
            String namaKemampuan
    ) {

        this(
                "K-" + nama.toUpperCase().replace(" ", ""),
                nama,
                hp,
                energi,
                damageSerangan,
                damageKemampuan,
                namaKemampuan
        );

    }

    // Constructor kedua (overloading)
    public Karakter(
            String id,
            String nama,
            int hp,
            int energi,
            int damageSerangan,
            int damageKemampuan,
            String namaKemampuan
    ) {

        this.id = id;
        this.nama = nama;

        this.hpMaksimal = Math.max(1, hp);
        this.hp = this.hpMaksimal;

        this.energiMaksimal = Math.max(0, energi);
        this.energi = this.energiMaksimal;

        this.damageSerangan = Math.max(0, damageSerangan);
        this.damageKemampuan = Math.max(0, damageKemampuan);

        this.namaKemampuan = namaKemampuan;

        this.aktif = true;
        this.sedangBertahan = false;

    }

    // =========================
    // GETTER DAN SETTER ID
    // =========================

    public String getId() {
        return this.id;
    }

    // ID tidak memiliki setter karena bersifat final.

    // =========================
    // GETTER DAN SETTER NAMA
    // =========================

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        }
    }

    // =========================
    // GETTER DAN SETTER HP
    // =========================

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(
                0,
                Math.min(hp, this.hpMaksimal)
        );

        this.aktif = this.hp > 0;
    }

    public int getHpMaksimal() {
        return this.hpMaksimal;
    }

    public void setHpMaksimal(int hpMaksimal) {

        if (hpMaksimal > 0) {

            this.hpMaksimal = hpMaksimal;

            if (this.hp > hpMaksimal) {
                this.hp = hpMaksimal;
            }

        }

        this.aktif = this.hp > 0;
    }

    // =========================
    // GETTER DAN SETTER ENERGI
    // =========================

    public int getEnergi() {
        return this.energi;
    }

    public void setEnergi(int energi) {

        this.energi = Math.max(
                0,
                Math.min(energi, this.energiMaksimal)
        );

    }

    public int getEnergiMaksimal() {
        return this.energiMaksimal;
    }

    public void setEnergiMaksimal(int energiMaksimal) {

        if (energiMaksimal >= 0) {

            this.energiMaksimal = energiMaksimal;

            if (this.energi > energiMaksimal) {
                this.energi = energiMaksimal;
            }

        }

    }

    // =========================
    // GETTER DAN SETTER DAMAGE
    // =========================

    public int getDamageSerangan() {
        return this.damageSerangan;
    }

    public void setDamageSerangan(int damageSerangan) {
        this.damageSerangan = Math.max(0, damageSerangan);
    }

    public int getDamageKemampuan() {
        return this.damageKemampuan;
    }

    public void setDamageKemampuan(int damageKemampuan) {
        this.damageKemampuan = Math.max(0, damageKemampuan);
    }

    // =========================
    // GETTER DAN SETTER KEMAMPUAN
    // =========================

    public String getNamaKemampuan() {
        return this.namaKemampuan;
    }

    public void setNamaKemampuan(String namaKemampuan) {

        if (namaKemampuan != null && !namaKemampuan.trim().isEmpty()) {
            this.namaKemampuan = namaKemampuan;
        }

    }

    // =========================
    // GETTER DAN SETTER STATUS
    // =========================

    public boolean isAktif() {
        return this.aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif && this.hp > 0;
    }

    public boolean isSedangBertahan() {
        return this.sedangBertahan;
    }

    public void setSedangBertahan(boolean sedangBertahan) {
        this.sedangBertahan = sedangBertahan;
    }

    // =========================
    // METHOD PROSEDUR
    // MENERIMA SERANGAN
    // =========================

    public void terimaSerangan(int damage) {

        if (!this.aktif || damage <= 0) {
            return;
        }

        int damageDiterima = damage;

        if (this.sedangBertahan) {

            damageDiterima = damage
                    * (100 - GameConfig.PENGURANGAN_DAMAGE) / 100;

            this.sedangBertahan = false;

            System.out.println(
                    this.nama + " berhasil mengurangi damage!"
            );

        }

        this.hp -= damageDiterima;

        if (this.hp <= 0) {

            this.hp = 0;
            this.aktif = false;

        }

        System.out.println(
                this.nama + " menerima " + damageDiterima + " damage."
        );

        System.out.println(
                "HP tersisa " + this.nama + ": " + this.hp
        );

    }

    // =========================
    // METHOD FUNGSI
    // =========================

    public int hitungPersentaseHP() {

        return (this.hp * 100) / this.hpMaksimal;

    }

    // =========================
    // METHOD PROSEDUR
    // PEMULIHAN ENERGI
    // =========================

    public void pulihkanEnergi() {

        int energiLama = this.energi;

        this.energi = Math.min(
                this.energi + GameConfig.PEMULIHAN_ENERGI,
                this.energiMaksimal
        );

        System.out.println(
                this.nama + " memulihkan energi: "
                        + energiLama + " -> " + this.energi
        );

    }

    // =========================
    // ABSTRACT METHOD
    // =========================

    public abstract void gunakanKemampuan(Karakter target);

    // =========================
    // METHOD MENAMPILKAN STATUS
    // =========================

    public void tampilkanStatus() {

        System.out.println("--------------------------------");
        System.out.println("ID          : " + this.id);
        System.out.println("Nama        : " + this.nama);

        System.out.println(
                "HP          : " + this.hp
                        + "/" + this.hpMaksimal
        );

        System.out.println(
                "Energi      : " + this.energi
                        + "/" + this.energiMaksimal
        );

        System.out.println(
                "Damage      : " + this.damageSerangan
        );

        System.out.println(
                "Kemampuan   : " + this.namaKemampuan
        );

        System.out.println(
                "Status      : " + (this.aktif ? "Aktif" : "Kalah")
        );

        System.out.println("--------------------------------");

    }

}