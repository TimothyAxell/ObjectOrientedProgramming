package proyek_pbo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ester Gabriel
 */
public class Trans {
    private int IDBarang;
    private String nama;
    private int harga;
    private int quantity;
    private int subtotal;

    public Trans()
    {
        
    }
    
    public Trans(String nama,int harga, int quantity, int subtotal, int IDBarang) {
        this.nama = nama;
        this.harga = harga;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.IDBarang = IDBarang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getIDBarang() {
        return IDBarang;
    }

    public void setIDBarang(int IDBarang) {
        this.IDBarang = IDBarang;
    }
    
    
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    
    
}
