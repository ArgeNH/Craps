package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManagementCraps {
	
	private ListedCircled<Player> list;
	private int number=1;
	private Player turn;
	
	public ManagementCraps() {
		list=new ListedCircled<>(Player.compId);
		turn=null;
	}
	
	public boolean addPlayer(String nickName,String name) {
		if(!list.isEmpty()) {
			if(findPlayer(nickName)==null) {
			list.addFirst(new Player(nickName, name));
			return true;
			}else {
			return false;
			}
		}else {
			list.addFirst(new Player(nickName, name));
			return true;
		}
	}
	
	public Player findPlayer(String nickName) {
		return list.findObject(new Player(nickName, null));
	}
	
	public Node<Player> findNodePlayer(String nickName){
		return list.findNode(new Player(nickName, null));
	}
	
	public boolean deleteNode(String nickName){
		if(!list.isEmpty()){
			if(findPlayer(nickName)!=null){
				list.deleteNode(list.findNode(new Player(nickName, null)));
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Player> sorted(Comparator<Player> compId){
		ArrayList<Player> clonPlayers= getPlayers();
		Collections.sort(clonPlayers,compId);
		return clonPlayers;
	}
	
	public ArrayList<Player> getPlayers(){
		if(!list.isEmpty()){
			return list.getList();
		}
		return null;
	}
	
	public byte generateTurn() {
		int value=(int)(Math.random()*getPlayers().size())+1;
		this.turn=list.getObject(value);
		return (byte)value;
	}
	
	public byte generateDices() {
		int value=(int)(Math.random()*6)+1;
		return (byte)value;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Player getTurn() {
		return turn;
	}

	public void setTurn(Player turn) {
		this.turn = turn;
	}
	
}
