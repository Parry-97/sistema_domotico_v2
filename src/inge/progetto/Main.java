package inge.progetto;

import it.unibs.fp.mylib.*;

import java.io.*;
import java.util.*;

/**
 * Principale punto d'avvio e funzionamento del sistema domotico. Svolge un ruolo di interfacciamento tra l'utente e la logica interna
 * del sistema, permettendo all'utente di interagire con l'unita immobiliare e le sue sottounit&agrave;. Vi sono 2 tipi di utente: manutentore e
 * fruitore. Il primo &egrave; un esponente dell&rsquo;azienda che installa l&rsquo;impianto; egli &egrave; deputato alla descrizione delle
 * categorie di dispositivi utilizzabili e delle singole unit&agrave; immobiliari controllate dal
 * sistema. Le unit&agrave; immobiliari possono avere diverse destinazioni d&rsquo;uso: residenziale,
 * commerciale, produttiva ecc. Il secondo tipo di utente &egrave; una persona che usa il sistema
 * installato per adattare le condizioni di una specifica unit&agrave; immobiliare alle esigenze
 * connesse alla destinazione della stessa e/o espresse dalle persone in essa ospitate; ad
 * esempio, pu&ograve; trattarsi di un inquilino di un appartamento o del responsabile delle
 * condizioni ambientali interne di un capannone destinato all&rsquo;allevamento di pollame, ecc.
 *
 * @author Parampal Singh, Mattia Nodari
 */
public class Main {

    public static void main(String[] args) {
        //TODO: Testare tutte le nuove funzio con un dummy Main
        /*ArrayList<Informazione> testInfos1 = new ArrayList<>();
        ArrayList<Informazione> testInfos2 = new ArrayList<>();

        ArrayList<String> domNonNum = new ArrayList<>();
        domNonNum.add("Presente");
        domNonNum.add("Non-Presente");

        testInfos1.add(new Informazione("STATO"));//funge da placeholder per stato artefatto
        testInfos1.add(new Informazione("temp_interna_lamp", 50, -50));

        testInfos2.add(new InformazioneNonNum("Presenza Persone", domNonNum));

        HashMap<String, Integer> parametri = new HashMap<>();
        parametri.put("energia_media_dissipata", 100);

        CategoriaAttuatore catInt = new CategoriaAttuatore("interruttore", "dadad");
        catInt.aggiungiModalitaOperativa(new ModalitaOperativa("Acceso")); //Codice di v1
        catInt.aggiungiModalitaOperativa(new ModalitaOperativa("Spento"));
        catInt.aggiungiModalitaOperativa(new ModalitaOperativa("Risparmio", parametri));

        CategoriaSensore cats1 = new CategoriaSensore("sensLamp","sdasdada",false);
        cats1.setInfoRilevabili(testInfos1);

        CategoriaSensore cats2 = new CategoriaSensore("VideoSorv", "sdadadsd", true);
        cats2.setInfoRilevabili(testInfos2);

        Sensore s1 = new Sensore("s1",cats1);
        Sensore sVid = new Sensore("vid", cats2);

        Artefatto lampada1 = new Artefatto("lampada1", new ModalitaOperativa("Spento"));
        Artefatto lampada2 = new Artefatto("lampada2", new ModalitaOperativa("Spento"));

        Attuatore int1 = new Attuatore("int1", catInt,"Spento",false);
        Attuatore int2 = new Attuatore("int2", catInt, "Spento",false);

        lampada1.aggiungiSensore(s1);
        lampada1.aggiungiAttuatore(int1);

        lampada2.aggiungiAttuatore(int2);

        System.out.println(" *** Misure di sVid e s1 : ");
        for (int i = 0; i < 12; i++) {

            if(i == 4)
                int1.setModalitaAttuale("Acceso","energia_media_dissipata", 10);//TODO: Verificare nel Main che la modalita operativa sia parametrica o meno

            if (i == 8)
                int1.setModalitaAttuale("Risparmio", "energia_media_dissipata",80);

            System.out.println( i +") " + "sVid: " + sVid.getRilevazioni());
            System.out.println("    S1: " + s1.getRilevazioni()) ;
        }

        System.out.println("\nT2) Misure di sensLamp");
        System.out.println(lampada1.visualizzaDispositivi());
        System.out.println(lampada2.visualizzaDispositivi());

         */


        /*UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare();
        ArrayList<CategoriaAttuatore> listaCategoriaAttuatori = new ArrayList<>();
        ArrayList<CategoriaSensore> listaCategoriaSensori = new ArrayList<>();
        ArrayList<ModalitaOperativa> listaModalitaOperative = new ArrayList<>();
        ArrayList<Attuatore> listaAttuatori = new ArrayList<>();
        ArrayList<Sensore> listaSensori = new ArrayList<>();

        String operatore;
        do {

            do {
                operatore = InputDati.leggiStringa("Selezionare il tipo di Utente(manutentore/fruitore) o FINE per uscire: ");
            } while (!operatore.equals("manutentore") && !operatore.equals("fruitore") && !operatore.equals("FINE"));

            if (operatore.equals("manutentore")) {
                int caso;

                do {
                    System.out.println("\n1) CREA UNITA' IMMOBILIARE\n2) CREA STANZA\n3) AGGIUNGI UNA CATEGORIA DI SENSORI\n4) AGGIUNGI UNA CATEGORIA DI ATTUATORI\n" +
                            "5) CREA ARTEFATTO\n6) CREA NUOVA MODALITA' OPERATIVA\n7) CREA ATTUATORE\n8) ASSEGNA MODALITA' OPERATIVA AD UNA CATEGORIA DI ATTUATORI\n9) CREA SENSORE\n" +
                            "10) AGGIUNGI SENSORE E ATUATORE AD ARTEFATTO\n11) AGGIUNGI ARTEFATTO A STANZA\n12) AGGIUNGI SENSORE A STANZA\n13) MOSTRA RILEVAZIONI DI UN SENSORE\n" +
                            "14) SETTA NUOVA MODALITA' ATTUATORE\n15) VISUALIZZA TUTTO\n16) SALVA CATEGORIE DI SENSORI E ATTUATORI SU FILE\n17) RIPRISTINA CATEGORIE DI SENSORI E ATTUATORI\n0) USCITA");

                    caso = InputDati.leggiIntero("Seleziona funzionalità: ");
                    switch (caso) {
                        case 1:
                            if (!unitaImmobiliare.getTipo().equals(""))
                                System.out.println("Unità Immobiliare già creata!");
                            else {
                                String tipo = InputDati.leggiStringa("\nDefinire il tipo dell'unità immobiliare da creare: ");
                                unitaImmobiliare = new UnitaImmobiliare(tipo);
                                System.out.println("Unità immobiliare creata correttamente");
                            }

                            break;
                        case 2:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima della creazione della stanza");
                            } else {
                                String nomeStanza = InputDati.leggiStringa("\nInserire il nome della stanza da creare: ");
                                unitaImmobiliare.aggiungiStanza(new Stanza(nomeStanza));
                            }

                            break;
                        case 3:


                            //TODO: Permettere al manutentore piu info rilevabili durante definizione di categoria di sensore
                            boolean categoriaPresenteSensore = false;
                            String nomeCategoriaSensore = InputDati.leggiStringa("\nInserisci nome della nuova categoria di sensori: ");

                            for (CategoriaSensore s : listaCategoriaSensori) {
                                if (s.getNome().equals(nomeCategoriaSensore)) {
                                    System.out.println("La categoria desiderata è gia stata creata precedentemente");
                                    categoriaPresenteSensore = true;
                                    break;
                                }
                            }

                            if (!categoriaPresenteSensore) {
                                String testoLibero = InputDati.leggiStringa("Inserisci il testo descrittivo per la nuova categoria di sensore:\n");
                                boolean fisico = InputDati.yesOrNo("E' una categoria di sensori fisico?");

                                //TODO: Aggiungere la possibilita di definire numero, nome e dominio delle informazioni oltre a fisico
                                //del tipo CategoriaSensore tempCategoria = new CategoriaSensore(nomeCategoriaSensore, testoLibero, fisico, infos);
                                //dove info è un arraylist di dimensione definita da manutentore di info casuali di default ma con nome, dominio specificate dall'utente
                                //Se poi info è non fisica ovvero da associare ad un artefatto si può fare che la info al primo indice è un info casuale di default di nome
                                //STATO che verrà poi sovrascitta dall'artefatto(Una sorta di placeholder)
                                //Test
                                ArrayList<Informazione> testInfos = new ArrayList<>();

                                InformazioneNonNum infoNan = new InformazioneNonNum("VideoDetect");
                                infoNan.setDominioNonNumerico(new ArrayList<>(List.of("Morto", "Vivo")));
                                testInfos.add(new Informazione("temp", 50,-50));
                                testInfos.add(infoNan);

                                //Aggiungere info rilevabili(anche multiple) al costruttore della categoria sensore
                                CategoriaSensore tempCategoria = new CategoriaSensore(nomeCategoriaSensore, testoLibero, fisico);

                                //TODO: Aggiungere info a una lista che va a sua volta aggiunta al costruttore
                                listaCategoriaSensori.add(tempCategoria);
                                System.out.println("Categoria creata correttamente");
                                if (fisico) {
                                    String informazione = InputDati.leggiStringa("Inserisci il tipo dell'informazione che questo sensore acquisisce: ");
                                    int min = InputDati.leggiIntero("Inserisci il valore minimo di " + informazione + " che la categoria acquisisce: ");
                                    int max = InputDati.leggiIntero("Inserisci il valore massimo di " + informazione + " che la categoria acquisisce: ");
                                    tempCategoria.setInfoRilevabile(new Informazione(informazione, max, min, false));
                                    System.out.println("Informazioni settate correttamente");
                                }
                            }

                            break;
                        case 4:

                            String nomeCategoriaAttuatore = InputDati.leggiStringa("\nInserisci nome della nuova categoria di attuatori: ");
                            boolean categoriaPresenteAttuatore = false;
                            for (CategoriaAttuatore a : listaCategoriaAttuatori) {
                                if (a.getNome().equals(nomeCategoriaAttuatore)) {
                                    System.out.println("La categoria desiderata è gia stata creata precedentemente");
                                    categoriaPresenteAttuatore = true;
                                    break;
                                }
                            }

                            if (!categoriaPresenteAttuatore) {
                                String testoLibero = InputDati.leggiStringa("Inserisci il testo descrittivo per la nuova categoria di attuatori:\n");
                                listaCategoriaAttuatori.add(new CategoriaAttuatore(nomeCategoriaAttuatore, testoLibero));
                                System.out.println("Categoria creata correttamente");
                            }

                            break;
                        case 5:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima della creazione di un artefatto");
                                break;
                            }
                            if (listaModalitaOperative.isEmpty()) {
                                System.out.println("E' necessario definire una lista di modalità operative da assegnare come stato iniziale per l'artefatto");
                                break;
                            }
                            String nomeArtefatto = InputDati.leggiStringa("\nInserisci nome artefatto: ");
                            if (!listaModalitaOperative.isEmpty()) {
                                System.out.println("...MODALITA' OPERATIVE ATTUALMENTE CREATE...");
                                for (ModalitaOperativa modalit : listaModalitaOperative) {
                                    System.out.println("Nome modalità: " + modalit.getNome());
                                }
                            }

                            //TODO: Aggiungere possibilta di definizione di parametri della modalita operativa
                            String nomeStato = InputDati.leggiStringa("Inserisci stato di default per il nuovo artefatto: ");
                            for (ModalitaOperativa modalita : listaModalitaOperative) {
                                if (modalita.getNome().equals(nomeStato)) {
                                    unitaImmobiliare.aggiungiArtefatto(new Artefatto(nomeArtefatto, new ModalitaOperativa(nomeStato)));
                                    break;
                                } else
                                    System.out.println("Lo stato attuale non è stato definito. E' necessario definirlo prima di poterlo assegnare ad un artefatto");
                            }

                            break;
                        case 6:

                            boolean presenteModalita = false;
                            String nuovaModalita = InputDati.leggiStringa("\nInserisci nuova modalità operativa: ");
                            for (ModalitaOperativa modalita : listaModalitaOperative) {
                                if (modalita.getNome().equals(nuovaModalita)) {
                                    System.out.println("Modalità operativa già creata precedentemente");
                                    presenteModalita = true;
                                    break;
                                }
                            }
                            if (!presenteModalita) {
                                int valore = InputDati.leggiIntero("Inserisci il valore di default della nuova modalità operativa: ");
                                //listaModalitaOperative.add(new ModalitaOperativa(nuovaModalita, valore));
                                //TODO: Fare if per definire parametri
                                listaModalitaOperative.add(new ModalitaOperativa(nuovaModalita)); //TODO: Controllare con funzionalità primarie di v1
                                System.out.println("Modalità operativa aggiunta correttamene");
                            }

                            break;
                        case 7:
                            if (listaCategoriaAttuatori.isEmpty()) {
                                System.out.println("Non sono presenti categorie di attuatori. E' necessario definirla prima di questa operazione");
                                break;
                            }
                            String nuovoAttuatore = InputDati.leggiStringa("\nInserisci nome nuovo attuatore: ");
                            boolean presenteAttuatore = false;
                            boolean erroreCategoria = true;
                            boolean erroreStato = true;

                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima di questa operazione");
                                break;
                            }
                            for (Attuatore a : listaAttuatori) {
                                if (a.getNome().equals(nuovoAttuatore)) {
                                    System.out.println("Esiste già un attuatore con lo stesso nome. E' necessario avere nomi differenti.");
                                    presenteAttuatore = true;
                                    break;
                                }
                            }


                            if (!presenteAttuatore) {

                                if (!listaCategoriaAttuatori.isEmpty()) {
                                    System.out.println("...CATEGORIE ATTUALMENTE CREATE...");
                                    for (CategoriaAttuatore cA : listaCategoriaAttuatori) {
                                        System.out.println("Nome Categoria Attuatori: " + cA.getNome());
                                    }
                                }

                                String categoria = InputDati.leggiStringa("Inserisci la categoria in cui rientra questo attuatore: ");
                                for (CategoriaAttuatore cat : listaCategoriaAttuatori) {
                                    if (cat.getNome().equals(categoria)) {
                                        erroreCategoria = false;

                                        if (!listaModalitaOperative.isEmpty()) {
                                            System.out.println("...MODALITA' OPERATIVE ATTUALMENTE CREATE...");
                                            for (ModalitaOperativa modalit : listaModalitaOperative) {
                                                System.out.println("Nome modalità: " + modalit.getNome());
                                            }
                                        }


                                        String statoAttuale = InputDati.leggiStringa("Inserisci lo stato di default dell'attuatore: ");
                                        for (ModalitaOperativa mod : listaModalitaOperative) {
                                            if (mod.getNome().equals(statoAttuale)) {
                                                boolean singolo = InputDati.yesOrNo("Ha caratterstica di associazione singola: ");
                                                listaAttuatori.add(new Attuatore(nuovoAttuatore, cat, statoAttuale, singolo));
                                                System.out.println("L'attuatore è stato creato correttamente");
                                                erroreStato = false;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                if (erroreCategoria)
                                    System.out.println("La categoria selezionata non rientra tra quelle attualmente create");
                                else if (erroreStato)
                                    System.out.println("Lo stato di default selezionato non è rientra tra gli stati di questa categoria di attuatori");
                            }

                            break;
                        case 8:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima di questa operazione");
                                break;
                            }
                            boolean presenzaNome = false;
                            boolean presenzaCate = false;
                            System.out.println();
                            if (!listaCategoriaAttuatori.isEmpty()) {
                                System.out.println("...CATEGORIE ATTUALMENTE CREATE...");
                                for (CategoriaAttuatore cA : listaCategoriaAttuatori) {
                                    System.out.println("Nome Categoria Attuatori: " + cA.getNome());
                                }
                            }
                            String nomeCategoriaAtt = InputDati.leggiStringa("Insersci il nome della categoria di attuatori nella quale si vuole inserire la nuova modalità opeativa: ");
                            for (CategoriaAttuatore cate : listaCategoriaAttuatori) {
                                if (cate.getNome().equals(nomeCategoriaAtt)) {
                                    presenzaCate = true;
                                    if (!listaModalitaOperative.isEmpty()) {
                                        System.out.println("...MODALITA' OPERATIVE ATTUALMENTE CREATE...");
                                        for (ModalitaOperativa modalit : listaModalitaOperative) {
                                            System.out.println("Nome modalità: " + modalit.getNome());
                                        }
                                    }
                                    String moda = InputDati.leggiStringa("Inserisci il nome della modalità opeativa da aggiungere: ");
                                    for (ModalitaOperativa m : listaModalitaOperative) {
                                        if (m.getNome().equals(moda)) {
                                            cate.aggiungiModalitaOperativa(m);
                                            presenzaNome = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!presenzaCate) {
                                System.out.println("La categoria di attuatori selezionata non è ancora stata creata");
                                break;
                            }
                            if (!presenzaNome) {
                                System.out.println("La modalità operativa che si vuole aggiungere non è ancora stata creata");
                                break;
                            }
                            break;
                        case 9:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima di questa operazione");
                                break;
                            }
                            boolean presenzaSensore = false;
                            String nomeSensore = InputDati.leggiStringa("\nInserisci il nome del sensore da aggiungere: ");
                            for (Sensore sens : listaSensori) {
                                if (sens.getNome().equals(nomeSensore)) {
                                    System.out.println("Esiste già un sensore con lo stesso nome. E' necessario avere nomi differenti.");
                                    presenzaSensore = true;
                                    break;
                                }
                            }
                            boolean siCate = false;
                            if (!presenzaSensore) {
                                if (!listaCategoriaSensori.isEmpty()) {
                                    System.out.println("...CATEGORIE ATTUALMENTE CREATE...");
                                    for (CategoriaSensore sS : listaCategoriaSensori) {
                                        System.out.println("Nome Categoria Sensori: " + sS.getNome());
                                    }
                                }
                                String nomeCategoria = InputDati.leggiStringa("Inserisci il nome della categoria in cui rientra qusto sensore: ");
                                for (CategoriaSensore cateSens : listaCategoriaSensori) {
                                    if (cateSens.getNome().equals(nomeCategoria)) {
                                        listaSensori.add(new Sensore(nomeSensore, cateSens));
                                        System.out.println("Sensore creato correttamente");
                                        siCate = true;
                                        break;
                                    }
                                }
                                if (!siCate)
                                    System.out.println("La categoria inserita non rientra tra quelle già presenti, è necessario crearne una nuova.");
                            }

                            break;
                        case 10:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima di questa operazione");
                                break;
                            }

                            boolean siArtefatto = false;
                            boolean siSensore = false;
                            boolean siAttuatore = false;
                            if (listaSensori.isEmpty()) {
                                System.out.println("Non sono stati definiti sensori. Impossibile proseguire con l'operazione");
                                break;
                            }
                            if (listaAttuatori.isEmpty()) {
                                System.out.println("Non sono stati definiti attuatori. Impossibile proseguire con l'operazione");
                                break;
                            }
                            System.out.println();
                            if (!unitaImmobiliare.getListaArtefatti().isEmpty()) {
                                System.out.println("...ARTEFATTI ATTUALMENTE CREATI...");
                                for (Artefatto ar : unitaImmobiliare.getListaArtefatti()) {
                                    System.out.println("Nome Artefatto: " + ar.getNome());
                                }
                            }
                            String artefatto = InputDati.leggiStringa("Inserisci il nome dell'artefato sul quale aggiungere sensore e attuatore: ");
                            for (Artefatto arte : unitaImmobiliare.getListaArtefatti()) {
                                if (arte.getNome().equals(artefatto)) {
                                    siArtefatto = true;
                                    if (!listaSensori.isEmpty()) {
                                        System.out.println("...SENSORI ATTUALMENTE CREATI...");
                                        for (Sensore s : listaSensori) {
                                            System.out.println("Nome sensore: " + s.getNome());
                                        }
                                    }
                                    String sensore = InputDati.leggiStringa("Inserisci il nome del sensore da aggiungere all'artefatto(N per non associare): ");

                                    if (!sensore.equals("N")) {
                                        for (Sensore sensor : listaSensori) {
                                            if (sensor.getNome().equals(sensore)) {
                                                arte.aggiungiSensore(sensor);
                                                siSensore = true;
                                                break;
                                            }
                                        }
                                    }

                                    if (!listaAttuatori.isEmpty()) {
                                        System.out.println("...ATTUATORI ATTUALMENTE CREATI...");
                                        for (Attuatore a : listaAttuatori) {
                                            System.out.println("Nome attuatore: " + a.getNome());
                                        }
                                    }
                                    String attuatore = InputDati.leggiStringa("Inserisci il nome dell' attuatore da aggiungere all'artefatto (N per non associare): ");

                                    if (!attuatore.equals("N")) {
                                        for (Attuatore att : listaAttuatori) {
                                            if (att.getNome().equals(attuatore)) {
                                                if (att.isSingolo()) {
                                                    for (Artefatto art : unitaImmobiliare.getListaArtefatti()) {
                                                        if (art.getListaAttuatori().contains(att)) {
                                                            System.out.println("Impossibile aggiungere l'attuatore");
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    arte.aggiungiAttuatore(att);
                                                    siAttuatore = true;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (!siArtefatto) {
                                System.out.println("L'artefatto non esiste tra quelli attualmente creati");
                                break;
                            }
                            if (!siSensore) {
                                System.out.println("Il sensore non esiste tra quelli attualmente creati");
                                break;
                            }
                            if (!siAttuatore) {
                                System.out.println("L'attuatore non esiste tra quelli attualmente creati");
                                break;
                            }

                            break;
                        case 11:
                            boolean siStanza = false;
                            boolean siArte = false;
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima di questa operazione");
                                break;
                            }
                            System.out.println();
                            if (!unitaImmobiliare.getListaStanze().isEmpty()) {
                                System.out.println("...STANZE ATTUALMENTE CREATE...");
                                for (Stanza s : unitaImmobiliare.getListaStanze()) {
                                    System.out.println("Nome stanza: " + s.getNome());
                                }
                            }
                            String stanza = InputDati.leggiStringa("Inserisci il nome della stanza in cui aggiungere l'artefatto: ");
                            for (Stanza s : unitaImmobiliare.getListaStanze()) {
                                if (s.getNome().equals(stanza)) {
                                    siStanza = true;
                                    if (!unitaImmobiliare.getListaArtefatti().isEmpty()) {
                                        System.out.println("...ARTEFATTI ATTUALMENTE CREATI...");
                                        for (Artefatto a : unitaImmobiliare.getListaArtefatti()) {
                                            System.out.println("Nome Artefatto: " + a.getNome());
                                        }
                                    }
                                    String arte = InputDati.leggiStringa("Inserisci il nome dell'artefatto da aggiungere alla stanza " + s.getNome() + ": ");
                                    for (Artefatto a : unitaImmobiliare.getListaArtefatti()) {
                                        if (a.getNome().equals(arte)) {
                                            s.aggiungiArtefatto(a);
                                            siArte = true;
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (!siStanza) {
                                System.out.println("La stanza non esiste tra quelle attualmente create");
                                break;
                            }
                            if (!siArte) {
                                System.out.println("L'artefatto non esiste tra quelli attualmente creati");
                                break;
                            }

                            break;
                        case 12:
                            boolean siStaza = false;
                            boolean siSens = false;
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima di questa operazione");
                                break;
                            }
                            System.out.println();
                            if (!unitaImmobiliare.getListaStanze().isEmpty()) {
                                System.out.println("...STANZE ATTUALMENTE CREATE...");
                                for (Stanza s : unitaImmobiliare.getListaStanze()) {
                                    System.out.println("Nome stanza: " + s.getNome());
                                }
                            }
                            String stanz = InputDati.leggiStringa("Inserisci il nome della stanza in cui aggiungere il sensore: ");
                            for (Stanza s : unitaImmobiliare.getListaStanze()) {
                                if (s.getNome().equals(stanz)) {
                                    siStaza = true;
                                    if (!listaSensori.isEmpty()) {
                                        System.out.println("...SENSORI ATTUALMENTE CREATI...");
                                        for (Sensore se : listaSensori) {
                                            System.out.println("Nome sensore: " + se.getNome());
                                        }
                                    }
                                    String sens = InputDati.leggiStringa("Inserisci il nome del sensore da aggiungere alla stanza " + s.getNome() + ": ");
                                    for (Sensore sz : listaSensori) {
                                        if (sz.getNome().equals(sens)) {
                                            s.aggiungiSensore(sz);
                                            siSens = true;
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (!siStaza) {
                                System.out.println("La stanza non esiste tra quelle attualmente create");
                                break;
                            }
                            if (!siSens) {
                                System.out.println("Il sensore non esiste tra quelli attualmente creati");
                                break;
                            }

                            break;
                        case 13:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima di questa operazione");
                                break;
                            }
                            boolean siSen = false;
                            System.out.println();
                            if (!listaSensori.isEmpty()) {
                                System.out.println("...SENSORI ATTUALMENTE CREATI...");
                                for (Sensore s : listaSensori) {
                                    System.out.println("Nome sensore: " + s.getNome());
                                }
                            }
                            String ss = InputDati.leggiStringa("Inserisci il nome del sensore sul quale si vogliono leggere i dati: ");
                            for (Sensore sensore : listaSensori) {
                                if (sensore.getNome().equals(ss)) {
                                    siSen = true;
                                    //TODO: Tocca modificare perchè le info rilevabili sono moltepilici
                                    //System.out.println("Rilevazione letta dal sensore " + sensore.getNome() + ": " + sensore.getRilevazioni().getValore());
                                    break;
                                }
                            }
                            if (!siSen)
                                System.out.println("Sensore non presente. E' necessario crearlo");

                            break;
                        case 14:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario definirla prima di questa operazione");
                                break;
                            }
                            boolean siAttua = false;
                            boolean siMod = false;
                            System.out.println();
                            if (!listaAttuatori.isEmpty()) {
                                System.out.println("...ATTUATORI ATTUALMENTE CREATI...");
                                for (Attuatore attr : listaAttuatori) {
                                    System.out.println("Nome attuatore: " + attr.getNome());
                                }
                            }
                            String nomeAtt = InputDati.leggiStringa("Inserisci il nome dell'attuatore al quale si vuole modificare la modalià operativa: ");
                            for (Attuatore a : listaAttuatori) {
                                if (a.getNome().equals(nomeAtt)) {
                                    siAttua = true;
                                    System.out.println("Attuatore: " + a.getNome() + ", stato attuale: " + a.getModalitaAttuale());
                                    if (!listaModalitaOperative.isEmpty()) {
                                        System.out.println("...MODALITA' OPERATIVE ATTUALMENTE CREATE...");
                                        for (ModalitaOperativa m : listaModalitaOperative) {
                                            System.out.println("Nome modalità operativa: " + m.getNome());
                                        }
                                    }
                                    String nuovaMod = InputDati.leggiStringa("Inserisci la nuova modalità per questo attuatore: ");
                                    for (ModalitaOperativa modal : a.getCategoria().getModalita()) {
                                        if (modal.getNome().equals(nuovaMod)) {
                                            a.setModalitaAttuale(nuovaMod);
                                            siMod = true;
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (!siAttua) {
                                System.out.println("L'attuatore non esiste. E' necessario crearlo");
                                break;
                            }
                            if (!siMod) {
                                System.out.println("La modalità inserita non esite. E' necessario crearla");
                                break;
                            }

                            break;

                        case 15:


                            int sceltaVisualizza;
                            do {
                                System.out.println("\n1) VISUALIZZA COMPOSIZIONE UNITA' IMMOBILIARE\n2) VISUALIZZA COMPOSIZIONE STANZE\n3) VISUALIZZA COMPOSIZIONE ARTEFATTI\n" +
                                        "4) VISUALIZZA LISTA SENSORI E CATEGORIE SENSORI\n5) VISUALIZZA LISTA ATTUATORI E CATEGORIE ATTUATORI\n6) VISUALIZZA LISTA MODALITA' OPERATIVE\n0) USCITA");
                                sceltaVisualizza = InputDati.leggiIntero("Seleziona funzionalità: ");
                                switch (sceltaVisualizza) {
                                    case 1:
                                        System.out.println(unitaImmobiliare.visualizzaDescrizione());
                                        break;
                                    case 2:
                                        if (unitaImmobiliare.getListaStanze().isEmpty()) {
                                            System.out.println("E' necessario creare almeno una stanza prima di utilizzare questa funzione");
                                            break;
                                        }
                                        for (Stanza stanzetta : unitaImmobiliare.getListaStanze()) {
                                            System.out.println(stanzetta.visualizzaDisposizione());
                                        }
                                        break;
                                    case 3:
                                        if (unitaImmobiliare.getListaArtefatti().isEmpty()) {
                                            System.out.println("E' necessario creare almeno un artefatto prima di utilizzare questa funzione");
                                            break;
                                        }
                                        for (Artefatto artefattino : unitaImmobiliare.getListaArtefatti()) {
                                            System.out.println(artefattino.visualizzaDispositivi());
                                        }
                                        break;
                                    case 4:
                                        System.out.println();
                                        if (listaSensori.isEmpty())
                                            System.out.println("Lista sensori attualmente vuota. E' necessario crearne di nuovi per utilizzare questa funzione");
                                        else {
                                            for (Sensore s : listaSensori) {
                                                System.out.println("Nome Sensore: " + s.getNome());
                                            }
                                        }
                                        if (listaCategoriaSensori.isEmpty())
                                            System.out.println("Lista categoria sensori attualmente vuota. E' necessario crearne di nuove per utilizzare questa funzione");
                                        else {
                                            for (CategoriaSensore catSens : listaCategoriaSensori)
                                                System.out.println("Nome categoria sensori: " + catSens.getNome());
                                        }

                                        break;
                                    case 5:
                                        System.out.println();
                                        if (listaAttuatori.isEmpty())
                                            System.out.println("Lista attuatori attualmente vuota. E' necessario crearne di nuovi per utilizzare questa funzione");
                                        else {
                                            for (Attuatore att : listaAttuatori) {
                                                System.out.println("Nome Attuatore: " + att.getNome());
                                            }
                                        }
                                        if (listaCategoriaAttuatori.isEmpty())
                                            System.out.println("Lista categoria attuatori attualmente vuota. E' necessario crearne di nuove per utilizzare questa funzione");
                                        else {
                                            for (CategoriaAttuatore catAtt : listaCategoriaAttuatori)
                                                System.out.println("Nome categoria attuatori: " + catAtt.getNome());
                                        }
                                        break;
                                    case 6:
                                        System.out.println();
                                        if (listaModalitaOperative.isEmpty())
                                            System.out.println("Lista modalità operatice attualmente vuota. E' necessario crearne di nuove per utilizzare questa funzione");
                                        else {
                                            for (ModalitaOperativa mod : listaModalitaOperative)
                                                System.out.println("Nome modalità operativa: " + mod.getNome());
                                        }
                                        break;
                                    case 0:
                                        System.out.println("USCITA DALLA FUNZIONE DI VISUALIZZAZIONE\n");
                                        break;
                                }
                            } while (sceltaVisualizza != 0);
                            break;

                        case 16:
                            if (listaCategoriaSensori.isEmpty()) {
                                System.out.println("\n!XX! Non sono presenti categorie di sensori da salvare !XX!");
                                break;
                            }
                            if (listaCategoriaAttuatori.isEmpty()) {
                                System.out.println("\n!XX! Non sono presenti categorie di attuatori da salvare !XX!");
                                break;
                            }

                            try {
                                FileOutputStream out = new FileOutputStream("categorieSens_Att");
                                ObjectOutputStream s = new ObjectOutputStream(out);
                                s.writeObject(listaCategoriaAttuatori);
                                s.writeObject(listaCategoriaSensori);
                                s.flush();
                                System.out.println("*** Salvataggio su file  è andato a buon fine ***");

                            } catch (IOException e) {
                                e.printStackTrace();
                                System.out.println("XXX Errore durante salvataggio su file XXX ");
                            }
                            break;

                        case 17:
                            FileInputStream in;
                            try {
                                in = new FileInputStream("categorieSens_Att");
                                ObjectInputStream s = new ObjectInputStream(in);
                                listaCategoriaAttuatori = (ArrayList<CategoriaAttuatore>) s.readObject();
                                listaCategoriaSensori = (ArrayList<CategoriaSensore>) s.readObject();
                                System.out.println("*** Ripristino da file è andato a buon fine ***");
                            } catch (IOException | ClassNotFoundException e) {
                                e.printStackTrace();
                                System.out.println("XXX Errore durante caricamento da file XXX");
                            }
                            break;

                        case 0:
                            System.out.println("USCITA DAL SISTEMA MANUTENTORE.\n");
                            break;
                    }
                } while (caso != 0);
            } else if (operatore.equals("fruitore")){
                int caso;
                do {
                    System.out.println("\n1) MOSTRA RILEVAZIONI DI UN SENSORE\n2) SETTA NUOVA MODALITA' ATTUATORE\n3) VISUALIZZA TUTTO\n0) USCITA");
                    caso = InputDati.leggiIntero("Seleziona funzionalità: ");

                    switch (caso) {
                        case 1:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione");
                                break;
                            }
                            boolean siSen = false;
                            System.out.println();
                            if (!listaSensori.isEmpty()) {
                                System.out.println("...SENSORI ATTUALMENTE CREATI DAL MANUTENTORE...");
                                for (Sensore s : listaSensori) {
                                    System.out.println("Nome sensore: " + s.getNome());
                                }
                            }
                            String ss = InputDati.leggiStringa("Inserisci il nome del sensore sul quale si vogliono leggere i dati: ");
                            for (Sensore sensore : listaSensori) {
                                if (sensore.getNome().equals(ss)) {
                                    siSen = true;
                                    //TODO: Tocca modificare l'ottenimento dell'informazione perche possono essere molteplici (fai foreach semmai)
                                    //System.out.println("Rilevazione letta dal sensore " + sensore.getNome() + ": " + sensore.getRilevazioni().getValore());
                                    break;
                                }
                            }
                            if (!siSen)
                                System.out.println("Il sensore non è presente tra quelli creati.");

                            break;
                        case 2:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione");
                                break;
                            }
                            boolean siAttua = false;
                            boolean siMod = false;
                            System.out.println();
                            if (!listaAttuatori.isEmpty()) {
                                System.out.println("...ATTUATORI ATTUALMENTE CREATI DAL MANUTENTORE...");
                                for (Attuatore attr : listaAttuatori) {
                                    System.out.println("Nome attuatore: " + attr.getNome());
                                }
                            }
                            String nomeAtt = InputDati.leggiStringa("Inserisci il nome dell'attuatore al quale si vuole modificare la modalià operativa: ");
                            for (Attuatore a : listaAttuatori) {
                                if (a.getNome().equals(nomeAtt)) {
                                    siAttua = true;
                                    System.out.println("---Attuatore: " + a.getNome() + ", stato attuale: " + a.getModalitaAttuale() + "---");
                                    if (!listaModalitaOperative.isEmpty()) {
                                        System.out.println("...MODALITA' OPERATIVE ATTUALMENTE CREATE DAL MANUTENTORE...");
                                        for (ModalitaOperativa m : listaModalitaOperative) {
                                            System.out.println("Nome modalità operativa: " + m.getNome());
                                        }
                                    }
                                    String nuovaMod = InputDati.leggiStringa("Inserisci la nuova modalità per questo attuatore: ");
                                    for (ModalitaOperativa modal : a.getCategoria().getModalita()) {
                                        if (modal.getNome().equals(nuovaMod)) {
                                            a.setModalitaAttuale(nuovaMod);
                                            siMod = true;
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (!siAttua) {
                                System.out.println("L'attuatore non esiste.");
                                break;
                            }
                            if (!siMod) {
                                System.out.println("La modalità inserita non esite.");
                                break;
                            }

                            break;
                        case 3:
                            int sceltaVisualizza;
                            do {
                                System.out.println("\n1) VISUALIZZA COMPOSIZIONE UNITA' IMMOBILIARE\n2) VISUALIZZA COMPOSIZIONE STANZE\n3) VISUALIZZA COMPOSIZIONE ARTEFATTI\n" +
                                        "4) VISUALIZZA LISTA SENSORI E CATEGORIE SENSORI\n5) VISUALIZZA LISTA ATTUATORI E CATEGORIE ATTUATORI\n0) USCITA");
                                sceltaVisualizza = InputDati.leggiIntero("Seleziona funzionalità: ");
                                switch (sceltaVisualizza) {
                                    case 1:
                                        if (unitaImmobiliare.getTipo().equals("")) {
                                            System.out.println("Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione");
                                            break;
                                        }
                                        System.out.println(unitaImmobiliare.visualizzaDescrizione());
                                        break;
                                    case 2:
                                        if (unitaImmobiliare.getTipo().equals("")) {
                                            System.out.println("Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione");
                                            break;
                                        }

                                        if (unitaImmobiliare.getListaStanze().isEmpty()) {
                                            System.out.println("E' necessario che esista almeno una stanza prima di utilizzare questa funzione");
                                            break;
                                        }
                                        for (Stanza stanzetta : unitaImmobiliare.getListaStanze()) {
                                            System.out.println(stanzetta.visualizzaDisposizione());
                                        }
                                        break;
                                    case 3:
                                        if (unitaImmobiliare.getTipo().equals("")) {
                                            System.out.println("Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione");
                                            break;
                                        }

                                        if (unitaImmobiliare.getListaArtefatti().isEmpty()) {
                                            System.out.println("E' necessario che esista almeno un artefatto prima di utilizzare questa funzione");
                                            break;
                                        }
                                        for (Artefatto artefattino : unitaImmobiliare.getListaArtefatti()) {
                                            System.out.println(artefattino.visualizzaDispositivi());
                                        }
                                        break;
                                    case 4:
                                        System.out.println();
                                        if (listaSensori.isEmpty())
                                            System.out.println("Il manutentore non ha creato nessun sensore");
                                        else {
                                            for (Sensore s : listaSensori) {
                                                System.out.println("Nome Sensore: " + s.getNome());
                                            }
                                        }
                                        if (listaCategoriaSensori.isEmpty())
                                            System.out.println("E' necessario che esista almeno una categoria di sensori per utilizzare questa funzione");
                                        else {
                                            for (CategoriaSensore catSens : listaCategoriaSensori)
                                                System.out.println("Nome categoria sensori: " + catSens.getNome());
                                        }

                                        break;
                                    case 5:
                                        System.out.println();
                                        if (listaAttuatori.isEmpty())
                                            System.out.println("Il manutentore non ha creato nessun attuatore");
                                        else {
                                            for (Attuatore att : listaAttuatori) {
                                                System.out.println("Nome Attuatore: " + att.getNome());
                                            }
                                        }
                                        if (listaCategoriaAttuatori.isEmpty())
                                            System.out.println("E' necessario che esista almeno una categoria di attuatori per utilizzare questa funzione");
                                        else {
                                            for (CategoriaAttuatore catAtt : listaCategoriaAttuatori)
                                                System.out.println("Nome categoria sensori: " + catAtt.getNome());
                                        }
                                        break;
                                    case 0:
                                        System.out.println("USCITA DALLA FUNZIONE DI VISUALIZZAZIONE\n");
                                        break;
                                }
                            } while (sceltaVisualizza != 0);
                            break;
                        case 0:
                            System.out.println("USCITA DAL SISTEMA FRUITORE.\n");
                            break;
                    }
                } while (caso != 0);
            } else {
                System.out.println("USCITA DAL SISTEMA DOMOTICO\n");
            }
        } while (!operatore.equals("FINE"));
        System.out.println("FINE");

         */

    }

}
