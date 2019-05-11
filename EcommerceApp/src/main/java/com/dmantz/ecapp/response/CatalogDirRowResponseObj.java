package com.dmantz.ecapp.response;

import java.util.List;

public class CatalogDirRowResponseObj {
 
	private String catalogName;
	private int catalogId;
	private String catalogDesc;
	private int catalogLevel;
	private int parentCatalogId;
	private int storeId;
	private List<CatalogDirRowResponseObj> childCatalog;

	public CatalogDirRowResponseObj() {
		super();
	}

	public CatalogDirRowResponseObj(String catalogName, int catalogId, String catalogDesc, int catalogLevel, int parentCatalogId,
			int storeId) {
		super();
		this.catalogName = catalogName;
		this.catalogId = catalogId;
		this.catalogDesc = catalogDesc;
		this.catalogLevel = catalogLevel;
		this.parentCatalogId = parentCatalogId;
		this.storeId = storeId;
	}

	public List<CatalogDirRowResponseObj> getChildCatalog() {
		return childCatalog;
	}

	public void setChildCatalog(List<CatalogDirRowResponseObj> childCatalog) {
		this.childCatalog = childCatalog;
	}

	
	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogDesc() {
		return catalogDesc;
	}

	public void setCatalogDesc(String catalogDesc) {
		this.catalogDesc = catalogDesc;
	}

	public int getCatalogLevel() {
		return catalogLevel;
	}

	public void setCatalogLevel(int catalogLevel) {
		this.catalogLevel = catalogLevel;
	}

	public int getParentCatalogId() {
		return parentCatalogId;
	}

	public void setParentCatalogId(int parentCatalogId) {
		this.parentCatalogId = parentCatalogId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "CatalogDirRow [catalogName=" + catalogName + ", catalogId=" + catalogId + ", catalogDesc="
				+ catalogDesc + ", catalogLevel=" + catalogLevel + ", parentCatalogId=" + parentCatalogId
				+ ", storeId=" + storeId + "]";
	}

}
