/*
 * This is created by admins
 */

package com.jdb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//public class ServiceCatalog {
//public class ServiceType {
@Entity
@Table
public class Category {

	@Id
	int catalogId;

	String catalogTitle;
	String catalogDescription;
	String measurementUnit;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int catalogId, String catalogTitle, String catalogDescription, String measurementUnit) {
		super();
		this.catalogId = catalogId;
		this.catalogTitle = catalogTitle;
		this.catalogDescription = catalogDescription;
		this.measurementUnit = measurementUnit;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogTitle() {
		return catalogTitle;
	}

	public void setCatalogTitle(String catalogTitle) {
		this.catalogTitle = catalogTitle;
	}

	public String getCatalogDescription() {
		return catalogDescription;
	}

	public void setCatalogDescription(String catalogDescription) {
		this.catalogDescription = catalogDescription;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	@Override
	public String toString() {
		return "CatalogItem [catalogId=" + catalogId + ", catalogTitle=" + catalogTitle + ", catalogDescription="
				+ catalogDescription + ", measurementUnit=" + measurementUnit + "]";
	}

	// TODO: STUB: if we need to create subcategories of this catalog item
//	int offerType;

}
