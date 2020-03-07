package inge.progetto;

import java.util.ArrayList;

public class InformazioneNonNum extends Informazione {
    private ArrayList<String> dominioNonNumerico;


    public InformazioneNonNum(String nome) {
        super(nome);
        this.dominioNonNumerico = new ArrayList<>();
    }

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

    @Override
    public String toString() {
        return "InfoNaN: [ " + super.getNome() + " | " + this.dominioNonNumerico.get(super.getValore()) + " ]";
    }
}
