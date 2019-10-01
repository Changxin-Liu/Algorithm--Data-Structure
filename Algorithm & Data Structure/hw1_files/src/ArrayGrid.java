/**
 * A 2D grid implemented as an array.
 * Each (x,y) coordinate can hold a single item of type <T>.
 *
 * @param <T> The type of element held in the data structure
 */
public class ArrayGrid<T> implements Grid<T> {
	private Object[][] grid;
	private int width;
	private int height;
	/**
	 * Constructs tha new ArrayGrid object with a given width and height.
	 *
	 * @param width The width of the grid
	 * @param height The height of the grid
     * @throws IllegalArgumentException If the width or height is less than or equal to zero
	 */


	public ArrayGrid(int width, int height) throws IllegalArgumentException {
		// TODO: implement the constructor
		if (width <= 0 || height <= 0){
			throw new IllegalArgumentException("Width or Height cannot be less than or equal to zero");
		}
		grid = new Object[width][height];
		this.width = width;
		this.height = height;
	}
	// TODO: implement all of Grid's methods here


	@Override
	public void add(int x, int y, T element) throws IllegalArgumentException {
		if (x >= width || y >= height){
			throw new IllegalArgumentException(" x or y value is out of the grid's maximum bounds");
		}
		grid[x][y] = element;

	}

	@Override
	public T get(int x, int y) throws IndexOutOfBoundsException {
		if (x >= width || y >= height){
			throw new IndexOutOfBoundsException("x or y value is out of the grid's maximum bounds");
		}
		return (T)grid[x][y];
	}

	@Override
	public boolean remove(int x, int y) throws IndexOutOfBoundsException {
		//Do not have to address the exception here since it has been addressed by using "get(x,y)" method.
		if (get(x,y) != null){
			grid[x][y] = null;
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		for (int x = 0 ; x < width; x++){
			for (int y = 0; y < height; y++){
				grid[x][y] = null;
			}
		}
	}


	@Override
	public void resize(int newWidth, int newHeight) throws IllegalArgumentException {
		if (newWidth <= 0 || newHeight <= 0) {
			throw new IllegalArgumentException("Width or Height cannot be less than or equal to zero");
		}
		Object[][]tempGrid = new Object[newWidth][newHeight];

		for (int x = 0 ; x < width; x++) {
			for (int y = 0; y < height; y++) {
				//Find the elements which are not in the new array when reducing the size.
				if (x >= newWidth || y >= newHeight) {
					//If the value is not null, throw the exception since the elements will be lost.
					// Do not need to consider expanding the size since no elements will be lost.
					if (get(x, y) != null) {
						throw new IllegalArgumentException("Elements would be lost after this resizing operation");
					}
				}else{
					tempGrid[x][y] = grid[x][y];
				}
			}
		}
		grid = tempGrid;
		width = newWidth;
		height = newHeight;
	}
}