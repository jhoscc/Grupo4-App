package app.ulima.edu.tlkapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import java.util.List;

/**
 * Created by Hiroshi on 10/07/2015.
 */
public class TopFragment extends Fragment {
    ImageButton ibmusica, ibpelicula, ibdeporte;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top,container,false);
        return view;
    }

}
