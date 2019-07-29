package executor.future;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		FutureClient fc = new FutureClient();
		Data data = fc.request("请求参数"); //返回FutureData，实现了Data接口
		System.out.println("请求发送成功!");
		System.out.println("做其他的事情...");
		
		String result = data.getResult();
		System.out.println(result);
		
	}
}
