package app.ulima.edu.tlkapp;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * Created by Hiroshi on 05/07/2015.
 */
public class PerfilEditFragment extends Fragment {
    TextView usuario,nombre,apellido,dni;
    ImageView foto;
    String noexiste = "No Definido";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfiledit, container, false);
        usuario = (EditText)view.findViewById(R.id.edit_usuario);
        usuario.setText(ParseUser.getCurrentUser().getUsername());

        nombre = (EditText)view.findViewById(R.id.edit_nombre);
        if(ParseUser.getCurrentUser().getString("Nombre").isEmpty()){
            nombre.setText(noexiste);
        }else {
            nombre.setText(ParseUser.getCurrentUser().getString("Nombre"));
        }
        apellido = (EditText)view.findViewById(R.id.edit_apellido);
        if(ParseUser.getCurrentUser().getString("Apellido").isEmpty()){
            apellido.setText(noexiste);
        }else {
            apellido.setText(ParseUser.getCurrentUser().getString("Apellido"));
        }
        dni = (EditText)view.findViewById(R.id.edit_dni);
        if(ParseUser.getCurrentUser().getString("DNI").isEmpty()) {
            dni.setText(noexiste);
        }else{
            dni.setText(ParseUser.getCurrentUser().getString("DNI"));
        }
        foto = (ImageView)view.findViewById(R.id.foto_perfil);
        ParseFile pic = ParseUser.getCurrentUser().getParseFile("Foto");
        pic.getDataInBackground(new GetDataCallback() {
            @Override
            public void done(byte[] data, ParseException e) {
                if (e == null) {
                    Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);;
                    foto.setImageBitmap(bmp);
                }else{

                    foto.setImageResource(R.drawable.perfil);
                }
            }
        });

        Button guradar = (Button)view.findViewById(R.id.btnGuardar);
        guradar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = ParseUser.getCurrentUser();
                String usern = usuario.getText().toString();
                user.setUsername(usern);
                String nom = nombre.getText().toString();
                user.put("Nombre", nom);
                String ape = apellido.getText().toString();
                user.put("Apellido", ape);
                String num = dni.getText().toString();
                user.put("DNI",num);
                try {
                    user.save();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }

}
