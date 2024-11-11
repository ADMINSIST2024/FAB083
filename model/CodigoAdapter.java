package com.example.fab083.model;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fab083.R;
import com.example.fab083.dtos.DtoObtenerDatosEtiqueta;
import com.example.fab083.dtos.DtoObtenerDatosStockEmpaqueInput;

import java.util.ArrayList;
import java.util.List;

public class CodigoAdapter extends RecyclerView.Adapter<CodigoAdapter.CodigoViewHolder> {

    public List<String> codigoList;
    public int contadorSecuencia;
    public CodigoAdapter() {
        this.codigoList = new ArrayList<>();
        this.contadorSecuencia = 1;
    }

    public void addValores(String codigo_etiqueta, String codigo_articulo, String color,
                           String lote, String stock, String salida, String um,String codigoExistencia,
                           String umreal,String cod_prov,String cantidad,int secuencia)
    {
        codigoList.add(0,
                codigo_etiqueta + ":" + codigo_articulo + ":" + color + ":" +
                lote + ":" + stock + ":" + salida + ":" + um+ ":" + codigoExistencia
                        + ":" + umreal + ":" + cod_prov + ":" + cantidad   + ":" + secuencia
        );
        contadorSecuencia++;
        notifyItemInserted(0);
    }
    public void addValoresGuardados(String valor)
    {
        codigoList.add(valor);
        notifyItemInserted(codigoList.size() - 1);
    }


    public boolean contains(String codigo_etiqueta) {
        for (String codigo : codigoList) {
            if (codigo.startsWith(codigo_etiqueta + ":")) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @Override
    public CodigoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_lista, parent, false);
        return new CodigoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CodigoViewHolder holder, int position) {
        String[] codigos = codigoList.get(position).split(":");
        String codigoEtiqueta = codigos[0];
        String codigoArticulo = codigos[1];
        String color = codigos[2];
        String lote = codigos[3];
        String stock = codigos[4];
        String salida = codigos[5];
        String um = codigos[6];
        String codigoExistencia = codigos[7] ;
        String umreal = codigos[8] ;
        String cod_prov = codigos[9] ;
        String cantidad= codigos[10] ;
        String secuencia=codigos[11] ;

        holder.codigo_etiqueta.setText(codigoEtiqueta);
        holder.codigo_articulo.setText(codigoArticulo);
        holder.color_hilado.setText(color);
        holder.nro_lote.setText(lote);
        holder.nro_stock.setText(stock);
        holder.salida.setText(salida);
        holder.um.setText(um);
        holder.codigoExistencia.setText(codigoExistencia);
        holder.umreal.setText(umreal);
        holder.cod_prov.setText(cod_prov);
        holder.cantidad.setText(cantidad);
        holder.secuencia.setText(secuencia);
        holder.mMenus.setImageResource(R.drawable.codbarra3); // Cambia la imagen según tus necesidades
    }

    @Override
    public int getItemCount() {
        return codigoList.size();
    }

    public static class CodigoViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView mMenus;
        TextView codigo_etiqueta, codigo_articulo, color_hilado, nro_lote, nro_stock, salida, um,codigoExistencia,umreal,cod_prov,cantidad,secuencia;

        public CodigoViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            mMenus = itemView.findViewById(R.id.mMenus);
            codigo_etiqueta = itemView.findViewById(R.id.codigo_etiqueta);
            codigo_articulo = itemView.findViewById(R.id.codigo_articulo);
            color_hilado = itemView.findViewById(R.id.color_hilado);
            nro_lote = itemView.findViewById(R.id.nro_lote);
            nro_stock = itemView.findViewById(R.id.nro_stock);
            salida = itemView.findViewById(R.id.salida);
            um = itemView.findViewById(R.id.um);
            codigoExistencia=itemView.findViewById(R.id.existencia);
            umreal=itemView.findViewById(R.id.umreal);
            cod_prov=itemView.findViewById(R.id.cod_prov);
            cantidad=itemView.findViewById(R.id.cantidad);
            secuencia=itemView.findViewById(R.id.secuencia);
        }
    }

    public List<String> getAllCodigoEtiquetas() {
        List<String> etiquetas = new ArrayList<>();
        for (String codigo : codigoList) {
            String[] codigos = codigo.split(":");
            etiquetas.add(codigos[7]); // `codigos[0]` es `codigoEtiqueta`
        }
        return etiquetas;
    }

    public String ObtenerTodasEtiquetas() {
        List<String> etiquetas = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for (String codigo : codigoList) {
            String[] codigos = codigo.split(":");
            if (res.length() > 0) { // Agregar coma solo si no es el primer elemento
                res.append(",");
            }
            res.append("'").append(codigos[0]).append("'");
        }


        return res.toString();
    }



    public List<DtoObtenerDatosStockEmpaqueInput> ObtenerTodasEtiquetasStock() {

        List<DtoObtenerDatosStockEmpaqueInput> etiquetas = new ArrayList<>();

        for (String codigo : codigoList) {
            // Separar el código en partes
            String[] codigos = codigo.split(":");

                DtoObtenerDatosStockEmpaqueInput dto = new DtoObtenerDatosStockEmpaqueInput();

                dto.setCodigoEtiqueta(codigos[0]); // codigos[0] es codigoEtiqueta
                dto.setStockreal(Double.valueOf(codigos[5])); // Asumiendo que codigos[5] es un número

                etiquetas.add(dto);

        }

        return etiquetas;
    }

    public List<DtoObtenerDatosEtiqueta> ObtenerTotalEtiquetas() {

        List<DtoObtenerDatosEtiqueta> etiquetas = new ArrayList<>();

        for (String codigo : codigoList) {
            // Separar el código en partes
            String[] codigos = codigo.split(":");

            DtoObtenerDatosEtiqueta dto = new DtoObtenerDatosEtiqueta();

            dto.setCodigoEtiqueta(codigos[0]); // codigos[0] es codigoEtiqueta
            dto.setCodigoArticulo(codigos[1]);
            dto.setColor(codigos[2]);
            dto.setLote(codigos[3]);
            dto.setStock(codigos[4]);
            dto.setSalida(codigos[5]);
            dto.setUm(codigos[6]);
            dto.setCodigoExistencia(codigos[7]);
            dto.setUmreal(codigos[8]) ;
            dto.setCod_prov(codigos[9]) ;
            dto.setCantidad(codigos[10]);
            dto.setSecuencia(codigos[11]);

            etiquetas.add(dto);

        }

        return etiquetas;
    }

    public void clearAdapter() {
        codigoList.clear(); // Limpiar la lista
        contadorSecuencia = 1; // Reiniciar el contador si es necesario
        notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
    }
    public int cantidadItems()
    {

        return codigoList.size();
    }
    public int getNextSecuencia() {
        if (codigoList.isEmpty()) {
            return 1;
        }
        String ultimoCodigo = codigoList.get(0);
        String[] partes = ultimoCodigo.split(":");
        int ultimaSecuencia = Integer.parseInt(partes[11]);
        return ultimaSecuencia + 1;
    }
}
