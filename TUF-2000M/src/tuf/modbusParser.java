package tuf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class modbusParser {
	
	long l;
	public String a;
	public String b;
	
	String dateAndTime;
	float flowRate;
	float eFlowRate;
	float velocity;		
	float fluidSoundSpeed;
	
	long pAccumulator;
	float pDecimalFraction;
	long nAccumulator;
	float nDecimalFraction;
	
	long peAccumulator;
	float peDecimalFraction;
	long neAccumulator;
	float neDecimalFraction;
	
	long netAccumulator;
	float netDecimalFraction;
	long neteAccumulator;
	float neteDecimalFraction;
	
	float temperature1in;
	float temperature2out;
	
	float analogInputAI3;
	float analogInputAI4;
	float analogInputAI5;
	
	float currentInputAI3;
	float currentInputAI4;
	float currentInputAI5;
	
	float PT100Inlet;
	float PT100Outlet;
	float totalTravelTime;
	float deltaTravelTime;
	float upstreamTravelTime;
	float downstreamTravelTime;
	float outputCurrent;
	
	int workingStep;
	int signalQuality;
	
	String languageUsedInInterface;
	
	float measuredTravelTIme;
	float reynoldsNumber;
	public modbusParser(String filename){
		
		Scanner fileScanner = null;
		String fileName = filename;

		String colon = ":" ;
		String[] linesplit = new String[2];

		
		
		//REG 1-10
		
		
		
		try{
			fileScanner = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e){
			System.out.println("Error, file not found.");
			
		}
		catch(Exception e){
			System.out.println("A problem occured during file scanner initialization");
		}
		dateAndTime = fileScanner.nextLine();
		
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			flowRate = registerToReal4(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for flowRate");
		}
	
		
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			eFlowRate = registerToReal4(a,b);
			}
		catch(Exception e){
			System.out.println("An error occured while parsing for EnergyflowRate");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			velocity=registerToReal4(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for velocity");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			fluidSoundSpeed=registerToReal4(a,b);	
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for Fluid Sound Speed");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			pAccumulator=registerToLong(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for positive accumulator");
		}
		
		
		
		//REG 11-20
		
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			pDecimalFraction=registerToReal4(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for positive decimal fraction");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			nAccumulator=registerToLong(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for negative accumulator");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			nDecimalFraction=registerToReal4(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for negative decimal fraction");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			peAccumulator=registerToLong(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for positive energy accumulator");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			peDecimalFraction=registerToReal4(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for positive energy decimal fraction");
		}
		
		
		
		//REG 21-30
		
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			neAccumulator=registerToLong(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for negative energy accumulator");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			neDecimalFraction=registerToReal4(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for negative energy decimal fraction");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			netAccumulator=registerToLong(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for net accumulator");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			netDecimalFraction=registerToReal4(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for net decimal fraction");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			netAccumulator=registerToLong(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for net energy accumulator");
		}
		
		
		
		
		//REG31-40
		
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			netDecimalFraction=registerToReal4(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for net energy decimal fraction");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];		
			temperature1in=registerToReal4(a,b);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for temperature#1inlet");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			temperature2out = registerToReal4(a,b);
			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for temperature#2outlet");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			analogInputAI3 = registerToReal4(a,b);
			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for analog Input AI3");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			analogInputAI4= registerToReal4(a,b);
			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for analog Input AI4");
		}
		
		
		
		//REG 41-50
		
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			analogInputAI5 = registerToReal4(a,b);
			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for analog Input AI5");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			currentInputAI3 = registerToReal4(a,b);
			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for current Input AI");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			currentInputAI4 = registerToReal4(a,b);
			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for current Input AI4");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			currentInputAI5 = registerToReal4(a,b);
			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for current Input AI5");
		}
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);

			linesplit = fileScanner.nextLine().split(colon);

			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for System password");
		}
		
		
		//REG 51-60
		
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);

			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for hardware password");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);

			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for register 52");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			linesplit = fileScanner.nextLine().split(colon);
			linesplit = fileScanner.nextLine().split(colon);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for calendar");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for dayhour autosave");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);		
			linesplit = fileScanner.nextLine().split(colon);	
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for registers 57-58");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for Key to input");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for go to window #");
		}
		
		
		
		
		//REG 61-70
		
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for LCD backlight time");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for beeper time and remaining OCT pulses");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);		
			linesplit = fileScanner.nextLine().split(colon);	
			linesplit = fileScanner.nextLine().split(colon);	
			linesplit = fileScanner.nextLine().split(colon);	
			linesplit = fileScanner.nextLine().split(colon);	
			linesplit = fileScanner.nextLine().split(colon);	
			linesplit = fileScanner.nextLine().split(colon);	
			linesplit = fileScanner.nextLine().split(colon);	
			linesplit = fileScanner.nextLine().split(colon);	
			
			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing registers 63-71");
		}
		
		
		
		
		//REG 72-80
		
		
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);		
		}
		catch(Exception e){
			System.out.println("An error occured while parsing for Error code");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);		
			linesplit = fileScanner.nextLine().split(colon);	
			linesplit = fileScanner.nextLine().split(colon);	
			linesplit = fileScanner.nextLine().split(colon);	
		}
		catch(Exception e){
			System.out.println("An error occured while parsing registers 73-76");
		}
		
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			PT100Inlet= registerToReal4(a,b);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing PT100 resistance of inlet");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			PT100Outlet= registerToReal4(a,b);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing PT100 resistance of outlet");
		}
		
		
		
		//REG 81-90
		
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			totalTravelTime= registerToReal4(a,b);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing total travel time");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			deltaTravelTime= registerToReal4(a,b);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing delta travel time");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			upstreamTravelTime= registerToReal4(a,b);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing upstream travel time");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			downstreamTravelTime= registerToReal4(a,b);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing downstream travel time");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			outputCurrent= registerToReal4(a,b);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing Output current");
		}
		
		
		
		//REG 91-100
		
		
		
		
		try{
			linesplit = fileScanner.nextLine().split(colon);
		
		}
		catch(Exception e){
			System.out.println("An error occured while parsing reg 91");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			workingStep = firstHalfOfReg(a);
			signalQuality = secondHalfOfReg(a);
			
		
		}
		catch(Exception e){
			System.out.println("An error occured while parsing working step and signal quality");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];		
		}
		catch(Exception e){
			System.out.println("An error occured while parsing upstream Strength");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
		
		}
		catch(Exception e){
			System.out.println("An error occured while parsing downstream Strength");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];	
			if(a.equals("1")){
				languageUsedInInterface = "Chinese";
			}
			else if(a.equals("0")){
				languageUsedInInterface = "English";
			}
			else{
				languageUsedInInterface = "error";
			}
		}
		catch(Exception e){
			System.out.println("An error occured while parsing interface language");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			measuredTravelTIme= registerToReal4(a,b);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing measured travel time");
		}
		try{
			linesplit = fileScanner.nextLine().split(colon);
			a=linesplit[1];
			linesplit = fileScanner.nextLine().split(colon);
			b=linesplit[1];
			reynoldsNumber= registerToReal4(a,b);			
		}
		catch(Exception e){
			System.out.println("An error occured while parsing Reynolds number");
		}
	}	
	
	
	
	

	
	
	
	
	
	
	private float registerToReal4(String a, String b){

		int dec1;
		int dec2;
		int decsum=0;
		float REAL4=0;
		int sign=1;
		dec1=Integer.parseInt(a);
		dec2 = Integer.parseInt(b);
		if(dec1 == 0 && dec2 == 0){
			return REAL4;
		}
		
		String bina = Integer.toBinaryString(dec1);
		String binb = Integer.toBinaryString(dec2);

		
		while(bina.length()<16){
			bina="0"+bina;
		}
		while(binb.length()<16){
			binb="0"+binb;
		}
		String binsum = binb+bina;
		
		if(binsum.charAt(0)=='1'){
			sign=-1;
			binsum = "0"+binsum.substring(1, 32);
		}
		decsum = Integer.parseInt(binsum,2);
		REAL4 = (float)sign*Float.intBitsToFloat(decsum);

		return REAL4;
	}

	private long registerToLong(String a, String b){

		int dec1;
		int dec2;
		String bin1;
		String bin2;
		String binlong;
		long converted;
		int sign;
		int i;
		int bin1length;
		int bin2length;
		
		
		dec1 =Integer.parseInt(a);
		dec2 =Integer.parseInt(b);;
		bin1 = Integer.toBinaryString(dec1);
		bin2 = Integer.toBinaryString(dec2);
		if(dec1 == 0 && dec2 == 0){
			return (long)0;
		}
		bin1length=bin1.length();
		bin2length=bin2.length();
		
		if(bin1.charAt(0)=='1'){
			sign = -1;
		}
		else{
			sign = 1;
		}
		
		if(bin1.length()<16){
			for(i = 0;i+bin1length<16;i++){
				bin1="0"+bin1;
			}
		}
		if(bin2.length()<16){
			for(i = 0;i+bin2length<16;i++){
				bin2="0"+bin2;
			}
		}
		if(bin2.charAt(0)=='1'){
			sign = -1;
		}
		else{
			sign = 1;
		}

		bin1 = bitFlipper(bin1);
		bin2 = bitFlipper(bin2);
		binlong = bin2+bin1;
		converted = Long.parseLong(binlong,2);
		converted = sign*(converted+1);

		return converted;
	}
	public static String bitFlipper(String bin){
		int blength=bin.length();
		String binflipped = "";
		
		for(int a=0;a<blength;a++){
			
			if(bin.charAt(a)=='1'){
				binflipped+="0";
			}
			else if(bin.charAt(a)=='0'){
				binflipped+="1";
			}
			else{
				System.out.println("Error, not a binary sequence");
				return bin;
			}
			
		}	
		return binflipped;
	}
	public static int firstHalfOfReg(String a){
		int temp = Integer.parseInt(a);
		String binwhole = Integer.toBinaryString(temp);
		if(binwhole.length()<16){
			for(int i = 0;binwhole.length()<16;i++){
				binwhole="0"+binwhole;
			}
		}
		String firstbin = binwhole.substring(0,binwhole.length()/2);
		int firstHalf = Integer.parseInt(firstbin,2);;
		return firstHalf;
	}
	public static int secondHalfOfReg(String a){
		int temp = Integer.parseInt(a);
		String binwhole = Integer.toBinaryString(temp);
		if(binwhole.length()<16){
			for(int i = 0;binwhole.length()<16;i++){
				binwhole="0"+binwhole;
			}
		}
		String secondbin = binwhole.substring(binwhole.length()/2,binwhole.length());
		int secondHalf = Integer.parseInt(secondbin,2);;
		return secondHalf;
	}	
	
}
