package sheva.serverwork2.mvp.model.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sheva.serverwork2.App;
import sheva.serverwork2.IConstants;
import sheva.serverwork2.mvp.model.db.mappers.UserEntityToContentValueMapper;
import sheva.serverwork2.mvp.model.entities.UserEntity;

public class DBHelper {
    private DB db1;
    @Inject
    UserEntityToContentValueMapper mapper;

    @Inject
    public DBHelper() {
        db1 = new DB(App.get());
        dropTable();

        createTable();
    }



    private void createTable() {
        SQLiteDatabase database = db1.getWritableDatabase();
        String createTable = "CREATE TABLE IF NOT EXISTS " + IConstants.db.TABLE_NAME + " " +
                "(" +
                IConstants.db.USER_ID + " INTEGER PRIMARY KEY NOT NULL," +
                IConstants.db.USERNAME + " TEXT NOT NULL," +
                IConstants.db.EMAIL + " TEXT," +
                IConstants.db.LAST_LOGIN + " TEXT," +
                IConstants.db.STATUS + " TEXT," +
                IConstants.db.FRIENDS + " TEXT," +
                IConstants.db.HANDS_PLAYED + " INTEGER," +
                IConstants.db.HANDS_WON + " INTEGER," +
                IConstants.db.BIGGEST_POT_WON + " INTEGER," +
                IConstants.db.SIT_N_GO_WINS + " INTEGER," +
                IConstants.db.SIT_N_GO_LOSES + " INTEGER," +
                IConstants.db.COINS + " INTEGER," +
                IConstants.db.LOCATION + " TEXT," +
                IConstants.db.BEST_HAND + " TEXT," +
                IConstants.db.PHOTO + " TEXT," +
                " UNIQUE (" + IConstants.db.USER_ID + ") ON CONFLICT REPLACE" +
                ");";
        database.execSQL(createTable);
    }

    public void dropTable() {
        SQLiteDatabase db = db1.getWritableDatabase();
        String QUERY = "DROP TABLE " + IConstants.db.TABLE_NAME + ";";
        db.execSQL(QUERY);
    }

    public void insert(UserEntity user) {
        SQLiteDatabase db = db1.getWritableDatabase();
        db.insert(IConstants.db.TABLE_NAME, null, mapper.transform(user));
    }

    public Observable<List<UserEntity>> getAllUsersFromDB() {
        String query = "SELECT * FROM " + IConstants.db.TABLE_NAME + ";";
        return select(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    private Observable<List<UserEntity>> select(String query) {
        return Observable.create(subscriber -> {
            List<UserEntity> list = syncGet(query);
            subscriber.onNext(list);
            subscriber.onCompleted();
        });
    }

    private List<UserEntity> syncGet(String query) {
        List<UserEntity> list = new ArrayList<>();
        SQLiteDatabase db = db1.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                list.add(getUser(cursor));
            }
            cursor.close();
        }
        return list;
    }

    private UserEntity getUser(Cursor cursor) {
        int userId = DBCursorUtils.getInt(cursor, IConstants.db.USER_ID);
        String username = DBCursorUtils.getString(cursor, IConstants.db.USERNAME);
        String lastLogin = DBCursorUtils.getString(cursor, IConstants.db.LAST_LOGIN);
        if (lastLogin == null){
            lastLogin = "---";
        }

        return new UserEntity(userId, username, lastLogin);
    }

}
