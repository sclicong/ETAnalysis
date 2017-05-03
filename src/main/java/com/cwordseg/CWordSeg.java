package com.cwordseg;

import java.io.UnsupportedEncodingException;

import com.service.InitService;
// import utils.SystemParas;  
import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * 
 * 功能：基本的分词功能 最后更新时间：2016年3月14日 21:01:21
 */

public class CWordSeg {
	// 定义接口CLibrary，继承自com.sun.jna.Library
	public interface CLibrary extends Library {
		// 定义并初始化接口的静态变量，用于加载NLPIR.dll，路径指向文件NLPIR.dll，但不加后缀dll
		CLibrary Instance = (CLibrary) Native.loadLibrary("src/main/resources/NLPIR", CLibrary.class);

		// 初始化函数声明：sDataPath是初始化路径地址，包括核心词库和配置文件的路径，encoding为输入字符的编码格式
		public int NLPIR_Init(String sDataPath, int encoding, String sLicenceCode);

		// 分词函数声明：sSrc为待分字符串，bPOSTagged=0表示不进行词性标注，bPOSTagged=1表示进行词性标注
		public String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);

		// 获取最后一个错误信息的函数声明
		public String NLPIR_GetLastErrorMsg();

		// 退出函数声明
		public void NLPIR_Exit();
	}

	public static String transString(String aidString, String ori_encoding, String new_encoding) {
		try {
			return new String(aidString.getBytes(ori_encoding), new_encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		// String argu = "src/main/resources/"; // 该路径指向Data文件夹（系统核心词库）
		// // String system_charset = "UTF-8";
		// int charset_type = 1; // UTF-8编码模式，其它的GBK对应0，BIG5对应2，含繁体字的GBK对应3
		// int init_flag = CLibrary.Instance.NLPIR_Init(argu, charset_type,
		// "0"); // 运行初始化函数，成功则返回1，失败返回0
		// String nativeBytes;
		//
		// // 初始化失败提示
		// if (0 == init_flag) {
		// nativeBytes = CLibrary.Instance.NLPIR_GetLastErrorMsg(); // 获取错误信息
		// System.err.println("初始化失败！原因：" + nativeBytes);
		// return;
		// }
		//
		// String sInput = "我不多高兴"; // 手工输入的字符串sInput
		// // 中文分词
		// nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sInput, 1); //
		// 运行分词函数
		// System.out.println("分词结果为： " + nativeBytes); // 输出分词结果
		// CLibrary.Instance.NLPIR_Exit(); // 退出
		//
		// // xml配置文件读取,存到hashmap中
		// HashMap<String, Double> hashMap = new HashMap<String, Double>();
		// DocumentBuilderFactory factory =
		// DocumentBuilderFactory.newInstance();
		// DocumentBuilder builder = factory.newDocumentBuilder();
		// Document doc = builder.parse("src/main/resources/configure.xml");
		// Element root = doc.getDocumentElement();
		// NodeList dics = root.getChildNodes();
		// for (int i = 0; i < dics.getLength(); i++) {
		// Node dic = dics.item(i);
		// if ("dic".equals(dic.getNodeName())) {
		// NodeList pathAndWeight = dic.getChildNodes();
		// String path = null;
		// Double weight = 0.0;
		// for (int j = 0; j < pathAndWeight.getLength(); j++) {
		// Node node = pathAndWeight.item(j);
		// if ("path".equals(node.getNodeName())) {
		// path = pathAndWeight.item(j).getTextContent();
		// } else if ("weight".equals(node.getNodeName())) {
		// weight = Double.valueOf(node.getTextContent());
		// }
		// }
		//
		// if (path != null && weight != 0) {
		// BufferedReader bReader = new BufferedReader(
		// new InputStreamReader(new FileInputStream(path), "UTF-8"));
		// try {
		// String s;
		// while ((s = bReader.readLine()) != null) {
		// hashMap.put(s, weight);
		// }
		// } catch (Exception e) {
		// // TODO: handle exception
		// } finally {
		// bReader.close();
		// }
		// }
		// }
		// }
		String sInput = "中国很不高兴."; // 手工输入的字符串sInput
		System.out.println(sInput.split("/."));
		InitService initService = new InitService();
		// String nativeBytes = initService.initAndGetFinally(sInput);
		// HashMap<String, WordState> wordSeg = initService.initWordSeg();
		// String[] strings = nativeBytes.split("/| ");
		// double a = 0.0;
		// for (int i = 0; i < strings.length; i++) {
		// if ("d".equals(strings[i])) {
		// if (wordSeg.get(strings[i - 1]).isState()) {
		// if (i >= 2) {
		// if ("d".equals(strings[i - 2])) {
		//
		// }
		// }
		// if (i <= strings.length - 2) {
		// if ("d".equals(strings[i + 2])) {
		//
		// }
		// }
		// }
		// }
		// }

		System.out.print(initService.getFinally(sInput));
	}
}