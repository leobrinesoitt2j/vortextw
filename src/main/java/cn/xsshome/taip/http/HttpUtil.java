package cn.xsshome.taip.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import cn.xsshome.taip.nlp.NLPConsts;


/**
 * http 工具类
 */
public class HttpUtil {

    public static String post(String requestUrl,String params){
        String result = "";
        URL url = null;
        HttpURLConnection connection = null;
        try {
    	url = new URL(requestUrl);
    	// 打开和URL之间的连接
    	connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        // 设置通用的请求属性
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        // 得到请求的输出流对象
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(params);
        out.flush();
        out.close();
        // 建立实际的连接
        connection.connect();
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = null;
        if(requestUrl.equals(NLPConsts.NLP_WORDSEG)||requestUrl.equals(NLPConsts.NLP_WORDPOS)||requestUrl.equals(NLPConsts.NLP_WORDNER)||requestUrl.equals(NLPConsts.NLP_WORDSYN)){
        	in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
        }else{
        	in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        }
        String getLine;
        while ((getLine = in.readLine()) != null) {
            result += getLine;
        }
        in.close();
        connection.disconnect();
    	} catch (Exception e) {
    		new Exception("HttpUtil出错了。快联系小帅丶吧。QQ:783021975"+e.getMessage());
    	}finally{
    		if(connection!=null){
    			connection.disconnect();
    		}
    	}
        return result;
    }
}

