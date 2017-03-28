package Classes;

public enum Information {
	
/*	Honestly stats and information feels mutable to me...?
	So all enums are a mess until I figure out what needs
	to be stored
	*/

	CLASS {
		@Override
		public String message() {
			return "class";
		}
	}, BACKGROUND {
		@Override
		public String message() {
			return "background";
		}
	}, PLAYER {
		@Override
		public String message() {
			return "player";
		}
	}, RACE {
		@Override
		public String message() {
			return "race";
		}
	}, ALIGNMENT {
		@Override
		public String message() {
			return "alignemnt";
		}
	}, EXPERIENCE {
		@Override
		public String message() {
			return "experience";
		}
	};

	abstract public String message();
}


	

