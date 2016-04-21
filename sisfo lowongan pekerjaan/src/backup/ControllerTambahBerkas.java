/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import Controller.*;
import View.TambahPelamar;
import View.TerimaBerkas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sistem.informasi.data.lowongan.pekerjaan.Aplikasi;

/**
 *
 * @author Mendex
 */
public class ControllerTambahBerkas implements ActionListener{
    Aplikasi app;
    TerimaBerkas tb;
    
    public ControllerTambahBerkas(Aplikasi app){
        this.app = app;
        this.tb= new TerimaBerkas();
        this.tb.setVisible(true);
        
        this.tb.getBackButton().addActionListener(this);
        this.tb.getTerimaButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x =ae.getSource();
        
        if(x.equals(tb.getBackButton())){
            this.tb.setVisible(false);
            ControllerPerusahaan cp = new ControllerPerusahaan(app);
        }
        
        else if(x.equals(tb.getTerimaButton())){
            String namaPerusahaan = tb.getNamaPerusahaanField().getText();
            String namaPelamar = tb.getNamaPelamarField().getText();
            String namaLowongan = tb.getNamaLowonganField().getText();
            String idBerkas = tb.getIdBerkasField().getText();
            
            app.getPerusahaan(namaPerusahaan).getLowongan(namaLowongan).terimaBerkas(app.getPelamar(namaPelamar).getBerkas(idBerkas));
            JOptionPane.showMessageDialog(null, "Berhasil Diterima");
            
            
        }

    }
    
}
