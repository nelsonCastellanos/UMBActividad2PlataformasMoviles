package com.umb.umbactividad2plataformasmoviles.ui.slideshow;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.umb.umbactividad2plataformasmoviles.R;
import com.umb.umbactividad2plataformasmoviles.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;
    TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button = root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
           TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);

            @Override
            public void onClick(View view)
            {
                String  name = ((EditText)root.findViewById(R.id.editTextTextPersonName)).getText().toString();
                String last = ((EditText)root.findViewById(R.id.editTextTextPersonLastName)).getText().toString();
                String age =  ((EditText)root.findViewById(R.id.editTextNumber)).getText().toString();

                if(name.isEmpty() || last.isEmpty() || age.isEmpty()){
                    Toast.makeText(binding.getRoot().getContext(), "Ingrese data..",Toast.LENGTH_SHORT).show();

                }else {
                    TableLayout listView = root.findViewById(R.id.table);
                    TableRow tableRow = new TableRow(listView.getContext());
                    tableRow.setLayoutParams(this.tableParams);
                    tableRow.addView(view(tableRow, "Nombre: " + name + " , Apellido: " + last + " Edad: " + age));
                    listView.addView(tableRow);
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    TextView view(TableRow tableRow, String name){
         TextView textView = new TextView(tableRow.getContext());
                 textView.setLayoutParams(rowParams);
                 textView.setText(name);
                 return textView;
    }

}

