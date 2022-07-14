package cn.xsshome.taip.speech;

import java.util.HashMap;




import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.HttpUtil;
import cn.xsshome.taip.sign.TencentAISignSort;
import cn.xsshome.taip.util.Base64Util;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.util.RandomNonceStrUtil;

public class TAipSpeech extends BaseClient{
	
	public TAipSpeech(String app_id, String app_key) {
		super(app_id, app_key);
	}
	 /**
     * 语音识别-echo版
     * 对音频进行语音识别，并返回语音的文字内容
     * @param audio - 二进制音频数据
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate - 语音采样率编码 8000 16000
     * @return String
	 * @throws Exception 
     */
    public String asrEcho(byte[] audio,int format,int rate) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(audio);
        params.put("speech", base64Content);
        params.put("format", Integer.toString(format));
        params.put("rate",Integer.toString(rate));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASR_AAI,TencentAISignSort.getParams(params));
        return result;
    }
	 /**
     * 语音识别-echo版
     * 对音频进行语音识别，并返回语音的文字内容
     * @param filePath - 音频文件本地路径
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate - 语音采样率编码 8000 16000
     * @return String
	 * @throws Exception 
     */
    public String asrEcho(String filePath,int format,int rate) throws Exception{
    	byte[] audio = FileUtil.readFileByBytes(filePath);
        return asrEcho(audio,format,rate);
    }
	 /**
     * 语音识别-echo版
     * 对音频进行语音识别，并返回语音的文字内容
     * @param audio - 二进制音频数据
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @return String
	 * @throws Exception 
     */
    public String asrEcho(byte[] audio,int format) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(audio);
        params.put("speech", base64Content);
        params.put("format", Integer.toString(format));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASR_AAI,TencentAISignSort.getParams(params));
        return result;
    }
	 /**
     * 语音识别-echo版
     * 对音频进行语音识别，并返回语音的文字内容
     * @param filePath - 音频文件本地路径
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @return String
	 * @throws Exception 
     */
    public String asrEcho(String filePath,int format) throws Exception{
    	byte[] audio = FileUtil.readFileByBytes(filePath);
        return asrEcho(audio,format);
    }
    /**
     * 语音识别-流式版（AI Lab）
     * 对音频进行语音识别，并返回语音的文字内容
     * @param format 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate 音频采样率编码 8000 16000
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @param speech_chunk 待识别语音分片 base64编码数据
     * @return String
     * @throws Exception
     */
    public String asrLab(int format,int rate,int seq,int len,int end,String speech_chunk) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("format", Integer.toString(format));
		params.put("rate",Integer.toString(rate));
		params.put("seq",Integer.toString(seq));
		params.put("len", Integer.toString(len));
		params.put("end", Integer.toString(end));
		params.put("speech_id",RandomNonceStrUtil.getRandomString(10));
		params.put("speech_chunk", speech_chunk);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASR_AAIS,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 语音识别-流式版（AI Lab）
     * 对音频进行语音识别，并返回语音的文字内容
     * @param format 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate 音频采样率编码 8000 16000
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @param audio 音频二进制数据
     * @return String
     * @throws Exception
     */
    public String asrLab(int format,int rate,int seq,int len,int end,byte[] audio) throws Exception{
    	String base64Content = Base64Util.encode(audio);
        return asrLab(format, rate, seq, len, end, base64Content);
    }
    /**
     * 语音识别-流式版（AI Lab）
     * 对音频进行语音识别，并返回语音的文字内容
     * @param filePath 音频文件本地路径
     * @param format 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate 音频采样率编码 8000 16000
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @return String
     * @throws Exception
     */
    public String asrLab(String filePath,int format,int rate,int seq,int len,int end) throws Exception{
    	String base64Content = Base64Util.encode(FileUtil.readFileByBytes(filePath));
        return asrLab(format, rate, seq, len, end, base64Content);
    }
    /**
     * 语音识别-流式版(WeChat AI) 	
     * 对音频进行语音识别，并返回语音的文字内容
     * @param audio - 二进制音频数据
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4 SPEEX-5 MP3-8
     * @param rate - 语音采样率编码 8000 16000
     * @param bits 音频采样位数 16
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @param cont_res 是否获取中间识别结果 0不获取 1获取
     * @return String
	 * @throws Exception 
     */
    public String asrWx(byte[] audio,int format,int rate,int bits,int seq,int len,int end,int cont_res) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("format", Integer.toString(format));
		params.put("rate",Integer.toString(rate));
		params.put("seq",Integer.toString(seq));
		params.put("len", Integer.toString(len));
		params.put("end", Integer.toString(end));
		params.put("bits", Integer.toString(bits));
		params.put("cont_res", Integer.toString(cont_res));
		params.put("speech_id",RandomNonceStrUtil.getRandomString(10));
		String speech_chunk = Base64Util.encode(audio);
		params.put("speech_chunk", speech_chunk);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASR_WX,TencentAISignSort.getParams(params));
        return result;
    }
	 /**
     * 语音识别-流式版(WeChat AI) 	
     * 对音频进行语音识别，并返回语音的文字内容
     * @param filePath - 音频文件本地路径
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate - 语音采样率编码 8000 16000
     * @param bits 音频采样位数 16
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @param cont_res 是否获取中间识别结果 0不获取 1获取
     * @return String
	 * @throws Exception 
     */
    public String asrWx(String filePath,int format,int rate,int bits,int seq,int len,int end,int cont_res) throws Exception{
    	byte[] audio = FileUtil.readFileByBytes(filePath);
        return asrWx(audio, format, rate, bits, seq, len, end, cont_res);
    }
    /**
     * 语音合成（AI Lab） 	非默认值
     * 将文字转换为语音，返回文字的语音数据。
     * @param text 待合成文本
     * @param speaker 语音发音人编码
     * @param format 合成语音格式编码
     * @param volume 合成语音音量 取值范围[-10, 10]，如-10表示音量相对默认值小10dB，0表示默认音量，10表示音量相对默认值大10dB
     * @param speed 合成语音语速，默认100
     * @param aht 合成语音降低/升高半音个数，即改变音高，默认0
     * @param apc 控制频谱翘曲的程度，改变说话人的音色，默认58
     * @return String
     * @throws Exception
     */
    public String TtsSynthesis(String text,int speaker,int format,int volume,int speed,int aht,int apc) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("text", text);
		params.put("speaker",String.valueOf(speaker));
		params.put("format",String.valueOf(format));
		params.put("volume",String.valueOf(volume));
		params.put("speed",String.valueOf(speed));
		params.put("aht", String.valueOf(aht));
		params.put("apc", String.valueOf(apc));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_TTS_TTS,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 语音合成（AI Lab） 默认值
     * 将文字转换为语音，返回文字的语音数据。
     * @param text 待合成文本
     * @param speaker 语音发音人编码
     * @param format 合成语音格式编码
     * @return String
     * @throws Exception
     */
    public String TtsSynthesis(String text,int speaker,int format) throws Exception{
    	return TtsSynthesis(text, speaker, format, 0, 100, 0, 58);
    }
    /**
     * 语音合成（优图） 	
     * 将文字转换为语音，返回文字的语音数据。
     * @param text 待合成语音文本
     * @param model_type 发音模型
     * @param speed 语速
     * @return String
     * @throws Exception
     */
    public String TtaSynthesis(String text,int model_type,int speed) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("text", text);
		params.put("speed", Integer.toString(speed));
		params.put("model_type", Integer.toString(model_type));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_TTS_TTA,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 语音合成（优图） 	
     * 将文字转换为语音，返回文字的语音数据。
     * @param text 待合成语音文本
     * @return String
     * @throws Exception
     */
    public String TtaSynthesis(String text) throws Exception{
    	return TtaSynthesis(text, 0, 0);
    }
    /**
     * 长语音识别 	待识别语音
     * 上传长音频，提供回调接口，异步获取识别结果
     * @param speech 语音数据的Base64编码，原始音频大小上限5MB
     * @param format 语音压缩格式编码
     * @param callback_url 用户回调url，需用户提供，用于平台向用户通知识别结果
     * @return String
     * @throws Exception
     */
    public String asrLong(byte[] speech,int format,String callback_url) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(speech);
        params.put("speech", base64Content);
        params.put("format", Integer.toString(format));
        params.put("callback_url",callback_url);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASRLONG,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 长语音识别 	待识别语音下载地址
     * 上传长音频，提供回调接口，异步获取识别结果
     * @param speech_url 待识别语音下载地址
     * @param format 语音压缩格式编码
     * @param callback_url 用户回调url，需用户提供，用于平台向用户通知识别结果
     * @return String
     * @throws Exception
     */
    public String asrLongByUrl(String speech_url,int format,String callback_url) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("speech_url", speech_url);
        params.put("format", Integer.toString(format));
        params.put("callback_url",callback_url);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASRLONG,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 长语音识别 	 待识别语音
     * 上传长音频，提供回调接口，异步获取识别结果
     * @param speechPath 音频文件本地路径
     * @param format 语音压缩格式编码
     * @param callback_url 用户回调url，需用户提供，用于平台向用户通知识别结果
     * @return String
     * @throws Exception
     */
    public String asrLong(String speechPath,int format,String callback_url) throws Exception{
    	byte[] speech = FileUtil.readFileByBytes(speechPath);
    	return asrLong(speech, format, callback_url);
    }
}
