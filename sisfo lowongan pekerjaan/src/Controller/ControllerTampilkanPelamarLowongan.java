/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.TampilkanPelamarLowongan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistem.informasi.data.lowongan.pekerjaan.Aplikasi;
import sistem.informasi.data.lowongan.pekerjaan.Pelamar;
import sistem.informasi.data.lowongan.pekerjaan.Perusahaan;

/**
 *
 * @author Mendex
 */
public class ControllerTampilkanPelamarLowongan implements ActionListener {

    Aplikasi app;
    TampilkanPelamarLowongan p;

    public ControllerTampilkanPelamarLowongan(Aplikasi ap) {
        this.p = new TampilkanPelamarLowongan();
        this.p.setVisible(true);
        this.app = ap;

        this.p.getBackButton().addActionListener(this);

        this.p.getTampilkanButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();

        if (x.equals(p.getBackButton())) {
            this.p.setVisible(false);
            ControllerPerusahaan cp = new ControllerPerusahaan(app);

        } else if (x.equals(p.getTampilkanButton())) {
            String namaPerusahaan = p.getNamaPerusahaanField().getText();

            String[] header = new String[2];
            header[0] = "Nama Lowongan";
            header[1] = "Pelamar";

            String[][] data = new String[app.getListPerusahaan().size()][2];
            for (int i = 0; i < app.getListPerusahaan().size(); i++) {
                for (int j = 0; j < app.getListPerusahaan().get(i).getnLowongan(); j++) {

                    for (int k = 0; k < app.getListPerusahaan().get(i).getLowongan(j).getnBerkas(); k++) {

                        data[j][0] = app.getPerusahaan(namaPerusahaan).getLowongan(j).getNamaLowongan();
                        data[k][1] = app.getPerusahaan(namaPerusahaan).getLowongan(j).getBerkasMasuk(k).getIdBerkas();

                    }
//                       

                }

                p.getTabel().setModel(new DefaultTableModel(data, header));

            }

        }

    }

}
