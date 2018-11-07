package fr.formation.toastdemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tools {

    private static int noNotif;

    public static void affToast (Activity act, String msg){
        //Accéder au gonfleur d'écran:
        LayoutInflater inflater = act.getLayoutInflater();

        //Générer l'écran
        View v = inflater.inflate(R.layout.toast, (ViewGroup) act.findViewById(R.id.llToast));

        //Définir le texte à afficher :
        TextView etToast = v.findViewById(R.id.tvToast);
        etToast.setText(msg);

        //Créer le toast :
        Toast toast = Toast.makeText(act, msg, Toast.LENGTH_LONG);
        toast.setView(v);
        toast.show();
    }

    public static Integer affNotif(Context ctxt, String titre, String msq) {
        NotificationManager manager = (NotificationManager) ctxt.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder;

        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(ctxt, "CH");
        } else {
            builder = new Notification.Builder(ctxt);
        }

        builder.setContentTitle(titre);
        builder.setContentText(msq);
        builder.setSmallIcon(R.mipmap.notification);

        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel("CH", "Channel", NotificationManager.IMPORTANCE_DEFAULT);
            builder.setChannelId("CH");
        }

        noNotif++;
        Notification notif = builder.build();
        manager.notify(noNotif, notif);
        return noNotif;
    }
}
