package inge.progetto;

import java.util.ArrayList;

/**
 * Ogni {@link UnitaImmobiliare} &egrave; costituita da almeno una {@link Stanza} o da almeno un {@link Artefatto}.
 * Una stanza &egrave; identificata da un {@link #nome}, da una {@link #listaSensori} e da una {@link #listaArtefatti} in essa dislocati.
 * I sensori in essa presenti forniscono informazioni al sistema, il quale agisce attraverso attuatori e quindi artefatti per compiere
 * 'azioni' e gestire una stanza.
 * @see Artefatto
 * @see UnitaImmobiliare
 * @see Sensore
 * @see Attuatore
 *
 * @author Parampal Singh, Mattia Nodari
 */
public class Stanza {
    /**
     * nome della stanza
     */
    private String nome;
    /**
     *  lista/insieme di sensori associati alla stanza
     */
    private ArrayList<Sensore> listaSensori;

    /**
     * lista/insieme di sensori dislocati nella stanza
     */
    private ArrayList<Artefatto> listaArtefatti;

    /**
     * Costruttore per specifica di un oggetto Stanza
     * @param nome nome da assegnare alla stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        listaSensori = new ArrayList<>();
        listaArtefatti = new ArrayList<>();
    }

    /**Permette di ottenere il nome della stanza
     * @return nome della stanza
     */
    public String getNome() {
        return nome;
    }

    /**Permette di assegnare un nuovo nome alla stanza
     * @param nome nuovo nome da assegnare alla stanza
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**Permette di ottenere la lista di sensori associati alla stanza
     * @return la lista di sensori associati alla stanza e in essa dislocati
     */
    public ArrayList<Sensore> getListaSensori() {
        return listaSensori;
    }


    /**Fornisce la lista degli artefatti presenti nella stanza
     * @return la lista degli artefatti nella stanza
     */
    public ArrayList<Artefatto> getListaArtefatti() {
        return listaArtefatti;
    }

    /**Associa un dispostivo alla stanza aggiungendolo alla sua lista di sensori({@link #listaSensori}).
     * Il sensore dev'essere di un certo tipo/categoria ovvero 'fisico' in quanto altrimenti non può essere aggiunto.
     * @param sens sensore da aggiungere
     */
    public void aggiungiSensore(Sensore sens) {
        if (!sens.getCategoria().isFisico()) {
            System.out.println("\n!!! Non è possibile associare tale categoria di dispositivo alla stanza specificata !!!\n");
            return;
        }

        for (Sensore s : listaSensori) {
            if (s.getCategoria().equals(sens.getCategoria()) || s.getNome().equals(sens.getNome()))
                return;
        }
        listaSensori.add(sens);
        System.out.println("Sensore aggiunto");

    }

    /**Permette di aggiungere un nuovo artefatto alla stanza
     * @param a nuovo artefatto da aggiungere
     */
    public void aggiungiArtefatto(Artefatto a) {
        for (Artefatto artefatto : listaArtefatti) {
            if (artefatto.getNome().equals(a.getNome()))
                return;
        }
        listaArtefatti.add(a);
        System.out.println("Artefatto aggiunto");

    }

    /**Permette di ottenere una descrizione testuale della disposizione interna della stanza
     * @return stringa descrittiva della stanza
     */
    public String visualizzaDisposizione() {
        String visualizza = "Nome Stanza: " + this.getNome() + ", essa possiede:\n";

        for (Artefatto a: listaArtefatti) {
            visualizza +=  a.visualizzaDispositivi();
        }

        for (Sensore s : listaSensori) {
            visualizza += "Nome Sensore: "+ s.getNome() + " | " + "Categoria: " + s.getCategoria().getNome() + " | " + "Rilevazione: " + s.getRilevazione().getValore()+"\n";
        }
        return visualizza;

    }
}