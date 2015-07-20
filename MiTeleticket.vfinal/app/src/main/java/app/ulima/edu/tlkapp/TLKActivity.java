package app.ulima.edu.tlkapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Hiroshi on 05/07/2015.
 */
public class TLKActivity extends Activity{
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    Button top, perfil, calendario, buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tkl);

        TopFragment tfrag = new TopFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frag_layout, tfrag);
        transaction.commit();
    }

    public void loadPicture(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.foto_perfil);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
            } else {
                Toast.makeText(this, "No ha seleccionado ninguna imagen", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void  onSelectFragment(View view){
        Fragment newf = null;

        if(view == findViewById(R.id.btn_buscar)){
            newf = new BuscarFragment();
        }else if(view == findViewById(R.id.btn_perfil)) {
            newf = new PerfilFragment();
        }else if(view == findViewById(R.id.btnEdit)){
            newf = new PerfilEditFragment();
        }else if(view == view.findViewById(R.id.topmusica)){
            newf = new TopList();
        }else if(view == view.findViewById(R.id.topfutbol)){
            newf = new TopList();
        }else if(view == view.findViewById(R.id.topcine)) {
            newf = new TopList();
        }else if(view == findViewById(R.id.btnGuardar)){
            newf = new PerfilFragment();
        }else{
            newf = new TopFragment();
        }

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frag_layout, newf);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
