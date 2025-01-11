package com.Epicode.be.ElMul;

public class Immagine extends PlayerMultimediale implements Luminosita {
    protected int luminosita;


    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;

    }


    public void show() {
        System.out.println("Titolo : " + this.titolo);
        infoLuminosita();
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
}
