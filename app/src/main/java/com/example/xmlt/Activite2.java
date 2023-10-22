package com.example.xmlt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activite2 extends AppCompatActivity {
    Uri uri;
    private ImageView imageView;

    private TextView nom;
    private TextView prenom;
    private TextView email;
    private TextView phone;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite2);
        imageView=(ImageView)findViewById(R.id.imagee);
logout=(Button)findViewById(R.id.logout);
        nom=  (TextView)findViewById(R.id.nom);
        prenom=  (TextView)findViewById(R.id.prenom);
        email=  (TextView)findViewById(R.id.email);
        phone=  (TextView)findViewById(R.id.phone);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        User user = (User) bundle.getSerializable("obj");


        nom.setText(user.nom);
        prenom.setText(user.prenom);
        email.setText(user.email);
        phone.setText(user.phone);
        if(user.uri!=""){
            imageView.setImageURI(Uri.parse(user.uri));

        }

logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intentOutput = new Intent();

        setResult(RESULT_OK, intentOutput);
        finish();
    }
});

    }
//    @Override
//    public void finish(){
//        Intent intentOutput = new Intent();
////        intentOutput.putExtra("result", "");
//        setResult(RESULT_OK, intentOutput);
//        super.finish();
//    }

}