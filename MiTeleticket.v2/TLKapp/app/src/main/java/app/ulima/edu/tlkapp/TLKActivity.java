package app.ulima.edu.tlkapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Created by Hiroshi on 05/07/2015.
 */
public class TLKActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tkl);

        PerfilFragment pfrag = new PerfilFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.tkl_activity,pfrag,"Perfil");
        transaction.commit();

    }
}
