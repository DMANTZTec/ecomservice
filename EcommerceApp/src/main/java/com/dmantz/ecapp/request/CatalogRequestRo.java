package com.dmantz.ecapp.request;

import java.util.List;

//import com.dmantz.ecapp.model.CatalogDirRow;

public class CatalogRequestRo {
	private int startLevel;
	private int endLevel;
	private int storeId;
	private int parentCatalogId;
	//List<CatalogDirRow> curCatalog;
	
	
/*
	public List<CatalogDirRow> getCurCatalog() {
		return curCatalog;
	}

	public void setCurCatalog(List<CatalogDirRow> curCatalog) {
		this.curCatalog = curCatalog;
	}
	*/

	public int getStartLevel() {
		return startLevel;
	}

	public void setStartLevel(int startLevel) {
		this.startLevel = startLevel;
	}

	public int getEndLevel() {
		return endLevel;
	}

	public void setEndLevel(int endLevel) {
		this.endLevel = endLevel;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getParentCatalogId() {
		return parentCatalogId;
	}

	public void setParentCatalogId(int parentCatalogId) {
		this.parentCatalogId = parentCatalogId;
	}

	
}
