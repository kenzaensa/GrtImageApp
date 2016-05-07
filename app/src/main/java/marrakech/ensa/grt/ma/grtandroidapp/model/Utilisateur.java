package marrakech.ensa.grt.ma.grtandroidapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by zaziouiz on 07/05/2016.
 */
@DatabaseTable
public class Utilisateur {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String login;
    @DatabaseField
    private String hashedPasswd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashedPasswd() {
        return hashedPasswd;
    }

    public void setHashedPasswd(String hashedPasswd) {
        this.hashedPasswd = hashedPasswd;
    }
}
