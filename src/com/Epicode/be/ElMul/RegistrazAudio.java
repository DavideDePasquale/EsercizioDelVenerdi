package com.Epicode.be.ElMul;

public class RegistrazAudio extends PlayerMultimediale implements Volume{
      protected int durata;
      protected int volume;
    public RegistrazAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;


    }

    @Override
    public String info() {
        return super.info() + "Durata registrazione : " + this.durata + "Volume registrazione : " + this.volume;
    }

    @Override
    public void alzaVolume() {
        this.volume ++;
        play();
    }

    @Override
    public void abbassaVolume() {
        if(this.volume > 0){
            this.volume --;
        } else {
            System.out.println("Il volume non puo essere minore di 0");
        }

    }
    public void play(){
        String strtitolo = titolo;
        for (int i = 0; i < volume; i++) {
            strtitolo += "!";
        }
        for (int i = 0; i < durata; i++) {
            System.out.println(strtitolo);

        }

    }
}
