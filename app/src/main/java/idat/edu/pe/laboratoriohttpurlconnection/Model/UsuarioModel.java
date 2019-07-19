package idat.edu.pe.laboratoriohttpurlconnection.Model;

import java.util.Date;

public abstract class UsuarioModel {
    //Atributos o propie
    String usu_codigo;
    String usu_nombre;
    String usu_descri;
    String usu_passwd;
    String usu_email;
    String usu_imagen;
    Date usu_fecreg;
    int usu_estcod;


    public String getUsu_codigo() {
        return usu_codigo;
    }

    public void setUsu_codigo(String usu_codigo) {
        this.usu_codigo = usu_codigo;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_descri() {
        return usu_descri;
    }

    public void setUsu_descri(String usu_descri) {
        this.usu_descri = usu_descri;
    }

    public String getUsu_passwd() {
        return usu_passwd;
    }

    public void setUsu_passwd(String usu_passwd) {
        this.usu_passwd = usu_passwd;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public String getUsu_imagen() {
        return usu_imagen;
    }

    public void setUsu_imagen(String usu_imagen) {
        this.usu_imagen = usu_imagen;
    }

    public Date getUsu_fecreg() {
        return usu_fecreg;
    }

    public void setUsu_fecreg(Date usu_fecreg) {
        this.usu_fecreg = usu_fecreg;
    }

    public int getUsu_estcod() {
        return usu_estcod;
    }

    public void setUsu_estcod(int usu_estcod) {
        this.usu_estcod = usu_estcod;
    }
}
