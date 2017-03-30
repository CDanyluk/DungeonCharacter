package Classes;

public enum Information {
	
/*	Honestly stats and information feels mutable to me...?
	So all enums are a mess until I figure out what needs
	to be stored
	*/

	CLASS {
		String clas = "";
		@Override
		public String get() {
			return clas;
		}
		@Override
		public void change(String s) {
			clas = s;
		}
	}, BACKGROUND {
		String back = "";
		@Override
		public String get() {
			return back;
		}
		@Override
		public void change(String s) {
			back = s;
		}
	}, PLAYER {
		String play = "";
		@Override
		public String get() {
			return play;
		}
		@Override
		public void change(String s) {
			play = s;
		}
	}, RACE {
		String rac = "";
		@Override
		public String get() {
			return rac;
		}
		@Override
		public void change(String s) {
			rac = s;
		}
	}, ALIGNMENT {
		String ali = "";
		@Override
		public String get() {
			return ali;
		}
		@Override
		public void change(String s) {
			ali = s;
		}
	};

	abstract public String get();
	
	abstract public void change(String s);
}


	

