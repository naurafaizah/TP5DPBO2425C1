import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ProductMenu extends JFrame {
    public static void main(String[] args) {
        ProductMenu menu = new ProductMenu();
        menu.setSize(700, 600);
        menu.setLocationRelativeTo(null);
        menu.setContentPane(menu.mainPanel);
        menu.getContentPane().setBackground(Color.WHITE);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int selectedIndex = -1;
    private Database database;

    private JPanel mainPanel;
    private JTextField idField;
    private JTextField namaField;
    private JTextField hargaField;
    private JTable productTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> kategoriComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel idLabel;
    private JLabel namaLabel;
    private JLabel hargaLabel;
    private JLabel kategoriLabel;

    public ProductMenu() {
        database = new Database();

        // isi tabel awal
        productTable.setModel(setTable());

        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));
        String[] kategoriData = { "???", "Elektronik", "Makanan", "Minuman", "Pakaian", "Alat Tulis" };
        kategoriComboBox.setModel(new DefaultComboBoxModel<>(kategoriData));
        deleteButton.setVisible(false);

        // tombol add/update
        addUpdateButton.addActionListener(e -> {
            if (selectedIndex == -1) {
                insertData();
            } else {
                updateData();
            }
        });

        // tombol delete
        deleteButton.addActionListener(e -> deleteData());

        // tombol cancel
        cancelButton.addActionListener(e -> clearForm());

        // klik tabel
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = productTable.getSelectedRow();

                idField.setText(productTable.getValueAt(selectedIndex, 0).toString());
                namaField.setText(productTable.getValueAt(selectedIndex, 1).toString());
                hargaField.setText(productTable.getValueAt(selectedIndex, 2).toString());
                kategoriComboBox.setSelectedItem(productTable.getValueAt(selectedIndex, 3).toString());

                addUpdateButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });
    }

    public final DefaultTableModel setTable() {
        Object[] cols = { "ID Produk", "Nama", "Harga", "Kategori" };
        DefaultTableModel tmp = new DefaultTableModel(null, cols);

        try {
            ResultSet rs = database.selectQuery("SELECT * FROM product");
            while (rs.next()) {
                Object[] row = {
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("harga"),
                        rs.getString("kategori")
                };
                tmp.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
        }
        return tmp;
    }

    public void insertData() {
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String hargaText = hargaField.getText().trim();
        String kategori = kategoriComboBox.getSelectedItem().toString();

        // validasi kosong
        if (id.isEmpty() || nama.isEmpty() || hargaText.isEmpty() || kategori.equals("???")) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // validasi angka
        double harga;
        try {
            harga = Double.parseDouble(hargaText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Harga harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // cek duplikat ID
        try {
            ResultSet rs = database.selectQuery("SELECT * FROM product WHERE id = '" + id + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "ID sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memeriksa ID: " + e.getMessage());
            return;
        }

        // insert ke DB
        String query = "INSERT INTO product VALUES ('" + id + "', '" + nama + "', '" + harga + "', '" + kategori + "')";
        database.insertUpdateDeleteQuery(query);

        productTable.setModel(setTable());
        clearForm();
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
    }

    public void updateData() {
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String hargaText = hargaField.getText().trim();
        String kategori = kategoriComboBox.getSelectedItem().toString();

        if (id.isEmpty() || nama.isEmpty() || hargaText.isEmpty() || kategori.equals("???")) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double harga;
        try {
            harga = Double.parseDouble(hargaText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Harga harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "UPDATE product SET nama = '" + nama + "', harga = '" + harga + "', kategori = '" + kategori
                + "' WHERE id = '" + id + "'";
        database.insertUpdateDeleteQuery(query);

        productTable.setModel(setTable());
        clearForm();
        JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
    }

    public void deleteData() {
        String id = idField.getText().trim();

        int confirm = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ini?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String query = "DELETE FROM product WHERE id = '" + id + "'";
            database.insertUpdateDeleteQuery(query);

            productTable.setModel(setTable());
            clearForm();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        }
    }

    public void clearForm() {
        idField.setText("");
        namaField.setText("");
        hargaField.setText("");
        kategoriComboBox.setSelectedIndex(0);
        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);
        selectedIndex = -1;
    }
}
