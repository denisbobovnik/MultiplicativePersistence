import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podajte, do koliko multiplikacij naj gre iskano število: ");
		String in = scanner.nextLine();		
		
		long stMultiplikacij;
		try {
			stMultiplikacij = Long.parseLong(in);
		} catch (Exception e) {
			System.out.println("\nNeveljaven vnos");
			return;
		}
		
		if(stMultiplikacij<0) {
			System.out.println("\nNeveljaven vnos");
			return;
		}
		
		boolean pogoj = false;
		long iskanoStevilo = 0;
		
		System.out.println();
		
		long i = 0;
		while(!pogoj) {
			if(vrniSteviloZmnoskov(i) == (stMultiplikacij)) {
				pogoj = true;
				iskanoStevilo = i;
			}
			if(i%10000000 == 0)
				System.out.println("Zdaj smo pri številu: " + i);
			
			if(i<Long.MAX_VALUE)
				i++;
			else {
				System.out.println("\nPrišli smo do mej programa. Števila žal ni mogoče najti.");
				return;
			}
		}
		System.out.println();
		System.out.println("Najdeno stevilo: " + iskanoStevilo);
		
		System.out.println("\nIzračun");
		narediIzracun(iskanoStevilo);
	}
	
	public static long vrniSteviloZmnoskov(long vhod) {
		String stText = vhod + "";
		long steviloMnozenj = 0;
		while(stText.length()>1) {
			long vmesniZmnozek = 1;
			for(int j=0; j<stText.length(); j++)
				vmesniZmnozek *= Long.parseLong(stText.charAt(j)+"");
			vhod = vmesniZmnozek;
			stText = vhod+"";
			steviloMnozenj++;
		}
		return steviloMnozenj;
	}
	
	public static void narediIzracun(long vhod) {
		String stText = vhod + "";
		while(stText.length()>1) {
			long vmesniZmnozek = 1;
			System.out.print(vhod + " = ");
			for(int j=0; j<stText.length(); j++) {
				vmesniZmnozek *= Long.parseLong(stText.charAt(j)+"");
				
				System.out.print(stText.charAt(j));
				
				if(j<stText.length()-1)
					System.out.print("*");
			}
			System.out.println(" = " + vmesniZmnozek);
			vhod = vmesniZmnozek;
			stText = vhod+"";
		}
	}
}