/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.data.lowongan.pekerjaan;

/**
 *
 *
 * @author mendexx
 */
public class Perusahaan extends Orang {

    private Lowongan[] daftarLowongan = new Lowongan[10];//membuat array lowongan sebanyak 10

    private int nLowongan = 0;
    private String nmPerusahaan;
    private Lowongan lowongan;

    //constructor perusahaan berupa nama dan nama perusahaan
    public Perusahaan(String nm, String nmPerusahaan) {
        super(nm);//mengambil constructor super dari parent(Orang)
        this.nmPerusahaan = nmPerusahaan;
    }
    
    
    //mengembalikan lowongan
    public Lowongan getLowongan1() {
        return this.lowongan;
    }
    
    //mengembalikan daftar lowongan dari class Lowongan
    public Lowongan[] getDaftarLowongan() {
        return daftarLowongan;
    }

    //mengembalikan banyak Lowongan yang ada
    public int getnLowongan() {
        return nLowongan;
    }

    //mengembalikan nama perusahaan
    public String getNamaPerusahaan() {
        return this.nmPerusahaan;
    }
    
    //meembuat lowongan baru 
    public void createLowongan(String idLowongan, String nmLowongan, String deadline) {

        Lowongan lo = new Lowongan(idLowongan, nmLowongan, deadline);//membuat lowongan baru dengan mengambil constructor kelas lowongan
        daftarLowongan[nLowongan] = lo; //menyimpan lowongan yang dibuat ke dalam array nLowongan
        nLowongan++;//increment jumlah nLowongan
    }

    //mengembalikan lowongan sesuai index
    public Lowongan getLowongan(int index) {

        return daftarLowongan[index];
    }

    //mengembalikan lowongan sesuai namaLowongan yang dimasukkan ke dalam parameter
    public Lowongan getLowongan(String nmLowongan) {
        for (int i = 0; i < nLowongan; i++) {
            if (nmLowongan.equalsIgnoreCase(this.daftarLowongan[i].getNamaLowongan())) {//jika parameter method sama dengan namaLowongan perusahaan 
                return daftarLowongan[i];//maka akan mengembalikan index Lowongan
            }
        }
        return null;
    }

    // method menghapus loowongan sesuai parameter String yang diinputkan
    public void remLowongan(String a) {
        int getIndex = -2;
        for (int i = 0; i < nLowongan; i++) {
            if (this.daftarLowongan[i].getIdLowongan().equalsIgnoreCase(a)) {//memeriksa idLowongan yang sama dengan parameter sebanyak nLowongan 
                getIndex = i;
                break;
            }
        }
        for (int i = getIndex + 1; i < nLowongan; i++) {
            daftarLowongan[i - 1] = daftarLowongan[i];
        }
        nLowongan--; //menghapus lowongan
    }

    @Override
    public void display() {
        System.out.println("Perusahaan " + getNamaPerusahaan());
        System.out.println("Nama Pemilik Perusahaan     : " + super.getNamaOrang());
        for (int i = 0; i < nLowongan; i++) {
            System.out.println("Lowongan yang tersedia : " + daftarLowongan[i].getIdLowongan() + "\tLowongan " + daftarLowongan[i].getNamaLowongan() + "\t\t Deadline :" + daftarLowongan[i].getDeadline());
        }

    }

    @Override
    public String toString() {
        String s = "nama Lowongan :" + this.getNamaOrang() + "\n";
        String s1 = "perusahaan : " + this.getNamaPerusahaan() + "\n";
        String s2 = "lowongan : \n";
        String lowongan = "";
        for (int i = 0; i < nLowongan; i++) {
            lowongan += (i + 1) + " " + this.daftarLowongan[i].getNamaLowongan() + "\n";
        }
        return s + s1 + s2 + lowongan;
    }

}
