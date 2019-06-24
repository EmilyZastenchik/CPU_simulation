import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Instruction {

	private String term;
	private int [] pgtable;
	private int [] memframe;
	private int amt;
	private int RAM;
	private int PAGESIZE;
Instruction(String name) throws IOException{
		File file = new File(name);
		if(file.exists()) {
			FileReader fileread = new FileReader(name);
			StreamTokenizer tokenize = new StreamTokenizer(fileread);
			tokenize.parseNumbers();
			tokenize.wordChars('a', 'z');
			
	 boolean eof = false;
	// boolean eol = false;
	         do {
	    //while(!eol) {
	            int token = tokenize.nextToken();

	            switch (token) {
	               case StreamTokenizer.TT_EOF:
	                  System.out.println("End of File encountered.");
	                  eof = true;
	                  break;
	                  
	              case StreamTokenizer.TT_EOL:
	                  System.out.println("End of Line encountered.");
	                  //eol = true;
	                  break;
	                  
	              case StreamTokenizer.TT_WORD:
	            	   if(tokenize.sval=="RAM")
	            		   setRAM( tokenize.nextToken());
	            	   else if(tokenize.sval=="PAGESIZE")
	            		   setPAGESIZE(tokenize.nextToken());
	            	   else if (tokenize.sval=="NEW") {
	            		   
	            		   //add process info to vector
	            	   }
	            	   
	            		   
	                  System.out.println("Word: " + tokenize.sval);
	                  
	                  break;
	                  
	               case StreamTokenizer.TT_NUMBER:
	                  System.out.println("Number: " + tokenize.nval);
	                  break;
	                  
	               default:
	                  System.out.println((char) token + " encountered.");
	                  
	                  if (token == '!') {
	                     eof = true;
	                  }
	            }//end switch
	            //}
	            
	         } while (!eof);
}//end if exists
	}
	
	
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public int getRAM() {
		return RAM;
	}
	public void setRAM(int rAM) {
		RAM = rAM;
	}
	public int getPAGESIZE() {
		return PAGESIZE;
	}
	public void setPAGESIZE(int PG) {
		PAGESIZE = PG;
	}
	public int [] getPgtable() {
		return pgtable;
	}
	public void setPgtable(int [] pgtable) {
		this.pgtable = pgtable;
	}
	public int [] getMemframe() {
		return memframe;
	}
	public void setMemframe(int [] memframe) {
		this.memframe = memframe;
	}
	public class Driver {

		
	
		public int totalframes = 0;
		public int allocatedframes = 0;
		public int logaddr = 0;
		public int physaddr = 0;
		
		public int p = 0;
		public int currentvalue = 0;


		/**
		 * @param args
		 * @throws IOException 
		 */
		public void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
		String fileName = null;
		//try {
		//InputStreamReader input = new InputStreamReader(System.in);
		//BufferedReader consoleInput = new BufferedReader(input);
		System.out.println("Enter input file please: ");
		fileName = "memorytrace1.txt";
		//fileName = consoleInput.readLine();
		if(!fileName.endsWith(".txt")) {
			System.out.println("This is not a text file :( ");
			System.exit(0);
		}
		
		
		/*}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();

		}*/
		Instruction instr = new Instruction(fileName);
		
		
		System.out.println("RAM = " + instr.getRAM()+ "pagesize "+instr.getPAGESIZE());
	}//end main
		
		
		
	
}
}
