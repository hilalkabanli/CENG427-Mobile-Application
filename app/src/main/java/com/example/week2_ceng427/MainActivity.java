package com.example.week2_ceng427;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
//if there is final you can assume that it is autogenerated since it is protected a lot
//layout
    private Button toastButton, alertDialogButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastButton = (Button) findViewById(R.id.toastButton);
        alertDialogButton = (Button) findViewById(R.id.alertDialogButton);

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast("This is a toast message");
            }
        });
        alertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeAndShowDialogBox("This is an AlertDialog");
            }
        });
    }
    private void displayToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
    private void makeAndShowDialogBox(String msg) {
        AlertDialog.Builder myDialogBox = new AlertDialog.Builder(this);
// set message, title, and icon
        myDialogBox.setTitle("My Alert Dialog");
        myDialogBox.setMessage(msg);
        myDialogBox.setIcon(R.drawable.ic_launcher_background);
// Set three option buttons
        myDialogBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
// whatever should be done when answering "Yes" goes
// here
            }
        });
        myDialogBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
// whatever should be done when answering "No" goes
// here
            }
        });
        myDialogBox.setNeutralButton("Cancel",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
// whatever should be done when answering "Cancel" goes
// here
            }
        });
        myDialogBox.create();
        myDialogBox.show();
    }

}