package com.opendroid.validation;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.EditText;

public class FileldDataMatchValidator extends Validator {

	SparseBooleanArray valid;
	List<String> valueList;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opendroid.validation.Validator#validate()
	 */
	@Override
	public boolean validate() {
		valueList = new ArrayList<String>();
		int index = 0;

		valid = new SparseBooleanArray();

		for (View view : list) {
			if (view instanceof EditText) {
				EditText txt = (EditText) view;
				if (index > 0) {
					if (txt != null
							&& !txt.getText().toString().trim().equals(list.get(index-1))) {
						if (highlight) {
							txt.setBackgroundColor(Color.parseColor("#FF9999"));
						}
//						valid.put(index, false);
						return false;
					} else {
						valid.put(index, true);
						txt.setBackgroundColor(Color.TRANSPARENT);
					}
				}
			} else {
				throw new IllegalArgumentException(
						"Non EditText object found at index : " + index);
			}
			index++;
		}

		return true;
	}

	@Override
	public SparseBooleanArray getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Checks if is valid.
	 * 
	 * @return true, if is valid
	 */
/*	private boolean isValid() {
		for (int i = 0; i < valid.size(); i++) {
			if (!valid.get(i)) {
				return false;
			}
		}
		return true;
	}*/

}
