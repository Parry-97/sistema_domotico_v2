package inge.progetto;

import java.util.ArrayList;

/**
 * Permette di modellizare un sensore gestibile da un sistema domotico. Il sensore &egrave; identificato da un {@link #nome},
 * {@link #categoria} e dalla misura che questo rileva({@link #rilevazioni}), la quale pu&ograve; essere lo 'stato' di un
 * {@link Artefatto} da questi monitorato o la misura di una grandezza fisica associata ad una {@link Stanza} (es. temperatura o pressione).
 * Si definiscono quindi, attraverso la sua {@link #categoria}, sensori di tipo 'fisici' e 'sensori di stato' che monitorano
 * rispettivamente una stanza o un artefatto.
 *
 * @author Parampal Singh, Mattia Nodari
 */
public class Sensore {
    /** nome del sensore*/
    private String nome;

    /** categoria a cui il sensore appartiene (guarda {@link CategoriaSensore})*/
    private CategoriaSensore categoria;

    /** informazione o misura che il sensore rileva (guarda {@link Informazione})*/
    private ArrayList<Informazione> rilevazioni; //TODO: Cosa fa un sensore con info multiple ma associato ad un artefatto

    /** stato del sensore ovvero se questi &egrave; abilitato o meno, attivo o spento*/
    private boolean statoAttivazione;

    /**
     * Costruttore della classe Sensore.
     * l'informazione inizialmente associata &egrave; di natura casuale(default)
     * @param nome nome da attribuire al sensore
     * @param categoria categoria di sensore a cui questo 'appartiene'
     * @see CategoriaSensore
     * @see Informazione
     */
    public Sensore(String nome, CategoriaSensore categoria) {
        this.nome = nome + "_" + categoria.getNome();
        this.categoria = categoria;
        this.rilevazioni = categoria.getInfoRilevabili();
        this.statoAttivazione = true;
    }

    /**Fornisce il nome del sensore
     * @return nome del sensore
     */
    public String getNome() {
        return nome;
    }

    /** Permette di modificare il nome del sensore
     * @param nome nuovo nome da attribuire al sensore
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Fornisce la categoria a cui 'appartiene' il sensore
     * @return categoria del sensore
     */
    public CategoriaSensore getCategoria() {
        return categoria;
    }

    /**Permette di ottenere l'informazione rilevata dal sensore
     * @return informazione
     */
    public ArrayList<Informazione> getRilevazioni() {
        return rilevazioni;
    }

    /** Permette di specificare esplicitamente l'informazione rilevabile dal sensore. Utilizzata principalmente per sensori
     *  che monitorano artefatti, in quanto devono 'essere associati' a quest'ultimi per tener traccia del loro comportamento.
     *  Mentre invece sensori di natura 'fisica' non sono associati a particolari artefatti e misurano autonomamente una grandezza
     *  come temperatura o pressione ed &egrave; quindi vietato alterarne il contenuto informativo. Il tipo di sensore e le informazioni
     *  da questo rilevabili sono definite nella sua categoria (vedi {@link CategoriaSensore})
     *
     * @param rilevazione nuova informazione che il sensore rileva
     * @see Informazione
     */
    public void setRilevazione(Informazione  rilevazione) { //TODO: magari conviene 'aggiungere invece di settare

        //Mantenendo un'po la logica di prima: si ha che se il sensore è fisico allora a questi non si possono associare artefatti
        //Quelli non fisici avranno come primo elemento Informazione di inforilevabili un informazione casuale inizialmente di nome STATO che cambiamo
        //quando chiamiamo questo metodo.
        if(this.categoria.isFisico()) {
            System.out.println("Non è possibile alterare le rilevazioni del sensore! \n");
        }
        else {
            //Altrimenti possiamo semplicemente fare che la info al primo indice è una modalita operativa
            //Il resto fotte sega
            for (int i = 0; i < this.rilevazioni.size(); i++) {
                if (this.rilevazioni.get(i).getNome().equals("STATO")) {
                    this.rilevazioni.set(i,rilevazione);
                    break;
                }
            }
        }
    }


    public void modificaRilevazione(Informazione info1, Informazione info2) {
        if (rilevazioni.contains(info1))
            rilevazioni.set(rilevazioni.indexOf(info1),info2);
    }

    /**Permette di conoscere lo stato di attivazione del sensore ovvero se &egrave; accesso o spento
     * @return vero se il sensore &egrave; accesso/attivo falso altrimenti
     */
    public boolean isAttivo() {
        return statoAttivazione;
    }

    /**Permette di impostare lo stato di attivazione del sensore
     * @param statoAttivazione lo stato del sensore (acceso=True, spento=False)
     */
    public void setStatoAttivazione(boolean statoAttivazione) {
        this.statoAttivazione = statoAttivazione;
    }

}
