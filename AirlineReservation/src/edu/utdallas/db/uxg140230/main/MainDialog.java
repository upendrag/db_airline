package edu.utdallas.db.uxg140230.main;

import java.util.ArrayList;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;

import edu.utdallas.db.uxg140230.controller.DataManager;
import edu.utdallas.db.uxg140230.model.Flight;
import edu.utdallas.db.uxg140230.view.FlightsContentProvider;
import edu.utdallas.db.uxg140230.view.FlightsLabelProvider;
import edu.utdallas.db.uxg140230.view.LegsContentProvider;
import edu.utdallas.db.uxg140230.view.LegsLabelProvider;
import edu.utdallas.db.uxg140230.view.AvailabilityContentProvider;
import edu.utdallas.db.uxg140230.view.AvailabilityLabelProvider;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;

public class MainDialog extends Shell {
	private Display display;
	private TabFolder tbflViews;
	private DataManager dataManager;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MainDialog shell = new MainDialog(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public MainDialog(Display display) {		
		super(display, SWT.SHELL_TRIM);
		this.dataManager = new DataManager();
		this.display = display;
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		tbflViews = new TabFolder(this, SWT.BORDER);
		
		createFlightsTab();		
		createLegsTab();
		createSeatsTab();
		createPassengersTab();
		
		createContents();	
	}
	
	private void createPassengersTab() {
		TabItem tabItem = new TabItem(tbflViews, SWT.NONE);
		tabItem.setText("Passengers");
		
		Composite composite = new Composite(tbflViews, SWT.NONE);
		tabItem.setControl(composite);
		composite.setLayout(new GridLayout(3, false));
		
		Label lblFlightNumber = new Label(composite, SWT.NONE);
		lblFlightNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFlightNumber.setText("Flight Number:");
		
		Combo cmbFlightNum = new Combo(composite, SWT.READ_ONLY);
		cmbFlightNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				
		Button btnShowPassengers = new Button(composite, SWT.NONE);
		btnShowPassengers.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnShowPassengers.setText("Show Passengers>>");
		
		List passengersList = new List(composite, SWT.BORDER);
		passengersList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1));
		
		Label lblPassenger = new Label(composite, SWT.NONE);
		lblPassenger.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPassenger.setText("Passenger:");
		
		Text txtPassengerName = new Text(composite, SWT.BORDER);
		txtPassengerName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnShowFlights = new Button(composite, SWT.NONE);
		btnShowFlights.setText("Show Flights>>");
		
		List flightsList = new List(composite, SWT.BORDER);
		flightsList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1));
	}

	private void createSeatsTab() {
		TabItem tabItem = new TabItem(tbflViews, SWT.NONE);
		tabItem.setText("Seats");
		
		Composite composite = new Composite(tbflViews, SWT.NONE);
		tabItem.setControl(composite);
		composite.setLayout(new GridLayout(5, false));
		
		Label lblFlightNumber = new Label(composite, SWT.NONE);
		lblFlightNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFlightNumber.setText("Flight Number:");
		
		Combo cmbFlightNum = new Combo(composite, SWT.READ_ONLY);
		cmbFlightNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDate = new Label(composite, SWT.NONE);
		lblDate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDate.setText("Date:");
		
		DateTime dt = new DateTime(composite, SWT.NONE);
		dt.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
				
		Button btnShowSeats = new Button(composite, SWT.NONE);
		btnShowSeats.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnShowSeats.setText("Show Seats >>");
		
		TableViewer tv = new TableViewer(composite);
		tv.setContentProvider(new AvailabilityContentProvider());
		tv.setLabelProvider(new AvailabilityLabelProvider());
		
		Table table = tv.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
		
		TableColumn tcLegNumber = new TableColumn(table, SWT.CENTER);
		tcLegNumber.setText("Leg");
		tcLegNumber.setWidth(150);
		tcLegNumber.setResizable(false);
		TableColumn tcDeparture = new TableColumn(table, SWT.CENTER);
		tcDeparture.setText("Departure Aiport");
		tcDeparture.setWidth(200);
		tcDeparture.setResizable(false);
		TableColumn tcArrival = new TableColumn(table, SWT.CENTER);
		tcArrival.setText("Arrival Airport");
		tcArrival.setWidth(200);
		tcArrival.setResizable(false);
		TableColumn tcSeats = new TableColumn(table, SWT.CENTER);
		tcSeats.setText("Seats Available");
		tcSeats.setWidth(250);
		tcSeats.setResizable(false);
				
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}

	/**
	 * 
	 */
	private void createLegsTab() {
		TabItem tbtmLegs = new TabItem(tbflViews, SWT.NONE);
		tbtmLegs.setText("Legs");
		
		Composite compositeLegs = new Composite(tbflViews, SWT.NONE);
		tbtmLegs.setControl(compositeLegs);
		compositeLegs.setLayout(new GridLayout(3, false));
		
		Label lblFlightNumber = new Label(compositeLegs, SWT.NONE);
		lblFlightNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFlightNumber.setText("Flight Number:");
		
		Combo cmbFlightNum = new Combo(compositeLegs, SWT.READ_ONLY);
		cmbFlightNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));	
				
		Button btnShowLegs = new Button(compositeLegs, SWT.NONE);
		btnShowLegs.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnShowLegs.setText("Show Legs >>");
		
		Composite composite = new Composite(compositeLegs, SWT.NONE);
		composite.setLayout(new GridLayout(6, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1) );
		
		Label lblFare = new Label(composite, SWT.NONE);
		lblFare.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFare.setText("Fare:");
		
		Text txtFare  = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		txtFare.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblFareCode = new Label(composite, SWT.NONE);
		lblFareCode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFareCode.setText("Fare Code:");
		
		Text txtFareCode = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		txtFareCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblRestrictionsifAny = new Label(composite, SWT.NONE);
		lblRestrictionsifAny.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRestrictionsifAny.setText("Restrictions (if any):");
		
		Text txtRestrictions = new Text(composite, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI);
		txtRestrictions.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 2));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
				
		TableViewer tv = new TableViewer(compositeLegs);
		tv.setContentProvider(new LegsContentProvider());
		tv.setLabelProvider(new LegsLabelProvider());
		
		Table table = tv.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		
		TableColumn tcLegNumber = new TableColumn(table, SWT.CENTER);
		tcLegNumber.setText("Leg");
		tcLegNumber.setWidth(100);
		tcLegNumber.setResizable(false);
		TableColumn tcDeparture = new TableColumn(table, SWT.CENTER);
		tcDeparture.setText("Departure Aiport");
		tcDeparture.setWidth(150);
		tcDeparture.setResizable(false);
		TableColumn tcDeptTime = new TableColumn(table, SWT.CENTER);
		tcDeptTime.setText("Scheduled Departure");
		tcDeptTime.setWidth(200);
		tcDeptTime.setResizable(false);
		TableColumn tcArrival = new TableColumn(table, SWT.CENTER);
		tcArrival.setText("Arrival Airport");
		tcArrival.setWidth(150);
		tcArrival.setResizable(false);
		TableColumn tcArrTime = new TableColumn(table, SWT.CENTER);
		tcArrTime.setText("Scheduled Arrival");
		tcArrTime.setWidth(200);
		tcArrTime.setResizable(false);
				
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}

	/**
	 * 
	 */
	private void createFlightsTab() {
		TabItem tbtmFlights = new TabItem(tbflViews, SWT.NONE);
		tbtmFlights.setText("Flights");
		
		Composite compositeFlights = new Composite(tbflViews, SWT.NONE);
		tbtmFlights.setControl(compositeFlights);
		compositeFlights.setLayout(new GridLayout(5, false));
		
		Label lblDeparture = new Label(compositeFlights, SWT.NONE);
		lblDeparture.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDeparture.setText("Departure:");
		
		final Combo cmbDeparture = new Combo(compositeFlights, SWT.READ_ONLY);
		cmbDeparture.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblArrival = new Label(compositeFlights, SWT.NONE);
		lblArrival.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblArrival.setText("Arrival:");
		
		final Combo cmbArrival = new Combo(compositeFlights,  SWT.READ_ONLY);
		cmbArrival.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnShowFlights = new Button(compositeFlights, SWT.NONE);
		btnShowFlights.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnShowFlights.setText("Show Flights >>");
		
		final TableViewer tv = new TableViewer(compositeFlights);
		tv.setContentProvider(new FlightsContentProvider());
		tv.setLabelProvider(new FlightsLabelProvider(this.display));
		
		Table table = tv.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
		
		TableColumn tcFlightNumber = new TableColumn(table, SWT.CENTER);
		tcFlightNumber.setText("Flight");
		tcFlightNumber.setWidth(100);
		tcFlightNumber.setResizable(false);
		TableColumn tcSun = new TableColumn(table, SWT.CENTER);
		tcSun.setText("Sun");
		tcSun.setWidth(100);
		tcSun.setResizable(false);
		TableColumn tcMon = new TableColumn(table, SWT.CENTER);
		tcMon.setText("Mon");
		tcMon.setWidth(100);
		tcMon.setResizable(false);
		TableColumn tcTue = new TableColumn(table, SWT.CENTER);
		tcTue.setText("Tue");
		tcTue.setWidth(100);
		tcTue.setResizable(false);
		TableColumn tcWed = new TableColumn(table, SWT.CENTER);
		tcWed.setText("Wed");
		tcWed.setWidth(100);
		tcWed.setResizable(false);
		TableColumn tcThu = new TableColumn(table, SWT.CENTER);
		tcThu.setText("Thu");
		tcThu.setWidth(100);
		tcThu.setResizable(false);
		TableColumn tcFri = new TableColumn(table, SWT.CENTER);
		tcFri.setText("Fri");
		tcFri.setWidth(100);
		tcFri.setResizable(false);
		TableColumn tcSat = new TableColumn(table, SWT.CENTER);
		tcSat.setText("Sat");
		tcSat.setWidth(100);		
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		btnShowFlights.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event e) {
				if (e.type == SWT.Selection) {
					ArrayList<Flight> flights = dataManager.getFlights(cmbDeparture.getText(),
							cmbArrival.getText());		
					tv.setInput(flights);
					
				}
			}
		});
		
		ArrayList<String> airportCodes = this.dataManager.getAllAirportCodes();
		for (String code : airportCodes) {
			cmbDeparture.add(code);
			cmbArrival.add(code);
		}
		cmbDeparture.select(0);
		cmbArrival.select(0);
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Airline Reservation System");
		setSize(800, 450);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
