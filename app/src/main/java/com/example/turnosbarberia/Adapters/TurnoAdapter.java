package com.example.turnosbarberia.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.turnosbarberia.Models.Turno;
import com.example.turnosbarberia.R;

import java.util.List;

public class TurnoAdapter extends RecyclerView.Adapter<TurnoAdapter.ReclamoViewHolder> {
        Context context;
        List<Turno> mReclamoList;
public OnItemClickListener mListener;

public TurnoAdapter(Context context, List<Turno> mReclamoList) {
        this.context = context;
        this.mReclamoList = mReclamoList;
        }

public interface OnItemClickListener {
    void onItemClick(int position);
    void onDeleteClick(int position);
}

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ReclamoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.turno_item, parent, false);
        return new ReclamoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReclamoViewHolder holder, int position) {
        holder.textViewTitulo.setText(mReclamoList.get(position).getNombre());
        holder.textViewFecha.setText(mReclamoList.get(position).getFecha().substring(0,10));
    }

    @Override
    public int getItemCount() {
        return mReclamoList.size();
    }

public class ReclamoViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public TextView textViewTitulo;
    public TextView textViewFecha;
    public ImageView image_goto;

    public ReclamoViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        textViewTitulo = mView.findViewById(R.id.textViewTitulo);
        textViewFecha = mView.findViewById(R.id.textViewFecha);
        image_goto = mView.findViewById(R.id.image_goto);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            }
        });
    }
}
}
