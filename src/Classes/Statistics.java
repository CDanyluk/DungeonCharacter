package Classes;

public enum Statistics {
	
	/*	Honestly stats and information feels mutable to me...?
	So all enums are a mess until I figure out what needs
	to be stored
	*/
	
	STRENGTH {
		@Override
		public String message() {
			return "str";
		}
	}, DEXTERITY {
		@Override
		public String message() {
			return "dex";
		}
	}, CONSTITUTiON {
		@Override
		public String message() {
			return "con";
		}
	}, INTELLIGENCE {
		@Override
		public String message() {
			return "int";
		}
	}, WISDOM {
		@Override
		public String message() {
			return "wis";
		}
	}, CHARISMA {
		@Override
		public String message() {
			return "char";
		}
	};

	abstract public String message();
}

