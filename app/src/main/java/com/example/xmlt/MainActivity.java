package com.example.xmlt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ArrayAdapter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {


private User user;
    private ImageView imageView;
    private FloatingActionButton floatingActionButton;
    private  Uri uri;
    private Button button;
    private TextView nom;
    private TextView prenom;
    private TextView email;
    private TextView phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner countrySpinner = findViewById(R.id.country_spinner);
        String[] countryCodes = {"+1 (USA)", "+44 (UK)", "+33 (France)", "+49 (Germany)", "+81 (Japan)",  "+213 (Algeria)"};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryCodes);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countryAdapter);

        nom=(TextView)findViewById(R.id.nom);
        prenom=(TextView)findViewById(R.id.prenom);
        email=(TextView)findViewById(R.id.email);
        phone=(TextView)findViewById(R.id.phone);
        button=(Button) findViewById(R.id.Button07);
imageView=(ImageView)findViewById(R.id.image);

floatingActionButton=(FloatingActionButton)findViewById(R.id.floatingActionButton);

floatingActionButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ImagePicker.with(MainActivity.this)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start();
    }
});
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivite2();
            }
        });

    }
public void openActivite2(){

    Toast t = Toast.makeText(this, "msg", Toast.LENGTH_SHORT);
t.show();
if(uri==null){
     user=new User(nom.getText().toString(),prenom.getText().toString(),email.getText().toString(),phone.getText().toString(), "");

}else{
     user=new User(nom.getText().toString(),prenom.getText().toString(),email.getText().toString(),phone.getText().toString(), uri.toString());

}

    Intent intent=new Intent(MainActivity.this, Activite2.class);

    Bundle bundle = new Bundle();
    bundle.putSerializable("obj",user);
    intent.putExtras(bundle);

//    this.startActivity(intent);
    this.startActivityForResult(intent, 99);

}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data!=null){
            uri =data.getData();
            uri =data.getData();
            imageView.setImageURI(uri);
        }

        if(requestCode == 99 && resultCode == -1){
            Toast t = Toast.makeText(this, "rj3t mn button", Toast.LENGTH_SHORT);
            t.show();

        }else if(requestCode == 99 && resultCode == RESULT_CANCELED){
            Toast t = Toast.makeText(this, "rj3t bl back(Canceled)", Toast.LENGTH_SHORT);
            t.show();
        }


    }
}