OCR Java SDKĿ¼�ṹ
cn.xsshome.taip
       ������ base                                //����
       ������ http                                //Httpͨ�������
       ������ sign                                //ǩ��������
       ������ ocr
       ��       ������ TAipOcr           		   //TAipOcr��
       ������ util                                //������
	   
֧�� JAVA�汾��1.7+

ֱ��ʹ��JAR���������£�

1.����ѶAIQQȺ����Java SDKѹ�����߰���

2.�����ص�tai-java-sdk-version.zip��ѹ�󣬸��Ƶ������ļ����С�

3.��Eclipse�Ҽ������� -> Properties -> Java Build Path -> Add JARs����

4.���SDK���߰�tai-java-sdk-version.jar��

���У�versionΪ�汾�ţ������ɺ��û��Ϳ����ڹ�����ʹ����ѶAIJava SDK��	   
#ʾ������
�½�TAipOcr
TAipOcr�ǵ�����ѶAI��OCR��Java�ͻ��ˣ�Ϊ������ѶAI��OCR���ܵĿ�����Ա�ṩ��һϵ�еĽ���������

�û����Բο����´����½�һ��TAipOcr,��ʼ����ɺ��鵥��ʹ�ã�

public class Sample {
    //����APPID/APP_KEY
    public static final String APP_ID = "��� App ID";
    public static final String APP_KEY = "��� Api Key";

    public static void main(String[] args) {
        // ��ʼ��һ��AipOcr
       TAipOcr aipOcr = new TAipOcr(APP_ID,APP_KEY);
        // ���ýӿ�
        String path = "test.jpg";
		String result = aipOcr.bcOcr(path);
		System.out.println(result);
    }
}