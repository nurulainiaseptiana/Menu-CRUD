import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Lab Informatika
 */
public class formmhs extends JFrame{
    JLabel lnim,lnama,lalamat;
    JTextField txnim,txnama,txalamat;
    JButton cetak,lihat,update,hapus;
    Statement statement;
    
    public void tesformmhs (){
        
        setTitle("From Pengisian Mahasiswa");
        
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");        
        lalamat = new JLabel("Alamat");
        
        txnim = new JTextField("");
        txnama = new JTextField("");
        txalamat = new JTextField("");
        
        cetak = new JButton("Cetak");
        lihat = new JButton("Lihat");
        update = new JButton("Update");
        hapus = new JButton("Hapus");
        
        setLayout(null);
        add(lnim);
        add(lnama);
        add(lalamat);
        add(txnim);
        add(txnama);
        add(txalamat);
        add(cetak);
        add(lihat);
        add(update);
        add(hapus);
        
        lnim.setBounds(75, 50, 30, 20);
        lnama.setBounds(75, 75, 50, 20);
        lalamat.setBounds(75, 100, 50, 20);
        txnim.setBounds(150, 50, 150, 20);
        txnama.setBounds(150, 75, 150, 20);
        txalamat.setBounds(150, 100, 150, 100);
        cetak.setBounds(75, 205, 75, 20);
        lihat.setBounds(155, 205, 75, 20);
        update.setBounds(235, 205, 75, 20);
        hapus.setBounds(315, 205, 75, 20);
        
        setSize(500,300); //untuk luas jendela
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        cetak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                int a1 =  Integer.parseInt(txnim.getText());
                String a2 = txnama.getText();
                String a3 = txalamat.getText();
                        
                KoneksiDB koneksi = new KoneksiDB();
                    try {
                        statement = koneksi.getKoneksi().createStatement();
                        String sql = "INSERT INTO data_mhs VALUES ('"
                                + a2 + "','" + a1 + "','" + a3 + "')";
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(formmhs.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(formmhs.class.getName()).log(Level.SEVERE, null, ex);
                    }
                LihatData ld = new LihatData();
                ld.LihatData();
                    
                } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH");
                } catch (Error ext){
                 JOptionPane.showMessageDialog(rootPane,"SALAH");
                 
                }
            }

        });
        
        lihat.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                LihatData ld = new LihatData();
                ld.LihatData();
            }
            
        });
        
        
        update.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditData ed = new EditData();
                ed.EditData();
            }
            
        });
        
        hapus.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                HapusData hd = new HapusData();
                hd.HapusData();
            }
            
        });
    }
}
