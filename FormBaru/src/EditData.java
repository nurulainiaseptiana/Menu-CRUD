
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class EditData extends JFrame
{
    JLabel lnim,lnama,lalamat,ljudul;
    JTextField tfnim,tfnama,tfalamat;
    JButton btnUpdate,btnKembali;
    Statement statement;
    ResultSet resultSet;
    
    public void EditData()
    {
        ljudul = new JLabel("Masukkan NIM yang akan diupdate");
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");        
        lalamat = new JLabel("Alamat");
        
        tfnim = new JTextField();
        tfnama = new JTextField();
        tfalamat = new JTextField();
        
        btnUpdate = new JButton("Update");
        btnKembali = new JButton("Kembali");
        
        setTitle("Update Data Mahasiswa");
        setSize(500,300);
        ljudul.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        setLayout(null);
        add(ljudul);
        add(lnim);
        add(lnama);
        add(lalamat);
        add(tfnim);
        add(tfnama);
        add(tfalamat);
        add(btnUpdate);
        add(btnKembali);
        
        ljudul.setBounds(75, 10, 300, 25);
        lnim.setBounds(75, 50, 30, 20);
        lnama.setBounds(75, 75, 50, 20);
        lalamat.setBounds(75, 100, 50, 20);
        tfnim.setBounds(150, 50, 150, 20);
        tfnama.setBounds(150, 75, 150, 20);
        tfalamat.setBounds(150, 100, 150, 100);
        btnUpdate.setBounds(120, 205, 100, 20);
        btnKembali.setBounds(235, 205, 100, 20);
        
        btnKembali.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new formmhs();
            }
            
        });
        
        btnUpdate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateactionListener();
            }

        });
    }
    
    private void btnUpdateactionListener() 
    {
        KoneksiDB koneksi = new KoneksiDB();
        try 
        {
            statement = koneksi.getKoneksi().createStatement();
            statement.executeUpdate("UPDATE data_mhs SET nama='" + tfnama.getText() + "'," + "alamat='"+
                                    tfalamat.getText() + "' WHERE nim='" + tfnim.getText() + "'");
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update!","Hasil",JOptionPane.ERROR_MESSAGE);
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Update!","Hasil",JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!","Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
}
