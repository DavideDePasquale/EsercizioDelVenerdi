package com.Epicode.be.ElMul;

public class RegistrazAudio extends PlayerMultimediale implements Volume{
      protected int durata;
      protected int volume;
    public RegistrazAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;


    }
    public void play() {
        String strtitolo = titolo;
        for (int i = 0; i < volume; i++) {
            strtitolo += "!";

        }
        for (int j = 0; j < durata; j++) {

            System.out.println("titolo : " + strtitolo +" Durata registrazione : " + this.durata + " Volume registrazione : " + this.volume);
        }


    }

    @Override
    public void alzaVolume() {
        this.volume ++;

    }

    @Override
    public void abbassaVolume() {
        if(this.volume > 0){
            this.volume --;

        } else {
            System.out.println("Il volume non puo essere minore di 0");
        }

    }

    @Override
    public void riproduci() {
        System.out.println("AUDIO INSERITO CORRETTAMENTE!");
        play();
    }
    @Override
    public String toString() {
        return super.toString() + " , Durata: " + durata + " min , Volume : " + volume;
    }
}
