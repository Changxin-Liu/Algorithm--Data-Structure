

public class gridTest {
    public static void main(String[] args){
        final int WIDTH = 20;
        final int HEIGHT = 20;
        Grid<Object> grid;
        grid = new ArrayGrid<>(WIDTH, HEIGHT);
        grid.add(5, 5, "Override me");
        grid.add(5, 5, "Hello");
        grid.add(0, 0, "World");
        grid.add(0, 4, "UQ");
        grid.add(6, 0, "COMP3506");
        grid.add(5, 10, "COMP7505");

        for (int i = 0; i < WIDTH; i++){
            for (int j = 0; j < HEIGHT; j++){
                System.out.print(grid.get(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("##################################");
        grid.resize(7, 11);
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 11; j++){
                System.out.print(grid.get(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("##################################");
        grid.resize(WIDTH + 10, HEIGHT + 10);
        for (int i = 0; i < WIDTH + 10; i++){
            for (int j = 0; j < HEIGHT + 10; j++){
                System.out.print(grid.get(i, j) + " ");
            }
            System.out.println();
        }
    }

}
