/*
 * 
 */
package com.opendroid.validation;

import java.util.ArrayList;
import java.util.List;

import android.util.SparseBooleanArray;
import android.view.View;

/**
 * The Class Validator.
 * 
 * @author Rishi K
 */
public abstract class Validator {
	
	boolean highlight = false; 
	private String errorMessage;
	protected List<View> list;

	/**
	 * Instantiates a new Validator.
	 */
	public Validator() {
		list = new ArrayList<View>();
	}

	/**
	 * Adds a view to be validated in list
	 * 
	 * @param view
	 *            the view
	 */
	public void add(View view) {
		list.add(view);
	}

	/**
	 * Adds an array of views to be validated in list
	 * 
	 * @param view
	 *            the view
	 */
	public void add(View[] view) {
		for (View vi : view) {
			list.add(vi);
		}
	}
	
	public void highlightControl(boolean highlight)
	{
		this.highlight = highlight;
	}

	/**
	 * validates list of views.
	 * 
	 * @return true, if successful
	 */
	public abstract boolean validate();
	
	public abstract SparseBooleanArray getResult();

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
