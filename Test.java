package baseCase;

public class Test {
	static DieRoller d = new DieRoller();
	static boolean fist=false;
	public static void main(String[] args){
		Soldier a = new Soldier();
		System.out.println(a+"\n\n");
		Soldier b = new Soldier();
		System.out.println(b+"\n\n");
		System.out.println("************************");
		System.out.println("Initiative\n");
		int aIn=d.d(20)+a.INIT;
		int bIn=d.d(20)+b.INIT;
		while(bIn==aIn){
			bIn=d.d(20)+b.INIT;
		}
		System.out.println(a.getName()+" rolled a " +aIn);
		System.out.println(b.getName()+" rolled a " +bIn);
		if(aIn>bIn){
			System.out.println(a.getName()+" takes the initiative and strikes first.\n\n");
			fist=true;
		}
		else
			System.out.println(b.getName()+" takes the initiative and strikes first.");
		while(a.HP>0&&b.HP>0){
			if(fist){
				if(a.BAB+a.statx[0]+d.d(20)>b.AC)
					b.HP-=(d.d(6)+a.statx[0]);
			System.out.println(b.HP);
			}
			if(b.BAB+b.statx[0]+d.d(20)>a.AC)
				a.HP-=(d.d(6)+b.statx[0]);
			System.out.println(a.HP);
			if(a.BAB+a.statx[0]+d.d(20)>b.AC)
				b.HP-=(d.d(6)+a.statx[0]);
			System.out.println(b.HP);
		}
		if(a.HP<0)
			System.out.println(b.getName()+" has slain "+a.getName()+" and won!");
		else
			System.out.println(a.getName()+" has slain "+b.getName()+" and won!");
	}
}
