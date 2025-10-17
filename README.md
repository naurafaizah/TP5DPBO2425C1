Saya Naura Nur Faizah dengan NIM 2408352 mengerjakan TP 5 dalam mata kuliah Desain Pemrograman Berbasis Objek untuk keberkahan-Nya maka saya tidak akan melakukan kecurangan seperti yang telah di spesifikasikan

# desain program
Pada bagian Model, terdapat kelas Product.java yang berfungsi menyimpan struktur data produk, seperti id, nama, harga, dan kategori. Bagian View sekaligus Controller diwakili oleh kelas ProductMenu.java, yang menampilkan antarmuka grafis (GUI) kepada pengguna serta mengatur interaksi dan logika aplikasi. Selain itu, terdapat kelas Database.java (yang dipanggil di dalam program ini) untuk menangani koneksi serta eksekusi perintah SQL terhadap database.

Antarmuka program terdiri dari beberapa komponen utama, yaitu form input data produk (ID, Nama, Harga, dan Kategori), tabel (JTable) untuk menampilkan daftar produk dari database, serta tombol aksi seperti Add, Update, Delete, dan Cancel. Ketika program dijalankan, data produk langsung dimuat dari database menggunakan fungsi setTable(). Pengguna dapat menambahkan produk baru melalui tombol Add, yang akan memicu proses validasi input sebelum data disimpan ke tabel product di database. Jika pengguna mengklik salah satu baris di tabel, data produk tersebut akan muncul di form sehingga dapat diubah menggunakan tombol Update atau dihapus menggunakan tombol Delete. Tombol Cancel digunakan untuk membersihkan form dan mengembalikan tampilan ke kondisi semula.

Secara keseluruhan, desain program ini menggabungkan antarmuka yang sederhana dan fungsional dengan pengelolaan data berbasis database. Program ini menekankan kemudahan interaksi pengguna melalui tampilan GUI, serta keandalan dalam menjaga konsistensi data melalui validasi input dan pembaruan otomatis tabel setiap kali terjadi perubahan.

# penjelasan alur
Alur program ProductMenu dimulai ketika aplikasi dijalankan dan jendela utama tampil dengan tabel berisi data produk yang diambil dari database melalui fungsi setTable(). Pengguna dapat mengisi form (ID, Nama, Harga, dan Kategori), lalu menekan tombol Add untuk menambahkan data baru ke database. Jika pengguna memilih salah satu baris di tabel, data produk tersebut otomatis muncul di form sehingga bisa diperbarui dengan menekan Update atau dihapus dengan tombol Delete. Tombol Cancel digunakan untuk mengosongkan form dan mengembalikan tampilan ke kondisi awal. Setelah setiap operasi (tambah, ubah, hapus), tabel akan diperbarui secara otomatis agar menampilkan data terbaru dari database.

# dokumentasi
<img width="770" height="475" alt="image" src="https://github.com/user-attachments/assets/3dfa5296-dddc-4fbd-849a-d15114329f42" />
pada tabel tersebut terlihat bahwa user baru menambahkan data baru untuk id "PRD021" dan "PRD022"

<img width="1012" height="872" alt="Screenshot 2025-10-17 112027" src="https://github.com/user-attachments/assets/ec76ca09-4f3d-4f01-9b7a-2a9b0456b58a" />
pada dokumentasi tersebut terlihat bahwa muncul pesan validasi bahwa semua kolom harus di isi, yang artinya tidak boleh kosong pada bagian ID untuk contoh pada gambar tersebut

<img width="777" height="518" alt="image" src="https://github.com/user-attachments/assets/60c01dde-ed1e-4ee3-9dd6-91c8d1a3633b" />
terlihat bahwa ada pesan kalau data berhasil di update pada bagian esteh yang tadinya tertulis makanan, sekarang sudah di update menjadi kategori minuman

<img width="825" height="732" alt="image" src="https://github.com/user-attachments/assets/c53bb669-96ce-4520-857e-47067de7fa18" />
muncul pesan error bahwa untuk mengisi bagian harga itu harus merupakan pure angka tidak boleh ada koma

<img width="447" height="214" alt="Screenshot 2025-10-17 202831" src="https://github.com/user-attachments/assets/c36b2c13-26f5-4daa-b4a7-a927652365db" />
sebelum menghapus data terdapat pesan konfirmasi apakah yakin untuk menghapus data tersebut

<img width="595" height="368" alt="image" src="https://github.com/user-attachments/assets/38d00243-d7a1-4048-9bb4-9e7776187e7d" />
terlihat bahwa data sudah berhasil terhapus





