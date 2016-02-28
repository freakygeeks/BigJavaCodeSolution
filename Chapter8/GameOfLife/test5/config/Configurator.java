package gol.config;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class Configurator {

	protected Object result;
	protected Shell configShell;
	private Text widthText;
	private Text heightText;
	private Text zoomText;
	private Text fpsText;
	
	private int widthValue, heightValue, zoomValue;
	private double fpsValue;
	private boolean valuesReady;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Configurator() {
		valuesReady = false;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 * @wbp.parser.entryPoint
	 */
	public Object open() {
		createContents();
		configShell.open();
		configShell.layout();
		Display display = Display.getDefault();
		while (!configShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.close();
		return result;
	}
	
	public void close() {
		configShell.dispose();
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		configShell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
		configShell.setSize(199, 213);
		configShell.setText("Game Of Life");
		configShell.setLayout(new GridLayout(1, false));
		
		Composite composite_1 = new Composite(configShell, SWT.NONE);
		GridData gd_composite_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_1.widthHint = 184;
		composite_1.setLayoutData(gd_composite_1);
		composite_1.setLayout(new GridLayout(2, false));
		
		Label widthLabel = new Label(composite_1, SWT.NONE);
		widthLabel.setText("Width");
		
		widthText = new Text(composite_1, SWT.BORDER);
		widthText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		widthText.setText("160");
		
		Label heightLabel = new Label(composite_1, SWT.NONE);
		heightLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		heightLabel.setText("Height");
		
		heightText = new Text(composite_1, SWT.BORDER);
		heightText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		heightText.setText("90");
		
		Label zoomLabel = new Label(composite_1, SWT.NONE);
		zoomLabel.setText("Zoom");
		
		zoomText = new Text(composite_1, SWT.BORDER);
		zoomText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		zoomText.setText("5");
		
		Label fpsLabel = new Label(composite_1, SWT.NONE);
		fpsLabel.setText("FPS");
		
		fpsText = new Text(composite_1, SWT.BORDER);
		fpsText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		fpsText.setText("10.0");
		
		Composite composite = new Composite(configShell, SWT.NONE);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite.widthHint = 184;
		composite.setLayoutData(gd_composite);
		
		final Label statusLabel = new Label(composite, SWT.NONE);
		statusLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		statusLabel.setBounds(0, 2, 184, 15);
		
		Button okButton = new Button(composite, SWT.NONE);
		okButton.setBounds(99, 23, 85, 31);
		okButton.setText("OK");
		okButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseUp(MouseEvent arg0) {
				String result = parseValues();
				if (result != null) {
					statusLabel.setText(result);
				} else {
					statusLabel.setText("");
					valuesReady = true;
					configShell.dispose();
				}
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}
		});
		
		Button cancelButton = new Button(composite, SWT.NONE);
		cancelButton.setBounds(0, 23, 85, 31);
		cancelButton.setText("Cancel");
		cancelButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseUp(MouseEvent arg0) {
				System.exit(0);
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}
		});
		

	}
	
	private String parseValues() {
		try {
			widthValue = Integer.parseInt(widthText.getText());
		} catch(NumberFormatException nfe) {
			return "can't parse width";
		}
		try {
			heightValue = Integer.parseInt(heightText.getText());
		} catch(NumberFormatException nfe) {
			return "can't parse heigth";
		}
		try {
			zoomValue = Integer.parseInt(zoomText.getText());
		} catch(NumberFormatException nfe) {
			return "can't parse zoom";
		}
		try {
			fpsValue = Double.parseDouble(fpsText.getText());
		} catch(NumberFormatException nfe) {
			return "can't parse fps";
		}
		
		if (widthValue < 3)
			return "Width >= 3";
		if (heightValue < 3)
			return "Height >= 3";
		if (zoomValue < 1)
			return "zoom >= 1";
		if (fpsValue < 0)
			return "FPS >= 0";
		
		int screenWidth = this.configShell.getDisplay().getClientArea().width;
		int screenHeight = this.configShell.getDisplay().getClientArea().height;
		if (widthValue * zoomValue > screenWidth)
			return "Too wide for your screen";
		if (heightValue * zoomValue > screenHeight)
			return "Too high for your screen";
		return null;
	}
	
	public int getWidthValue() {
		return widthValue;
	}

	public int getHeightValue() {
		return heightValue;
	}

	public int getFieldSizeValue() {
		return zoomValue;
	}

	public double getFpsValue() {
		return fpsValue;
	}
	
	public boolean areValuesReady() {
		return valuesReady;
	}
}
