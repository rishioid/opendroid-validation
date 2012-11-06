package com.opendroid.validation;

import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

// TODO: Auto-generated Javadoc
/**
 * The Class CompulsoryValidator.
 */
public class CompulsoryValidator extends Validator {

	SparseBooleanArray valid;

	/* (non-Javadoc)
	 * @see com.opendroid.validation.Validator#validate()
	 */
	@Override
	public boolean validate() {
		valid = new SparseBooleanArray();

		int index = 0;

		for (View view : list) {
			if (view instanceof EditText) {
				EditText txt = (EditText) view;
				if (txt != null
						&& txt.getText().toString().trim().length() == 0) {
					if (highlight) {
						txt.setBackgroundColor(Color.parseColor("#FF9999"));
					}
					valid.put(index, false);
				} else {
					valid.put(index, true);
					txt.setBackgroundColor(Color.TRANSPARENT);
				}
			} else if (view instanceof CheckBox) {
				CheckBox chk = (CheckBox) view;
				if (chk != null && chk.isChecked()) {
					valid.put(index, false);
				} else {
					valid.put(index, true);
				}
			} else {
				valid.put(index, false);
			}
			index++;
		}

		return isValid();
	}

	/* (non-Javadoc)
	 * @see com.opendroid.validation.Validator#getResult()
	 */
	public SparseBooleanArray getResult() {
		return valid;
	}

	/**
	 * Checks if is valid.
	 *
	 * @return true, if is valid
	 */
	private boolean isValid() {
		for (int i = 0; i < valid.size(); i++) {
			if (!valid.get(i)) {
				return false;
			}
		}
		return true;
	}

}
