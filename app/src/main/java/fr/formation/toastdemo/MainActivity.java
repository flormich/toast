package fr.formation.toastdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static fr.formation.toastdemo.Tools.affToast;
import static fr.formation.toastdemo.Tools.affNotif;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clic(View view) {
        affToast (this, "bonjour");
    }

    public void affNotif1(View view) {
        affNotif(this, "Notifications", "Le texte de notification");
    }

}
