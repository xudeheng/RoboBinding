package org.robobinding.widget.timepicker;

import org.robobinding.property.ValueModel;
import org.robobinding.viewattribute.property.TwoWayPropertyViewAttribute;
import org.robobinding.widgetaddon.timepicker.TimePickerAddOn;

import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Joachim Hill-Grannec
 */
public class TwoWayCurrentMinuteAttribute implements TwoWayPropertyViewAttribute<TimePicker, TimePickerAddOn, Integer> {

	@Override
    public void updateView(TimePicker view, Integer newValue, TimePickerAddOn viewAddOn) {
        view.setCurrentMinute(newValue);
    }

    @Override
    public void observeChangesOnTheView(TimePickerAddOn viewAddOn, final ValueModel<Integer> valueModel, TimePicker view) {
    	viewAddOn.addOnTimeChangedListener(new OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            	valueModel.setValue(minute);
            }
        });
    }
}