package tuf;

public class mainTUFprogram {

	public static void main(String[] args) {
		String filename = "TUFinput.txt";
		modbusParser parsed = new modbusParser(filename);
		
		System.out.println(parsed.dateAndTime+"\n");
		System.out.println("flowrates: "+parsed.flowRate +" m^3/h");
		System.out.println("energy flow rate: "+parsed.eFlowRate+" GJ/h");
		System.out.println("speed: "+parsed.velocity+ " m/s");
		System.out.println("fluid sound speed: "+parsed.fluidSoundSpeed+" m/s");
		
		System.out.println("\npositive accumulator: "+parsed.pAccumulator);
		System.out.println("positive decimal fraction: "+parsed.pDecimalFraction);
		System.out.println("negative accumulator: "+parsed.nAccumulator);
		System.out.println("negative decimal fraction: "+parsed.nDecimalFraction);
		
		System.out.println("\npositive energy accumulator: "+parsed.peAccumulator);
		System.out.println("positive energy decimal fraction: "+parsed.peDecimalFraction);
		System.out.println("negative energy accumulator: "+parsed.neAccumulator);
		System.out.println("negative energy decimal fraction: "+parsed.neDecimalFraction);
		
		System.out.println("\ntemp 1 inlet: "+parsed.temperature1in+" C");
		System.out.println("temp 2 outlet: "+parsed.temperature2out+" C");
		
		System.out.println("\nanalog inputAI3: "+parsed.analogInputAI3);
		System.out.println("analog inputAI4: "+parsed.analogInputAI4);
		System.out.println("analog inputAI5; "+parsed.analogInputAI5);
		
		System.out.println("\ncurrent Input AI3: "+parsed.currentInputAI3+" mA");
		System.out.println("current Input AI4: "+parsed.currentInputAI4+" mA");
		System.out.println("current Input AI5: "+parsed.currentInputAI5+" mA");
		
		System.out.println("\nPT100 resistance of inlet: "+parsed.PT100Inlet+" Ohm");
		System.out.println("PT100 resistance of outlet: "+parsed.PT100Outlet+" Ohm");
		
		System.out.println("\nTotal travel time: "+parsed.totalTravelTime+" micro seconds");
		System.out.println("Delta travel time: "+parsed.deltaTravelTime+" micro seconds");
		System.out.println("Upstream travel time: "+parsed.upstreamTravelTime+" micro seconds");
		System.out.println("Downstream travel time: "+parsed.downstreamTravelTime+" micro seconds");
		
		System.out.println("\nOutput current: "+parsed.outputCurrent+" mA");
		System.out.println("working step: "+parsed.workingStep);
		System.out.println("signal quality: "+parsed.signalQuality);
		
		System.out.println("Language: "+parsed.languageUsedInInterface);
		System.out.println("Measured travel time: "+parsed.measuredTravelTIme);
		System.out.println("Reynolds number: "+parsed.reynoldsNumber);
	}

}
