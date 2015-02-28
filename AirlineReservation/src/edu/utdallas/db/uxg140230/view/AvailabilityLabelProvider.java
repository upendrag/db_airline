package edu.utdallas.db.uxg140230.view;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import edu.utdallas.db.uxg140230.model.Availability;

public class AvailabilityLabelProvider implements ITableLabelProvider {

	public static final int COLUMN_LEG = 0;
	public static final int COLUMN_DEPT_AIRPORT = 1;
	public static final int COLUMN_ARR_AIRPORT = 2;
	public static final int COLUMN_SEATS_AVAILABLE = 3;
	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object arg0, int arg1) {
		Availability availability = (Availability)arg0;
		String text = "";
		switch (arg1){
			case COLUMN_LEG:
				text = String.valueOf(availability.getLeg());
				break;
			case COLUMN_DEPT_AIRPORT:
				text = availability.getDeptAirport();
				break;
			case COLUMN_ARR_AIRPORT:
				text = availability.getArrAirport();
				break;
			case COLUMN_SEATS_AVAILABLE:
				text = String.valueOf(availability.getNumOfAvailableSeats());
				break;
		}		
		return text;
	}

}
