package com.base.thread.tradition;
/**
 * 
 * 当一个线程访问object的一个synchronized(this)同步代码块时，
 * 其他线程对object中所有其它synchronized(this)同步代码块的访问不会被阻塞
 *
 */
public class SynchronizedDemo {
	
    private boolean ready = false;
    private int result = 0;
    private int number = 1;   
    
    public void write(){
    	ready = true;	      				 //1.1				
    	number = 2;		                    //1.2			    
    }
    
    public void read(){			   	 
    	if(ready){						     //2.1.
    		result = number*3;	 	//2.2
    	}   	
    	System.out.println("result:" + result);
    }

    
    private class ReadWriteThread extends Thread {
    	
    	private boolean flag;
    	public ReadWriteThread(boolean flag){
    		this.flag = flag;
    	}
        @Override                                                                    
        public void run() {
        	if(flag){       		
        		write();
        	}else{       		
        		read();
        	}
        }
    }

    public static void main(String[] args)  {
    	SynchronizedDemo synDemo = new SynchronizedDemo();
    	
    	synDemo.new ReadWriteThread(true).start();
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	synDemo.new ReadWriteThread(false).start();
    }
}