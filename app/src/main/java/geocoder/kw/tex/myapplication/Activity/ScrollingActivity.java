package geocoder.kw.tex.myapplication.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import geocoder.kw.tex.myapplication.Model.DaoSession;
import geocoder.kw.tex.myapplication.Model.Mantan;
import geocoder.kw.tex.myapplication.Model.MantanDao;
import geocoder.kw.tex.myapplication.R;

public class ScrollingActivity extends AppCompatActivity {
    private MantanDao mantanDao;
    private Query<Mantan> mantanQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //DAO get session on activty
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        mantanDao = daoSession.getMantanDao();
        //query for list
        mantanQuery = mantanDao.queryBuilder().orderAsc(MantanDao.Properties.TglJadian).build();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //event insert data to dao
                addMantan();
                Snackbar.make(view, "Data mantan berhasil ditambah", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void addMantan() {
        Mantan mantan = new Mantan();
        mantan.setNama("Raisa");
        mantan.setTglJadian("20 Januari 2014");
        mantan.setTglPutus("24 Januari 2014");
        mantanDao.insert(mantan);
        Log.d("DaoExample", "Inserted new note, ID: " + mantan.getNama());
        List<Mantan> mantans = mantanQuery.list();
        for (Mantan m : mantans){
            Log.d("DaoExample", "Data nih " + mantans.size()+ " isinya "+ m.getNama());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
