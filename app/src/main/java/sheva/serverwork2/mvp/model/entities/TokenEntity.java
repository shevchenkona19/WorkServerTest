package sheva.serverwork2.mvp.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenEntity implements Parcelable{
    @SerializedName("token")
    @Expose
    private String token;

    public TokenEntity(){}

    protected TokenEntity(Parcel in) {
        token = in.readString();
    }

    public static final Creator<TokenEntity> CREATOR = new Creator<TokenEntity>() {
        @Override
        public TokenEntity createFromParcel(Parcel in) {
            return new TokenEntity(in);
        }

        @Override
        public TokenEntity[] newArray(int size) {
            return new TokenEntity[size];
        }
    };

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(token);
    }
}
