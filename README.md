OCR Java SDKĿ¼�ṹ
cn.xsshome.taip
       ������ base                                //����
       ������ http                                //Httpͨ�������
       ������ sign                                //ǩ��������
       ������ ocr
       ��       ������ TAipOcr           		   //TAipOcr��
	   ������ speech
	   ��       ������ TAipOcr           		   //TAipSpeech��
       ������ util                                //������
	   
֧�� JAVA�汾��1.7+

ֱ��ʹ��JAR���������£�

1.����ѶAIQQȺ����Java SDKѹ�����߰���

2.�����ص�tai-java-sdk-version.zip��ѹ�󣬸��Ƶ������ļ����С�

3.��Eclipse�Ҽ������� -> Properties -> Java Build Path -> Add JARs����

4.���SDK���߰�tai-java-sdk-version.jar��

���У�versionΪ�汾�ţ������ɺ��û��Ϳ����ڹ�����ʹ����ѶAIJava SDK��	   
#OCRʾ������
�½�TAipOcr
TAipOcr�ǵ�����ѶAI��OCR��Java�ͻ��ˣ�Ϊ������ѶAI��OCR���ܵĿ�����Ա�ṩ��һϵ�еĽ���������

�û����Բο����´����½�һ��TAipOcr,��ʼ����ɺ��鵥��ʹ�ã�

public class Sample {
    //����APPID/APP_KEY
    public static final String APP_ID = "��� App ID";
    public static final String APP_KEY = "��� Api Key";

    public static void main(String[] args) {
        // ��ʼ��һ��TAipOcr
       TAipOcr aipOcr = new TAipOcr(APP_ID,APP_KEY);
        // ���ýӿ�
        String path = "test.jpg";
		String result = aipOcr.bcOcr(path);
		System.out.println(result);
    }
}
#ASRʾ������
�½�TAipOcr
TAipOcr�ǵ�����ѶAI������ʶ���Java�ͻ��ˣ�Ϊ������ѶAI������ʶ���ܵĿ�����Ա�ṩ��һϵ�еĽ���������

�û����Բο����´����½�һ��TAipSpeech,��ʼ����ɺ��鵥��ʹ�ã�

public class Sample {
    //����APPID/APP_KEY
    public static final String APP_ID = "��� App ID";
    public static final String APP_KEY = "��� Api Key";

    public static void main(String[] args) {
        // ��ʼ��һ��TAipSpeech
        TAipSpeech aipSpeech = new TAipSpeech(APP_ID, APP_KEY);
        // ���ýӿ�
		String filePath ="./VOICE1513237078.pcm";//�����ļ�·��
		byte[] audio = FileUtil.readFileByBytes(filePath);//��ȡ�ļ���byte����
		String result = aipSpeech.asrEcho(filePath, 1);//����ʶ��-echo��
		String result = aipSpeech.asrLab(1, 16000, 0, 1024, 1, audio);//����ʶ��-��ʽ�棨AI Lab��
		String result = aipSpeech.asrWx(filePath, 1, 16000, 16, 0, 1024, 1, 1);//����ʶ��-��ʽ��(WeChat AI)
		System.out.println(result);
    }
}