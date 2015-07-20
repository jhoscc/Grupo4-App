package app.ulima.edu.tlkapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

import java.util.List;

/**
 * Created by Hiroshi on 11/07/2015.
 */
public class TopList extends Fragment{
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toplist,container,false);
        ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(this.getActivity(), "Evento");

        adapter.setTextKey("Nombre");
        adapter.setImageKey("Imagen");

        listView = (ListView)view.findViewById(R.id.toplist);
        listView.setAdapter(adapter);
        return view;
    }


}
