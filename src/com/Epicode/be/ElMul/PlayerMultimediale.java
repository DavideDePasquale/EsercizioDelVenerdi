package com.Epicode.be.ElMul;


public abstract class PlayerMultimediale {
    protected String titolo;
    protected String[] tipoDato;



    public PlayerMultimediale(String titolo){
        this.titolo =  titolo;

    }

    public String toString(){
        return " Titolo :" + titolo;
    }

    public abstract void riproduci();



}
