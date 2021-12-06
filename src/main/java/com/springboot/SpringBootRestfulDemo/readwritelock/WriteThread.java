package com.springboot.SpringBootRestfulDemo.readwritelock;

/**
 * @author yan
 * @desc WriteThread
 * @date 2021/11/15
 */
class WriteThread extends Thread {
    private ReadWriteTool writeTool;

    public WriteThread(ReadWriteTool writeTool)
    { this.writeTool = writeTool; }

    public void run()
    { writeTool.write();	}
}
