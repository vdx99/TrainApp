package mw.wpam.trainapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList train_id, train_name, excercise1, excercise2, excercise3, excercise4, excercise5, excercise6, series;

    CustomAdapter(Activity activity, Context context, ArrayList train_id, ArrayList train_name, ArrayList excercise1, ArrayList excercise2,
                  ArrayList excercise3, ArrayList excercise4, ArrayList excercise5, ArrayList excercise6, ArrayList series){
        this.activity = activity;
        this.context = context;
        this.train_id = train_id;
        this.train_name = train_name;
        this.excercise1 = excercise1;
        this.excercise2 = excercise2;
        this.excercise3 = excercise3;
        this.excercise4 = excercise4;
        this.excercise5 = excercise5;
        this.excercise6 = excercise6;
        this.series = series;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
       // holder.train_id_txt.setText(String.valueOf(train_id.get(position)));
        holder.train_name_txt.setText(String.valueOf(train_name.get(position)));
        holder.excercise1_txt.setText(String.valueOf(excercise1.get(position)));
        holder.excercise2_txt.setText(String.valueOf(excercise2.get(position)));
        holder.excercise3_txt.setText(String.valueOf(excercise3.get(position)));
        holder.excercise4_txt.setText(String.valueOf(excercise4.get(position)));
        holder.excercise5_txt.setText(String.valueOf(excercise5.get(position)));
        holder.excercise6_txt.setText(String.valueOf(excercise6.get(position)));
        holder.series_txt.setText(String.valueOf(series.get(position)));

        //holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        //holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(train_id.get(position)));
                intent.putExtra("trainName", String.valueOf(train_name.get(position)));
                intent.putExtra("exc1", String.valueOf(excercise1.get(position)));
                intent.putExtra("exc2", String.valueOf(excercise2.get(position)));
                intent.putExtra("exc3", String.valueOf(excercise3.get(position)));
                intent.putExtra("exc4", String.valueOf(excercise4.get(position)));
                intent.putExtra("exc5", String.valueOf(excercise5.get(position)));
                intent.putExtra("exc6", String.valueOf(excercise6.get(position)));
                intent.putExtra("series", String.valueOf(series.get(position)));
                //intent.putExtra("author", String.valueOf(book_author.get(position)));
                //intent.putExtra("pages", String.valueOf(book_pages.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return train_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView train_id_txt, train_name_txt, excercise1_txt, excercise2_txt, excercise3_txt, excercise4_txt, excercise5_txt, excercise6_txt, series_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //train_id_txt = itemView.findViewById(R.id.train_id_txt);
            train_name_txt = itemView.findViewById(R.id.train_name_txt);
            excercise1_txt = itemView.findViewById(R.id.excercise1_txt);
            excercise2_txt = itemView.findViewById(R.id.excercise2_txt);
            excercise3_txt = itemView.findViewById(R.id.excercise3_txt);
            excercise4_txt = itemView.findViewById(R.id.excercise4_txt);
            excercise5_txt = itemView.findViewById(R.id.excercise5_txt);
            excercise6_txt = itemView.findViewById(R.id.excercise6_txt);
            series_txt = itemView.findViewById(R.id.series_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
