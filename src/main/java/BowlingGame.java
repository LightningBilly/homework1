public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
		int[] score = new int[15];
		int[] range = new int[15];

		int i=0;
		int j=0;
		//System.out.println(bowlingCode.length());

		for(;i<10 && j<bowlingCode.length();++j, i++)
		{
			char c = bowlingCode.charAt(j);
			if('X' == c)
			{
				score[i]=10;
				range[i]=2;
				++j;
				for(int k=i-1;k>=0 && k>=i-2; --k)
				{
					if(range[k]>0){score[k]+=score[i]; --range[k];}
				}
			}
			else
			{
				int tmp=0;
				if(Character.isDigit(c))
				{
					score[i]+= c-'0';
					tmp = c-'0';
				}

				
				for(int k=i-1;k>=0 && k>=i-2; --k)
				{
					if(range[k]>0){score[k]+=tmp; --range[k];}
				}

				j++;
				c = bowlingCode.charAt(j);
				
				tmp=0;
				if(Character.isDigit(c))
				{
					score[i]+= c-'0';
					tmp = c-'0';
				}
				else if('/' == c)
				{
					tmp = 10-score[i];
					score[i]=10;
					range[i]=1;
				}
				j++;
				
				for(int k=i-1;k>=0 && k>=i-2; --k)
				{
					if(range[k]>0){score[k]+=tmp; --range[k];}
				}
			}
		}

		for(++j; j<bowlingCode.length(); ++j, ++i)
		{
			char c=bowlingCode.charAt(j);
			//System.out.println(c + " " +j);

			if(Character.isDigit(c))score[i] = c-'0';
			else if('X' == c)score[i]=10;

			for(int k=i-1;k>=0 && k>=i-2; --k)
			{
				if(range[k]>0){score[k]+=score[i]; --range[k];}
			}
		}

		int sum=0;
		for(i=0;i<10;++i)
		{
			//System.out.print(score[i] + " " + range[i]+"\n");

			sum+=score[i];
		}

        return sum;
    }

	/*
	public static void main(String []args)
	{
		//String bowlingCode = "X|X|X|X|X|X|X|X|X|X||XX";           //300

		String bowlingCode = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";  //150

		//String bowlingCode = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";   //90

		//String bowlingCode = "X|7/|9-|X|-8|8/|-6|X|X|X||81";      //167

		int sum = new BowlingGame().getBowlingScore(bowlingCode);
		System.out.println(sum);
	}
	*/

}


