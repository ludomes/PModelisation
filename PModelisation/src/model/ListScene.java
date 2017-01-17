package model;

import java.util.ArrayList;

public class ListScene {
	private ArrayList<Scene> myListScene;
	
	public ListScene () {
		myListScene = new ArrayList<>();
	}
	
	public void addScene(Scene uneScene){
		myListScene.add(uneScene);
	}
	
	public Scene getScene(int index){
		return myListScene.get(index);
	}
	
	public boolean estVide(){
		return myListScene.isEmpty();
	}
	
	public int indexOf(Scene uneScene) {
		return myListScene.indexOf(uneScene);
	}
	
	public int size() {
		return myListScene.size();
	}
	
	
	
}
