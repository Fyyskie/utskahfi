fun main() {

    // Objek
    val pelanggan = Pelanggan(3000)
    val mesin = MesinPrint(5, 5)

    val dokumenGagal = Dokumen(10)
    val dokumenSukses = Dokumen(2)

    println("===== SIMULASI GAGAL =====")
    mesin.cetakDokumen(dokumenGagal, pelanggan)

    println("\n===== SIMULASI SUKSES =====")
    mesin.cetakDokumen(dokumenSukses, pelanggan)
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

        // ATURAN 1: cek tinta & kertas
        if (tinta == 0 || kertas == 0) {
            println("❌ Gagal: Tinta atau kertas habis!")
            return
        }

        // ATURAN 2: cek saldo
        val cukup = pelanggan.bayar(totalBiaya)
        if (!cukup) {
            println("❌ Gagal: Saldo pelanggan tidak mencukupi!")
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