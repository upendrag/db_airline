package edu.utdallas.db.uxg140230.view;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import edu.utdallas.db.uxg140230.model.Leg;

public class LegsLabelProvider implements ITableLabelProvider {

	public static final int COLUMN_LEG = 0;
	public static final int COLUMN_DEPT_AIRPORT = 1;
	public static final int COLUMN_DEPT_TIME = 2;
	public static final int COLUMN_ARR_AIRPORT = 3;
	public static final int COLUMN_ARR_TIME = 4;
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
		Leg leg = (Leg) arg0;
		String text = "";
		switch (arg1) {
			case COLUMN_LEG:
				text = String.valueOf(leg.getLegNumber());
				break;
			case COLUMN_DEPT_AIRPORT:
				text = leg.getDeptAirportCode();
				break;
			case COLUMN_DEPT_TIME:
				text = leg.getSchedDeptTime();
				break;
			case COLUMN_ARR_AIRPORT:
				text = leg.getArrAirportCode();
				break;
			case COLUMN_ARR_TIME:
				text = leg.getSchedArrTime();
				break;
		}
		return text;
	}

}
