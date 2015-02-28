package edu.utdallas.db.uxg140230.view;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.utdallas.db.uxg140230.model.Flight;

public class FlightsContentProvider implements IStructuredContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object arg0) {
		return ((ArrayList<Flight>)arg0).toArray();
	}

}
