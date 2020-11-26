package com.example.p6recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p6recyclerview.databinding.FragmentMostrarDesafioBinding;
import com.example.p6recyclerview.databinding.FragmentRecyclerDesafiosBinding;

public class mostrarDesafioFragment extends Fragment {
    private FragmentMostrarDesafioBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMostrarDesafioBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DesafiosViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(DesafiosViewModel.class);


    }
}