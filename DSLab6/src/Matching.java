import java.io.*;


public class Matching
{
	public static AVLtree[] ht = new AVLtree[100]; 

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
				System.out.println("�Է��� �߸��Ǿ����ϴ�. ���� : " + e.toString());
			}
		}
		System.exit(0);
	}


	private static void command(String input) throws FileNotFoundException, IOException
	{
		 for(int i = 0 ; i < 100 ; i++){
			 ht[i] = new AVLtree();
		 }

		if(input.charAt(0) == '?'){
			String[] string_arg = input.split(" ");
			String pattern = string_arg[1];
			int sum = 0;
			
			for(int i = 0; i < 6; i++){
				sum += pattern.charAt(i);
			}
			
			int idx = sum % 100;
			ht[idx].preorder();;
		
		}else if(input.charAt(0) == '@')
		{
			String[] string_arg = input.split(" ");
			int idx = Integer.parseInt(string_arg[1]);
			ht[idx].preorder();
			
		}else if(input.charAt(0) == '<')
		{
			String[] string_arg = input.split(" ");
			String file = string_arg[1];
			// �̰� ��¼��
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
				for(int l = 0 ; l < S[j].length() - 5 ; l++)
				{
					sum = 0;
					sub_string = S[j].substring(l, l+5);
					for(int k = 0; k < sub_string.length() ; k++){
						sum += S[j].charAt(l+k);
					}
					hash_idx = sum % 100;
					Pos p = new Pos(j,l);
					ht[hash_idx].insert(p);					
				}
			}
			
			}
			}
		
		}
	