package sheva.serverwork2.mvp.model.db.mappers;

import android.content.ContentValues;

import javax.inject.Inject;

import sheva.serverwork2.IConstants;
import sheva.serverwork2.mvp.model.entities.UserEntity;

public class UserEntityToContentValueMapper implements IMapper<UserEntity, ContentValues> {
    @Inject
    public UserEntityToContentValueMapper() {
    }

    @Override
    public ContentValues transform(UserEntity object) throws RuntimeException {
        ContentValues values = new ContentValues();
        values.put(IConstants.db.USER_ID, object.getId());
        values.put(IConstants.db.USERNAME, object.getUsername());
        values.put(IConstants.db.EMAIL, object.getEmail());
        values.put(IConstants.db.LAST_LOGIN, object.getLastLogin());
        values.put(IConstants.db.STATUS, object.getStatus());
        values.put(IConstants.db.FRIENDS, object.getFriends());
        values.put(IConstants.db.HANDS_PLAYED, object.getHandsPlayed());
        values.put(IConstants.db.HANDS_WON, object.getHandsWon());
        values.put(IConstants.db.BIGGEST_POT_WON, object.getBiggestPotWon());
        values.put(IConstants.db.SIT_N_GO_WINS, object.getSitNGoWins());
        values.put(IConstants.db.SIT_N_GO_LOSES, object.getSitNGoLoses());
        values.put(IConstants.db.COINS, object.getCoins());
        values.put(IConstants.db.LOCATION, object.getLocation());
        values.put(IConstants.db.BEST_HAND, object.getBestHand());
        values.put(IConstants.db.PHOTO, object.getPhoto());
        return values;
    }
}