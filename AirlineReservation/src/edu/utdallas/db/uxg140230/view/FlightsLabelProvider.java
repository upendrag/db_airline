package edu.utdallas.db.uxg140230.view;

import java.io.File;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import edu.utdallas.db.uxg140230.model.Flight;

public class FlightsLabelProvider implements ITableLabelProvider {
	private Image availImage;
	public static final int COLUMN_FLIGHT_NUMBER = 0;
	public static final int COLUMN_SUN= 1;
	public static final int COLUMN_MON= 2;
	public static final int COLUMN_TUE= 3;
	public static final int COLUMN_WED= 4;
	public static final int COLUMN_THU= 5;
	public static final int COLUMN_FRI= 6;
	public static final int COLUMN_SAT= 7;
	
	public static final byte BITMASK_SUN= 64;
	public static final byte BITMASK_MON= 32;
	public static final byte BITMASK_TUE= 16;
	public static final byte BITMASK_WED= 8;
	public static final byte BITMASK_THU= 4;
	public static final byte BITMASK_FRI= 2;
	public static final byte BITMASK_SAT= 1;
	
	
	public FlightsLabelProvider(Display display) {
		this.availImage = new Image(display, getClass().getClassLoader().
				getResourceAsStream("images" + File.separator + "available24.png"));
	}

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
		Flight flight = (Flight) arg0;
		Image img = null;
		switch (arg1) {
			case COLUMN_SUN:
				if ((flight.getWeekdays() & BITMASK_SUN) != 0)
					img = availImage;
				break;
			case COLUMN_MON:
				if ((flight.getWeekdays() & BITMASK_MON) != 0)
					img = availImage;
				break;
			case COLUMN_TUE:
				if ((flight.getWeekdays() & BITMASK_TUE) != 0)
					img = availImage;
				break;
			case COLUMN_WED:
				if ((flight.getWeekdays() & BITMASK_WED) != 0)
					img = availImage;
				break;
			case COLUMN_THU:
				if ((flight.getWeekdays() & BITMASK_THU) != 0)
					img = availImage;
				break;
			case COLUMN_FRI:
				if ((flight.getWeekdays() & BITMASK_FRI) != 0)
					img = availImage;
				break;
			case COLUMN_SAT:
				if ((flight.getWeekdays() & BITMASK_SAT) != 0)
					img = availImage;
				break;
		}
		return img;
	}

	@Override
	public String getColumnText(Object arg0, int arg1) {
		Flight flight = (Flight) arg0;
		String text = "";
		switch (arg1) {
			case COLUMN_FLIGHT_NUMBER:
				text = flight.getFlightNumber();
				break;
			case COLUMN_SUN:
				if ((flight.getWeekdays() & BITMASK_SUN) != 0)
					text = "Available";
				break;
			case COLUMN_MON:
				if ((flight.getWeekdays() & BITMASK_MON) != 0)
					text = "Available";
				break;
			case COLUMN_TUE:
				if ((flight.getWeekdays() & BITMASK_TUE) != 0)
					text = "Available";
				break;
			case COLUMN_WED:
				if ((flight.getWeekdays() & BITMASK_WED) != 0)
					text = "Available";
				break;
			case COLUMN_THU:
				if ((flight.getWeekdays() & BITMASK_THU) != 0)
					text = "Available";
				break;
			case COLUMN_FRI:
				if ((flight.getWeekdays() & BITMASK_FRI) != 0)
					text = "Available";
				break;
			case COLUMN_SAT:
				if ((flight.getWeekdays() & BITMASK_SAT) != 0)
					text = "Available";
				break;
		}
		return text;
	}

}
