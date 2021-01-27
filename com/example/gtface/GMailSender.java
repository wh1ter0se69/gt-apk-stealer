package com.example.gtface;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class GMailSender extends Authenticator {
  private String emailCode;
  
  private String macad;
  
  private String mailhost = "smtp.gmail.com";
  
  private String password;
  
  private Session session;
  
  private String user;
  
  public GMailSender(String paramString1, String paramString2) {
    this.user = paramString1;
    this.password = paramString2;
    this.emailCode = createEmailCode();
    Properties properties = new Properties();
    properties.setProperty("mail.transport.protocol", "smtp");
    properties.setProperty("mail.host", this.mailhost);
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.socketFactory.port", "465");
    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    properties.put("mail.smtp.socketFactory.fallback", "false");
    properties.setProperty("mail.smtp.quitwait", "false");
    this.session = Session.getDefaultInstance(properties, this);
  }
  
  private String createEmailCode() {
    String[] arrayOfString = new String[35];
    arrayOfString[0] = "a";
    arrayOfString[1] = "b";
    arrayOfString[2] = "c";
    arrayOfString[3] = "d";
    arrayOfString[4] = "e";
    arrayOfString[5] = "f";
    arrayOfString[6] = "g";
    arrayOfString[7] = "h";
    arrayOfString[8] = "i";
    arrayOfString[9] = "j";
    arrayOfString[10] = "k";
    arrayOfString[11] = "l";
    arrayOfString[12] = "m";
    arrayOfString[13] = "n";
    arrayOfString[14] = "o";
    arrayOfString[15] = "p";
    arrayOfString[16] = "q";
    arrayOfString[17] = "r";
    arrayOfString[18] = "s";
    arrayOfString[19] = "t";
    arrayOfString[20] = "u";
    arrayOfString[21] = "v";
    arrayOfString[22] = "w";
    arrayOfString[23] = "x";
    arrayOfString[24] = "y";
    arrayOfString[25] = "z";
    arrayOfString[26] = "1";
    arrayOfString[27] = "2";
    arrayOfString[28] = "3";
    arrayOfString[29] = "4";
    arrayOfString[30] = "5";
    arrayOfString[31] = "6";
    arrayOfString[32] = "7";
    arrayOfString[33] = "8";
    arrayOfString[34] = "9";
    String str = new String();
    for (int i = 0; i < 8; i++) {
      int j = (int)(Math.random() * arrayOfString.length);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(arrayOfString[j]);
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public String getEmailCode() {
    return this.emailCode;
  }
  
  protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(this.user, this.password);
  }
  
  public void sendMail(String paramString1, String paramString2, String paramString3, String paramString4) throws Exception {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new javax/mail/internet/MimeMessage
    //   5: dup
    //   6: aload_0
    //   7: getfield session : Ljavax/mail/Session;
    //   10: invokespecial <init> : (Ljavax/mail/Session;)V
    //   13: astore #5
    //   15: new javax/activation/DataHandler
    //   18: dup
    //   19: new com/example/gtface/GMailSender$ByteArrayDataSource
    //   22: dup
    //   23: aload_0
    //   24: aload_2
    //   25: invokevirtual getBytes : ()[B
    //   28: ldc 'text/plain'
    //   30: invokespecial <init> : (Lcom/example/gtface/GMailSender;[BLjava/lang/String;)V
    //   33: invokespecial <init> : (Ljavax/activation/DataSource;)V
    //   36: astore_2
    //   37: aload #5
    //   39: new javax/mail/internet/InternetAddress
    //   42: dup
    //   43: aload_0
    //   44: getfield user : Ljava/lang/String;
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: invokevirtual setSender : (Ljavax/mail/Address;)V
    //   53: aload #5
    //   55: aload_1
    //   56: invokevirtual setSubject : (Ljava/lang/String;)V
    //   59: aload #5
    //   61: aload_2
    //   62: invokevirtual setDataHandler : (Ljavax/activation/DataHandler;)V
    //   65: aload_3
    //   66: bipush #44
    //   68: invokevirtual indexOf : (I)I
    //   71: ifle -> 89
    //   74: aload #5
    //   76: getstatic javax/mail/Message$RecipientType.TO : Ljavax/mail/Message$RecipientType;
    //   79: aload_3
    //   80: invokestatic parse : (Ljava/lang/String;)[Ljavax/mail/internet/InternetAddress;
    //   83: invokevirtual setRecipients : (Ljavax/mail/Message$RecipientType;[Ljavax/mail/Address;)V
    //   86: goto -> 105
    //   89: aload #5
    //   91: getstatic javax/mail/Message$RecipientType.TO : Ljavax/mail/Message$RecipientType;
    //   94: new javax/mail/internet/InternetAddress
    //   97: dup
    //   98: aload_3
    //   99: invokespecial <init> : (Ljava/lang/String;)V
    //   102: invokevirtual setRecipient : (Ljavax/mail/Message$RecipientType;Ljavax/mail/Address;)V
    //   105: aload #4
    //   107: ifnull -> 163
    //   110: new javax/mail/internet/MimeBodyPart
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore_1
    //   118: new javax/mail/internet/MimeMultipart
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore_2
    //   126: aload_1
    //   127: new javax/activation/DataHandler
    //   130: dup
    //   131: new javax/activation/FileDataSource
    //   134: dup
    //   135: aload #4
    //   137: invokespecial <init> : (Ljava/lang/String;)V
    //   140: invokespecial <init> : (Ljavax/activation/DataSource;)V
    //   143: invokevirtual setDataHandler : (Ljavax/activation/DataHandler;)V
    //   146: aload_1
    //   147: ldc 'save.dat'
    //   149: invokevirtual setFileName : (Ljava/lang/String;)V
    //   152: aload_2
    //   153: aload_1
    //   154: invokevirtual addBodyPart : (Ljavax/mail/BodyPart;)V
    //   157: aload #5
    //   159: aload_2
    //   160: invokevirtual setContent : (Ljavax/mail/Multipart;)V
    //   163: aload #5
    //   165: invokestatic send : (Ljavax/mail/Message;)V
    //   168: aload_0
    //   169: monitorexit
    //   170: return
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Exception table:
    //   from	to	target	type
    //   2	86	171	finally
    //   89	105	171	finally
    //   110	163	171	finally
    //   163	168	171	finally
  }
  
  public class ByteArrayDataSource implements DataSource {
    private byte[] data;
    
    private String type;
    
    public ByteArrayDataSource(byte[] param1ArrayOfbyte) {
      this.data = param1ArrayOfbyte;
    }
    
    public ByteArrayDataSource(byte[] param1ArrayOfbyte, String param1String) {
      this.data = param1ArrayOfbyte;
      this.type = param1String;
    }
    
    public String getContentType() {
      String str = this.type;
      return (str == null) ? "application/octet-stream" : str;
    }
    
    public InputStream getInputStream() throws IOException {
      return new ByteArrayInputStream(this.data);
    }
    
    public String getName() {
      return "ByteArrayDataSource";
    }
    
    public OutputStream getOutputStream() throws IOException {
      throw new IOException("Not Supported");
    }
    
    public void setType(String param1String) {
      this.type = param1String;
    }
  }
}


/* Location:              C:\Users\Tbrin\Downloads\System_Freezer_1-dex2jar.jar!\com\example\gtface\GMailSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */