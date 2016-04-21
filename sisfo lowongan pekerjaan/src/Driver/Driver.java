/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.ControllerMainMenu;
import sistem.informasi.data.lowongan.pekerjaan.Aplikasi;

/**
 *
 * @author Mendex
 */
public class Driver {

    public static void main(String[] args) {

        Aplikasi app = new Aplikasi();
        app.addPerusahaan("Tesla", "Tesla");
        app.addPerusahaan("Bill Gates", "Microsoft");
        app.addPerusahaan("Steve Jobs", "Apple");

        app.getPerusahaan("Apple").createLowongan("L001", "konsultan", "20 maret 2018");
        app.getPerusahaan("Apple").createLowongan("L002", "konsultan engineer", "20 maret 2018");
        app.getPerusahaan("Tesla").createLowongan("L003", "engineer", "20 maret 2018");
        app.getPerusahaan("Microsoft").createLowongan("L004", "kasir", "20 maret 2018");

        app.addPelamar("kaka", "P001");
        app.getPelamar("kaka").createBerkas("B001", "Dokumen", "20 maret 2017");

        app.getPerusahaan("Apple").getLowongan("konsultan").addBerkas(app.getPelamar("kaka").getBerkas("B001"));

        app.addPelamar("kiki", "P002");
        app.getPelamar("kiki").createBerkas("kiki", "Dokumen", "20 maret 2017");

        app.getPerusahaan("Apple").getLowongan("konsultan").addBerkas(app.getPelamar("kiki").getBerkas("kiki"));

        app.addPelamar("koko", "P003");
        app.getPelamar("koko").createBerkas("koko", "Dokumen", "20 maret 2017");

        app.getPerusahaan("Microsoft").getLowongan("kasir").addBerkas(app.getPelamar("koko").getBerkas("koko"));

        ControllerMainMenu cmm = new ControllerMainMenu(app);
    }

}
