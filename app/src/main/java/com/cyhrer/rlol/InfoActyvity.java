package com.cyhrer.rlol;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActyvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_actyvity);

    }

    public void Click(View view){
        FragmentManager manager = getSupportFragmentManager();
        DialogFragment myDialogFragment = new rules();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (view .getId()){
            case R.id.rules:
                myDialogFragment.show(transaction, CR.Rator("bXlEaWFsb2c="));
                break;
            case R.id.game:
                Intent intent = new Intent(InfoActyvity.this, GameInfoActuvity.class);
                startActivity(intent);
                break;
            case R.id.PP:
                Intent intent2 = new Intent(InfoActyvity.this, WebActivity.class);
                startActivity(intent2);
                break;
            case R.id.exit:
                finish();
                break;
        }
    }
}