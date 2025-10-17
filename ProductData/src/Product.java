public class Product {
    private String id;
    private String nama;
    private double harga;
    private String kategori;

    // constructor utama
    public Product(String id, String nama, double harga, String kategori) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    // constructor kosong (penting jika nanti ingin membuat object tanpa langsung isi)
    public Product() {
    }

    // getter & setter
    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public double getHarga() {
        return this.harga;
    }

    public String getKategori() {
        return this.kategori;
    }

    // opsional: ubah data ke string agar mudah ditampilkan/logging
    @Override
    public String toString() {
        return id + " - " + nama + " (" + kategori + ") Rp" + harga;
    }
}
