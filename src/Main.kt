fun main() {

    println("===== SIMULASI 1: TINTA HABIS =====")
    val pelanggan1 = Pelanggan(10000)
    val mesin1 = MesinPrint(0, 10)
    val dokumen1 = Dokumen(5)
    mesin1.cetakDokumen(dokumen1, pelanggan1)

    println("\n===== SIMULASI 2: KERTAS HABIS =====")
    val pelanggan2 = Pelanggan(10000)
    val mesin2 = MesinPrint(10, 0)
    val dokumen2 = Dokumen(5)
    mesin2.cetakDokumen(dokumen2, pelanggan2)

    println("\n===== SIMULASI 3: SALDO TIDAK CUKUP =====")
    val pelanggan3 = Pelanggan(1000)
    val mesin3 = MesinPrint(10, 10)
    val dokumen3 = Dokumen(5)
    mesin3.cetakDokumen(dokumen3, pelanggan3)

    println("\n===== SIMULASI 4: TRANSAKSI SUKSES =====")
    val pelanggan4 = Pelanggan(10000)
    val mesin4 = MesinPrint(10, 10)
    val dokumen4 = Dokumen(5)
    mesin4.cetakDokumen(dokumen4, pelanggan4)
}

// ================= CLASS PELANGGAN =================
class Pelanggan(private var saldo: Int) {

    fun getSaldo(): Int {
        return saldo
    }

    // Custom Setter (Jalur Resmi Pembayaran)
    fun bayar(jumlah: Int): Boolean {
        if (jumlah <= 0) {
            println("❌ Error: Jumlah pembayaran tidak valid!")
            return false
        }

        return if (jumlah <= saldo) {
            saldo -= jumlah
            true
        } else {
            false
        }
    }
}

// ================= CLASS DOKUMEN =================
class Dokumen(val jumlahHalaman: Int)

// ================= CLASS MESIN PRINT =================
class MesinPrint(private var tinta: Int, private var kertas: Int) {

    private val hargaPerLembar = 500

    fun cetakDokumen(dokumen: Dokumen, pelanggan: Pelanggan) {

        val totalBiaya = dokumen.jumlahHalaman * hargaPerLembar

        println("Mencetak ${dokumen.jumlahHalaman} halaman")
        println("Total biaya: Rp$totalBiaya")

        // VALIDASI 1: Tinta
        if (tinta == 0) {
            println("❌ Gagal: Tinta habis!")
            return
        }

        // VALIDASI 2: Kertas
        if (kertas == 0) {
            println("❌ Gagal: Kertas habis!")
            return
        }

        // VALIDASI 3: Saldo
        if (!pelanggan.bayar(totalBiaya)) {
            println("❌ Gagal: Saldo tidak mencukupi!")
            return
        }

        // PROSES CETAK
        tinta -= dokumen.jumlahHalaman
        kertas -= dokumen.jumlahHalaman

        println("✅ Cetak berhasil!")
        println("Sisa saldo: Rp${pelanggan.getSaldo()}")
        println("Sisa tinta: $tinta")
        println("Sisa kertas: $kertas")

    }
}