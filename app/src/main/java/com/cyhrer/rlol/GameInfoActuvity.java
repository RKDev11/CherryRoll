package com.cyhrer.rlol;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BlendMode;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameInfoActuvity extends AppCompatActivity {
    private Handler handler;
    int leng;
    int random1;
    int random2;
    int random3;
    int random4;
    int random5;
    int random6;
    int random7;
    int random8;
    int point = 0;
    Button button;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    TextView textPoint;
    Boolean bonus = false;
    int clickcount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(1024);
        setContentView(R.layout.game_info_actuvity);
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);
        textPoint = findViewById(R.id.point);
        Button bonusBut = findViewById(R.id.buttonBonus);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        button = findViewById(R.id.button);
        handler = new Handler();
        LinearLayout ln = findViewById(R.id.ln2);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                leng = 0;
                point = 190;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        leng++;
                        if (leng <= 60) {
                            handler.postDelayed(this::run, 30);
                            random1 = (int) (1 + Math.random() * 4);
                            int value = getResources().getIdentifier("a" + random1,
                                    "drawable", "com.cyhrer.rlol");
                            imageView1.setImageResource(value);
                        }
                    }
                });
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        leng++;
                        if (leng <= 90) {
                            handler.postDelayed(this::run, 30);
                            random2 = (int) (1 + Math.random() * 4);

                            int value = getResources().getIdentifier("a" + random2,
                                    "drawable", "com.cyhrer.rlol");
                            imageView2.setImageResource(value);
                        }

                        if (leng >= 90 && leng <= 95) {
                            if (random1 == random2) {
                                point += 10;
                                textPoint.setText(Integer.toString(point));
                            }
                        }
                        if (point >= 200) {
                            bonusBut.setVisibility(View.VISIBLE);
                        }
                    }
                });
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        leng++;
                        if (random1 == random2) {
                            if (leng <= 130) {
                                handler.postDelayed(this::run, 80);
                                random3 = (int) (1 + Math.random() * 4);
                                int value = getResources().getIdentifier("a" + random3,
                                        "drawable", "com.cyhrer.rlol");
                                imageView3.setImageResource(value);
                            }
                        } else {
                            if (leng <= 130) {

                                handler.postDelayed(this::run, 30);
                                random3 = (int) (1 + Math.random() * 4);
                                int value = getResources().getIdentifier("a" + random3,
                                        "drawable", "com.cyhrer.rlol");
                                imageView3.setImageResource(value);
                            }
                        }
                        if (leng >= 130 && leng <= 135) {
                            if (random1 == random2 && random2 == random3) {
                                point += 20;
                                textPoint.setText(Integer.toString(point));
                            }
                        }
                        if (point >= 200) {
                            bonusBut.setVisibility(View.VISIBLE);
                        }
                    }
                });
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        leng++;
                        if (random1 == random2 && random2 == random3) {

                            if (leng <= 180) {
                                handler.postDelayed(this::run, 120);
                                random4 = (int) (1 + Math.random() * 4);
                                int value = getResources().getIdentifier("a" + random4,
                                        "drawable", "com.cyhrer.rlol");
                                imageView4.setImageResource(value);
                            }
                        } else {
                            if (leng <= 180) {
                                handler.postDelayed(this::run, 30);
                                random4 = (int) (1 + Math.random() * 4);
                                int value = getResources().getIdentifier("a" + random4,
                                        "drawable", "com.cyhrer.rlol");
                                imageView4.setImageResource(value);
                            }
                        }
                        if (leng >= 180 && leng <= 185) {
                            if (random1 == random2 && random2 == random3 && random3 == random4) {
                                point += 50;
                                textPoint.setText(Integer.toString(point));
                            }
                        }
                    }
                });

                if (bonus) {
                    clickcount=clickcount+1;
                    if(clickcount >= 5){
                        bonus = false;
                        ln.setVisibility(View.INVISIBLE);
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            leng++;
                            if (leng <= 60) {
                                handler.postDelayed(this::run, 30);
                                random5 = (int) (5 + Math.random() * 4);
                                int value = getResources().getIdentifier("a" + random5,
                                        "drawable", "com.cyhrer.rlol");
                                imageView5.setImageResource(value);
                            }
                        }
                    });
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            leng++;
                            if (leng <= 90) {
                                handler.postDelayed(this::run, 30);
                                random6 = (int) (5 + Math.random() * 4);
                                int value = getResources().getIdentifier("a" + random6,
                                        "drawable", "com.cyhrer.rlol");
                                imageView6.setImageResource(value);
                                if (leng >= 90 && leng <= 95) {
                                    if (random5 == random6) {
                                        point += 10;
                                        textPoint.setText(Integer.toString(point));
                                    }
                                }
                            }
                        }
                    });
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            leng++;
                            if (leng <= 130) {
                                handler.postDelayed(this::run, 30);
                                random7 = (int) (5 + Math.random() * 4);
                                int value = getResources().getIdentifier("a" + random7,
                                        "drawable", "com.cyhrer.rlol");
                                imageView7.setImageResource(value);
                            }
                            if (leng >= 130 && leng <= 135) {
                                if (random5 == random6 && random6 == random7) {
                                    point += 20;
                                    textPoint.setText(Integer.toString(point));
                                }
                            }
                        }
                    });
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            leng++;
                            if (leng <= 180) {
                                handler.postDelayed(this::run, 30);
                                random8 = (int) (5 + Math.random() * 4);
                                int value = getResources().getIdentifier("a" + random8,
                                        "drawable", "com.cyhrer.rlol");
                                imageView8.setImageResource(value);
                                if (leng >= 180 && leng <= 185) {
                                    if (random5 == random6 && random6 == random7 && random7 == random8) {
                                        point += 50;
                                        textPoint.setText(Integer.toString(point));
                                    }
                                }
                            }
                        }
                    });
                }

            }
        });

        bonusBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickcount = 0;
                point -= 200;
                textPoint.setText(Integer.toString(point));
                bonus = true;
                ln.setVisibility(View.VISIBLE);
                bonusBut.setVisibility(View.INVISIBLE);
            }
        });

    }

}