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
 * <p>
 * L'utente manutentore di pu&ograve; aggiungere (a quella gi&agrave; presente) la descrizione di ulteriori unit&agrave; immobiliari (di pertinenza del medesimo
 * fruitore), che possono fare uso di ogni tipo di sensore e attuatore. Sia il manutentore sia il fruitore possono richiedere la visualizzazione di tutte le
 * categorie di dispositivi cos&igrave; come di tutte le unit&agrave; immobiliari inserite.
 * <p>
 * Il fruitore pu&agrave; selezionare di volta in volta l&rsquo;unit&agrave; immobiliare su cui vuole operare fra quelle descritte nell&rsquo;installazione
 * messa a sua disposizione. Relativamente all&rsquo;unit&agrave; selezionata, l' applicazione consente al fruitore (non solo di richiedere la visualizzazione
 * dei valori attualmente rilevati da ogni singolo sensore ma anche) di compiere azioni, ovvero di assegnare una modalit&agrave; operativa specifica (anche parametrica) a ciascun
 * attuatore.
 *
 * @author Parampal Singh, Mattia Nodari
 */
public class Main {

    public static void main(String[] args) {

        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare();
        ArrayList<UnitaImmobiliare> listaUnitaImmobiliari = new ArrayList<>();
        ArrayList<CategoriaAttuatore> listaCategoriaAttuatori = new ArrayList<>();
        ArrayList<CategoriaSensore> listaCategoriaSensori = new ArrayList<>();
        ArrayList<ModalitaOperativa> listaModalitaOperative = new ArrayList<>();
        //ArrayList<Attuatore> listaAttuatori = new ArrayList<>();
        //ArrayList<Sensore> listaSensori = new ArrayList<>();

        String operatore;

        do {
            do {
                operatore = InputDati.leggiStringaNonVuota("Selezionare il tipo di Utente(manutentore/fruitore) o FINE per uscire: ");
            } while (!operatore.equals("manutentore") && !operatore.equals("fruitore") && !operatore.equals("FINE"));

            if (operatore.equals("manutentore")) {
                int caso;

                do {
                    System.out.println("\n1) CREA O SELEZIONA UNITA' IMMOBILIARE\n2) CREA STANZA\n3) AGGIUNGI UNA CATEGORIA DI SENSORI\n4) AGGIUNGI UNA CATEGORIA DI ATTUATORI\n" +
                            "5) CREA ARTEFATTO\n6) CREA NUOVA MODALITA' OPERATIVA\n7) CREA ATTUATORE\n8) ASSEGNA MODALITA' OPERATIVA AD UNA CATEGORIA DI ATTUATORI\n9) CREA SENSORE\n" +
                            "10) AGGIUNGI SENSORE E ATTUATORE AD ARTEFATTO\n11) AGGIUNGI ARTEFATTO A STANZA\n12) AGGIUNGI SENSORE A STANZA\n13) MOSTRA RILEVAZIONI DI UN SENSORE\n" +
                            "14) SETTA NUOVA MODALITA' ATTUATORE\n15) VISUALIZZA TUTTO\n16) SALVA CATEGORIE DI SENSORI E ATTUATORI SU FILE\n17) RIPRISTINA CATEGORIE DI SENSORI E ATTUATORI\n0) USCITA\n");

                    caso = InputDati.leggiIntero("### Seleziona funzionalità: ");
                    switch (caso) {
                        case 1:

                            StringBuilder visUnits = new StringBuilder();
                            for (UnitaImmobiliare unitaImm : listaUnitaImmobiliari) {
                                    visUnits.append("-- Unita Immobiliare: ").append(unitaImm.getNome()).append("\n");
                            }

                            if (visUnits.length() > 0)
                                System.out.println("...ELENCO DI UNITA IMMOBILIARI DISPONIBILI...\n" + visUnits.toString());
                            else
                                System.out.println("XXX Finora non sono state create unita immobiliari XXX");


                            boolean giaPresente = false;

                            String seleziona = InputDati.leggiStringaNonVuota("Specificare se si vuole creare una nuova unità immobiliare(nuova)\n" +
                                    "- oppure accedere ad una già creata per utilizzare le funzionalità del sistema(nome unità immobiliare da selezionare): ");
                            if (seleziona.equals("nuova")) {
                                String nome = InputDati.leggiStringaNonVuota("Inserisci il nome dell'unità immobiliare da creare: ");
                                String tipo = InputDati.leggiStringaNonVuota("Inserisci il tipo dell'unità immobiliare da creare: ");


                                for (UnitaImmobiliare unitImmob : listaUnitaImmobiliari) {
                                    if (unitImmob.getNome().equals(nome)) {
                                        System.out.println("XXX Esiste gia un'unità immobiliare presente con tale nome XXX");
                                        giaPresente = true;
                                        break;
                                    }
                                }

                                if (!giaPresente) {

                                    UnitaImmobiliare temp = new UnitaImmobiliare(tipo, nome);

                                    listaUnitaImmobiliari.add(temp);
                                    System.out.println("\n*** Unità immobiliare creata correttamente *** ");
                                    unitaImmobiliare = temp;
                                    System.out.println("*** " + unitaImmobiliare.getNome() + " è stata selezionata come unità immobiliare corrente *** ");
                                }

                            } else if (seleziona.equals(unitaImmobiliare.getNome())) {
                                System.out.println(seleziona + " è stata già selezionata come unità immobiliare corrente ! ");

                            } else {
                                boolean presente = false;

                                if (listaUnitaImmobiliari.isEmpty())
                                    System.out.println("!!! Non è stata creata nessuna unità immobiliare al momento !!!");
                                else {
                                    for (UnitaImmobiliare immo : listaUnitaImmobiliari) {
                                        if (immo.getNome().equals(seleziona)) {
                                            presente = true;
                                            unitaImmobiliare = immo;
                                            break;
                                        }
                                    }
                                    if (presente)
                                        System.out.println("*** " + unitaImmobiliare.getNome() + " è stata selezionata come unità immobiliare corrente ***");
                                    else
                                        System.out.println("!!! Unità immobiliare specificata non è ancora stata creata !!!");
                                }
                            }

                            break;
                        case 2:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima della creazione della stanza !!!");
                            } else {
                                String nomeStanza = InputDati.leggiStringaNonVuota("Inserire il nome della stanza da creare: ");
                                unitaImmobiliare.aggiungiStanza(new Stanza(nomeStanza));
                            }

                            break;
                        case 3:
                            boolean categoriaPresenteSensore = false;
                            String nomeCategoriaSensore = InputDati.leggiStringaNonVuota("\nInserisci nome della nuova categoria di sensori: ");

                            if (nomeCategoriaSensore.contains(" ")) {
                                System.out.println("!! Errore di inserimento nome, spazi non ammessi !!\n");
                                break;
                            }

                            for (CategoriaSensore s : listaCategoriaSensori) {
                                if (s.getNome().equals(nomeCategoriaSensore)) {
                                    System.out.println("!!! La categoria desiderata è gia stata creata precedentemente !!!");
                                    categoriaPresenteSensore = true;
                                    break;
                                }
                            }

                            if (!categoriaPresenteSensore) {
                                String testoLibero = InputDati.leggiStringaNonVuota("Inserisci il testo descrittivo per la nuova categoria di sensore:\n");
                                boolean fisico = InputDati.yesOrNo("E' una categoria di sensori fisico?");
                                CategoriaSensore tempCategoria = new CategoriaSensore(nomeCategoriaSensore, testoLibero, fisico);
                                listaCategoriaSensori.add(tempCategoria);
                                System.out.println("\n*** Categoria di sensori è stata creata correttamente ***\n");

                                String informazione;
                                ArrayList<Informazione> infoRilevabili = new ArrayList<>();
                                if (!fisico)
                                    infoRilevabili.add(new Informazione("STATO"));

                                boolean infoDoppia;
                                do {
                                    infoDoppia = false;
                                    informazione = InputDati.leggiStringaNonVuota("Inserisci il nome dell'informazione che la categoria creata rileva oppure fine per uscire: ");
                                    if (!informazione.equals("fine")) {
                                        for (Informazione info : infoRilevabili) {
                                            if (info.getNome().equals(informazione)) {
                                                infoDoppia = true;
                                                break;
                                            }
                                        }
                                        if (infoDoppia)
                                            System.out.println("!!! Un'informazione simile è già stata inserita precedentemente !!! ");
                                        else {
                                            boolean isNum = InputDati.yesOrNo("L'informazione rilevabile è numerica o ha un dominio non numerico?");
                                            if (isNum) {
                                                int min = InputDati.leggiIntero("Inserisci il valore minimo di " + informazione + " che la categoria acquisisce: ");
                                                int max = InputDati.leggiIntero("Inserisci il valore massimo di " + informazione + " che la categoria acquisisce: ");
                                                infoRilevabili.add(new Informazione(informazione, max, min));
                                                System.out.println("*** Informazione rilevabile inserita correttamente *** ");
                                            } else {
                                                String rilevazione;
                                                ArrayList<String> dominioNonNum = new ArrayList<>();
                                                do {

                                                    rilevazione = InputDati.leggiStringaNonVuota("Inserisci una rilevazione(stringa) appartenente al dominio per questo tipo di informazione o fine per terminare: ");


                                                    if (!rilevazione.equals("fine")) {

                                                        if (dominioNonNum.contains(rilevazione))
                                                            System.out.println("La rilevazione inserita è già presente per questa categoria");

                                                        else {
                                                            dominioNonNum.add(rilevazione);
                                                            System.out.println("Rilevazione non numerica  inserita correttamente");
                                                        }
                                                    }
                                                } while (!rilevazione.equals("fine"));
                                                infoRilevabili.add(new InformazioneNonNum(informazione, dominioNonNum));
                                            }
                                        }
                                    }

                                } while (!informazione.equals("fine") || infoRilevabili.isEmpty());
                                tempCategoria.setInfoRilevabili(infoRilevabili);
                                System.out.println("\n *** Informazioni inserite correttamente nella categoria creata ***");
                            }
                            break;
                        case 4:
                            String nomeCategoriaAttuatore = InputDati.leggiStringaNonVuota("\nInserisci nome della nuova categoria di attuatori: ");


                            if (nomeCategoriaAttuatore.contains(" ")) {
                                System.out.println("!! Errore di inserimento nome, spazi non ammessi !!\n");
                                break;
                            }

                            boolean categoriaPresenteAttuatore = false;
                            for (CategoriaAttuatore a : listaCategoriaAttuatori) {
                                if (a.getNome().equals(nomeCategoriaAttuatore)) {
                                    System.out.println("!!! La categoria desiderata è gia stata creata precedentemente !!!");
                                    categoriaPresenteAttuatore = true;
                                    break;
                                }
                            }

                            if (!categoriaPresenteAttuatore) {
                                String testoLibero = InputDati.leggiStringaNonVuota("Inserisci il testo descrittivo per la nuova categoria di attuatori:\n");
                                listaCategoriaAttuatori.add(new CategoriaAttuatore(nomeCategoriaAttuatore, testoLibero));
                                System.out.println("*** Categoria creata correttamente ***");
                            }

                            break;
                        case 5:
                            boolean siStato = false;
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima della creazione di un artefatto !!!");
                                break;
                            }
                            if (listaModalitaOperative.isEmpty()) {
                                System.out.println("!!! E' necessario prima definire una lista di modalità operative da assegnare come stato iniziale per l'artefatto !!! ");
                                break;
                            }
                            String nomeArtefatto = InputDati.leggiStringaNonVuota("\nInserisci nome artefatto: ");


                            if (nomeArtefatto.contains(" ")) {
                                System.out.println("!! Errore di inserimento nome, spazi non ammessi !!\n");
                                break;
                            }

                            if (!listaModalitaOperative.isEmpty()) {
                                System.out.println("...MODALITA' OPERATIVE ATTUALMENTE CREATE...");
                                for (ModalitaOperativa modalit : listaModalitaOperative) {
                                    System.out.println("--- Nome modalità: " + modalit.getNome());
                                }
                            }
                            String nomeStato = InputDati.leggiStringaNonVuota("Inserisci stato di default per il nuovo artefatto: ");
                            for (ModalitaOperativa modalita : listaModalitaOperative) {

                                if (modalita.getNome().equals(nomeStato)) {
                                    siStato = true;
                                    if (modalita.isParametrica()) {

                                        HashMap<String, Integer> params = (HashMap<String, Integer>) modalita.getParametri().clone();
                                        ModalitaOperativa modParam = new ModalitaOperativa(nomeStato, params);
                                        unitaImmobiliare.aggiungiArtefatto(new Artefatto(nomeArtefatto, modParam));


                                    } else {
                                        unitaImmobiliare.aggiungiArtefatto(new Artefatto(nomeArtefatto, new ModalitaOperativa(nomeStato)));
                                        break;
                                    }
                                }
                            }

                            if (!siStato) {
                                System.out.println("!!! Lo stato attuale non è stato correttamente specificato. Non è stato possibile creare l'artefatto !!!");
                            }
                            break;
                        case 6:

                            boolean presenteModalita = false;
                            String nuovaModalita = InputDati.leggiStringaNonVuota("\nInserisci nuova modalità operativa: ");

                            if (nuovaModalita.contains(" ")) {
                                System.out.println("!! Errore di inserimento nome, spazi non ammessi !!\n");
                                break;
                            }

                            for (ModalitaOperativa modalita : listaModalitaOperative) {
                                if (modalita.getNome().equals(nuovaModalita)) {
                                    System.out.println("!!! Modalità operativa già creata precedentemente !!! ");
                                    presenteModalita = true;
                                    break;
                                }
                            }
                            if (!presenteModalita) {
                                boolean parametrica = InputDati.yesOrNo("La modalità operativa è parametrica?");
                                if (parametrica) {
                                    String nomeParam;
                                    HashMap<String, Integer> parametri = new HashMap<>();
                                    do {
                                        nomeParam = InputDati.leggiStringaNonVuota("Inserisci il nome del parametro di " + nuovaModalita + " oppure fine per uscire: ");

                                        if (parametri.isEmpty() && nomeParam.equals("fine")) {
                                            System.out.println("### Inserire almeno un parametro per la modalità parametrica ");
                                            continue;
                                        }

                                        if (!nomeParam.equals("fine")) {
                                            if (parametri.containsKey(nomeParam))
                                                System.out.println("!!! Un parametro con il nome inserito è già presente per questa modalità operativa !!!");
                                            else {
                                                int valore = InputDati.leggiIntero("Inserisci il valore di default per questo parametro: ");
                                                parametri.put(nomeParam, valore);
                                            }
                                        }

                                    } while (!nomeParam.equals("fine") || parametri.isEmpty());
                                    listaModalitaOperative.add(new ModalitaOperativa(nuovaModalita, parametri));
                                    System.out.println("*** Modalità operativa parametrica creata correttamente ***");
                                } else {
                                    listaModalitaOperative.add(new ModalitaOperativa(nuovaModalita));
                                    System.out.println("*** Modalità operativa non parametrica creata correttamente *** ");
                                }
                            }

                            break;
                        case 7:
                            if (listaCategoriaAttuatori.isEmpty()) {
                                System.out.println("!!! Non sono presenti categorie di attuatori. E' necessario definirne almeno una prima di questa operazione !!!");
                                break;
                            }

                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                break;
                            }


                            String nuovoAttuatore = InputDati.leggiStringaNonVuota("\nInserisci il nome per il nuovo attuatore: ");


                            if (nuovoAttuatore.contains(" ")) {
                                System.out.println("!! Errore di inserimento nome, spazi non ammessi !!\n");
                                break;
                            }

                            boolean presenteAttuatore = false;
                            boolean erroreCategoria = true;
                            boolean erroreStato = true;


                            for (Attuatore a : unitaImmobiliare.getListaAttuatori()) {
                                if (a.getNome().equals(nuovoAttuatore + "_" + a.getCategoria().getNome())) {
                                    System.out.println("!!! Esiste già un attuatore con lo stesso nome. E' necessario avere nomi differenti !!! ");
                                    presenteAttuatore = true;
                                    break;
                                }
                            }

                            if (!presenteAttuatore) {

                                System.out.println("...CATEGORIE ATTUALMENTE CREATE...");
                                for (CategoriaAttuatore cA : listaCategoriaAttuatori) {
                                    System.out.println("--- Nome Categoria Attuatori: " + cA.getNome());
                                }


                                String categoria = InputDati.leggiStringaNonVuota("Inserisci la categoria in cui rientra questo attuatore: ");
                                for (CategoriaAttuatore cat : listaCategoriaAttuatori) {
                                    if (cat.getNome().equals(categoria)) {
                                        erroreCategoria = false;

                                        ArrayList<ModalitaOperativa> listaMods = cat.getModalita();

                                        if (!listaMods.isEmpty()) {
                                            System.out.println("\n...MODALITA' OPERATIVE ATTUALMENTE DEFINITE PER LA CATEGORIA DI ATTUATORI SCELTA...");
                                            for (ModalitaOperativa mod : listaMods) {
                                                System.out.println("--- Nome modalità: " + mod.getNome());
                                            }
                                        } else {
                                            System.out.println("\n!!! Non sono state definite modalità operative per la categoria di attuatori scelta !!! ");
                                            break;
                                        }
                                        String statoAttuale = InputDati.leggiStringaNonVuota("Inserisci lo stato di default dell'attuatore: ");
                                        for (ModalitaOperativa mod : listaModalitaOperative) {
                                            if (mod.getNome().equals(statoAttuale)) {
                                                boolean singolo = InputDati.yesOrNo("Ha caratterstica di associazione singola: ");
                                                unitaImmobiliare.aggiungiAttuatore(new Attuatore(nuovoAttuatore, cat, statoAttuale, singolo));
                                                erroreStato = false;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                if (erroreCategoria)
                                    System.out.println("\n!!! La categoria selezionata non rientra tra quelle attualmente create !!! ");
                                else if (erroreStato)
                                    System.out.println("\n!!! La modalità operativa di default non è stata correttamente definita!!!");
                            }

                            if (erroreCategoria || erroreStato || presenteAttuatore)
                                System.out.println("XXX L'attuatore non è stato creato XXX");

                            break;
                        case 8:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! !!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!! !!!");
                                break;
                            }

                            if (listaModalitaOperative.isEmpty()) {
                                System.out.println("!!! E' necessario prima definire almeno una modalità operativa !!!");
                                break;
                            }

                            boolean presenzaNome = false;
                            boolean presenzaCate = false;
                            System.out.println();
                            if (!listaCategoriaAttuatori.isEmpty()) {
                                System.out.println("\n..CATEGORIE ATTUALMENTE CREATE...");
                                for (CategoriaAttuatore cA : listaCategoriaAttuatori) {
                                    System.out.println("--- Nome Categoria Attuatori: " + cA.getNome());
                                }
                            }
                            String nomeCategoriaAtt = InputDati.leggiStringaNonVuota("Insersci il nome della categoria di attuatori nella quale si vuole inserire la nuova modalità operativa: ");
                            for (CategoriaAttuatore cate : listaCategoriaAttuatori) {
                                if (cate.getNome().equals(nomeCategoriaAtt)) {
                                    presenzaCate = true;

                                    ArrayList<ModalitaOperativa> modsgiaPresenti = cate.getModalita();
                                    System.out.println("\n...MODALITA' OPERATIVE ATTUALMENTE CREATE E DISPONIBILI...");
                                    StringBuilder visualizza = new StringBuilder();
                                    for (ModalitaOperativa modalit : listaModalitaOperative) {
                                        if (!modsgiaPresenti.contains(modalit))
                                            visualizza.append("--- Nome modalità: ").append(modalit.getNome()).append("\n");
                                    }

                                    if (visualizza.length() > 0)
                                        System.out.println(visualizza.toString());
                                    else
                                        System.out.println("XX Non sono disponibili ulteriori modalità operative per questa categoria XX");

                                    String moda = InputDati.leggiStringaNonVuota("Inserisci il nome della modalità operativa da aggiungere: ");
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
                                System.out.println("!!! La categoria di attuatori specificata non è ancora stata creata !!! ");
                                break;
                            }
                            if (!presenzaNome) {
                                System.out.println("!!! Non è stato possibile aggiungere la modalità operativa desiderata!!!");
                                break;
                            }
                            break;
                        case 9:

                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                break;
                            }

                            if (listaCategoriaSensori.isEmpty()) {
                                System.out.println("!!! Non sono state definite le categorie di sensori necessarie per quest'operazione !!! ");
                                break;
                            }

                            boolean presenzaSensore = false;

                            String nomeSensore = InputDati.leggiStringaNonVuota("\nInserisci il nome del sensore da aggiungere: ");
                            if (nomeSensore.contains(" ")) {
                                System.out.println("!! Errore di inserimento nome, spazi non ammessi !!\n");
                                break;
                            }

                            for (Sensore sens : unitaImmobiliare.getListaSensori()) {
                                if (sens.getNome().equals(nomeSensore + "_" + sens.getCategoria().getNome())) {
                                    System.out.println("!!! Esiste già un sensore con lo stesso nome. E' necessario avere nomi differenti !!!");
                                    presenzaSensore = true;
                                    break;
                                }
                            }
                            boolean siCate = false;
                            if (!presenzaSensore) {

                                System.out.println("\n...CATEGORIE ATTUALMENTE CREATE...");
                                for (CategoriaSensore sS : listaCategoriaSensori) {
                                    System.out.println("--- Nome Categoria Sensori: " + sS.getNome());
                                }
                                String nomeCategoria = InputDati.leggiStringaNonVuota("Inserisci il nome della categoria in cui rientra questo sensore: ");
                                for (CategoriaSensore cateSens : listaCategoriaSensori) {
                                    if (cateSens.getNome().equals(nomeCategoria)) {
                                        unitaImmobiliare.aggiungiSensore(new Sensore(nomeSensore, cateSens));
                                        System.out.println("*** Sensore creato correttamente *** ");
                                        siCate = true;
                                        break;
                                    }
                                }
                                if (!siCate)
                                    System.out.println("!!! La categoria inserita non rientra tra quelle già presenti, è necessario prima definirla !!!");
                            }

                            break;
                        case 10:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaArtefatti().isEmpty()) {
                                System.out.println("\n!!! L'unità immobiliare non contiene alcun artefatto !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaSensori().isEmpty() && unitaImmobiliare.getListaAttuatori().isEmpty()) {
                                System.out.println("XXX Non sono stati definiti sensori e attuatori. Impossibile proseguire con l'operazione XXX");
                                break;
                            }

                            boolean siArtefatto = false;
                            boolean siSensore = false;
                            boolean siAttuatore = false;


                            System.out.println("\n...ARTEFATTI ATTUALMENTE CREATI...");
                            for (Artefatto ar : unitaImmobiliare.getListaArtefatti()) {
                                System.out.println("--- Nome Artefatto: " + ar.getNome());
                            }

                            String artefatto = InputDati.leggiStringaNonVuota("Inserisci il nome dell'artefatto sul quale aggiungere sensore e attuatore: ");
                            for (Artefatto arte : unitaImmobiliare.getListaArtefatti()) {
                                if (arte.getNome().equals(artefatto)) {
                                    siArtefatto = true;


                                    if (!unitaImmobiliare.getListaSensori().isEmpty()) {
                                        System.out.println("...SENSORI ATTUALMENTE CREATI E DISPONIBILI...");
                                        StringBuilder visualizzaSens = new StringBuilder();
                                        for (Sensore s : unitaImmobiliare.getListaSensori()) {
                                            if (s.getCategoria().isFisico() || arte.getListaSensori().contains(s) || s.isConnesso())
                                                continue;
                                            visualizzaSens.append("--- Nome sensore: ").append(s.getNome()).append("\n");
                                        }

                                        if (visualizzaSens.length() > 0)
                                            System.out.println(visualizzaSens.toString());
                                        else
                                            System.out.println("XXX Non sono presenti ulteriori sensori da poter associare all'artefatto XXX ");

                                    } else {
                                        System.out.println("!!! Non sono presenti sensori da poter assegnare !!!");
                                    }
                                    String sensore = InputDati.leggiStringaNonVuota("Inserisci il nome del sensore da aggiungere all'artefatto(N per non associare): ");

                                    if (!sensore.equals("N")) {
                                        for (Sensore sensor : unitaImmobiliare.getListaSensori()) {
                                            if (sensor.getNome().equals(sensore)) {
                                                if (sensor.isConnesso()) {
                                                    System.out.println("\n!!! Il sensore specificato è già stato associato ad un altro artefatto !!!");
                                                    break;
                                                }

                                                if (sensor.getCategoria().isFisico()) {
                                                    System.out.println("\n !!! Un sensore di questo tipo non può essere associato ad un artefatto !!!");
                                                    break;
                                                }

                                                arte.aggiungiSensore(sensor);
                                                siSensore = true;
                                                break;
                                            }
                                        }

                                        if (!siSensore)
                                            System.out.println("XXX Il sensore selezionato non è compreso tra quelli attualmente disponibili XXX\n");
                                    } else {
                                        System.out.println("XX Non è stato aggiunto alcun sensore XX");
                                    }

                                    if (!unitaImmobiliare.getListaAttuatori().isEmpty()) {
                                        System.out.println("...ATTUATORI ATTUALMENTE CREATI E DISPONIBILI...");
                                        StringBuilder visualizzaAtt = new StringBuilder();

                                        for (Attuatore at : unitaImmobiliare.getListaAttuatori()) {
                                            if (arte.getListaAttuatori().contains(at))
                                                continue;

                                            visualizzaAtt.append("--- Nome attuatore: ").append(at.getNome()).append("\n");
                                        }

                                        if (visualizzaAtt.length() > 0)
                                            System.out.println(visualizzaAtt.toString());
                                        else
                                            System.out.println("XXX Non sono presenti ulteriori attuatori da poter associare all'artefatto XXX ");
                                    } else {
                                        System.out.println("!!! Non sono presenti attuatori da poter associare all'artefatto !!!");
                                    }
                                    String attuatore = InputDati.leggiStringaNonVuota("Inserisci il nome dell' attuatore da aggiungere all'artefatto (N per non associare): ");

                                    if (!attuatore.equals("N")) {
                                        for (Attuatore att : unitaImmobiliare.getListaAttuatori()) {
                                            if (att.getNome().equals(attuatore)) {
                                                siAttuatore = true;
                                                if (att.isSingolo()) {
                                                    for (Artefatto art : unitaImmobiliare.getListaArtefatti()) {
                                                        if (art.getListaAttuatori().contains(att)) {
                                                            siAttuatore = false;
                                                            System.out.println("!!! Non è possibile aggiungere l'attuatore specificato a più artefatti !!!");
                                                            break;
                                                        }
                                                    }
                                                    if (siAttuatore) {
                                                        arte.aggiungiAttuatore(att);

                                                        break;
                                                    }
                                                } else {
                                                    arte.aggiungiAttuatore(att);
                                                    break;
                                                }
                                            }
                                        }

                                        if (!siAttuatore)
                                            System.out.println("!!! L'attuatore specificato non è compreso tra quelli attualmente disponibili !!!");

                                    } else {
                                        System.out.println("XXX Non è stato assegnato alcun attuatore XXX");
                                    }
                                }
                            }

                            if (!siArtefatto) {
                                System.out.println("!!! L'artefatto non esiste tra quelli attualmente creati !!! ");
                                break;
                            }

                            if (siSensore)
                                System.out.println("*** Il sensore è stato correttamente aggiunto all'artefatto ***");

                            if (siAttuatore)
                                System.out.println("*** L'attuatore è stato correttamente aggiunto all'artefatto ***");


                            break;
                        case 11:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaArtefatti().isEmpty()) {
                                System.out.println("!!! Non è stato definito alcun artefatto da poter assegnare !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaStanze().isEmpty()) {
                                System.out.println("!!! Non è stata definita alcuna stanza a cui poter assegnare artefatti !!!");
                                break;
                            }

                            boolean siStanza = false;
                            boolean siArte = false;

                            System.out.println("\n...STANZE ATTUALMENTE CREATE...");

                            for (Stanza s : unitaImmobiliare.getListaStanze()) {
                                System.out.println("--- Nome stanza: " + s.getNome());
                            }

                            String stanza = InputDati.leggiStringaNonVuota("Inserisci il nome della stanza in cui aggiungere l'artefatto: ");
                            for (Stanza s : unitaImmobiliare.getListaStanze()) {
                                if (s.getNome().equals(stanza)) {
                                    siStanza = true;

                                    System.out.println("...ARTEFATTI ATTUALMENTE CREATI...");
                                    StringBuilder visArte = new StringBuilder();
                                    for (Artefatto a : unitaImmobiliare.getListaArtefatti()) {
                                        if (s.getListaArtefatti().contains(a))
                                            continue;

                                        visArte.append("--- Nome Artefatto: ").append(a.getNome()).append("\n");
                                    }

                                    if (visArte.length() > 0)
                                        System.out.println(visArte.toString());
                                    else
                                        System.out.println("XXX Non sono presenti artefatti disponibili per la stanza XX");

                                    String arte = InputDati.leggiStringaNonVuota("Inserisci il nome dell'artefatto da aggiungere alla stanza " + s.getNome() + ": ");
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
                                System.out.println("!!! La stanza non esiste tra quelle attualmente create !!!");
                                break;
                            }
                            if (!siArte) {
                                System.out.println("!!! L'artefatto non è compreso tra quelli attualmente disponibili per la stanza !!!");
                                break;
                            }

                            break;
                        case 12:
                            boolean siStaza = false;
                            boolean siSens = false;

                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaStanze().isEmpty()) {
                                System.out.println("!!! Non è stata definita alcuna stanza a cui poter associare sensori !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaSensori().isEmpty()) {
                                System.out.println("!!! Non sono presenti sensori da poter assegnare alla stanza !!!");
                                break;
                            }


                            System.out.println("\n...STANZE ATTUALMENTE CREATE...");
                            for (Stanza s : unitaImmobiliare.getListaStanze()) {
                                System.out.println("--- Nome stanza: " + s.getNome());
                            }

                            String stanz = InputDati.leggiStringaNonVuota("Inserisci il nome della stanza in cui aggiungere il sensore: ");
                            for (Stanza s : unitaImmobiliare.getListaStanze()) {
                                if (s.getNome().equals(stanz)) {
                                    siStaza = true;

                                    System.out.println("...SENSORI ATTUALMENTE CREATI E DISPONIBILI...");
                                    StringBuilder visualizzaLS = new StringBuilder();
                                    for (Sensore se : unitaImmobiliare.getListaSensori()) {

                                        if (!se.getCategoria().isFisico() || s.getListaSensori().contains(se))
                                            continue;
                                        visualizzaLS.append("--- Nome sensore: ").append(se.getNome()).append("\n");
                                    }

                                    if (visualizzaLS.length() > 0)
                                        System.out.println(visualizzaLS.toString());
                                    else
                                        System.out.println("XX Non sono presenti sensori disponibili per la stanza XX");

                                    String sens = InputDati.leggiStringaNonVuota("Inserisci il nome del sensore da aggiungere alla stanza " + s.getNome() + ": ");
                                    for (Sensore sz : unitaImmobiliare.getListaSensori()) {
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
                                System.out.println("!!! La stanza non esiste tra quelle attualmente create !!!");
                                break;
                            }
                            if (!siSens) {
                                System.out.println("!!! Il sensore non \u00e8 presenti tra quelli attualmente disponibili per la stanza !!!");
                                break;
                            }

                            break;
                        case 13:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaSensori().isEmpty()) {
                                System.out.println("XX Non sono presenti sensori da cui poter leggere rilevazioni XX");
                                break;
                            }

                            boolean siSen = false;

                            System.out.println("\n...SENSORI ATTUALMENTE CREATI...");

                            for (Sensore s : unitaImmobiliare.getListaSensori()) {
                                System.out.println("--- Nome sensore: " + s.getNome());
                            }

                            String ss = InputDati.leggiStringaNonVuota("Inserisci il nome del sensore sul quale si vogliono leggere i dati: ");
                            for (Sensore sensore : unitaImmobiliare.getListaSensori()) {
                                if (sensore.getNome().equals(ss)) {
                                    siSen = true;
                                    for (Informazione info : sensore.getRilevazioni()) {
                                        System.out.println(info);
                                    }
                                    break;
                                }
                            }
                            if (!siSen)
                                System.out.println("XXX Sensore non presente. E' necessario crearlo XXX");

                            break;
                        case 14:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaAttuatori().isEmpty()) {
                                System.out.println("!!! Non è presente alcun attuatore con cui poter agire !!!");
                                break;
                            }

                            boolean siAttua = false;
                            boolean siMod = false;

                            System.out.println("\n...ATTUATORI ATTUALMENTE CREATI...");
                            for (Attuatore attr : unitaImmobiliare.getListaAttuatori()) {
                                System.out.println("--- Nome attuatore: " + attr.getNome());
                            }

                            String nomeAtt = InputDati.leggiStringaNonVuota("Inserisci il nome dell'attuatore al quale si vuole modificare la modalià operativa: ");
                            for (Attuatore a : unitaImmobiliare.getListaAttuatori()) {
                                if (a.getNome().equals(nomeAtt)) {
                                    siAttua = true;


                                    System.out.println("Attuatore: " + a.getNome() + ", modalità operativa attuale: " + a.getModalitaAttuale());

                                    System.out.println("...MODALITA' OPERATIVE DELL'ATTUATORE DISPONIBILI PER L'ATTUATORE...");
                                    for (ModalitaOperativa m : a.getCategoria().getModalita()) {
                                        System.out.println("--- Nome modalità operativa: " + m.getNome());
                                    }


                                    String nuovaMod = InputDati.leggiStringaNonVuota("Inserisci la nuova modalità per questo attuatore: ");
                                    for (ModalitaOperativa modal : a.getCategoria().getModalita()) {
                                        if (modal.getNome().equals(nuovaMod)) {
                                            siMod = true;

                                            if (modal.isParametrica()) {
                                                System.out.println("...PARAMETRI DELLA MODALITA...");
                                                HashMap<String, Integer> params = modal.getParametri();
                                                for (String key : params.keySet()) {
                                                    System.out.println("--- Nome parametro: " + key + " | valore parametro: " + params.get(key));
                                                }
                                                String nomeParam = InputDati.leggiStringaNonVuota("Inserisci il nome del parametro per questa modalità operativa: ");

                                                int nuovoVal = InputDati.leggiIntero("Inserisci il nuovo valore per questa modalità parametrica: ");

                                                a.setModalitaAttuale(nuovaMod, nomeParam, nuovoVal);
                                            } else {
                                                a.setModalitaAttuale(nuovaMod);
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (!siAttua) {
                                System.out.println("!!! L'attuatore non esiste. E' necessario crearlo !!!");
                                break;
                            }
                            if (!siMod) {
                                System.out.println("!!! Si è verificato un errore durante l'assegnamento della modalita operativa !!!");
                                break;
                            }

                            break;
                        case 15:
                            int sceltaVisualizza;
                            do {
                                System.out.println("\n1) VISUALIZZA COMPOSIZIONE UNITA' IMMOBILIARE\n2) VISUALIZZA COMPOSIZIONE STANZE\n3) VISUALIZZA COMPOSIZIONE ARTEFATTI\n" +
                                        "4) VISUALIZZA LISTA SENSORI E CATEGORIE SENSORI\n5) VISUALIZZA LISTA ATTUATORI E CATEGORIE ATTUATORI\n6) VISUALIZZA LISTA MODALITA' OPERATIVE\n0) USCITA");
                                sceltaVisualizza = InputDati.leggiIntero("### Seleziona funzionalità: ");
                                switch (sceltaVisualizza) {
                                    case 1:
                                        if (unitaImmobiliare.getTipo().equals("")) {
                                            System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                            break;
                                        }
                                        System.out.println(unitaImmobiliare.visualizzaDescrizione());
                                        break;
                                    case 2:
                                        if (unitaImmobiliare.getTipo().equals("")) {
                                            System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                            break;
                                        }
                                        if (unitaImmobiliare.getListaStanze().isEmpty()) {
                                            System.out.println("E' necessario creare almeno una stanza prima di utilizzare questa funzione");
                                            break;
                                        }
                                        for (Stanza stanzetta : unitaImmobiliare.getListaStanze()) {
                                            System.out.println(stanzetta.visualizzaDisposizione());
                                        }
                                        break;
                                    case 3:
                                        if (unitaImmobiliare.getTipo().equals("")) {
                                            System.out.println("!!! Unità Immobiliare non creata. E' necessario definirla prima di questa operazione !!!");
                                            break;
                                        }
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
                                        if (unitaImmobiliare.getListaSensori().isEmpty())
                                            System.out.println("Lista sensori attualmente vuota. E' necessario crearne di nuovi per utilizzare questa funzione");
                                        else {
                                            for (Sensore s : unitaImmobiliare.getListaSensori()) {
                                                System.out.println("Nome Sensore: " + s.getNome());
                                            }
                                        }
                                        if (listaCategoriaSensori.isEmpty())
                                            System.out.println("Lista categoria sensori attualmente vuota. E' necessario crearne di nuove per utilizzare questa funzione");
                                        else {
                                            for (CategoriaSensore catSens : listaCategoriaSensori)
                                                System.out.println("--- Nome categoria sensori: " + catSens.getNome());
                                        }

                                        break;
                                    case 5:
                                        System.out.println();
                                        if (unitaImmobiliare.getListaAttuatori().isEmpty())
                                            System.out.println("Lista attuatori attualmente vuota. E' necessario crearne di nuovi per utilizzare questa funzione");
                                        else {
                                            for (Attuatore att : unitaImmobiliare.getListaAttuatori()) {
                                                System.out.println("Nome Attuatore: " + att.getNome());
                                            }
                                        }
                                        if (listaCategoriaAttuatori.isEmpty())
                                            System.out.println("Lista categoria attuatori attualmente vuota. E' necessario crearne di nuove per utilizzare questa funzione");
                                        else {
                                            for (CategoriaAttuatore catAtt : listaCategoriaAttuatori)
                                                System.out.println("--- Nome categoria attuatori: " + catAtt.getNome());
                                        }
                                        break;
                                    case 6:
                                        System.out.println();
                                        if (listaModalitaOperative.isEmpty())
                                            System.out.println("Lista modalità operative attualmente vuota. E' necessario crearne di nuove per utilizzare questa funzione");
                                        else {
                                            for (ModalitaOperativa mod : listaModalitaOperative)
                                                System.out.println("--- Nome modalità operativa: " + mod.toString());
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
            } else if (operatore.equals("fruitore")) {
                int caso;


                unitaImmobiliare = new UnitaImmobiliare();

                do {
                    System.out.println("\n1) SELEZIONARE UN'UNITA' IMMOBILIARE PER EFFETTUARE LE OPERAZIONI DESIDERATE\n2) MOSTRA RILEVAZIONI DI UN SENSORE\n3) SETTA NUOVA MODALITA' ATTUATORE\n4) VISUALIZZA TUTTO\n0) USCITA\n");
                    caso = InputDati.leggiIntero("# Seleziona funzionalità: ");

                    switch (caso) {


                        case 1:
                            if (listaUnitaImmobiliari.isEmpty()) {
                                System.out.println("XX Non è stata definita alcuna unità immobiliare per poter interagire con il sistema XX");
                                break;
                            }

                            System.out.println("...ELENCO DI UNITA IMMOBILIARI DISPONIBILI ALLA SCELTA...");
                            for (UnitaImmobiliare unit : listaUnitaImmobiliari)
                                    System.out.println("-- Unita Immobiliare: " + unit.getNome() + "\n");

                            String seleziona = InputDati.leggiStringaNonVuota("Accedi ad un'unità immobiliare  già creata per utilizzare le funzionalità del sistema(nome unità immobiliare da selezionare): ");

                            if (seleziona.equals(unitaImmobiliare.getNome())) {
                                System.out.println(seleziona + " è stata già selezionata come unità immobiliare corrente ! ");

                            } else {
                                boolean presente = false;
                                if (listaUnitaImmobiliari.isEmpty())
                                    System.out.println("!!! Non è stata creata nessuna unità immobiliare al momento, è necessario che il manutentore ne crei una !!!");
                                else {
                                    for (UnitaImmobiliare immo : listaUnitaImmobiliari) {
                                        if (immo.getNome().equals(seleziona)) {
                                            presente = true;
                                            unitaImmobiliare = immo;
                                            break;
                                        }
                                    }

                                    if (presente)
                                        System.out.println("*** " + unitaImmobiliare.getNome() + " è stata selezionata come unità immobiliare corrente ***");
                                    else
                                        System.out.println("!!! Unità immobiliare specificata non è ancora stata creata !!!");
                                }
                            }

                            break;
                        case 2:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaSensori().isEmpty()) {
                                System.out.println("XX Non sono presenti sensori da cui poter leggere rilevazioni XX");
                                break;
                            }

                            boolean siSen = false;

                            System.out.println("\n...SENSORI ATTUALMENTE CREATI DAL MANUTENTORE...");

                            for (Sensore s : unitaImmobiliare.getListaSensori()) {
                                System.out.println("--- Nome sensore: " + s.getNome());
                            }

                            String ss = InputDati.leggiStringaNonVuota("Inserisci il nome del sensore sul quale si vogliono leggere i dati: ");
                            for (Sensore sensore : unitaImmobiliare.getListaSensori()) {
                                if (sensore.getNome().equals(ss)) {
                                    siSen = true;
                                    for (Informazione info : sensore.getRilevazioni()) {
                                        System.out.println(info);
                                    }
                                    break;
                                }
                            }
                            if (!siSen)
                                System.out.println("XXX Sensore non presente. E' necessario crearlo XXX");

                            break;
                        case 3:
                            if (unitaImmobiliare.getTipo().equals("")) {
                                System.out.println("!!! Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione !!!");
                                break;
                            }

                            if (unitaImmobiliare.getListaAttuatori().isEmpty()) {
                                System.out.println("!!! Non è presente alcun attuatore con cui poter agire !!!");
                                break;
                            }

                            boolean siAttua = false;
                            boolean siMod = false;

                            System.out.println("\n...ATTUATORI ATTUALMENTE CREATI DAL MANUTENTORE...");
                            for (Attuatore attr : unitaImmobiliare.getListaAttuatori()) {
                                System.out.println("--- Nome attuatore: " + attr.getNome());
                            }

                            String nomeAtt = InputDati.leggiStringaNonVuota("Inserisci il nome dell'attuatore al quale si vuole modificare la modalià operativa: ");
                            for (Attuatore a : unitaImmobiliare.getListaAttuatori()) {
                                if (a.getNome().equals(nomeAtt)) {
                                    siAttua = true;


                                    System.out.println("Attuatore: " + a.getNome() + ", modalità operativa attuale: " + a.getModalitaAttuale());

                                    System.out.println("...MODALITA' OPERATIVE DELL'ATTUATORE DAL MANUTENTORE...");
                                    for (ModalitaOperativa m : a.getCategoria().getModalita()) {
                                        System.out.println("--- Nome modalità operativa: " + m.getNome());
                                    }


                                    String nuovaMod = InputDati.leggiStringaNonVuota("Inserisci la nuova modalità per questo attuatore: ");
                                    for (ModalitaOperativa modal : a.getCategoria().getModalita()) {
                                        if (modal.getNome().equals(nuovaMod)) {
                                            siMod = true;

                                            if (modal.isParametrica()) {
                                                System.out.println("...PARAMETRI DELLA MODALITA'...");
                                                HashMap<String, Integer> params = modal.getParametri();
                                                for (String key : params.keySet()) {
                                                    System.out.println("--- Nome parametro: " + key + ", valore parametro: " + params.get(key));
                                                }
                                                String nomeParam = InputDati.leggiStringaNonVuota("Inserisci il nome del parametro per questa modalità operativa: ");
                                                int nuovoVal = InputDati.leggiIntero("Inserisci il nuovo valore per questa modalità parametrica: ");
                                                a.setModalitaAttuale(nuovaMod, nomeParam, nuovoVal);
                                            } else {
                                                a.setModalitaAttuale(nuovaMod);
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (!siAttua) {
                                System.out.println("!!! L'attuatore non esiste. E' necessario crearlo !!!");
                                break;
                            }
                            if (!siMod) {
                                System.out.println("!!! La modalità inserita non esiste. E' necessario crearla !!!");
                                break;
                            }

                            break;
                        case 4:
                            int sceltaVisualizza;
                            do {
                                System.out.println("\n1) VISUALIZZA COMPOSIZIONE UNITA' IMMOBILIARE\n2) VISUALIZZA COMPOSIZIONE STANZE\n3) VISUALIZZA COMPOSIZIONE ARTEFATTI\n" +
                                        "4) VISUALIZZA LISTA SENSORI E CATEGORIE SENSORI\n5) VISUALIZZA LISTA ATTUATORI E CATEGORIE ATTUATORI\n6) VISUALIZZA LISTA MODALITA' OPERATIVE\n0) USCITA");
                                sceltaVisualizza = InputDati.leggiIntero("### Seleziona funzionalità: ");
                                switch (sceltaVisualizza) {
                                    case 1:
                                        if (unitaImmobiliare.getTipo().equals("")) {
                                            System.out.println("!!! Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione !!!");
                                            break;
                                        }
                                        System.out.println(unitaImmobiliare.visualizzaDescrizione());
                                        break;
                                    case 2:
                                        if (unitaImmobiliare.getTipo().equals("")) {
                                            System.out.println("!!! Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione !!!");
                                            break;
                                        }
                                        if (unitaImmobiliare.getListaStanze().isEmpty()) {
                                            System.out.println("E' necessario creare almeno una stanza prima di utilizzare questa funzione");
                                            break;
                                        }
                                        for (Stanza stanzetta : unitaImmobiliare.getListaStanze()) {
                                            System.out.println(stanzetta.visualizzaDisposizione());
                                        }
                                        break;
                                    case 3:
                                        if (unitaImmobiliare.getTipo().equals("")) {
                                            System.out.println("!!! Unità Immobiliare non creata. E' necessario che il manutentore ne definisca una prima di questa operazione !!!");
                                            break;
                                        }
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
                                        if (unitaImmobiliare.getListaSensori().isEmpty())
                                            System.out.println("Lista sensori attualmente vuota. E' necessario crearne di nuovi per utilizzare questa funzione");
                                        else {
                                            for (Sensore s : unitaImmobiliare.getListaSensori()) {
                                                System.out.println("Nome Sensore: " + s.getNome());
                                            }
                                        }
                                        if (listaCategoriaSensori.isEmpty())
                                            System.out.println("Lista categoria sensori attualmente vuota. E' necessario crearne di nuove per utilizzare questa funzione");
                                        else {
                                            for (CategoriaSensore catSens : listaCategoriaSensori)
                                                System.out.println("--- Nome categoria sensori: " + catSens.getNome());
                                        }

                                        break;
                                    case 5:
                                        System.out.println();
                                        if (unitaImmobiliare.getListaAttuatori().isEmpty())
                                            System.out.println("Lista attuatori attualmente vuota. E' necessario crearne di nuovi per utilizzare questa funzione");
                                        else {
                                            for (Attuatore att : unitaImmobiliare.getListaAttuatori()) {
                                                System.out.println("Nome Attuatore: " + att.getNome());
                                            }
                                        }
                                        if (listaCategoriaAttuatori.isEmpty())
                                            System.out.println("Lista categoria attuatori attualmente vuota. E' necessario crearne di nuove per utilizzare questa funzione");
                                        else {
                                            for (CategoriaAttuatore catAtt : listaCategoriaAttuatori)
                                                System.out.println("--- Nome categoria attuatori: " + catAtt.getNome());
                                        }
                                        break;
                                    case 6:
                                        System.out.println();
                                        if (listaModalitaOperative.isEmpty())
                                            System.out.println("Lista modalità operative attualmente vuota. E' necessario crearne di nuove per utilizzare questa funzione");
                                        else {
                                            for (ModalitaOperativa mod : listaModalitaOperative)
                                                System.out.println("--- Nome modalità operativa: " + mod.toString());
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

    }

}
