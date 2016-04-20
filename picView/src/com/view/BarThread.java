package com.view;



    
   public  class BarThread extends Thread {
    private static int DELAY = 200;


    public BarThread() {

    }

    public void run() {
      int minimum = 1;
      int maximum = 100;
      for (int i=minimum; i<maximum; i++) {
    	  

         try {
			Thread.sleep(DELAY);
		 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
      }

      }
  }

