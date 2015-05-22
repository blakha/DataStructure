import java.io.*;


public class Matching
{
	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true)
		{
			try
			{
				String input = br.readLine();
				if (input.compareTo("QUIT") == 0)
					break;

				command(input);
			}
			catch (IOException e)
			{
				System.out.println("입력이 잘못되었습니다. 오류 : " + e.toString());
			}
		}
	}
	
	private static AVLTree[] hash_table = new AVLTree[100]; 

	private static void command(String input) throws FileNotFoundException, IOException
	{
		if(input.charAt(0) == '?'){
			String[] string_arg = input.split(" ");
			String pattern = string_arg[1];
			int sum = 0;
			
			for(int i = 0; i < 6; i++){
				sum += pattern.charAt(i);
			}
			
			int idx = sum % 100;
			hash_table[idx].inorder();
		
		}else if(input.charAt(0) == '@')
		{
			String[] string_arg = input.split(" ");
			int idx = Integer.parseInt(string_arg[1]);
			hash_table[idx].inorder();
			
		}else if(input.charAt(0) == '<')
		{
			String[] string_arg = input.split(" ");
			String file = string_arg[1];
			// 이거 어쩌냐
			String[] S = new String[10];
			int i = 0;
			
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			    	S[i] = line;
			    	i++;
			    }
			}
			
			int line_num = i;
						
			int hash_idx = 0;
			int sum = 0;
			String sub_string = null;
			
			for(int j = 0; j < line_num ; j++){
				for(int l = 0 ; l < S[j].length() - 5 ; j++)
				{
					sum = 0;
					sub_string = S[j].substring(l, l+5);
					for(int k = 0; k < sub_string.length() ; k++){
						sum += S[j].charAt(l+k);
					}
					hash_idx = sum % 100;
					hash_table[hash_idx].insert(new Pos(i,j));					
				}
			}
			}
			}
		
		}
	