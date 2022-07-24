package cn.xsshome.taip.vision;


import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.TAipEBodyFormat;
import cn.xsshome.taip.http.TAipRequest;
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
        TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis()/1000+"";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        String sign = TencentAISignSort.getSignature(request.getBody(),app_key);
		request.addBody("sign",sign);
        request.setUri(VisionConsts.IMAGE_TERRORISM);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
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
        TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis()/1000+"";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        String sign = TencentAISignSort.getSignature(request.getBody(),app_key);
		request.addBody("sign",sign);
        request.setUri(VisionConsts.VISION_PORN);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
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
