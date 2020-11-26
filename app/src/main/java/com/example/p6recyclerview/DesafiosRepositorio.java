package com.example.p6recyclerview;

import java.util.ArrayList;
import java.util.List;

public class DesafiosRepositorio {

    List<Desafio> desafios = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Desafio> desafios);
    }

    DesafiosRepositorio(){
        desafios.add(new Desafio("Backflip", "Voltereta patra."));
        desafios.add(new Desafio("Backflip", "Voltereta patra."));
        desafios.add(new Desafio("Backflip", "Voltereta patra."));
        desafios.add(new Desafio("Backflip", "Voltereta patra."));
        desafios.add(new Desafio("Backflip", "Voltereta patra."));
        desafios.add(new Desafio("Backflip", "Voltereta patra."));
        desafios.add(new Desafio("Backflip", "Voltereta patra."));
        desafios.add(new Desafio("Backflip", "Voltereta patra."));
    }

    public List<Desafio> getDesafios() {
        return desafios;
    }
}
