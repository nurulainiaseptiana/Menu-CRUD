
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class HapusData extends JFrame
{
    Statement statement;
    ResultSet resultSet;
    JLabel lnim,ljudul;
    JTextField tfnim;
    JButton btnDel,btnKembali;
    
    public void HapusData()
    {
        ljudul = new JLabel("Hapus Data Mahasiswa");
        lnim = new JLabel("NIM"); 
        
        tfnim = new JTextField();
        
        btnDel = new JButton("Hapus");
        btnKembali = new JButton("Kembali");
        
        setTitle("Update Data Mahasiswa");
        setSize(300,200);
        ljudul.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        setLayout(null);
        add(ljudul);
        add(lnim);
        add(tfnim);
        add(btnDel);
        add(btnKembali);
        
        ljudul.setBounds(50, 10, 150, 25);
        lnim.setBounds(50, 50, 100, 25);
        tfnim.setBounds(100, 50, 100, 25);
        btnDel.setBounds(30, 90, 100, 25);
        btnKembali.setBounds(140, 90, 100, 25);
        
        btnKembali.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new formmhs();
            }
            
        });
        
        btnDel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBuatactionListener();
            }

        });
        
    }
    
    private void btnBuatactionListener() 
    {
        KoneksiDB koneksi = new KoneksiDB();
        try 
        {
            statement = koneksi.getKoneksi().createStatement();
            statement.executeUpdate("DELETE FROM data_mhs WHERE nim='" + tfnim.getText() + "'");
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus!","Hasil",JOptionPane.ERROR_MESSAGE);
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Hapus!","Hasil",JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!","Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
}
