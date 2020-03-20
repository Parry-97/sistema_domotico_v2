package inge.progetto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Un utente manutentore pu&ograve; descrivere inoltre ogni tipo di {@link CategoriaSensore}, cio&egrave; anche quelle per cui un {@link Sensore} pu&ograve; rilevare un'informazione anche non numerica.
 * Ciascun tipo di informazione non numerica pu&ograve; assumere valori appartenenti a un dominio scalare finito (ogni singolo valore entro il dominio &egrave; una stringa). Ad esempio,
 * l&rsquo;immagine prodotta da una videocamera di videosorveglianza &egrave; un&rsquo;informazione non numerica: si pu&ograve; convenire che i valori prodotti in uscita dalla stessa cadano nel dominio
 * {presenza di persone, assenza di persone} a seconda che nell&rsquo;immagine sia riscontrabile la presenza o l&rsquo;assenza di persone. Invece il dominio dei valori di un&rsquo;immagine prodotta
 * da una videocamera preposta al controllo di interni potrebbe essere {persona a terra, ok}, dove il primo valore denuncia un possibile incidente mentre il secondo lo esclude.
 *
 * @see Informazione
 *
 * @author Parampal Singh, Mattia Nodari
 */
public class InformazioneNonNum extends Informazione
                                implements Serializable {
    /**
     * Insieme di valori scalari(stringhe) che definiscono il dominio non numerico dell'informazione
     */
    private ArrayList<String> dominioNonNumerico;


    /**Costruttore di un'istanza di informazione non numerica
     * @param nome nome dell'informazione
     */
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
    /**
     * Fornisce una rappresentazione testuale che descrive l'informazione
     * @return una stringa descrittiva dell'istanza
     */
    @Override
    public String toString() {
        return "[ Nome informazione: " + super.getNome() + " | Rilevazione: " + this.dominioNonNumerico.get(super.getValore()) + " ]";
    }
}
