package com.Epicode.be.ElMul;

public class Video extends PlayerMultimediale implements Luminosita,Volume{
    protected int durata;
    protected int volume;
      protected int luminosita;
    public Video(String titolo , int durata, int volume, int luminosita) {
        super(titolo);

        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;


    }

    public void play() {
        for (int i = durata; i > 0; i--) {
            System.out.println("Titolo : " + this.titolo + " Durata video : " +  this.durata --);
                infoLuminosita();
                infoVolume();
        }
    }


    @Override
    public void alzaLuminosita() {
        if(luminosita > 0){
            luminosita ++;

        } else {
            System.out.println("Luminosità al massimo!");
        }

    }

    @Override
    public void abbassaLuminosita() {
        if(luminosita < 10){
            luminosita--;
        } else {
            System.out.println("Non puoi abbassare la luminosità! è già troppo bassa!");
        }

    }

    @Override
    public void infoLuminosita() {
        System.out.println("LUMINOSITA' : " + "*".repeat(luminosita));
    }

    @Override
    public void alzaVolume() {
        if(volume > 0){
            volume ++;

        } else {
            System.out.println("Volume al massimo!");
        }


    }

    @Override
    public void abbassaVolume() {
        if(volume < 10){
            volume--;
        } else {
            System.out.println("Non puoi abbassare il volumeeee! è già troppo basso!");
        }


    }
    public void infoVolume(){
        System.out.println(" Volume : " + "!".repeat(volume));
    }
}
