package idat.edu.pe.laboratoriohttpurlconnection.View;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import idat.edu.pe.laboratoriohttpurlconnection.R;

public class PresentationActivity extends AppCompatActivity {
    ImageView presImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        presImage = findViewById(R.id.imagePresentation);

        presImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginView = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(loginView);
            }
        });
    }
}
