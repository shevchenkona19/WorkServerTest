package sheva.serverwork2.mvp.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

import sheva.serverwork2.IConstants;


public class DB extends SQLiteOpenHelper {

    @Inject
    public DB(Context context) {
        super(context, IConstants.db.DB_NAME, null, IConstants.db.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public static void deleteDB(Context context) {
        context.deleteDatabase(IConstants.db.DB_NAME);
    }
}