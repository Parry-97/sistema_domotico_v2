package inge.progetto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Rappresenta il dominio non numero delll'informazione/misura che il sistema domotico acquisisce attaverso ogni singolo sensore non numerico dislocato
 * nelle sottounit&agrave; immobiliari soggette al controllo. Ciascuna informazione &egrave; identificata da un nome
 * e pu&ograve;
 *
 * @author Parampal Singh, Mattia Nodari
 */
public class InformazioneNonNum extends Informazione
                                implements Serializable {
    private ArrayList<String> dominioNonNumerico;


    public InformazioneNonNum(String nome) {
        super(nome);
        this.dominioNonNumerico = new ArrayList<>();
    }

    /**
     *
     * @param nome dell'informazione non numerica
     * @param dominioNonNumerico è l'insieme delle strighe(stati) che possono essere acquisiti da un sensore con dominio non numerico
     */
    public InformazioneNonNum(String nome, ArrayList<String> dominioNonNumerico) {
        super(nome);
        this.dominioNonNumerico = dominioNonNumerico;
        super.setVALORE_MAX(dominioNonNumerico.size());
    }

    public ArrayList<String> getDominioNonNumerico() {
        return dominioNonNumerico;
    }

    public void setDominioNonNumerico(ArrayList<String> dominioNonNumerico) {
        this.dominioNonNumerico = dominioNonNumerico;
    }

    /**
     *
     * @return una rappresentazione testuale delle informazioni non numeriche che una categoria di sensori può acquisire
     */
    @Override
    public String toString() {
        return "[ Nome informazione: " + super.getNome() + " | Rilevazione: " + this.dominioNonNumerico.get(super.getValore()) + " ]";
    }
}
