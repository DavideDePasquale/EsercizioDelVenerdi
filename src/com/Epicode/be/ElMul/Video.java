package com.Epicode.be.ElMul;

public class Video extends ImmagineVideo implements Play,Luminosita{
    protected int durata;
    protected int volume;
      protected int luminosita;
    public Video(String titolo , int durata, int volume, int luminosita) {
        super(titolo);

        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;


    }

    @Override
    public String info() {
        return super.info() + " Durata video : " +  this.durata + " Volume video : " +  this.volume + " Luminosità video : " + this.luminosita;
    }

    @Override
    public void play() {
          String strTitVideo = titolo;
        for (int i = 0; i < durata; i++) {
            strTitVideo += "!";

        }

    }

    @Override
    public void luminosita() {

    }

    @Override
    public void play(String titolo, int durata) {

    }
}
