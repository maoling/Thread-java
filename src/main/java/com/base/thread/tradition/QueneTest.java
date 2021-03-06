package com.base.thread.tradition;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class QueneTest {

	public static void main(String[] args) {
		//final Semaphore semaphore = new Semaphore(1);
		//final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		
		final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
		
		for(int i=0;i<4;i++){
			new Thread(new Runnable(){
				@Override
				public void run(){	
					while(true){
						try {
							//semaphore.acquire();
							String input = queue.take();
							String output = TestDo.doSome(input);
							System.out.println(Thread.currentThread().getName()+ "已经处理了:" +"日志任务"+ output);
							//semaphore.release();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						
					}		
				}
			}).start();
		}
		
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		for(int i=0;i<16;i++){  //这行不能改动
			String input = i +" ";  //这行不能改动
			try {
				queue.put(input);
				System.out.println("日志任务"+(i)+"已经被放入队列中:");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//不能改动此TestDo类
class TestDo {
	public static String doSome(String input){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String output = input + ":"+ (System.currentTimeMillis() / 1000);
		return output;
	}
}
