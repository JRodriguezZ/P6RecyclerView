package com.example.p6recyclerview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class DesafiosViewModel {
    DesafiosRepositorio desafiosRepositorio;

    MutableLiveData<List<Desafio>> listDesafiosMutableLiveData = new MutableLiveData<>();

    public DesafiosViewModel(@NonNull Application application) {
        super(application);

        desafiosRepositorio = new DesafiosRepositorio();

        listDesafiosMutableLiveData.setValue(desafiosRepositorio.getDesafios());
    }

    MutableLiveData<List<Desafio>> obtener(){
        return listDesafiosMutableLiveData;
    }

}
