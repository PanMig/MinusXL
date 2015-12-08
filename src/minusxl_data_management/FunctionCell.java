package minusxl_data_management;

public class FunctionCell extends Cell<Object> {

	Object value;
	final String cellType = "Function";
	Function function;

	// This constructor takes in consideration the constructor of the
	// super-class (Cell)
	FunctionCell(int row, int column, Cell[] input_cells, String function) {
		super(row, column);
		// The "super" sends the arguments to the superclass constructor.

		// The first step is to create a function object

		switch (function) {
		// Here, depending on the requested function, we create the
		// corresponding one...

		// 1: Mathematical Functions:
		case "Abs":
			this.function = new AbsFunction(input_cells);
			break;

		case "Cos":
			this.function = new CosFunction(input_cells);
			break;

		case "Mult":
			this.function = new MultFunction(input_cells);
			break;

		case "Pow":
			this.function = new PowFunction(input_cells);
			break;

		case "Log":
			this.function = new LogFunction(input_cells);
			break;

		case "Sum":
			this.function = new SumFunction(input_cells);
			break;

		case "Log10":
			this.function = new Log10Function(input_cells);
			break;

		// 2. Logical Functions:

		// 3. Statistical Functions:

		// 4. Alpharithmetic Functions:

		default:
			// TODO: Right now, using the console - later maybe using the GUI,
			// return an error message
			System.out.println("Sorry, but the requested function was not found.");
			break;
		}

		// The second step is to let the function object do its job on the data
		// and save the value here, to the FunctionCell's "value" field.
		calculateValue();

		// Aaaand, we're finished!
	}

	public void calculateValue() {
		// We ask the function object to do its job on the data
		// and then we save the value here, to the FunctionCell's "value" field.
		// We can call this method whenever we want the data to be updated
		value = function.calculateValue();
	}

	@Override
	public Object getCell() {
		return value;
	}

	@Override
	public String getCellType() {
		return cellType;
	}

	@Override
	public void setCell(Object input) {
		value = input.toString();
	}

}
