package inge.progetto;

import java.io.Serializable;

/**
 * Rappresenta l'informazione/misura numerica che il sistema domotico acquisisce attaverso ogni singolo sensori dislocati
 * nelle sottounit&agrave; immobiliari soggette al controllo. Ciascuna informazione &egrave; identificata da un {@link #nome}
 * e pu&ograve; assumere un valore che cade entro un dominio ({@link #VALORE_MIN} , {@link #VALORE_MAX}).
 *
 * @author Parampal Singh, Mattia Nodari
 */
public class Informazione implements Serializable {

    /**
     * nome dell'informazione
     */
    private String nome;


    /**estremo superiore del dominio di valori assunti dall'informazione
     */
    private int  VALORE_MAX = Integer.MAX_VALUE;

    /**estremo superiore del dominio di valori assunti dall'informazione
     */
    private int VALORE_MIN = 0;


    /**Costruttore per un oggetto di tipo {@link Informazione}
     * @param nome nome da assegnare all'informazione
     */
    public Informazione(String nome) {
        this.nome = nome;
    }

    /** Costruttore per un oggetto di tipo {@link Informazione}
     * @param nome nome da assegnare all'informazione
     * @param valoreMax valore massimo del range/dominio dell'informazione
     * @param valoreMin valore minimo del range/dominio dell'informazione
     */
    public Informazione(String nome, int valoreMax, int valoreMin) {
        this.nome = nome;
        this.VALORE_MAX = valoreMax;
        this.VALORE_MIN = valoreMin;
    }

    /**Permette di modificare estremo superiore del dominio in cui cade l'informazione
     * @param VALORE_MAX nuovo valore massimo possibile per l'informazione
     */
    public void setVALORE_MAX(int VALORE_MAX) {
        this.VALORE_MAX = VALORE_MAX;
    }

    /**Permette di modificare estremo inferiore del dominio in cui cade l'informazione
     * @param VALORE_MIN nuovo valore minimo possibile per l'informazione
     */
    public void setVALORE_MIN(int VALORE_MIN) {
        this.VALORE_MIN = VALORE_MIN;
    }

    /**Fornisce la misura/valore dell'informazione, un valore casuale che cade entro il dominio specificato
     * @return valore numerico dell'informazione
     */
    protected int getValore() {
        return (int) (Math.random() * (this.VALORE_MAX - this.VALORE_MIN) + this.VALORE_MIN);
    }

    /**Fornisce estremo superiore del dominio in cui cade l'informazione
     * @return valore massimo possibile per l'informazione
     */
    public int getVALORE_MAX() {
        return VALORE_MAX;
    }

    /**Fornisce estremo inferiore del dominio in cui cade l'informazione
     * @return valore minimo possibile per l'informazione
     */
    public int getVALORE_MIN() {
        return VALORE_MIN;
    }

    /**Fornisce nome con cui è specificata dell'informazione
     * @return valore massimo possibile per l'informazione
     */
    public String getNome() {
        return nome;
    }

    /**Permette di modificare il nome con cui è specificata dell'informazione
     * @param nome  nuovo nome da assegnare all'informazione
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "[" + this.nome + " : " + this.getValore() + "]";
    }
}
