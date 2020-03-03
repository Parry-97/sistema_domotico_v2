package inge.progetto;

import java.io.Serializable;

/**
 * Rappresenta la modalit&agrave; operativa di una determinato {@link Attuatore}e di conseguenza lo stato dell'{@link Artefatto}
 * ad esso associato. Permettendo cosi ad un attuatore, attraverso una specifica modalit&agrave;, di comandare
 * il comportamento dell'artefatto, misurato o comunque monitorato eventualmente da un {@link Sensore}.
 *
 * @author Parampal Singh, Mattia Nodari
 *
 * @see Informazione
 */
public class ModalitaOperativa extends Informazione
                                implements Serializable {

    /**
     * Un valore intero unico, specificato dal manutentore, che permette di  avere una rappresentazione numerica
     * della modalit&agrave; operativa, usata dal sistema per acquisizione di informazioni/misure attraverso sensori.
     */
    private int valore;

    /**Costruttore della classe
     * La modalit&agrave; operativa &egrave; completamente specificata dal manutentore
     * con nome e valore prefissato
     *
     * @param nome nome della modalit&agrave; operativa
     * @param valore valore numerico della modalit&agrave; operativa
     */
    public ModalitaOperativa(String nome, int valore) {
        super(nome); //Costruttore della classe padre (Informazione)
        this.valore = valore;
    }

    /**
     * Ci permette di ricavare il valore informativo/numerico precedentemente assegnato dal manutentore alla
     * modalit&agrave; operativa (guarda costruttore).
     * Il metodo sovrascrive del omonimo metodo della classe padre(Informazione) dove il valore &egrave; generato casualmente
     * ed &egrave; limitato da un range/dominio per la misura
     *
     * @see Informazione
     */
    @Override
    public int getValore() {
        if(this.valore > super.getVALORE_MAX())
            return super.getVALORE_MAX();
        else return Math.max(this.valore, super.getVALORE_MIN());
    }

    /**Permette la modifica del valore numerico associato alla modalit&agrave; operativa
     * @param valore nuovo valore da assegnare alla modalit&agrave; operativa
     */
    public void setValore(int valore) {
        this.valore = valore;
    }
}
