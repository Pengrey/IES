package com.example.demo;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteRestController {

	// Create quotes "DB"
	public String[][] generate_db(){
		String[][] show_quotes = {
			{"May the Force be with you.","Star Wars"},
			{"There's no place like home.","Toto, I've a feeling we're not in Kansas anymore.","The Wizard of Oz"},
			{"I'm the king of the world!","Titanic"},
			{"Carpe diem. Seize the day, boys. Make your lives extraordinary.","Dead Poets Society"},
			{"Elementary, my dear Watson.","The Adventures of Sherlock Holmes"},
			{"It's alive! It's alive!","Frankenstein"},
			{"My mama always said life was like a box of chocolates. You never know what you're gonna get.","Forrest Gump"},
			{"I'll be back.","The Terminator"},
			{"You're gonna need a bigger boat.","Jaws"},
			{"Here's looking at you, kid.","Casablanca"},
			{"My precious.","The Lord of the Rings: Two Towers"},
			{"Houston, we have a problem.","Apollo 13"},
			{"There's no crying in baseball!","A League of Their Own"},
			{"E.T. phone home.","E.T. the Extra-Terrestrial"},
			{"You can't handle the truth!","A Few Good Men"},
			{"A martini. Shaken, not stirred.","Goldfinger"},
			{"Life is a banquet, and most poor suckers are starving to death!","Auntie Mame"},
			{"If you build it, he will come.","Field of Dreams"},
			{"The stuff that dreams are made of.","The Maltese Falcon"},
			{"Magic Mirror on the wall, who is the fairest one of all?","Snow White and the Seven Dwarfs"},
			{"Keep your friends close, but your enemies closer.","The Godfather Part II"},
			{"I am your father.","Star Wars Episode V: The Empire Strikes Back"},
			{"Just keep swimming.","Finding Nemo"},
			{"Today, I consider myself the luckiest man on the face of the earth.","The Pride of the Yankees"},
			{"You is kind. You is smart. You is important.","The Help"},
			{"What we've got here is failure to communicate.","Cool Hand Luke"},
			{"Hasta la vista, baby.","Terminator 2: Judgment Day"},
			{"You don't understand! I coulda had class. I coulda been a contender. I could've been somebody, instead of a bum, which is what I am.","On the Waterfront"},
			{"Bond. James Bond.","Dr.No"},
			{"You talking to me?","Taxi Driver"},
			{"Roads? Where we're going we don't need roads.","Back to the Future"},
			{"That'll do, pig. That'll do.","Babe"},
			{"I'm walking here! I'm walking here!","Midnight Cowboy"},
			{"It was beauty killed the beast.","King Kong"},
			{"Stella! Hey, Stella!","A Streetcar Named Desire"},
			{"As if!","Clueless"},
			{"Here's Johnny!","The Shining"},
			{"Rosebud.","Citizen Kane"},
			{"I'll have what she's having.","When Harry Met Sally"},
			{"Inconceivable!","The Princess Bride"},
			{"All right, Mr. DeMille, I'm ready for my close-up.","Sunset Boulevard"},
			{"Fasten your seatbelts. It's going to be a bumpy night.","All About Eve"},
			{"Nobody puts Baby in a corner.","Dirty Dancing"},
			{"Well, nobody's perfect.","Some Like it Hot"},
			{"Snap out of it!","Moonstruck"},
			{"You had me at ‘hello.’","Jerry Maguire"},
			{"They may take our lives, but they'll never take our freedom!","Braveheart"},
			{"To infinity and beyond!","Toy Story"},
			{"You’re killin’ me, Smalls.","The Sandlot"}
		};
		return show_quotes;
	}

	public static boolean isNumeric(String str)
	{
		for (char c : str.toCharArray())
		{
			if (!Character.isDigit(c)) return false;
		}
		return true;
	}

	@GetMapping("/quote")
	public Quote quote() {
		String[][] db = generate_db();
		Random r = new Random();
		Integer show_index = r.nextInt(db.length - 1);
		Integer quote_index = r.nextInt(db[show_index].length - 1);
		return new Quote( db[show_index][db[show_index].length - 1],db[show_index][quote_index]);
	}

	@GetMapping("/quotes")
	public Quote quote(@RequestParam(value = "show", defaultValue = "Default value") String id) {
		if(id.equals("Default value")){
			return new Quote("error","Please give a valid id");
		}else if(isNumeric(id)){
			String[][] db = generate_db();
			Integer show_index = Integer.parseInt(id);
			if(show_index >= db.length){
				return new Quote("error","ID doesnt exist");
			}else{
				Random r = new Random();
				Integer quote_index = r.nextInt(db[show_index].length - 1);
				return new Quote( db[show_index][db[show_index].length - 1],db[show_index][quote_index]);
			}
		}else{
			return new Quote("error","Please give a valid id");
		}
	}
		
	@GetMapping("/shows")
	public Show[] shows(){
		String [][] db = generate_db();
		Show[] shows = new Show[db.length];

		int id = 0;
		for(String[] show: generate_db()){
			shows[id] = new Show(show[show.length - 1], id);
			id++;
		}
		return shows;
	}
}

