package com.example.p11problemstatement;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class VaccinationFragment extends Fragment {


    Button btnVac;
    TextView tv;

    public VaccinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_vaccination, container, false);
        tv = v.findViewById(R.id.tvShow);
        btnVac = v.findViewById(R.id.btnVac);
        btnVac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Use the Builder class for convenient dialog construction
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                // Set up the input
                final EditText input = new EditText(getContext());
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setMessage(R.string.edit_V)
                        .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User click Yes
                                Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                                String text = input.getText().toString();
                                tv.setText(text);
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User click cancel
                                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });
                // Create the AlertDialog object and return it
                builder.show();
            }
        });
        return v;


    }

}
