package co.example.lutfillahmafazi.infomobil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMobil extends AppCompatActivity {

    @BindView(R.id.imgDetailMobil)
    ImageView imgDetailMobil;
    @BindView(R.id.txtNamaMobil)
    TextView txtNamaMobil;
    @BindView(R.id.txtDetailMobil)
    TextView txtDetailMobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mobil);
        ButterKnife.bind(this);

        txtNamaMobil.setText(getIntent().getStringExtra("nm"));
        txtDetailMobil.setText(getIntent().getStringExtra("dm"));
        Glide.with(this).load(getIntent().getIntExtra("gm",0)).into(imgDetailMobil);
    }
}
