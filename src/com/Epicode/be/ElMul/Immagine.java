package com.Epicode.be.ElMul;

public class Immagine extends ImmagineVideo implements Luminosita{
    protected int luminosita;


    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;

    }

    @Override
    public String info() {
        return super.info() + " Luminosità :" + this.luminosita;
    }

    @Override
    public void play() {

    }

    @Override
    public void luminosita() {

    }



}
