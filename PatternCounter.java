import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PatternCounter {

	public static void main(String [] args) {
		String file_name = args[0];
		int num_words =  Integer.parseInt(args[1]);
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file_name));

            String curr_line;
            List<String> a = new ArrayList<String>();
            while ((curr_line = br.readLine()) != null) {
            	//System.out.println(curr_line);
            	curr_line = curr_line.toLowerCase().replaceAll("/[.\":*?<>{}]/g", "").replace(".","");
                Collections.addAll(a,curr_line.split(" "));
            }
            patternFreq(a, num_words);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                	br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}

	private static void patternFreq(List<String> a, int num_words) {
		// TODO Auto-generated method stub
		int i =0, len = a.size(), wordcount = num_words;
		Map<String,Integer> freq_map= new HashMap<String, Integer>(); 
		String temp ="";
		while(i < a.size()) {
			temp="";
			int c = i+num_words, j=i;
			while(j<c && c<=a.size()) {
				temp = temp+" "+ a.get(j++);
			}
			wordcount = num_words;
			
			if(temp!="") {
			if(freq_map.containsKey(temp)) {
				freq_map.put(temp, freq_map.get(temp)+1);
			}
			else
				
				freq_map.put(temp, 1);
			}
			i++;
		}
		for(Entry<String,Integer> res: freq_map.entrySet()) {
			System.out.println(res.getKey()+": "+res.getValue() );
		}
		
	}
	
}
