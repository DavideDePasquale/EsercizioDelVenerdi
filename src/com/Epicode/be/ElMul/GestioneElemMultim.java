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

            System.out.println("inserisci audio, video o immagine");

            String elementoDaCreare = sc.next().toLowerCase();
            sc.nextLine();
            if (elementoDaCreare.equals("audio") || elementoDaCreare.equals("video") || elementoDaCreare.equals("immagine")) {

                //CREARE VARIABILE TITOLO!
                //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE TITOLO
                System.out.println("inserisci titolo");

                String titolo = sc.nextLine();


                //CREA VARIABILE DURATA
                //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE DURATA
                //VALUTARE SE CI SERVE EFFETTIVAMENTE SAPERE LA DURATA...
                String durata = "";
                String volume = "";
                if (!elementoDaCreare.equals("immagine")) {
                    boolean stringaValidaDur = false;
                    while(!stringaValidaDur){
                        System.out.println("inserisci durata");
                        durata = sc.next();
                        try{
                            //converto il valore stringa di luminosità in intero
                            int durataInt = Integer.parseInt(durata);
                            stringaValidaDur = true;
                            if(durataInt > 0 && durataInt <= 10){
                                stringaValidaDur = true;
                            } else {
                                System.out.println("Devi mettere un valore compreso fra 1 e 10!");
                                durata = sc.next();
                            }

                        } catch (NumberFormatException eccezione){
                            System.out.println("Devi inserire un numero che rappresenta la durata!");

                        }


                    }
                    boolean stringaValidaVol = false;
                    while(!stringaValidaVol){
                        System.out.println("inserisci volume");
                        volume = sc.next();
                        try{
                            //converto il valore stringa di luminosità in intero
                            int volumeInt = Integer.parseInt(volume);
                            stringaValidaVol = true;
                               if(volumeInt > 0 && volumeInt <= 10){
                                   stringaValidaVol = true;
                               } else {
                                   System.out.println("Devi mettere un valore compreso fra 1 e 10!");
                                   volume = sc.next();
                               }
                        } catch (NumberFormatException eccezione){
                            System.out.println("Devi inserire un numero che rappresenta il volume!");

                        }



                    }
                    int volumeUfficiale = Integer.parseInt(volume);


                    //CREARE VARIABILE VOLUME!
                    //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE VOLUME

                }

                //CREARE VARIABILE LUMINOSITà!
                //PRENDERE IN INPUT CON SCANNER NEXT () LA VARIABILE LUMINOSITA
                String luminosita = "";

                if (!elementoDaCreare.equals("audio")) {

                    boolean stringaValidaLum = false;
                    while(!stringaValidaLum){
                            System.out.println("inserisci luminosità");
                            luminosita = sc.next();
                           try{
                               //converto il valore stringa di luminosità in intero
                             int luminositaInt =  Integer.parseInt(luminosita);
                               stringaValidaLum = true;
                               if(luminositaInt > 0 && luminositaInt <= 10){
                                   stringaValidaLum = true;
                               } else {
                                   System.out.println("Devi mettere un valore compreso fra 1 e 10!");
                                   luminosita = sc.next();
                               }

                           } catch (NumberFormatException eccezione){
                               System.out.println("Devi inserire un numero!");
                           }
                    }
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
            //qui voglio vedere gli elementi creati
            for (PlayerMultimediale oggettoNellArray : el1) {
                if (oggettoNellArray != null) {
                    System.out.println(oggettoNellArray);  // Questo invoca il metodo toString() su ogni oggetto
                }
            }
        }
        System.out.println("Scegli un numero da 1 a 5 per visualizzare uno degli oggetti appena creati o 0 per chiudere il terminale!");
        int scelta = sc.nextInt();
        sc.nextLine();
        switch (scelta){
            case 1 : {
                System.out.println(el1[0]);
                System.out.println("Cosa vorresti fare di questo oggetto?");
                String cosaFare = sc.nextLine();
                if(cosaFare.toLowerCase().contains("modifica")){
                    System.out.println("Vuoi modificare il titolo? si/no");
                    String siOno = sc.nextLine();
                    if(siOno.toLowerCase().equals("si")){
                        System.out.println("Inserisci un nuovo titolo");
                        String nuovoTitolo = sc.nextLine();
                        el1[0].titolo = nuovoTitolo;
                    }
                    if(el1[0] instanceof Video){
                        Video videoModificato = (Video) el1[0];
                        System.out.println("Vuoi modificare la durata del video? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata del video");
                            videoModificato.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume del video? si/no");
                        String siOnoVol = sc.nextLine();
                        if(siOnoVol.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume");
                            videoModificato.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare la luminosità del video? si/no");
                        String siOnoLum = sc.nextLine();
                        if(siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova luminosità");
                            videoModificato.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Video modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Video : " + videoModificato);
                    }
                    if(el1[0] instanceof Immagine){
                        Immagine immagineModificata = (Immagine) el1[0];
                        System.out.println("Vuoi modificare la luminosità dell'immagine? si/no");
                        String siOnoLum = sc.nextLine();
                        if (siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo valore di luminosità.");
                            immagineModificata.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Immagine modificata correttamente!");
                        System.out.println("Ecco il nuovo oggetto Immagine : " + immagineModificata);
                    }
                    if(el1[0] instanceof RegistrazAudio){
                        RegistrazAudio regAudioMod = (RegistrazAudio) el1[0];
                        System.out.println("Vuoi modificare la durata dell'audio? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata dell'audio");
                            regAudioMod.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume dell'audio? si/no");
                        String siOnoAud = sc.nextLine();
                        if(siOnoAud.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume dell'audio");
                            regAudioMod.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Audio modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Audio : " + regAudioMod);
                    }


                }


                break;
            } case 2 : {
                System.out.println(el1[1]);
                System.out.println("Cosa vorresti fare di questo oggetto?");
                String cosaFare = sc.nextLine();
                if(cosaFare.toLowerCase().contains("modifica")){
                    System.out.println("Vuoi modificare il titolo? si/no");
                    String siOno = sc.nextLine();
                    if(siOno.toLowerCase().equals("si")){
                        System.out.println("Inserisci un nuovo titolo");
                        String nuovoTitolo = sc.nextLine();
                        el1[1].titolo = nuovoTitolo;
                    }
                    if(el1[1] instanceof Video){
                        Video videoModificato = (Video) el1[1];
                        System.out.println("Vuoi modificare la durata del video? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata del video");
                            videoModificato.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume del video? si/no");
                        String siOnoVol = sc.nextLine();
                        if(siOnoVol.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume");
                            videoModificato.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare la luminosità del video? si/no");
                        String siOnoLum = sc.nextLine();
                        if(siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova luminosità");
                            videoModificato.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Video modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Video : " + videoModificato);
                    }
                    if(el1[1] instanceof Immagine){
                        Immagine immagineModificata = (Immagine) el1[1];
                        System.out.println("Vuoi modificare la luminosità dell'immagine? si/no");
                        String siOnoLum = sc.nextLine();
                        if (siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo valore di luminosità.");
                            immagineModificata.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Immagine modificata correttamente!");
                        System.out.println("Ecco il nuovo oggetto Immagine : " + immagineModificata);
                    }
                    if(el1[1] instanceof RegistrazAudio){
                        RegistrazAudio regAudioMod = (RegistrazAudio) el1[1];
                        System.out.println("Vuoi modificare la durata dell'audio? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata dell'audio");
                            regAudioMod.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume dell'audio? si/no");
                        String siOnoAud = sc.nextLine();
                        if(siOnoAud.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume dell'audio");
                            regAudioMod.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Audio modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Audio : " + regAudioMod);
                    }


                }


                break;
            } case 3 : {
                System.out.println(el1[2]);
                System.out.println("Cosa vorresti fare di questo oggetto?");
                String cosaFare = sc.nextLine();
                if(cosaFare.toLowerCase().contains("modifica")){
                    System.out.println("Vuoi modificare il titolo? si/no");
                    String siOno = sc.nextLine();
                    if(siOno.toLowerCase().equals("si")){
                        System.out.println("Inserisci un nuovo titolo");
                        String nuovoTitolo = sc.nextLine();
                        el1[2].titolo = nuovoTitolo;
                    }
                    if(el1[2] instanceof Video){
                        Video videoModificato = (Video) el1[2];
                        System.out.println("Vuoi modificare la durata del video? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata del video");
                            videoModificato.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume del video? si/no");
                        String siOnoVol = sc.nextLine();
                        if(siOnoVol.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume");
                            videoModificato.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare la luminosità del video? si/no");
                        String siOnoLum = sc.nextLine();
                        if(siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova luminosità");
                            videoModificato.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Video modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Video : " + videoModificato);
                    }
                    if(el1[2] instanceof Immagine){
                        Immagine immagineModificata = (Immagine) el1[2];
                        System.out.println("Vuoi modificare la luminosità dell'immagine? si/no");
                        String siOnoLum = sc.nextLine();
                        if (siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo valore di luminosità.");
                            immagineModificata.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Immagine modificata correttamente!");
                        System.out.println("Ecco il nuovo oggetto Immagine : " + immagineModificata);
                    }
                    if(el1[2] instanceof RegistrazAudio){
                        RegistrazAudio regAudioMod = (RegistrazAudio) el1[2];
                        System.out.println("Vuoi modificare la durata dell'audio? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata dell'audio");
                            regAudioMod.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume dell'audio? si/no");
                        String siOnoAud = sc.nextLine();
                        if(siOnoAud.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume dell'audio");
                            regAudioMod.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Audio modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Audio : " + regAudioMod);
                    }


                }


                break;
            }  case 4 : {
                System.out.println(el1[3]);
                System.out.println("Cosa vorresti fare di questo oggetto?");
                String cosaFare = sc.nextLine();
                if(cosaFare.toLowerCase().contains("modifica")){
                    System.out.println("Vuoi modificare il titolo? si/no");
                    String siOno = sc.nextLine();
                    if(siOno.toLowerCase().equals("si")){
                        System.out.println("Inserisci un nuovo titolo");
                        String nuovoTitolo = sc.nextLine();
                        el1[3].titolo = nuovoTitolo;
                    }
                    if(el1[3] instanceof Video){
                        Video videoModificato = (Video) el1[3];
                        System.out.println("Vuoi modificare la durata del video? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata del video");
                            videoModificato.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume del video? si/no");
                        String siOnoVol = sc.nextLine();
                        if(siOnoVol.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume");
                            videoModificato.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare la luminosità del video? si/no");
                        String siOnoLum = sc.nextLine();
                        if(siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova luminosità");
                            videoModificato.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Video modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Video : " + videoModificato);
                    }
                    if(el1[3] instanceof Immagine){
                        Immagine immagineModificata = (Immagine) el1[3];
                        System.out.println("Vuoi modificare la luminosità dell'immagine? si/no");
                        String siOnoLum = sc.nextLine();
                        if (siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo valore di luminosità.");
                            immagineModificata.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Immagine modificata correttamente!");
                        System.out.println("Ecco il nuovo oggetto Immagine : " + immagineModificata);
                    }
                    if(el1[3] instanceof RegistrazAudio){
                        RegistrazAudio regAudioMod = (RegistrazAudio) el1[3];
                        System.out.println("Vuoi modificare la durata dell'audio? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata dell'audio");
                            regAudioMod.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume dell'audio? si/no");
                        String siOnoAud = sc.nextLine();
                        if(siOnoAud.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume dell'audio");
                            regAudioMod.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Audio modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Audio : " + regAudioMod);
                    }


                }


                break;
            }  case 5 : {
                System.out.println(el1[4]);
                System.out.println("Cosa vorresti fare di questo oggetto?");
                String cosaFare = sc.nextLine();
                if(cosaFare.toLowerCase().contains("modifica")){
                    System.out.println("Vuoi modificare il titolo? si/no");
                    String siOno = sc.nextLine();
                    if(siOno.toLowerCase().equals("si")){
                        System.out.println("Inserisci un nuovo titolo");
                        String nuovoTitolo = sc.nextLine();
                        el1[4].titolo = nuovoTitolo;
                    }
                    if(el1[4] instanceof Video){
                        Video videoModificato = (Video) el1[4];
                        System.out.println("Vuoi modificare la durata del video? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata del video");
                            videoModificato.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume del video? si/no");
                        String siOnoVol = sc.nextLine();
                        if(siOnoVol.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume");
                            videoModificato.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare la luminosità del video? si/no");
                        String siOnoLum = sc.nextLine();
                        if(siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova luminosità");
                            videoModificato.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Video modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Video : " + videoModificato);
                    }
                    if(el1[4] instanceof Immagine){
                        Immagine immagineModificata = (Immagine) el1[4];
                        System.out.println("Vuoi modificare la luminosità dell'immagine? si/no");
                        String siOnoLum = sc.nextLine();
                        if (siOnoLum.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo valore di luminosità.");
                            immagineModificata.luminosita = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Immagine modificata correttamente!");
                        System.out.println("Ecco il nuovo oggetto Immagine : " + immagineModificata);

                    }
                    if(el1[4] instanceof RegistrazAudio){
                        RegistrazAudio regAudioMod = (RegistrazAudio) el1[4];
                        System.out.println("Vuoi modificare la durata dell'audio? si/no");
                        String siOnoDur = sc.nextLine();
                        if(siOnoDur.toLowerCase().equals("si")){
                            System.out.println("Inserisci la nuova durata dell'audio");
                            regAudioMod.durata = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Vuoi modificare il volume dell'audio? si/no");
                        String siOnoAud = sc.nextLine();
                        if(siOnoAud.toLowerCase().equals("si")){
                            System.out.println("Inserisci il nuovo volume dell'audio");
                            regAudioMod.volume = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Oggetto di tipo Audio modificato correttamente!");
                        System.out.println("Ecco il nuovo oggetto Audio : " + regAudioMod);
                    }


                }


                break;
            }  case 0 : {
                sc.close();
                break;
            } default: {
                System.out.println("Numero non valido, inserisci un numero fra 1 e 5 per selezionare un oggetto o 0 per chiudere il terminale");
            }
        }

    }
}
 // spero di aver capito bene la consegna, ho fatto l'impossibile intrecciando anche la polvere che c'è in stanza :)
