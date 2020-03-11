package inge.progetto;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Rappresenta la modalit&agrave; operativa di una determinato {@link Attuatore}e di conseguenza lo stato dell'{@link Artefatto}
 * ad esso associato. Permettendo cosi ad un attuatore, attraverso una specifica modalit&agrave;, di comandare
 * il comportamento dell'artefatto, misurato o comunque monitorato eventualmente da un {@link Sensore}.
 *
 * @author Parampal Singh, Mattia Nodari
 *
 * @see Informazione
 */
public class ModalitaOperativa extends Informazione //TODO: Incorporare cambiamenti provenienti da classe padre Informazione
                                implements Serializable {

    //Hashmap con nome e valore dei possibili parametri della modalità operativa
    private HashMap<String, Integer> parametri;

    /**
     * Un valore intero unico, specificato dal manutentore, che permette di  avere una rappresentazione numerica
     * della modalit&agrave; operativa, usata dal sistema per acquisizione di informazioni/misure attraverso sensori.
     */
     // private int valore; Magari non mi serve piu perchè posso anche avere info non numeriche ora

    /**Costruttore della classe
     * La modalit&agrave; operativa &egrave; completamente specificata dal manutentore
     * con nome e valore prefissato
     *
     * @param nome nome della modalit&agrave; operativa
     * //@param valore valore numerico della modalit&agrave; operativa
     */
    public ModalitaOperativa(String nome) {
        super(nome); //Costruttore della classe padre (Informazione)
        //this.valore = valore;
        this.parametri = new HashMap<>();
    }

    //TODO: Creare HashMap nel Main quando si crearlo durante creazione di modalità operativa parametrica
    public ModalitaOperativa(String nome, HashMap<String, Integer> parametri) {
        super(nome); //Costruttore della classe padre (Informazione)
        //this.valore = valore;
        this.parametri = parametri;
    }



    /**
     * Ci permette di ricavare il valore informativo/numerico precedentemente assegnato dal manutentore alla
     * modalit&agrave; operativa (guarda costruttore).
     * Il metodo sovrascrive del omonimo metodo della classe padre(Informazione) dove il valore &egrave; generato casualmente
     * ed &egrave; limitato da un range/dominio per la misura
     *
     * @see Informazione
     */

    //Per ora è una mia versione di settaggio parametro da parte dell'utente e conseguente assegnamento al valore della modalita operativa
    public void setParametro(String nome, int valoreParam) {
        if (parametri.isEmpty()) {
            System.out.println("La modalità operativa non è parametrica");
            return;
        }
        else if (!parametri.containsKey(nome)) {
            System.out.println("La modalita operativa non ha un parametro con questo nome");
            return;
        }
        parametri.put(nome,valoreParam);
        System.out.println("Il parametro è stato impostato correttamente al nuovo valore");
    }



    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Modalita Operativa: " + this.getNome());
        if (!this.parametri.isEmpty()) {
            out.append("\nParametri = ");
            for (String key : parametri.keySet()) {
                out.append("...[ ").append(key).append(":").append(parametri.get(key)).append(" ]");
            }
        }
        return String.valueOf(out);
    }

    /**Permette la modifica del valore numerico associato alla modalit&agrave; operativa
     * //@param valore nuovo valore da assegnare alla modalit&agrave; operativa
     */
    /*public void setValore(int valore) {
        this.valore = valore;
    }

     */
    public boolean isParametrica() {
        return !parametri.isEmpty();
    }

    public HashMap<String, Integer> getParametri() {
        return parametri;
    }

    public void setParametri(HashMap<String, Integer> parametri) {
        this.parametri = parametri;
    }
}
