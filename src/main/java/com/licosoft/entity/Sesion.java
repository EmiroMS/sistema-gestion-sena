package com.licosoft.entity;

public class Sesion {

    private static int idUsuario;
    private static String nombre;
    private static String rol;

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        Sesion.idUsuario = idUsuario;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Sesion.nombre = nombre;
    }

    public static String getRol() {
        return rol;
    }

    public static void setRol(String rol) {
        Sesion.rol = rol;
    }
}
