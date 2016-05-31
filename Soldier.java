package baseCase;

public class Soldier {
	int LVL=1;
	int AC,TAC,FAC;
	int BAB,HP,INIT;
	int stat[];
	int statx[]=new int[6];
	String Class,name,atk;
	String feats="Power Attack, Cleave";
	int FORT,REF,WILL;
	public Soldier(){
		stat = rollStats();
		statLogic(stat);
		HP=10+statx[2];
		BAB=1;
		INIT=statx[1];
		AC=16+statx[1];
		TAC=10+statx[1];
		FAC=16;
		FORT=2+statx[2];
		REF=statx[1];
		WILL=statx[4];
		Class="Fighter";
		name=setName();
		atk="Longsword "+"+"+(BAB+statx[0])+" (1d6+"+statx[0]+")";
	}
	public Soldier(String n, int[] stats){
		name=n;
		stat=stats;
		statLogic(stats);
		HP=10+statx[2];
		BAB=1;
		INIT=statx[1];
		AC=16+statx[1];
		TAC=10+statx[1];
		FAC=16;
		FORT=2+statx[2];
		REF=statx[1];
		WILL=statx[4];
		Class="Fighter";
		atk="Longsword "+"+"+(BAB+statx[0])+" (1d6+"+statx[0]+")";
	}
	public int[] rollStats(){
		int[] s = new int[6];
		for(int n=0;n<6;n++)
			s[n]=DieRoller.d(6)+DieRoller.d(6)+DieRoller.d(6);
		return s;
	}
	public void statLogic(int[] s){
		//Priority order: 0,2,1,4,3,5
		int[] base = new int[6];
		for(int n=0;n<6;n++)
			base[n]=s[n];
		int maximum=0;
		int index=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[0]=base[index];
		statx[0]=modifierLogic(stat[0]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[2]=base[index];
		statx[2]=modifierLogic(stat[2]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[1]=base[index];
		statx[1]=modifierLogic(stat[1]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[4]=base[index];
		statx[4]=modifierLogic(stat[4]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[3]=base[index];
		statx[3]=modifierLogic(stat[3]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[5]=base[index];
		statx[5]=modifierLogic(stat[5]);
		base[index]=0;
		maximum=0;
	}
	public String setName(){
		String[] names = {"Aelian","Aemilian","Aemil","Agrippa","Aheno","Alban","Anton","Aquilan",
				"Augusta","Aulan","Aurelan","Avitan","Balbin","Blandan","Blasian","Caecilan",
				"Calian","Caelinian","Cain","Camill","Cassian","Cicero","Cnaeus","Crispin",
				"Deciman","Diocletian","Domitan","Drusan","Ennian","Fabian","Fabrican","Faust",
				"Felix","Festan","Flavian","Florian","Gaius","Gallan","German","Glaucan",
				"Gnaeus","Gordian","Hadrian","Hilar","Horace","Hortense","Jovian","Julian",
				"Juvenal","Laelian","Laurence","Livian","Longinian","Lucan","Luchi","Lucian",
				"Lucretian","Manian","Manlian","Marcellan","Marcan","Marcus","Marian","Martial",
				"Martin","Maxan","Naevian","Nero","Nonan","Octavian","Ovid","Otho","Paul","Petron",
				"Plinian","Pompon","Pontin","Porcian","Publian","Quint","Quintan","Regulan",
				"Rufus","Sabine","Saturn","Scaevol","Secund","Senecan","Septim","Sergian","Servum",
				"Severus","Sextilian","Silvanian","Tacitan","Tatian","Trajan","Tullian","Valens",
				"Valentian","Valerian","Varian","Vergil","Virgian","Vespasian","Vibian","Vitan"
		};
		return names[DieRoller.d(names.length-1)]+" "+names[DieRoller.d(names.length-1)];
	}
	public int modifierLogic(int x){
		return (int)Math.floor(((double)(x-10))/2);
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return "Name: "+name+"\n"+
			   "Class: "+Class+" "+LVL+"\n"+
			   "HP: "+HP+"\n"+
			   "Initiative: "+INIT+"\n"+
			   "AC: "+AC+"\n"+
			   "BAB: "+BAB+"\n\n"+
			   "Attack: "+atk+"\n\n"+
			   "Str: "+stat[0]+", "+statx[0]+"\n"+
			   "Dex: "+stat[1]+", "+statx[1]+"\n"+
			   "Con: "+stat[2]+", "+statx[2]+"\n"+
			   "Int: "+stat[3]+", "+statx[3]+"\n"+
			   "Wis: "+stat[4]+", "+statx[4]+"\n"+
			   "Cha: "+stat[5]+", "+statx[5]+"\n\n"+
			   "Saves: "+"Fort +"+FORT+", Ref +"+REF+", Will +"+WILL+"\n\n"+
			   "Feats: "+feats;
	}
}
