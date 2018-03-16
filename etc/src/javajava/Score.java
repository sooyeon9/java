package javajava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Score {
	int play_no_;
	String play_date_;
	int home_no_;
	int away_no_;
	int home_score_;
	int away_score_;
	
	public Score(int play_no, String play_date, int home_no, int away_no, int home_score, int away_score)
	{
		play_no_ = play_no;
		play_date_ = play_date;
		home_no_ = home_no;
		away_no_ = away_no;
		home_score_ = home_score;
		away_score_ = away_score;
	}
	
	public int get_play_no()
	{
		return play_no_;
	}
	public String get_play_date()
	{
		return play_date_;
	}
	public int get_home_no()
	{
		return home_no_;
	}
	public int get_away_no_()
	{
		return away_no_;
	}
	public int get_home_score()
	{
		return home_score_;
	}
	public int get_away_score()
	{
		return away_score_;
	}
	
	public void set_play_no(int a)
	{
		play_no_ = a;
	}
	public void set_play_date(String a)
	{
		play_date_ = a;
	}
	public void set_home_no(int a)
	{
		home_no_ = a;
	}
	public void set_away_no_(int a)
	{
		away_no_ = a;
	}
	public void set_home_score(int a)
	{
		home_score_ = a;
	}
	public void set_away_score(int a)
	{
		away_score_ = a;
	}


public static void main(String[] args) {
	// TODO Auto-generated method stub

	ArrayList<Score> sl = new ArrayList<Score>();
	String[] team_names = { "»ï¼º", "µÎ»ê", "·Ôµ¥", "SK", "ÇÑÈ­", "³Ø¼¾", "LG",
			"KIA", "NC", "KT" };
	int[] no_team_plays = new int[10];
	int[] no_team_wins = new int[10];
	int[] no_team_loses = new int[10];
	int[] no_team_draws = new int[10];
	double[] no_team_ratios = new double[10];
	ScoreManager sm = new ScoreManager(sl, team_names, no_team_plays,
			no_team_wins, no_team_loses, no_team_draws, no_team_ratios);

	BufferedReader br = null;
	try {

		String sCurrentLine;
		br = new BufferedReader(new FileReader("scoredata.txt"));
		while ((sCurrentLine = br.readLine()) != null) {
			String[] info = sCurrentLine.split(" ");
			int h_score = Integer.parseInt(info[2]);
			int a_score = Integer.parseInt(info[4]);
			Score a = new Score(sm.get_sl().size() + 1, info[0],
					sm.get_team_number(info[1]),
					sm.get_team_number(info[5]), h_score, a_score);
			sm.add_score(a);
			
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	sm.listScores();
	//sm.findScores("NC");
	//sm.viewMatchScore();
	
}}
