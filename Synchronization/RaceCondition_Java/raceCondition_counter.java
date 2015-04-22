 class AppThreads extends Thread{
 	
 	protected Counter counter = null;
 	
 	void setCounter(Counter _counter){
        this.counter = _counter;
     }
 	 
 	public void run(){
 		//synchronized(counter)
 		{
 			for(int i=0; i<10000; i++)
 			 	counter.incCounter();
 		}
 	}	
 }
 
 class Counter{
     
		private long counter = 0;
		
		public long getCounter(){
			return counter;
		}

		//public synchronized void incCounter(){
		public void incCounter(){
		 this.counter ++;
		}
 }
 
 
 class App{
 
 	public static void main(String[] args){
 	
 		Counter counter = new Counter();;
 		AppThreads[] appthreads = new AppThreads[1000];
 		for(int i=0; i<appthreads.length; i++){
 			appthreads[i] = new AppThreads();
 			appthreads[i].setCounter(counter);
 			appthreads[i].start();
 		}
 		
 		try{
 			for(int i=0; i< appthreads.length; i++){
 				appthreads[i].join();
 			}
 		}catch(InterruptedException e){
 			e.printStackTrace();
 		}
 		
 		System.out.println("\nCounter value is: "+counter.getCounter() +"\n");
 	}
 }
