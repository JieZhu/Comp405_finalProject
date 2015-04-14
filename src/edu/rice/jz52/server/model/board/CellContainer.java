package edu.rice.jz52.server.model.board;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class CellContainer {
	
	public ArrayList<Cell> cells;

	public CellContainer() {
		cells = new ArrayList<Cell>();
	}
	
	public CellContainer(ArrayList<Cell> cellsIn) {
		this.cells = cellsIn;
	}
	
	public void add(Cell cell) {
		cells.add(cell);
	}
	
	public static CellContainer fromJson(String str) {
		Gson gson = new Gson();
		return gson.fromJson(str, CellContainer.class);
	}
	
	public static CellContainer fromJson(InputStream inputStream) {
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return gson.fromJson(reader, CellContainer.class);
	}
	
	public static String toJson(CellContainer container) {
		Gson gson = new Gson();
		return gson.toJson(container, CellContainer.class);
	}
	
}