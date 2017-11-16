package geocoder.kw.tex.myapplication.Activity;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import geocoder.kw.tex.myapplication.Model.DaoMaster;
import geocoder.kw.tex.myapplication.Model.DaoSession;

/**
 * Created by User on 16-Nov-17.
 */

public class App extends Application {

    private DaoSession daoSession;
    @Override
    public void onCreate() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "mantan-db", null);
        Database db = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        super.onCreate();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
