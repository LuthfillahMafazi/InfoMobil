package co.example.lutfillahmafazi.infomobil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.myRecyle)
    RecyclerView myRecyle;

    String[] namaMobilSport,detailMobilSport,namaMobilOffroad,detailMobilOffroad,namaMobilClassic,detailMobilClassic;
    int[] gambarMobilSupport,gambarMobilOffroad,gambarMobilClassic;

    AdapterMobil adapterMobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        namaMobilSport = getResources().getStringArray(R.array.nama_mobil_sport);
        detailMobilSport = getResources().getStringArray(R.array.detail_mobil_sport);
        gambarMobilSupport = new int[]{R.drawable.koenigsegg_one_1,R.drawable.bugatti_chiron,R.drawable.ferrari_pininfarina_sergio,R.drawable.aston_martin_valkyrie,R.drawable.w_motors_lykan_hypersport,
                R.drawable.bugatti_veyron,R.drawable.mclaren_p1_gtr,R.drawable.lamborghini_veneno_roadster,R.drawable.koenigsegg_ccxr_trevita,R.drawable.mercedes_benz_maybach_exelero};

        namaMobilOffroad = getResources().getStringArray(R.array.nama_mobil_offroad);
        detailMobilOffroad = getResources().getStringArray(R.array.detail_mobil_offroad);
        gambarMobilOffroad = new int[]{R.drawable.offroad1,R.drawable.offroad2,R.drawable.offroad3,R.drawable.offroad4,
                R.drawable.offroad5,R.drawable.offroad6,R.drawable.offroad7,R.drawable.offroad8,
                R.drawable.offroad9,R.drawable.offroad10};

        namaMobilClassic = getResources().getStringArray(R.array.nama_mobil_classic);
        detailMobilClassic = getResources().getStringArray(R.array.detail_mobil_classic);
        gambarMobilClassic = new int[]{R.drawable.klsik1,R.drawable.klsik2,R.drawable.clasik3,
                R.drawable.klsik4,R.drawable.klsik5,R.drawable.clasik6,R.drawable.clasik7};

        String mobil = getIntent().getStringExtra("mobil");

        if (mobil.equals("sport")){
            adapterMobil = new AdapterMobil(RecycleActivity.this,namaMobilSport,detailMobilSport,gambarMobilSupport);
        }else if (mobil.equals("offroad")){
            adapterMobil = new AdapterMobil(RecycleActivity.this,namaMobilOffroad,detailMobilOffroad,gambarMobilOffroad);
        }else {
            adapterMobil = new AdapterMobil(RecycleActivity.this,namaMobilClassic,detailMobilClassic,gambarMobilClassic);
        }

        myRecyle.setHasFixedSize(true);
        myRecyle.setLayoutManager(new LinearLayoutManager(this));
        myRecyle.setAdapter(adapterMobil);

    }
}
