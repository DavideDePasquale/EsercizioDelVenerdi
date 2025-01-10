package com.Epicode.be.ElMul;

import java.util.Scanner;

public class GestioneElemMultim{

    public static void main(String[] args) {


        //CREARE SCANNER
        Scanner sc = new Scanner(System.in);
        PlayerMultimediale[] el1 = new PlayerMultimediale[5];


        for (int i = 0; i < el1.length; i++) {

            //CREARE VARIABILE ELEMENTO DA CREARE!
            //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE CREATA PRIMA
            System.out.println("inserisci elemento");
            String elementoDaCreare = sc.next();

            //CREARE VARIABILE TITOLO!
            //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE TITOLO
            System.out.println("inserisci titolo");
            String titolo = sc.next();

            //CREA VARIABILE DURATA
            //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE DURATA
            //VALUTARE SE CI SERVE EFFETTIVAMENTE SAPERE LA DURATA...
            String durata = "";
            String volume = "";
            if(!elementoDaCreare.equals("immagine")) {


                System.out.println("inserisci durata");
                durata = sc.next();


            //CREARE VARIABILE VOLUME!
            //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE VOLUME
            System.out.println("inserisci volume");
            volume = sc.next();
            }

            //CREARE VARIABILE VOLUME!
            //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE LUMINOSITA
            System.out.println("inserisci luminosità");
            String luminosita = sc.next();


            if (elementoDaCreare.equals("video")) {
                int durataint = Integer.parseInt(durata);
                int volumeInt = Integer.parseInt(volume);
                int luminositaInt = Integer.parseInt(luminosita);
                ImmagineVideo elVideo = new Video(titolo, durataint, volumeInt, luminositaInt);
             // DOPO AVER CREATO L'ELEMENTO, SOVRASCRIVO POSIZIONE I DEL VETTORE EL1 CON L'ELEMENTO ELVIDEO
                System.out.println(elVideo.info());
                el1[i] = elVideo;

            } else if(elementoDaCreare.equals("immagine")){
                int luminositaInt = Integer.parseInt(luminosita);
                ImmagineVideo elImmagine = new Immagine(titolo, luminositaInt);
                //DOPO AVER CREATO L'ELEMENTO, SOVRASCRIVO POSIZIONE I DEL VETTORE EL1 CON L'ELEMENTO ELVIDEO
                System.out.println(elImmagine.info());
                el1[i] = elImmagine;
                elImmagine.aumentaLuminosita();
            }


        }
    }
    public void play(String titolo, int durata){


    }




}
