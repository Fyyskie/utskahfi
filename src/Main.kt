fun main() {

    val pelanggan = Pelanggan(5000)
    val mesin = MesinPrint(5, 5)
    val dokumen = Dokumen(10)

    mesin.cetakDokumen(dokumen, pelanggan)
}

// ================= CLASS PELANGGAN =================
class Pelanggan(private var saldo: Int) {

    fun getSaldo(): Int {
        return saldo
    }

    fun bayar(jumlah: Int): Boolean {
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

        // Validasi sederhana (belum lengkap)
        if (tinta == 0 || kertas == 0) {
            println("❌ Gagal: Mesin tidak siap!")
            return
        }

        if (!pelanggan.bayar(totalBiaya)) {
            println("❌ Gagal: Saldo tidak cukup!")
            return
        }

        // Proses cetak
        tinta -= dokumen.jumlahHalaman
        kertas -= dokumen.jumlahHalaman

        println("✅ Cetak berhasil")
        println("Sisa saldo: Rp${pelanggan.getSaldo()}")
    }
}