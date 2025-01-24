package com.example.utsecommerce.Models;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ItemModel implements Serializable {
    private String nama, harga, photoPath, minPesan, deskripsi;
    private ArrayList<String> varian;

    public ItemModel() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getMinPesan() {
        return minPesan;
    }

    public void setMinPesan(String minPesan) {
        this.minPesan = minPesan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public ArrayList<String> getVarian() {
        return varian;
    }

    public void setVarian(ArrayList<String> varian) {
        this.varian = varian;
    }
}
