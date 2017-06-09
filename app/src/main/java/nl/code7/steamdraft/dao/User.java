package nl.code7.steamdraft.dao;

import android.os.Parcel;
import android.os.Parcelable;


public class User implements Parcelable{

    private long steamID;
    private long lastLogoff;
    private long primaryClanID;
    private long timeCreated;
    private long locCityID;

    private int personaState;
    private int communityVisibilityState;
    private int profileState;
    private int gameID;

    private String personaName;
    private String profileUrl;
    private String avatar;
    private String avatarMedium;
    private String avatarFull;
    private String realName;
    private String gameExtraInfo;
    private String locCountryCode;
    private String locStateCode;

    public User() {
        steamID = -1;
        lastLogoff = -1;
        primaryClanID = -1;
        timeCreated = -1;
        personaState = -1;
        communityVisibilityState = -1;
        profileState = -1;
        gameID = -1;
        locCityID = -1;
        personaName = "";
        profileUrl = "";
        avatar = "";
        avatarMedium = "";
        avatarFull = "";
        realName = "";
        gameExtraInfo = "";
        locCountryCode = "";
        locStateCode = "";
    }

    private User(Parcel in) {
        steamID = in.readLong();
        lastLogoff = in.readLong();
        primaryClanID = in.readLong();
        timeCreated = in.readLong();
        personaState = in.readInt();
        communityVisibilityState = in.readInt();
        profileState = in.readInt();
        gameID = in.readInt();
        locCityID = in.readLong();
        personaName = in.readString();
        profileUrl = in.readString();
        avatar = in.readString();
        avatarMedium = in.readString();
        avatarFull = in.readString();
        realName = in.readString();
        gameExtraInfo = in.readString();
        locCountryCode = in.readString();
        locStateCode = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "steamID=" + steamID +
                ", lastLogoff=" + lastLogoff +
                ", primaryClanID=" + primaryClanID +
                ", timeCreated=" + timeCreated +
                ", personaState=" + personaState +
                ", communityVisibilityState=" + communityVisibilityState +
                ", profileState=" + profileState +
                ", gameID=" + gameID +
                ", locCityID=" + locCityID +
                ", personaName='" + personaName + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                ", avatar='" + avatar + '\'' +
                ", avatarMedium='" + avatarMedium + '\'' +
                ", avatarFull='" + avatarFull + '\'' +
                ", realName='" + realName + '\'' +
                ", gameExtraInfo='" + gameExtraInfo + '\'' +
                ", locCountryCode='" + locCountryCode + '\'' +
                ", locStateCode='" + locStateCode + '\'' +
                '}';
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(steamID);
        out.writeLong(lastLogoff);
        out.writeLong(primaryClanID);
        out.writeLong(timeCreated);
        out.writeInt(personaState);
        out.writeInt(communityVisibilityState);
        out.writeInt(profileState);
        out.writeInt(gameID);
        out.writeLong(locCityID);
        out.writeString(personaName);
        out.writeString(profileUrl);
        out.writeString(avatar);
        out.writeString(avatarMedium);
        out.writeString(avatarFull);
        out.writeString(realName);
        out.writeString(gameExtraInfo);
        out.writeString(locCountryCode);
        out.writeString(locStateCode);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {

        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }

    };

    public long getSteamID() {
        return steamID;
    }

    public void setSteamID(long steamID) {
        this.steamID = steamID;
    }

    public long getLastLogoff() {
        return lastLogoff;
    }

    public void setLastLogoff(long lastLogoff) {
        this.lastLogoff = lastLogoff;
    }

    public long getPrimaryClanID() {
        return primaryClanID;
    }

    public void setPrimaryClanID(long primaryClanID) {
        this.primaryClanID = primaryClanID;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public int getPersonaState() {
        return personaState;
    }

    public void setPersonaState(int personaState) {
        this.personaState = personaState;
    }

    public int getCommunityVisibilityState() {
        return communityVisibilityState;
    }

    public void setCommunityVisibilityState(int communityVisibilityState) {
        this.communityVisibilityState = communityVisibilityState;
    }

    public int getProfileState() {
        return profileState;
    }

    public void setProfileState(int profileState) {
        this.profileState = profileState;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public long getLocCityID() {
        return locCityID;
    }

    public void setLocCityID(long locCityID) {
        this.locCityID = locCityID;
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personaName) {
        this.personaName = personaName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarMedium() {
        return avatarMedium;
    }

    public void setAvatarMedium(String avatarMedium) {
        this.avatarMedium = avatarMedium;
    }

    public String getAvatarFull() {
        return avatarFull;
    }

    public void setAvatarFull(String avatarFull) {
        this.avatarFull = avatarFull;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGameExtraInfo() {
        return gameExtraInfo;
    }

    public void setGameExtraInfo(String gameExtraInfo) {
        this.gameExtraInfo = gameExtraInfo;
    }

    public String getLocCountryCode() {
        return locCountryCode;
    }

    public void setLocCountryCode(String locCountryCode) {
        this.locCountryCode = locCountryCode;
    }

    public String getLocStateCode() {
        return locStateCode;
    }

    public void setLocStateCode(String locStateCode) {
        this.locStateCode = locStateCode;
    }
}
