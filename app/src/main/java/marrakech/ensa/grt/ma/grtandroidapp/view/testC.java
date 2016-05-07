package marrakech.ensa.grt.ma.grtandroidapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import marrakech.ensa.grt.ma.grtandroidapp.model.Utilisateur;

public class testC extends AppCompatActivity {
    private ConnectionSource connectionSource;
    private Dao<Utilisateur, Integer> simpleDao;

    private void initConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/test?user=root&password=hhhhhh";
            connectionSource = new JdbcConnectionSource(url);
            if (connectionSource.isOpen())
                Log.i("ISOPEN","OPEN");
            else
                Log.i("ISOPEN","CLOSED");
            simpleDao = DaoManager.createDao(connectionSource, Utilisateur.class);
        } catch (SQLException e) {
            throw new RuntimeException("Problems initializing database objects", e);
        }
        try {
            TableUtils.createTable(connectionSource, Utilisateur.class);
        } catch (SQLException e) {
            // ignored
            throw new RuntimeException("CommFailure", e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initConnection();
    }
}
