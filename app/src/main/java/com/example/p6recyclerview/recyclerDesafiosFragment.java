package com.example.p6recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p6recyclerview.databinding.FragmentRecyclerDesafiosBinding;
import com.example.p6recyclerview.databinding.ViewholderDesafioBinding;

import java.util.List;


public class recyclerDesafiosFragment extends Fragment {

    private FragmentRecyclerDesafiosBinding binding;
    private DesafiosViewModel desafiosViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecyclerDesafiosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        desafiosViewModel = new ViewModelProvider(requireActivity()).get(DesafiosViewModel.class);
        navController = Navigation.findNavController(view);

        DesafiosAdapter desafiosAdapter = new DesafiosAdapter();
        binding.recyclerView.setAdapter(desafiosAdapter);

        desafiosViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Desafio>>() {
            @Override
            public void onChanged(List<Desafio> desafios) {
                desafiosAdapter.establecerLista(desafios);
            }
        });
    }

    class DesafioViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderDesafioBinding binding;

        public DesafioViewHolder(ViewholderDesafioBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class DesafiosAdapter extends RecyclerView.Adapter<DesafioViewHolder> {

        List<Desafio> desafios;

        @NonNull
        @Override
        public DesafioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new DesafioViewHolder(ViewholderDesafioBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull DesafioViewHolder holder, int position) {

            Desafio desafio = desafios.get(position);

            holder.binding.nombre.setText(desafio.nombre);
            holder.binding.valoracion.setRating(desafio.valoracion);
        }

        @Override
        public int getItemCount() {
            return desafios != null ? desafios.size() : 0;
        }

        public void establecerLista(List<Desafio> desafios){
            this.desafios = desafios;
            notifyDataSetChanged();
        }
    }
}