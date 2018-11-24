package co.example.lutfillahmafazi.infomobil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseActivity extends AppCompatActivity {

    @BindView(R.id.mobilSport)
    Button mobilSport;
    @BindView(R.id.mobilOffRoad)
    Button mobilOffRoad;
    @BindView(R.id.mobilClassic)
    Button mobilClassic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mobilSport, R.id.mobilOffRoad, R.id.mobilClassic})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.mobilSport:
                intent = new Intent(this,RecycleActivity.class);
                intent.putExtra("mobil","sport");
                startActivity(intent);
                break;
            case R.id.mobilOffRoad:
                intent = new Intent(this,RecycleActivity.class);
                intent.putExtra("mobil","offroad");
                startActivity(intent);
                break;
            case R.id.mobilClassic:
                intent = new Intent(this,RecycleActivity.class);
                intent.putExtra("mobil","classic");
                startActivity(intent);
                break;
        }
    }
}
