import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestProxy {
	public static void main(String args[]) {

		//System.getProperties().setProperty("proxySet", "true");//如果不设置，只要代理IP和代理端口正确,此项不设置也可以
		System.getProperties().setProperty("http.proxyHost", "218.26.204.66");// 代理服务器IP
		System.getProperties().setProperty("http.proxyPort", "8080");// 代理服务器端口
		System.out
				.println(getHtml("http://m.weather.com.cn/data/101030100.html"));//打印指定访问城市天津天气预报数据信息到控制台
	}

	//得到访问地址返回信息 
	private static String getHtml(String address) {
		StringBuffer html = new StringBuffer();
		String result = null;
		try {
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty(
					"User-Agent",
					"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");
			BufferedInputStream in = new BufferedInputStream(
					conn.getInputStream());
			try {
				String inputLine;
				byte[] buf = new byte[4096];
				int bytesRead = 0;
				while (bytesRead >= 0) {
					inputLine = new String(buf, 0, bytesRead, "ISO-8859-1");
					html.append(inputLine);
					bytesRead = in.read(buf);
					inputLine = null;
				}
				buf = null;
			} finally {
				in.close();
				conn = null;
				url = null;
			}
			result = new String(html.toString().trim().getBytes("ISO-8859-1"),
					"UTF-8").toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		html = null;
		return result;
	}
}