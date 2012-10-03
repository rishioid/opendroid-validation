package com.opendroid.validation;

import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class CompulsoryValidator extends Validator {

	@Override
	public SparseBooleanArray validate() {
		SparseBooleanArray valid = new SparseBooleanArray();

		int index = 0;

		for (View view : list) {
			if (view instanceof EditText) {
				EditText txt = (EditText) view;
				if (txt != null
						&& txt.getText().toString().trim().length() == 0) {
					valid.put(index, false);
				} else {
					valid.put(index, true);
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

		return valid;
	}

}
