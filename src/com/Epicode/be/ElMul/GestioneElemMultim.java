package com.Epicode.be.ElMul;

import java.util.Arrays;
import java.util.Scanner;

public class GestioneElemMultim{

    public static void main(String[] args) {

        PlayerMultimediale[] a1 = new PlayerMultimediale[5];
        Immagine imm1 = new Immagine("CIAOOOO", 9);


        imm1.show();


        RegistrazAudio r1 = new RegistrazAudio("AAA", 1, 2);
        a1[0] = r1;
        System.out.println(Arrays.toString(a1));
       // System.out.println(Collections.singleton(r1));

        Video v1 = new Video("CHACHACHA" , 3,5, 4);
//        v1.alzaVolume();
//        v1.alzaVolume();
//        v1.alzaVolume();
//        v1.alzaVolume();
//        v1.alzaVolume();
//        v1.alzaVolume();
//        v1.play();





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
                Video elVideo = new Video(titolo, durataint, volumeInt, luminositaInt);
             // DOPO AVER CREATO L'ELEMENTO, SOVRASCRIVO POSIZIONE I DEL VETTORE EL1 CON L'ELEMENTO ELVIDEO
                elVideo.play();
                el1[i] = elVideo;

            } else if(elementoDaCreare.equals("immagine")){
                int luminositaInt = Integer.parseInt(luminosita);
               Immagine elImmagine = new Immagine(titolo, luminositaInt);
                //DOPO AVER CREATO L'ELEMENTO, SOVRASCRIVO POSIZIONE I DEL VETTORE EL1 CON L'ELEMENTO ELVIDEO
                elImmagine.show();
                el1[i] = elImmagine;
                //elImmagine.aumentaLuminosita();
            }


        }



    }
}
