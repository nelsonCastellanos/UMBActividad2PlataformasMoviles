package com.umb.umbactividad2plataformasmoviles.ui.redirect;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umb.umbactividad2plataformasmoviles.databinding.FragmentHomeBinding;

public class Redirect extends Fragment {

    private FragmentHomeBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void goUmb(View view) {
         Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://umb.edu.co/"));
                        startActivity(browserIntent);
    }
}