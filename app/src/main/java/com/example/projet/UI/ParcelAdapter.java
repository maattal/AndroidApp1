package com.example.projet.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet.Entities.Parcel;
import com.example.projet.R;

import java.util.List;

public class ParcelAdapter extends RecyclerView.Adapter<ParcelAdapter.ParcelViewHolder>{
        private Context myCtx;
         List<Parcel> parcelList;

        public ParcelAdapter(Context myCtx, List<Parcel> parcelList) {
            this.myCtx = myCtx;
            this.parcelList = parcelList;
        }

        @NonNull
        @Override
        public ParcelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(myCtx.getApplicationContext()).inflate(R.layout.parcel_item_view, parent, false);
            return new ParcelViewHolder(view);
        }


    @Override
        public void onBindViewHolder(@NonNull ParcelAdapter.ParcelViewHolder holder, int position) {
            Parcel parcel = parcelList.get(position);
            holder.textViewStatus.setText("status: " + parcel.getParcelStatus().name().toString());
            holder.textViewType.setText("type: " + parcel.getType_havila().name().toString());
            holder.textViewDelivery.setText("delivery Name: " + parcel.getDeliveryName().toString());
            // TODO (7): Tans que le textView de la date n'est pas initialiser en bas sa ne
            //  marche pas de set le text
//            holder.textViewDate.setText("date: " + parcel.getSendParcelDate().toString());
        }

        @Override
        public int getItemCount() {
            return parcelList.size();
        }

        class ParcelViewHolder extends RecyclerView.ViewHolder {
            TextView textViewAdress, textViewDelivery, textViewDate, textViewStatus,textViewType;
            public ParcelViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewStatus = itemView.findViewById(R.id.text_Rview_status);
                textViewDelivery = itemView.findViewById(R.id.text_Rview_type);
                textViewDate = itemView.findViewById(R.id.Date);
                // TODO (6): Il faut remettre le textView de la date ici
//                textViewAdress = itemView.findViewById(R.id.text_Rview_Adress);
                 textViewType = itemView.findViewById(R.id.text_Rview_type);
            }
        }
    }


