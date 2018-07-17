package com.revature.beans;

public final class RoomsTheme { // room themes for level and room generation
	static final String[] GreekNames = { "Medusa Room" , "Minotaur Room", "Siren Room", "Cerberus Room", "Hydra Room" };
	static final String[] GreekDescs = {
			"There is a Medusa in here.\nMake sure you don't look at her.",
			"There is a Minotaur in here.\nIt's a good thing you brought a rocket launcher.",
			"There is a Siren in here.\nCover your ears!",
			"Cerberus is in here.\nLuckily it is asleep, so be quiet.",
			"There is a Hydra in here.\nIwouldn't cut off one of its heads if I were you."
	};
	
	static public String[] getGreekNames() {
		return GreekNames;
	}
	
	static public String[] getGreekDescs() {
		return GreekDescs;
	}
}
