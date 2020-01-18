/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakingschedule;
import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

/**
 *
 * @author Joshua
 */
public class fileReader {
    String fName;
    String[] rawData;
    String[][] teamInfo;
    String parkInfo;
    String startDate;
    String endDate;
    String matchNum;


    public void getName(String name){
        fName=name;
        fName=name+".txt"; // got to make it so it checks to see if .txt is on it
    }


    public void fileRead(){

        try{
            File dataFile=new File(fName);
            System.out.println(dataFile);
            Scanner arrayLength=new Scanner(dataFile);
            int numLine=0;

            while(arrayLength.hasNextLine()){
                numLine++;
                arrayLength.nextLine();
            }
            arrayLength.close();
            System.out.println("The number of lines are: " + numLine);
            rawData = new String[numLine];

            Scanner storeData=new Scanner(dataFile);
            int count=0;

            while(storeData.hasNextLine()){
                rawData[count]=storeData.nextLine();
                count++;
            }
            storeData.close();

        }
        catch(FileNotFoundException e){
            System.out.println("Invalid File");
        }

        for(int i = 0; i<13; i++) {
            System.out.println(rawData[i]);
        }

    }

    public void sort(){
        int numTeam;
        String[] teamNum=new String[2];
        teamNum=rawData[0].split("/");
        System.out.println("Team Num: "+teamNum[1]);
        numTeam=Integer.valueOf(teamNum[1]);
        int max=0;
        int count=0;
        /*String tempHolder= lineStore[4].replace("/", "0");
        System.out.println("new line store: " +tempHolder);
        System.out.print("true/false: ");
        System.out.println( tempHolder.indexOf("/")!=-1);*/
        int[] splitter=new int[numTeam];
        for(int x=3;x<3+numTeam;x++){
            String tempHolder=rawData[x];
            while(tempHolder.indexOf("/")!=-1){
                tempHolder=tempHolder.replaceFirst("/", "0");
                count++;;
                System.out.println("Looping");
            }
            splitter[x-3]=count;
            System.out.println(count);
            if (count>max){
                max=count;
            }
            count=0;
        }
        System.out.println("text splittiung");
        for(int x=0;x<numTeam;x++){
            System.out.println(splitter[x]);
        }
        System.out.println("text splittiung");
        System.out.println(max);
        teamInfo=new String[numTeam][max+2];
        for(int x=0;x<numTeam;x++){
            teamInfo[x][max+1]=String.valueOf(splitter[x]);
        }
        for(int x=3;x<3+numTeam;x++){
            teamInfo[x-3]=rawData[x].split("/");
            //System.out.println(lineStore[x]);
        }
        for(int x=0;x<numTeam;x++){
            // System.out.println("changing line");
            System.out.println(splitter[x]+1);
            for(int y=0;y<splitter[x]+1;y++){
                // System.out.println("Spot");
                System.out.println(teamInfo[x][y]);
            }
        }
    }
}
