fun main() {

    val pelanggan = Pelanggan(5000)
    val mesin = MesinPrint(10, 10)
    val dokumen = Dokumen(5)

    mesin.cetakDokumen(dokumen, pelanggan)
}

// ================= CLASS PELANGGAN =================
class Pelanggan(var saldo: Int)

// ================= CLASS DOKUMEN =================
class Dokumen(val jumlahHalaman: Int)

// ================= CLASS MESIN PRINT =================
class MesinPrint(var tinta: Int, var kertas: Int) {

    val hargaPerLembar = 500

    fun cetakDokumen(dokumen: Dokumen, pelanggan: Pelanggan) {

        val totalBiaya = dokumen.jumlahHalaman * hargaPerLembar

        println("Mencetak ${dokumen.jumlahHalaman} halaman")
        println("Total biaya: Rp$totalBiaya")

        // BELUM ADA VALIDASI (masih tahap awal)
        pelanggan.saldo -= totalBiaya
        tinta -= dokumen.jumlahHalaman
        kertas -= dokumen.jumlahHalaman

        println("Cetak selesai")
        println("Sisa saldo: Rp${pelanggan.saldo}")
    }
}