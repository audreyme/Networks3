import java.io.*;
import java.net.*;
import java.lang.Thread;

class Server3
{
  public static void main(String args[]) throws Exception
  {
    ServerSocket welcomeSocket = new ServerSocket(51234);

    Socket connection = welcomeSocket.accept();

    BufferedReader inFromClient = new BufferedReader(new
      InputStreamReader(connectionSocket.getInputStream()));

    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

    BoolFlag flag = new BoolFlag();
    Thread1 thread1 = new Thread1(flag);
    Thread2 thread2 = new Thread2(flag);

    thread1.start();
    thread2.start();

  }
}

class Thread1 extends Thread
{

  public thread1(BoolFlag f, BufferedReader keyboardInput, DataOutputStream outToClient){
    this.f = f;
    this.keyboardInput = keyboardInput;
    this.outToClient = outToClient;
  }//constructor

  public start(){
    run();
  }

  private run(){
    //KEYBOARD AND TRANSMISSION
    //BULK OF CODE HERE
    while(outbound != "EXITEXIT"){
      outbound = inFromUser.readLine();
      outToClient.writeBytes(outbound + '\n');
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
    private String inbound;

    do{
      inbound = inFromClient.readLine();
      System.out.println("FROM CLIENT: " + inbound);
    while(inbound!="EXITEXIT")
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