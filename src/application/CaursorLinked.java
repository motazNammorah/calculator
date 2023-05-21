package application;

public class CaursorLinked {
	 static int Header;
	 static 	CursorNode[] cursorSpace;
	 static int spaceSize=100; 
	static {
		
		
		
		
		cursorSpace=new CursorNode[spaceSize];
		for(int i=0;i<spaceSize;i++){
			cursorSpace[i]=new CursorNode(null, i+1);
		}
		cursorSpace[spaceSize-1].next=0;
	}
	public static int alloc() {
		int p=cursorSpace[0].next;
		cursorSpace[0].next=cursorSpace[p].next;
		
		if(p==0) {
			throw new OutOfMemoryError();
		}
		else {
			cursorSpace[p].next=0;
		}
		return p;
	}

	public CaursorLinked() {
	Header=alloc();
	}

	
	public static void insert(String obj ,int p) {
		if(p==0) {
			System.out.println("Out of space!! ");
			return ;
		}
		else {
			int temp=alloc();
			int pos=p;
			cursorSpace[temp].elemnt=obj;
			cursorSpace[temp].next=cursorSpace[pos].next;
			cursorSpace[pos].next=temp;
		}
		
		
	}
	public static boolean isEmpity(int h) {
	return cursorSpace[h].next==0;
	}
	

	static public void printList(int header)
	{
		if( isEmpity(header ) )
			System.out.print( "Empty list" );
		else
		{
			int current = cursorSpace[header].next;
			while (current != 0)
			{
				
				current = cursorSpace[current].next;
			}
		}
		System.out.println( );
	}
	

	public static int find(int header) {
		int current=cursorSpace[header].next;
		int i=2;
		while(current!=0) {
			current=cursorSpace[current].next;
			i++;
		}
		return i;
		
	}
	public static Object remove(String x,int header) {
		int p=findPrevious(x, header);
	
		if(!isLast(p)) {
		
			int temp=cursorSpace[p].next;
			Object Z =cursorSpace[temp].elemnt;
			cursorSpace[p].next=cursorSpace[temp].next;
			free(temp);
		return Z;
			
		}
		return null;
		
	}
	
	public static Object deleatLast(int p) {
		int n=findPrevious(cursorSpace[p].elemnt, Header);
		if(!isLast(n)  ) {
			int temp=cursorSpace[n].next;
			Object v=cursorSpace[temp].elemnt;
			cursorSpace[p].next=cursorSpace[p].next;
			free(temp);
			return v;
		}
		return null;
	}
	
	
	public static void free(int p){
		cursorSpace[p].elemnt=null;
		cursorSpace[p].next=cursorSpace[0].next;
		cursorSpace[0].next=p;
		
	}
	public static boolean isLast(int p) {
		return cursorSpace[p].next==0;
	}
	public static int findPrevious(String x,int header) {
		int current=header;
		while(cursorSpace[current].next!=0&&!cursorSpace[cursorSpace[current].next].elemnt.equals(x)) {
			current=cursorSpace[current].next;
		}
		return current;
	}
	
	
	public static void makeEmpity(int header) {
		int current=cursorSpace[header].next;

		while(current!=0) {
		
			cursorSpace[current].elemnt=null;
			current=cursorSpace[current].next;
		}
		
	}
	
	
	
	


}
