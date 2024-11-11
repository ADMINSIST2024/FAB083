package com.example.fab083.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fab083.R;
import com.example.fab083.dtos.DtoMovimientoAlmacenInput;

import java.util.List;

public class ConsultaMovimientoAdapter extends RecyclerView.Adapter<ConsultaMovimientoAdapter.ViewHolder> {



    private List<DtoMovimientoAlmacenInput> dataList;

    // Constructor para pasar la lista de datos al adaptador
    public ConsultaMovimientoAdapter(List<DtoMovimientoAlmacenInput> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_lista_consulta_movimiento, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DtoMovimientoAlmacenInput data = dataList.get(position);
        holder.txtmovimiento.setText(data.getMov());
        holder.txtcsc.setText(String.valueOf(data.getCscmag()));
        holder.txttipomovimiento.setText(data.getCodtmv());
        holder.txtalmacenorigen.setText(String.valueOf(data.getCodalg()));
        holder.txtccosto.setText(String.valueOf(data.getCencos()));
        holder.txtenvase.setText(String.valueOf(data.getCaemag()));
        holder.txtcodigo.setText(String.valueOf(data.getCodexi()));
        holder.txtproveedor.setText(data.getCodprv());
        holder.txttitulo.setText(String.valueOf(data.getTrhmag()));
        holder.txtalmacendestino.setText(String.valueOf(data.getAdemag()));
        holder.txtordencsc.setText(data.getOrden_csc());
        holder.txtkilos.setText(String.valueOf(data.getCanmag()));
        holder.txthilo.setText(data.getCodchi());
        holder.txtlote.setText(data.getNlhmag());
        holder.txtum.setText(data.getUrhmag());
        holder.txtetiqueta.setText(data.getCodigo());
        holder.txtsecuencia.setText(String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtmovimiento, txtcsc,txttipomovimiento,txtalmacenorigen,txtccosto,txtenvase,txtcodigo,txtproveedor,
                txttitulo,txtalmacendestino,txtordencsc,txtkilos,txthilo,txtlote,txtum,txtetiqueta,txtsecuencia;

        public ViewHolder(View itemView) {
            super(itemView);
            txtmovimiento = itemView.findViewById(R.id.txtmovimiento);
            txtcsc = itemView.findViewById(R.id.txtcsc);
            txttipomovimiento = itemView.findViewById(R.id.txttipomovimiento);
            txtalmacenorigen = itemView.findViewById(R.id.txtalmacenorigen);
            txtccosto = itemView.findViewById(R.id.txtccosto);
            txtenvase = itemView.findViewById(R.id.txtenvase);
            txtcodigo = itemView.findViewById(R.id.txtcodigo);
            txtproveedor = itemView.findViewById(R.id.txtproveedor);
            txttitulo = itemView.findViewById(R.id.txttitulo);
            txtalmacendestino = itemView.findViewById(R.id.txtalmacendestino);
            txtordencsc = itemView.findViewById(R.id.txtordencsc);
            txtkilos = itemView.findViewById(R.id.txtkilos);
            txthilo = itemView.findViewById(R.id.txthilo);
            txtlote = itemView.findViewById(R.id.txtlote);
            txtum = itemView.findViewById(R.id.txtum);
            txtetiqueta = itemView.findViewById(R.id.txtetiqueta);
            txtsecuencia = itemView.findViewById(R.id.txtsecuencia);
        }
    }
}
