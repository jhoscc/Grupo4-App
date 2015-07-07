package app.ulima.edu.tlkapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by Hiroshi on 05/07/2015.
 */
public class PerfilFragment extends Fragment {
    TextView usuario,nombre,apellido,dni;
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
        return view;
    }
}
