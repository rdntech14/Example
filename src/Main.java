import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String inputfile = System.getProperty("user.dir") + "/Assignment/input.csv";
		String outputfile = System.getProperty("user.dir") + "/Assignment/output.csv";

		String delimiter = ",";
		String lines;
		String firstLine = "";
		String[] wordsArray;
		String output = "";

		// verify path exist other terminate program with proper message
		File f = new File(inputfile);
		if (!f.exists()) {
			System.out.println("file path " + inputfile + " is invalid");
			System.out.println("output : file path is invalid");
			System.exit(0);
		} else {
			System.out.println("input path : " + inputfile);
			System.out.println("output path : " + outputfile);
		}

		// read input file
		BufferedReader br = new BufferedReader(new FileReader(inputfile));
		StringBuilder sbLines = new StringBuilder();
		while ((lines = br.readLine()) != null) {
			sbLines.append(lines);
		}

		//terminate program if file is empty 
		if (sbLines.length() == 0) {
			System.out.println("output : file is empty");
			System.exit(0);
		}

		lines = sbLines.toString();

		System.out.println("input file content : " + lines);

		// use newline as delimiter to make sure single line is captured
		firstLine = lines.split("\r?\n")[0];
		
		//terminate program if file is having only spaces 
			if (firstLine.trim().length() == 0) {
			System.out.println("output : singleline is having only spaces");
			System.exit(0);
		}
		
		// use comma as delimiter
		wordsArray = firstLine.split(delimiter);
		
		if(wordsArray.length==0){
			System.out.println("output : singleline has only comma symbol");
			System.exit(0);
		}
		
		//terminate program if any word is having special character or having no character/space
		for (String s : wordsArray) {
			if (s.trim().length() == 0) {
				System.out.println("output : singleline contains BLANK word");
				System.exit(0);
			} else if (!s.matches("[a-zA-Z].*")) {
				System.out.println("output : singleline words contains non alphabet");
				System.exit(0);
			}
		}

		System.out.println("input file content in array " + Arrays.toString(wordsArray));

		// reverse order of the words Array
		Arrays.sort(wordsArray, Collections.reverseOrder());
		System.out.println("array in descending order : " + Arrays.toString(wordsArray));

		StringBuilder sbOutput = new StringBuilder();

		for (int i = 0; i < wordsArray.length; i++) {
			sbOutput.append(wordsArray[i]);
			if (i != wordsArray.length - 1) {
				sbOutput.append(",");
			}
		}

		output = sbOutput.toString();
		System.out.println("output in string : " + output);

		
		
		// write output to file
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile));
		bw.write(output, 0, output.length());
		bw.flush();
		System.out.println("output : words are sorted successfully");
		bw.close();
	}

}


