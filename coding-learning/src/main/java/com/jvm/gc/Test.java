package com.jvm.gc;

/**
 * @author gaobenlong
 * @date 2021/6/3 3:10 下午
 * @desc
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		test();
		test();
		test();
		test();
		test();
		System.out.println("代码预热");
		test();
		test();
		test();
		Thread.sleep(10000);
		test();
		test();
	}


	public static void test() {
		long time = System.nanoTime();
		for (Long i = 0L; i < 1000; i++) {
			String s = String.valueOf(i);
		}
		long time1 = System.nanoTime();
		System.out.println("方式一耗时：" + (time1 - time));
		long time2 = System.nanoTime();
		for (Long i = 0L; i < 1000; i++){
			if (i == null) continue;
			String s = i.toString();
		}
		long time3 = System.nanoTime();
		System.out.println("方式二耗时：" + (time3 - time2));
	}

//	public static void main(String[] args) {
//		Long s = null;
//		String a = String.valueOf(s);
//		System.out.println(null == a);
//	}
}
