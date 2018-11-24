package co.example.lutfillahmafazi.infomobil;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterMobil extends RecyclerView.Adapter<AdapterMobil.ViewHolder> {

    Context context;
    String[] namaMobil,detailMobil;
    int[] gambarMobil;

    public AdapterMobil(Context context, String[] namaMobil, String[] detailMobil, int[] gambarMobil) {
        this.context = context;
        this.namaMobil = namaMobil;
        this.detailMobil = detailMobil;
        this.gambarMobil = gambarMobil;
    }

    @NonNull
    @Override
    public AdapterMobil.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_mobil,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMobil.ViewHolder viewHolder,final int i) {
        viewHolder.namaMobil.setText(namaMobil[i]);
        Glide.with(context).load(gambarMobil[i]).into(viewHolder.gambarMobil);

        viewHolder.btnDetailPemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailMobil.class);

                intent.putExtra("nm",namaMobil[i]);
                intent.putExtra("dm",detailMobil[i]);
                intent.putExtra("gm",gambarMobil[i]);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarMobil.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaMobil,detailMobil;
        ImageView gambarMobil;
        Button btnDetailPemain;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaMobil = itemView.findViewById(R.id.txtMobil);
            detailMobil = itemView.findViewById(R.id.txtDetailMobil);
            gambarMobil = itemView.findViewById(R.id.imgMobil);
            btnDetailPemain = itemView.findViewById(R.id.btnDetail);

        }
    }
}
