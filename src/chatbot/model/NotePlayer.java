package chatbot.model;

import jm.JMC;
import jm.music.data.Note;
import jm.util.Play;

public class NotePlayer
{
	//Defining Date Members
	private Note note;
	
	/**
	 * The Constructor of my note class
	 */
	public NotePlayer()
	{
		//Initializing Data Members
		note = new Note();
	}
	
	/**
	 * Plays the preselected note
	 */
	public void playNote()
	{
		//Play the note
		Play.midi(note);
	}
	
	/**
	 * Changez the pitch of the note
	 * @param pitch
	 */
	public void setNotePitch(int pitch)
	{
		note.setPitch(pitch);
	}
	
}
