package Model;

import com.mysql.cj.jdbc.Blob;
import java.io.FileInputStream;


public class ListaP {
    private int Registro;
    private String Nome;
    private Blob Imagem ;
    private byte[] img;
    public FileInputStream fis;
    private int tam;

    public int getRegistro() {
        return Registro;
    }

    public void setRegistro(int Registro) {
        this.Registro = Registro;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Blob getImagem() {
        return Imagem;
    }

    public void setImagem(Blob Imagem) {
        this.Imagem = Imagem;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    
}
