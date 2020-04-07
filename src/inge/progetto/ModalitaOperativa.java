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
public class ModalitaOperativa extends Informazione
                                implements Serializable {

    private HashMap<String, Integer> parametri;

    /**Costruttore della classe
     * La modalit&agrave; operativa &egrave; completamente specificata dal manutentore
     * con nome e valore prefissato
     *
     * @param nome nome della modalit&agrave; operativa
     * //@param valore valore numerico della modalit&agrave; operativa
     */
    public ModalitaOperativa(String nome) {
        super(nome);
        this.parametri = new HashMap<>();
    }


    public ModalitaOperativa(String nome, HashMap<String, Integer> parametri) {
        super(nome);
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

    public void setParametro(String nome, int valoreParam) {
        if (parametri.isEmpty()) {
            System.out.println("!!! La modalità operativa non è parametrica !!! Riprova");
            return;
        }
        else if (!parametri.containsKey(nome)) {
            System.out.println("!!! La modalita operativa non ha un parametro con questo nome !!! Riprova");
            return;
        }


        parametri.put(nome,valoreParam);
        System.out.println("*** Il parametro è stato impostato correttamente al nuovo valore ***");
    }

    /**
     *
     * @return stampa il toString della modalità operativa
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Modalita Operativa: " + this.getNome());
        if (!this.parametri.isEmpty()) {
            out.append("\n### Parametri = ");
            for (String key : parametri.keySet()) {
                out.append("...[ ").append(key).append(":").append(parametri.get(key)).append(" ]");
            }
        }
        return String.valueOf(out);
    }

    /**
     *
     * @return True se la modalità operativa è paramentrica oppure false se non lo è
     */
    public boolean isParametrica() {
        return !parametri.isEmpty();
    }

    /**
     * Effettua il get dell'HashMap che contiene la lista dei parametri di quella modalità operativa
     */
    public HashMap<String, Integer> getParametri() {
        return parametri;
    }

    public void setParametri(HashMap<String, Integer> parametri) {
        this.parametri = parametri;
    }
}
