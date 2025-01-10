package com.Epicode.be.ElMul;

public abstract class PlayerMultimediale {
    protected String titolo;



    public PlayerMultimediale(String titolo){
        this.titolo =  titolo;

    }
  public String info(){
        return this.titolo;
  }

    protected void play() {
    }


}
