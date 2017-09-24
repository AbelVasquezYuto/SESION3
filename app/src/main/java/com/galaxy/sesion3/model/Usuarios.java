package com.galaxy.sesion3.model;

public class Usuarios {

    public static final String TABLE_NAME = "usuarios";
    public static final String USUARIO_FIELD = "usuario";
    public static final String PASSWORD_FIELD = "password";
    public static final String NPASSWORD_FIELD = "npassword";
    public static final String NOMBRES_FIELD = "nombre";
    public static final String APELLIDOS_FIELD = "apellido";

    private String usuario;
    private String password;
    private String npassword;
    private String nombres;
    private String apellidos;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNpassword() {
        return npassword;
    }

    public void setNpassword(String npassword) {
        this.npassword = npassword;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", npassword='" + npassword + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
