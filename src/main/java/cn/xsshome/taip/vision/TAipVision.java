package cn.xsshome.taip.vision;

import java.util.HashMap;

import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.HttpUtil;
import cn.xsshome.taip.sign.TencentAISignSort;
import cn.xsshome.taip.util.Base64Util;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.util.RandomNonceStrUtil;

public class TAipVision extends BaseClient{

	public TAipVision(String app_id, String app_key) {
		super(app_id, app_key);
	}
	 /**
     * 暴恐图片识别 	
     * 识别一个图像是否为暴恐图像。 	
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String imageTerrorism(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(VisionConsts.IMAGE_TERRORISM,TencentAISignSort.getParams(params));
        return result;
    }
	 /**
     * 暴恐图片识别 	
     * 识别一个图像是否为暴恐图像。 	
     * @param filePath - 图片本地路径
     * @return String
	 * @throws Exception 
     */
    public String imageTerrorism(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
    	return imageTerrorism(image);
    }
	 /**
     * 智能鉴黄 	
     * 识别一个图像是否为色情图像。 	
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String visionPorn(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(VisionConsts.VISION_PORN,TencentAISignSort.getParams(params));
        return result;
    }
	 /**
     * 智能鉴黄 	
     * 识别一个图像是否为色情图像
     * @param filePath - 图片本地路径
     * @return String
	 * @throws Exception 
     */
    public String visionPorn(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
    	return visionPorn(image);
    }
}
