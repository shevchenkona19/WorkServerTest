
package sheva.serverwork2.mvp.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserEntity {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("friends")
    @Expose
    private String friends;
    @SerializedName("hands_played")
    @Expose
    private Integer handsPlayed;
    @SerializedName("hands_won")
    @Expose
    private Integer handsWon;
    @SerializedName("biggest_pot_won")
    @Expose
    private Integer biggestPotWon;
    @SerializedName("sit_n_go_wins")
    @Expose
    private Integer sitNGoWins;
    @SerializedName("sit_n_go_loses")
    @Expose
    private Integer sitNGoLoses;
    @SerializedName("coins")
    @Expose
    private Integer coins;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("best_hand")
    @Expose
    private String bestHand;
    @SerializedName("photo")
    @Expose
    private String photo;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserEntity() {
    }

    public UserEntity(Integer id, String username, String email, String lastLogin, String status, String friends, Integer handsPlayed, Integer handsWon, Integer biggestPotWon, Integer sitNGoWins, Integer sitNGoLoses, Integer coins, String location, String bestHand, String photo) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.lastLogin = lastLogin;
        this.status = status;
        this.friends = friends;
        this.handsPlayed = handsPlayed;
        this.handsWon = handsWon;
        this.biggestPotWon = biggestPotWon;
        this.sitNGoWins = sitNGoWins;
        this.sitNGoLoses = sitNGoLoses;
        this.coins = coins;
        this.location = location;
        this.bestHand = bestHand;
        this.photo = photo;
    }

    public UserEntity(Integer id, String username, String lastLogin) {
        this.id = id;
        this.username = username;
        this.lastLogin = lastLogin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public Integer getHandsPlayed() {
        return handsPlayed;
    }

    public void setHandsPlayed(Integer handsPlayed) {
        this.handsPlayed = handsPlayed;
    }

    public Integer getHandsWon() {
        return handsWon;
    }

    public void setHandsWon(Integer handsWon) {
        this.handsWon = handsWon;
    }

    public Integer getBiggestPotWon() {
        return biggestPotWon;
    }

    public void setBiggestPotWon(Integer biggestPotWon) {
        this.biggestPotWon = biggestPotWon;
    }

    public Integer getSitNGoWins() {
        return sitNGoWins;
    }

    public void setSitNGoWins(Integer sitNGoWins) {
        this.sitNGoWins = sitNGoWins;
    }

    public Integer getSitNGoLoses() {
        return sitNGoLoses;
    }

    public void setSitNGoLoses(Integer sitNGoLoses) {
        this.sitNGoLoses = sitNGoLoses;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBestHand() {
        return bestHand;
    }

    public void setBestHand(String bestHand) {
        this.bestHand = bestHand;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
