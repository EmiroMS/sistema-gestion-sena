package com.licosoft.entity;

public class Permisos {
	
    public static boolean esAdmin(){
        return Sesion.getRol().equals("ADMIN");
    }

    public static boolean esVendedor(){
        return Sesion.getRol().equals("VENDEDOR");
    }
}
