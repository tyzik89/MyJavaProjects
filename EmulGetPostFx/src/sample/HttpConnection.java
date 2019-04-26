package sample;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    private String serverUrl;
    private String params;
    private boolean doOutPut = true;
    private boolean doInput = true;
    private String method;

    public HttpConnection(String method, String serverUrl, String params) {
        this.serverUrl = serverUrl;
        this.params = params;
        this.method = method;
    }

    public String doRequest () {
        byte[] data = null;
        InputStream is = null;
        try {
            URL url = new URL(serverUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);
            connection.setDoOutput(doOutPut);
            connection.setDoInput(doInput);

            connection.setRequestProperty("Content-Length", "" + Integer.toString(params.getBytes().length));
            OutputStream os = connection.getOutputStream();

            data = params.getBytes("UTF-8");
            os.write(data);
            data = null;

            connection.connect();
            int responceCode = connection.getResponseCode();

            //ВЫВОД ОТВЕТА
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            is = connection.getInputStream();

            byte[] buffer = new byte[8192]; // Такого вот размера буфер
            // Далее, например, вот так читаем ответ
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (Exception ex) {}
        }

        String str = "";

        try {
            str = (data == null) ? "Нет ответа..." : new String(data, "UTF-8"); // for UTF-8 encoding
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return str;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public boolean isDoOutPut() {
        return doOutPut;
    }

    public void setDoOutPut(boolean doOutPut) {
        this.doOutPut = doOutPut;
    }

    public boolean isDoInput() {
        return doInput;
    }

    public void setDoInput(boolean doInput) {
        this.doInput = doInput;
    }
}
