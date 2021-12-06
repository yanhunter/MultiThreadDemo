package com.springboot.SpringBootRestfulDemo.readwritelock;

/**
 * @author yan
 * @desc ReadThread
 * @date 2021/11/15
 */
public class ReadThread extends Thread{

    private ReadWriteTool readTool;

		public ReadThread(ReadWriteTool readTool)
	    { this.readTool = readTool;	}

		public void run()
	    { readTool.read();}
	}


