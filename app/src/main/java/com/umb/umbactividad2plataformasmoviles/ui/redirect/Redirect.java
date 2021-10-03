package com.umb.umbactividad2plataformasmoviles.ui.redirect;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.umb.umbactividad2plataformasmoviles.R;
import com.umb.umbactividad2plataformasmoviles.databinding.FragmentHomeBinding;

public class Redirect extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_redirect, container, false);
        Button button = view.findViewById(R.id.buttonGoUMB);
          button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                goUmb();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void goUmb() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://umb.edu.co/"));
        startActivity(browserIntent);
    }
}