/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.data.lowongan.pekerjaan;

/**
 *
 * @author Givanni
 */
public class Pelamar extends Orang {
   private BerkasLamaran[] berkas = new BerkasLamaran[10];
    private String idPelamar;
 private int nBerkas= 0;
    
    
    public Pelamar(String nama, String idPelamar){
        super(nama);// mengambil constructor parent yaitu class orang
        setIdPelamar(idPelamar); 
    }
	
    //membuat berkas
    public void createBerkas(String id,String jenisBerkas, String tglMsk){
	BerkasLamaran b = new BerkasLamaran(id,jenisBerkas, tglMsk);//mengambil constructor BerkasLamaran dengan sejumlah parameter
	berkas[nBerkas]= b; 
        nBerkas++;//menambah sejumlah n berkas
    }
    
    
    public void setIdPelamar(String idPelamar){
        this.idPelamar= idPelamar;
    }
    
    public String getIdPelamar(){
        return this.idPelamar;
    }
    
    public BerkasLamaran getBerkas(int index){
        return this.berkas[index];
    }
    
    
    //mengembalika berkas dengan paramaeter String
    public BerkasLamaran getBerkas(String id){
        for (int i=0; i< nBerkas; i++){
			if(id.equalsIgnoreCase(this.berkas[i].getIdBerkas())) {//memeriksa jika nama pada indeks berkas sama dengan parameter
				return berkas[i];// akan mengembalikan indeks berkas
                        }
                }
                return null;
    }
    
    
    //mencari suatu lowongan sesuai paramater String
   public Perusahaan cariLowongan(String nama){
    for(int i = 0; i <Main.nPerusahaan; i++){
        for (int j= 0; j< Main.listPerusahaan[i].getnLowongan(); j++){
            if(nama.equals(Main.listPerusahaan[i].getDaftarLowongan()[j].getNamaLowongan())){
                return Main.listPerusahaan[i];
            }
        }
    }
        return null;
    }
   
   public int getnBerkas(){
        return nBerkas;
    }
    
    @Override
    public void display() {
        System.out.println();
        System.out.println("Id Pelamar              : "+getIdPelamar());
        System.out.println("Nama                    : "+super.getNamaOrang());
//        System.out.println("Id Berkas               : "+berkas.getIdBerkas());
//        System.out.println("Jenis Berkas            : "+berkas.getJenisBerkas());
//        System.out.println("Tanggal Masuk Berkas    : "+berkas.getTglMasukBerkas());
 //       System.out.println();
       
    }
    
    
}
