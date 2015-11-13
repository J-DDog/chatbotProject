package chatbot.model;

import jm.JMC;
import jm.music.data.Note;
import jm.util.Play;

public class NotePlayer extends Thread
{
	//Defining Date Members
	public Note c;
	public Note d;
	public Note e;
	public Note f;
	public Note g;
	public Note a;
	public Note b;
	public Note cs;
	public Note ds;
	public Note fs;
	public Note gs;
	public Note as;
	
	/**
	 * The Constructor of my note class
	 */
	public NotePlayer()
	{
		//Initializing Notes
		c = new Note();
		d = new Note();
		e = new Note();
		f = new Note();
		g = new Note();
		a = new Note();
		b = new Note();
		cs = new Note();
		ds = new Note();
		fs = new Note();
		gs = new Note();
		as = new Note();
		
		//Set Note values
		c.setPitch(JMC.C3);
		d.setPitch(JMC.D3);
		e.setPitch(JMC.E3);
		f.setPitch(JMC.F3);
		g.setPitch(JMC.G3);
		a.setPitch(JMC.A3);
		b.setPitch(JMC.B3);
		cs.setPitch(JMC.CS3);
		ds.setPitch(JMC.DS3);
		fs.setPitch(JMC.FS3);
		gs.setPitch(JMC.GS3);
		as.setPitch(JMC.AS3);
		
	}
	
	/**
	 * Plays the preselected note
	 */
	public void playNote(Note note)
	{
		//Play the note
		Play.midi(note);
	}
	
	/**
	 * Changez the pitch of the note
	 * @param pitch
	 */
	public void setNotePitch(Note note, int pitch)
	{
		note.setPitch(pitch);
	}
	
	public void playSong() throws InterruptedException
	{
		
		while(true)
		{
			Play.midi(e);
			Play.midi(f);
			Play.midi(g);
			Play.midi(a);
			this.sleep(10);
			Play.midi(a);
			Play.midi(a);
			this.sleep(10);
			Play.midi(g);
			Play.midi(f);
			Play.midi(e);
			Play.midi(d);
			this.sleep(10);
			Play.midi(d);
			Play.midi(d);
			this.sleep(10);
			
		}
		
	}
	
	public void run()
	{
		try
		{
			playSong();
		}
		catch(InterruptedException e)
		{
			return;
		}
		
	}
	
}
