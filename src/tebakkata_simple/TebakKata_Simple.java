/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tebakkata_simple;
import java.util.*;
import java.lang.String;
/**
 *
 * @author Ade Ilham Fajri
 */
public class TebakKata_Simple {

    /**
     * @param args the command line arguments
     */
    //deklarasi variable array gudang kata
    private static String[] gudangkata = {
        "michaelfaraday", "cristianoronaldo", 
        "lionelmessi", "markzuckerberg", "andyrubin","bayernmunich",
        "alberteinstein","kutu", "jetli"
    };
    
    //deklarasi variable array kata kunci
    private static String[] katakunci = {
        "Penemu Listrik", "pemain bola bernomor punggung 7 diReal Madrid",
        "Pemenang piala ballon d'or tahun 2013", "Penemu Facebook", "Penemu Android","Sebutan lain dari bayern munchen",
        "tokoh dunia","nama panggilan mahasiswa ithb jurusan SK", "nama panggilan mahasiswa ithb jurusan EL"  
    };
    
  
    public static void main(String[] args) {
        // TODO code application logic here
        //deklarasi variable dan class
        Scanner scan  = new Scanner(System.in);
        Random rand = new Random();
        
        int acak = 0;
        int kesempatan;
        String katapilihan = "";
        boolean ulangi = false;
        boolean loncat =  false;
        char pilih = 0, jawab = 0;
        String pilih2 = "";
        String[] ubah;
        boolean back;
        
        do{
           //tampilan utama
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Game Tebak Kata");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" 1. anda akan diberi kesempatan menebak 8 kali ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            
            //method untuk pemberhenti kompiler
            lanjut();
            
            //pengacakan angka dengan angka maksimal panjang gudangkata
            acak = rand.nextInt(gudangkata.length);
            
            //mereset String katapilihan
            katapilihan = "";
            
            //memberi kesempatan 8x
            kesempatan = 8;
            
            //mengubah string ke array
            ubah = gudangkata[acak].split("");
            
            //mengganti semua kata dengan simbol '-'
            for(int c=0; c<= gudangkata[acak].length(); c++){
                //proses penggantian
                ubah[c] = "-";
                
                //proses, kata yang sudah diganti lalu digabungkan ke dalam katapilihan
                katapilihan = katapilihan.concat(ubah[c]);
            }
            
            
            //tempat perulangan proses berlangsungan permainan
            do{
                System.out.println("\n kesempatan anda menebak : " + kesempatan); // untuk menampilkan jumlah kesempatan menebak
                System.out.println(" Kata Kunci : " + katakunci[acak]); // untuk menamplikan kata kunci sebagai pemandu penebakan
                System.out.println(" Tebak kata apa ini : " + katapilihan); // unutk menampilkan kata yang harus ditebak
                System.out.print(" Anda tebak : "); // inputan pilihan
                
                //proses menginputkan
                pilih = scan.next().toLowerCase().charAt(0);
                
                //proses mengubah dari char ke string
                pilih2 = String.valueOf(pilih);
                
                //memasukkan hal-hal penting ke method "proses"
                katapilihan = proses(katapilihan, pilih2, acak);
                
                //cek jawaban
                if(katapilihan.equals(gudangkata[acak])){
                    System.out.println("\n Selamat Jawaban Anda Benar !!");
                    break; //selesai dari permainan, hanya utk 1 kali permainan
                }
                
                //apabila kata yang diinputkan mengandung unsur kata yang dimaksud, maka counter kesempatan dilewati
                if(gudangkata[acak].contains(pilih2)){
                    continue; //melompat ke akhir permainan
                }
                
                //kesempatan akan minus 1 setiap jawabannya salah
                kesempatan--;
            }while(kesempatan > 0); //berhenti jika kesempatan == 0 
            
            //Jika kesempatan sudah habis, dan kata belum ketebak juga
            if(kesempatan==0 && !katapilihan.equals(gudangkata[acak])){
                System.out.println("\n Jawaban anda Salah !");
                System.out.println("Jawaban yang benar adalah : "+ gudangkata[acak]+"\n\n");
                lanjut(); //proses pemberhentikan sementara
            }
            
            //nambah lagi ?
            do{
                back = false; //inisialisasi variable "back"
                
                System.out.println("\n Apakah anda ngin mengulangi lagi ? [Y/N]");
                jawab = scan.next().toUpperCase().charAt(0); //proses input
                
                System.out.println("\n");
                
                if(jawab == 'Y'){
                    ulangi = true; //update nilai "ulang" jadi true
                }
                
                else if(jawab == 'N'){
                    ulangi = false; //update nilau "ulang" jadi false
                }
                
                else { //kalo  typo
                    back = true;
                }
              
            }while(back);
            
        }while(ulangi);
         //tampilkan kata perpisahan
        penutupan();
    }
    
    private static String proses(String katapilihan, String pilih2, int acak){
        
        //mengubah string biasa ke String Array untuk mengecek jawaban yang benar
        String[] ubah2 = gudangkata[acak].split("");
        
        //Mengubah string biasa ke String Array pada kata yang ditanyakan
        String[] ubah = katapilihan.split("");
        
        //reset katapilihan agar tidak jadi tumpukan
        katapilihan = "";
        
        for(int c=0; c<=gudangkata[acak].length(); c++){
            //mengecek apabila kata yang diinputkan apakah sama dengan kata yang sebenarnya
            if(ubah2[c].equalsIgnoreCase(pilih2)){
                ubah[c] = ubah2[c];
            }
            
            //menggabungkan semua array menjadi sebuah string
            katapilihan = katapilihan.concat(ubah[c]);
        }
        //mengembalikan nilai yang telah diproses
        return katapilihan;        
    }
    
    public static void penutupan() { // menampilkan kata perpisahan biar lebih sopan gtu...
		 
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println(" ******************************************************************************");
        System.out.println();
        System.out.println(" -----########-------------------------##-----########-------------------------");
        System.out.println(" ---##---------------------------------##-----##------##-----------------------");
        System.out.println(" -##-------------######---######---######-----##------##--##------##----####---");
        System.out.println(" -##----######-##----##-##----##-##----##-----########------##--##----##----##-");
        System.out.println(" -##--------##-##----##-##----##-##----##-----##------##----##--##----########-");
        System.out.println(" -####------##-##----##-##----##-##----##-----##------##----####------##-------");
        System.out.println(" -----########-########-########---######-----########--------##--------######-");
        System.out.println(" -------------------------------------------------------------##---------------");
        System.out.println(" -----------------------------------------------------------##-----------------");
        System.out.println();
        System.out.println(" ******************************************************************************");
        System.out.println("\n\n");
    }
    
    //untuk pemberhentian sementara
    public static void lanjut(){
        Scanner scan = new Scanner(System.in);
        char jawab=0; //deklarasi variable
        
        //tempat melakukan perulangan jika menjawab salah
        do{
             System.out.print(" Tekan \"c\" kemudian \"enter\" untuk melanjutkan..."); //menampikan kata

             //menerima & memproses inputan
             jawab = scan.next().toUpperCase().charAt(0);
        } while(jawab != 'C'); //jika tidak
    
    }   
}
