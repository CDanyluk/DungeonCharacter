package Classes;

public enum Statistics {
	
	//Enums to store and get character information
	//Do not use yet, currently using character hashmaps??
	
	STRENGTH {
		int str = 0;
		@Override
		public int get() {
			return str;
		}
		@Override
		public void change(int i) {
			str = i;	
		}
	}, DEXTERITY {
		int dex = 0;
		@Override
		public int get() {
			return dex;
		}
		@Override
		public void change(int i) {
			dex = i;	
		}
	}, CONSTITUTiON {
		int con = 0;
		@Override
		public int get() {
			return con;
		}
		@Override
		public void change(int i) {
			con = i;	
		}
	}, INTELLIGENCE {
		int intel = 0;
		@Override
		public int get() {
			return intel;
		}
		@Override
		public void change(int i) {
			intel = i;	
		}
	}, WISDOM {
		int wis = 0;
		@Override
		public int get() {
			return wis;
		}
		@Override
		public void change(int i) {
			wis = i;	
		}
	}, CHARISMA {
		int chari = 0;
		@Override
		public int get() {
			return chari;
		}
		@Override
		public void change(int i) {
			chari = i;	
		}
	}, EXPERIENCE {
		int exp = 0;
		@Override
		public int get() {
			return exp;
		}
		@Override
		public void change(int i) {
			exp = i;	
		}
	};

	abstract public int get();
	
	abstract public void change(int i);
}

