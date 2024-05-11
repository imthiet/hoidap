package com.example.recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class Myviewholder extends ViewHolder {

    TextView name_view;
    TextView pwd_view;
    TextView fn_view;
    TextView dob_view;
    TextView hobby_view;

    public Myviewholder(@NonNull View usView) {
        super(usView);

        name_view = usView.findViewById(R.id.name_view);
        pwd_view = usView.findViewById(R.id.password_view);
        fn_view = usView.findViewById(R.id.fn_view);
        dob_view = usView.findViewById(R.id.dob_view);
        hobby_view = usView.findViewById(R.id.interes_view);
    }
}
