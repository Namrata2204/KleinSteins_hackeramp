public enum Commands
{
	PRESS_MOUSE(-1);
	RELEASE_MOUSE(-2);
	PRESS_KEY(-3);;
	RELEASE_KEY(-4);
	MOUSE_MOVE(-5);
	
	private int abbrev;
	Commands(int abbrev)
	{
		this.abbrev=abbrev;
	}
	public void getAbbrev()
	{
		return abbrev;
	}
}