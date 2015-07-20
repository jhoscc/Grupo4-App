package app.ulima.edu.tlkapp;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;

/**
 * Created by Hiroshi on 05/07/2015.
 */
public class PerfilFragment extends Fragment {
    TextView usuario,nombre,apellido,dni;
    ImageView foto;
    //Button editar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        usuario = (TextView)view.findViewById(R.id.show_usuario);
        usuario.setText(ParseUser.getCurrentUser().getUsername());

        nombre = (TextView)view.findViewById(R.id.show_nombre);
        nombre.setText(ParseUser.getCurrentUser().getString("Nombre"));

        apellido = (TextView)view.findViewById(R.id.show_apellido);
        apellido.setText(ParseUser.getCurrentUser().getString("Apellido"));

        dni = (TextView)view.findViewById(R.id.show_dni);
        dni.setText(ParseUser.getCurrentUser().getString("DNI"));

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
        //editar = (Button)view.findViewById(R.id.btnEdit);
        return view;
    }

}
