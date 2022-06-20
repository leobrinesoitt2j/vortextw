package cn.xsshome.taip.nlp;

import java.util.HashMap;

import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.HttpUtil;
import cn.xsshome.taip.sign.TencentAISignSort;
import cn.xsshome.taip.util.Base64Util;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.util.RandomNonceStrUtil;
/**
 * 自然语言处理模块
 * @author 小帅丶
 * @version 4.2.0
 */
public class TAipNlp extends BaseClient{

	public TAipNlp(String app_id, String app_key) {
		super(app_id, app_key);
	}
	/**
	 * 分词 	
	 * 对文本进行智能分词识别，支持基础词与混排词粒度
	 * @param text 待分析文本
	 * @return String
	 * @throws Exception
	 */
    public String nlpWordseg(String text) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("text", text);
        String sign = TencentAISignSort.getSignatureforNLP(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_WORDSEG,TencentAISignSort.getParamsforNLP(params));
        return result;
    }
	/**
	 * 词性标注 	
	 * 对文本进行分词，同时为每个分词标注正确的词性
	 * @param text 待分析文本
	 * @return String
	 * @throws Exception
	 */
    public String nlpWordpos(String text) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("text", text);
        String sign = TencentAISignSort.getSignatureforNLP(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_WORDPOS,TencentAISignSort.getParamsforNLP(params));
        return result;
    }
	/**
	 * 专有名词识别 	
	 * 对文本进行专有名词的分词识别，找出文本中的专有名词
	 * @param text 待分析文本
	 * @return String
	 * @throws Exception
	 */
    public String nlpWordner(String text) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("text", text);
        String sign = TencentAISignSort.getSignatureforNLP(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_WORDNER,TencentAISignSort.getParamsforNLP(params));
        return result;
    }
	/**
	 * 同义词识别 	
	 * 识别文本中存在同义词的分词，并返回相应的同义词
	 * @param text 待分析文本
	 * @return String
	 * @throws Exception
	 */
    public String nlpWordsyn(String text) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("text", text);
        String sign = TencentAISignSort.getSignatureforNLP(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_WORDSYN,TencentAISignSort.getParamsforNLP(params));
        return result;
    }
    /**
	 * 意图成分识别 	
	 * 对文本进行意图识别，快速找出意图及上下文成分
	 * @param text 待分析文本
	 * @return String 
	 * @throws Exception
	 */
    public String nlpWordcom(String text) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("text", text);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_WORDCOM,TencentAISignSort.getParams(params));
        return result;
    }
    /**
	 * 情感分析识别 	
	 * 对文本进行情感分析，快速判断情感倾向（正面或负面）
	 * @param text 待分析文本
	 * @return String 
	 * @throws Exception
	 */
    public String nlpTextpolar(String text) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("text", text);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_TEXTPOLAR,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 基础闲聊
     * @param session 会话标识（应用内唯一）
     * @param question 用户输入的聊天内容
     * @return String
     * @throws Exception
     */
    public String nlpTextchat(String session,String question) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("session", session);
        params.put("question", question);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_TEXTCHAT,TencentAISignSort.getParams(params));
        return result;
    }
	 /**
     * 文本翻译（AI Lab） 	
     * 对文本进行翻译，支持多种语言之间互译 
     * 文本翻译接口提供自动翻译能力，可以帮您快速完成一段文本的翻译，支持中、英、德、法、日、韩、西、粤语种
     * @param type 翻译类型
     * @param text 待翻译文本
     * @return String
     * @throws Exception
     */
    public String nlpTextTrans(int type,String text) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("type", String.valueOf(type));
        params.put("text", text);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_TEXTTRANS,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 文本翻译（翻译君）	
     * 对文本进行翻译，支持多种语言之间互译 
     * 文本翻译接口提供自动翻译能力，可以帮您快速完成一段文本的翻译，支持多种语言之间的互译。
     * @param text 待翻译文本
     * @param source 源语言缩写
     * @param target 目标语言缩写
     * @return String
     * @throws Exception
     */
    public String nlpTextTranslate(String text,String source,String target) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("text", text);
        params.put("source", source);
        params.put("target", target);
        String sign = TencentAISignSort.getSignature4TransText(params,app_key);
        if(sign.contains("errorCode")){
        	return sign;
        }
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_TEXTTRANSLATE,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 图片翻译 	
     * 识别图片中的文字，并进行翻译
     * @param image 二进制图片数据
     * @param session_id 一次请求ID
     * @param scene 识别类型（word-单词识别，doc-文档识别）
     * @param source 源语言缩写
     * @param target 目标语言缩写
     * @return String
     * @throws Exception
     */
    public String nlpImageTranslate(byte[] image,String session_id,String scene,String source,String target) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		String imageBase64 = Base64Util.encode(image);
		params.put("image", imageBase64);
		params.put("session_id", session_id);
		params.put("scene", scene);
        params.put("source", source);
        params.put("target", target);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_IMAGETRANSLATE,TencentAISignSort.getParams(params));
        return result; 
    }
    /**
     * 图片翻译 	
     * 识别图片中的文字，并进行翻译
     * @param filePath 图片本地路径
     * @param session_id 一次请求ID
     * @param scene 识别类型（word-单词识别，doc-文档识别）
     * @param source 源语言缩写
     * @param target 目标语言缩写
     * @return String
     * @throws Exception
     */
    public String nlpImageTranslate(String filePath,String session_id,String scene,String source,String target) throws Exception{
    	byte [] image = FileUtil.readFileByBytes(filePath);
    	return nlpImageTranslate(image, session_id, scene, source, target);
    }
    /**
     * 语种识别 	
     * 识别给出文本的语种
     * @param text 待识别文本
     * @param candidate_langs 备选语言缩写
     * @param force 是否强制从候选语言中选择（只对二选一有效）
     * @return String
     * @throws Exception
     */
    public String nlpTextDetect(String text,String candidate_langs,int force) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("text", text);
		if(null!=candidate_langs&&!candidate_langs.equals("")){
		params.put("candidate_langs", candidate_langs);
		}
        params.put("force", String.valueOf(force));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_TEXTDETECT,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 语种识别 (不需要备选语言candidate_langs参数)	
     * 识别给出文本的语种
     * @param text 待识别文本
     * @param force 是否强制从候选语言中选择（只对二选一有效）
     * @return String
     * @throws Exception
     */
    public String nlpTextDetect(String text,int force) throws Exception{
    	return nlpTextDetect(text, "", force);
    }
    /**
     * 语音翻译
     * 识别出音频中的文字，并进行翻译
     * @param format 语音压缩格式编码
     * @param seq 语音分片所在语音流的偏移量
     * @param end 是否结束分片标识
     * @param session_id 语音唯一标识（同一应用内）
     * @param speech_chunk 待识别语音分片二进制数据
     * @param source 源语言缩写
     * @param target 目标语言缩写
     * @return String
     * @throws Exception
     */
    public String nlpSpeechTranslate(int format,int seq,int end,String session_id,byte[] speech_chunk,String source,String target) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("format",String.valueOf(format));
		params.put("seq", String.valueOf(seq));
        params.put("end", String.valueOf(end));
        params.put("session_id", session_id);
        String base64Voice = Base64Util.encode(speech_chunk);
        params.put("speech_chunk",base64Voice);
        params.put("source",source);
        params.put("target",target);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(NLPConsts.NLP_SPEECHTRANSLATE,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 语音翻译
     * 识别出音频中的文字，并进行翻译
     * @param format 语音压缩格式编码
     * @param seq 语音分片所在语音流的偏移量
     * @param end 是否结束分片标识
     * @param session_id 语音唯一标识（同一应用内）
     * @param filePath 待识别语音文件(本地路径)
     * @param source 源语言缩写
     * @param target 目标语言缩写
     * @return String
     * @throws Exception
     */
    public String nlpSpeechTranslate(int format,int seq,int end,String session_id,String filePath,String source,String target) throws Exception{
    	byte[] speech_chunk = FileUtil.readFileByBytes(filePath);
        return nlpSpeechTranslate(format, seq, end, session_id, speech_chunk, source, target);
    }
}
