package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

import model.ActionsCraps;
import model.ListedCircled;
import model.ManagementCraps;
import model.Player;

public class ControllCraps implements ActionListener{
	
	private ActionsCraps view;
	private ManagementCraps mng;
	
	
	public ControllCraps(ActionsCraps view) {
		this.view=view;
		mng=new ManagementCraps();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case ActionsCraps.START_GAME: view.readInput(ActionsCraps.START_GAME);
			break;
		case ActionsCraps.HELP: view.readInput(ActionsCraps.HELP);
			break;
		case ActionsCraps.AGAIN_START: view.readInput(ActionsCraps.AGAIN_START);
			break;	
		case ActionsCraps.VIEW_ADD_PLAYER: view.readInput(ActionsCraps.VIEW_ADD_PLAYER);
			break;
		case ActionsCraps.VIEW_GAME: view.readInput(ActionsCraps.VIEW_GAME);
			break;
		case ActionsCraps.ADD_PLAYER: addPlayer(view.readInput(ActionsCraps.ADD_PLAYER));
			break;
		case ActionsCraps.LIST_PLAYER: sortPlayer(Player.compId);
			break;
		case ActionsCraps.PLAYER_START: view.readInput(ActionsCraps.PLAYER_START);
			break;
		case ActionsCraps.THROW_DICE: view.readInput(ActionsCraps.THROW_DICE);
			break;
		}
	}

	private void sortPlayer(Comparator<Player> compId) {
		ArrayList<Player> sorte=mng.sorted(compId);
		String[] out=new String[sorte.size()];
		int cant=0;
		for (Player player : sorte) {
			String nickName=player.getNickName();
			System.out.println(nickName);
			String name=player.getNamePlayer();
			System.out.println(name);
			out[cant++]=nickName+";"+name+";";
		}
		view.writeOuput("List", out, true);
	}

	private void addPlayer(String[] dates) {
		if(dates!=null){
			if(mng.addPlayer(dates[0], dates[1])){
				view.writeOuput(ActionsCraps.ADD_PLAYER, dates, true);
			}else{
				view.writeOuput(ActionsCraps.ADD_PLAYER, dates, false);
			}
		}
	}
	
	
	public ArrayList<Player> getPlayers(){
		ArrayList<Player> out=mng.getPlayers();
		if(out!=null) {
			return (ArrayList<Player>) mng.getPlayers().clone();
		}else {
			return new ArrayList<Player>();
		}
		
	}

	public ManagementCraps getMng() {
		return mng;
	}

	public void setMng(ManagementCraps mng) {
		this.mng = mng;
	}
	
	
	

}
