package model;

import java.util.Comparator;

public class Player {
	
	private String nickName;
	private String namePlayer;
	private byte point;
	private int round;

	public static Comparator<Player> compId=new Comparator<Player>() {

		@Override
		public int compare(Player o1, Player o2) {
			return o1.getNickName().compareTo(o2.getNickName()); 
		}
		
	};
	
	public static Comparator<Player> compNamePlayer=new Comparator<Player>() {
		
		@Override
		public int compare(Player o1, Player o2) {
			return o1.getNamePlayer().compareTo(o2.getNamePlayer());
		}
	};

	public Player(String idPlayer, String namePlayer) {
		this.nickName = idPlayer;
		this.namePlayer = namePlayer;
		point=0;
		round=0;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getNamePlayer() {
		return namePlayer;
	}
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}
	public byte getPoint() {
		return point;
	}
	public void setPoint(byte point) {
		this.point = point;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	@Override
	public String toString() {
		return "Player [nickName=" + nickName + ", namePlayer=" + namePlayer + ", point=" + point + ", round=" + round
				+ "]";
	}

	
	
}
