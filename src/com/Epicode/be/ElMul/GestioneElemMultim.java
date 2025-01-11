package com.Epicode.be.ElMul;

import java.util.Arrays;
import java.util.Scanner;

public class GestioneElemMultim{

    public static void main(String[] args) {

        //CREARE SCANNER
        Scanner sc = new Scanner(System.in);
        PlayerMultimediale[] el1 = new PlayerMultimediale[5];


        for (int i = 0; i < el1.length; i++) {

            //CREARE VARIABILE ELEMENTO DA CREARE!
            //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE CREATA PRIMA

            System.out.println("inserisci audio, video o immagine");

            String elementoDaCreare = sc.next();
            if (elementoDaCreare.equals("audio") || elementoDaCreare.equals("video") || elementoDaCreare.equals("immagine")) {

                //CREARE VARIABILE TITOLO!
                //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE TITOLO
                System.out.println("inserisci titolo");
                String titolo = sc.next();

                //CREA VARIABILE DURATA
                //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE DURATA
                //VALUTARE SE CI SERVE EFFETTIVAMENTE SAPERE LA DURATA...
                String durata = "";
                String volume = "";
                if (!elementoDaCreare.equals("immagine")) {


                    System.out.println("inserisci durata");
                    durata = sc.next();


                    //CREARE VARIABILE VOLUME!
                    //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE VOLUME
                    System.out.println("inserisci volume");
                    volume = sc.next();
                }

                //CREARE VARIABILE LUMINOSITà!
                //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE LUMINOSITA
                String luminosita = "";

                if (!elementoDaCreare.equals("audio")) {
                    System.out.println("inserisci luminosità");
                    luminosita = sc.next();
                }

                if (elementoDaCreare.equals("video")) {
                    int durataVideo = Integer.parseInt(durata);
                    int volumeVideo = Integer.parseInt(volume);
                    int luminositaVideo = Integer.parseInt(luminosita);
                    Video elVideo = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    // DOPO AVER CREATO L'ELEMENTO, SOVRASCRIVO POSIZIONE I DEL VETTORE EL1 CON L'ELEMENTO ELVIDEO
                    elVideo.play();
                    el1[i] = elVideo;

                } else if (elementoDaCreare.equals("immagine")) {
                    int luminositaInt = Integer.parseInt(luminosita);
                    Immagine elImmagine = new Immagine(titolo, luminositaInt);
                    //DOPO AVER CREATO L'ELEMENTO, SOVRASCRIVO POSIZIONE I DEL VETTORE EL1 CON L'ELEMENTO ELVIDEO
                    elImmagine.show();
                    el1[i] = elImmagine;
                    //elImmagine.aumentaLuminosita();
                } else if (elementoDaCreare.equals("audio")) {
                    int durataAudio = Integer.parseInt(durata);
                    int volumeAudio = Integer.parseInt(volume);
                    RegistrazAudio regAudio1 = new RegistrazAudio(titolo, durataAudio, volumeAudio);
                    regAudio1.play();
                    el1[i] = regAudio1;
                }
            }
        }
    }
}
