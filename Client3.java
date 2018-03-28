import java.io.*;
import java.net.*;
import java.lang.Thread;

class Client3
{
  public static void main(String args[]) throws Exception
  {
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

      Socket clientSocket = new Socket("cisone.sbuniv.edu",51234);

      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

      BufferedReader inFromServer = new BufferedReader(new
        InputStreamReader(clientSocket.getInputStream()));

      BoolFlag flag = new BoolFlag();
      Thread1 thread1 = new Thread1(flag, inFromUser, outToServer );
      Thread2 thread2 = new Thread2(flag);
      thread1.start();
      thread2.start();

  }
}

class Thread1 extends Thread
{

  public thread1(BoolFlag f, BufferedReader keyboardInput, DataOutputStream outToServer){
    this.f = f;
    this.keyboardInput = keyboardInput;
    this.outToServer = outToServer;
  }//constructor

  public start(){
    run();
  }

  private run(){
    //KEYBOARD AND TRANSMISSION
    //BULK OF CODE HERE
    private String exitingChat;
    do{
      exitingChat = inFromUser.readLine();
      outToServer.writeBytes(exitingChat + '\n');
    while(exitingChat != "EXITEXIT")
    }
  }
}


class Thread2 extends Thread
{
  public thread2(Flag f){
    this.f=f;
  }

  public start(){
    run();
  }

  private run(){
    //BULK OF CODE
    //SOCKETS AND PRINTING
    private String incomingChat;

    while(incomingChat != "EXITEXIT"){
      incomingChat = inFromServer.readLine();
      System.out.println("FROM SERVER: " + incomingChat);
    }
  }
}

class BoolFlag
{
  public createFlag(){
    boolean continue = true;
  }

  public setFlag(boolean value){
    continue = value;
  }

  public getFlag(){
    return continue;
  }
}