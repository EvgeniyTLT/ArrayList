import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList carList;

    @org.junit.Before
    public void setUp() throws Exception {
        carList=new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100(CarList carList) {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementsRemoveByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(7));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementsRemoveThenSizeMustBeDecreased() {
        Car car = new Car("Reno", 10);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistenElementRemoveThenReturtFalse() {
        Car car = new Car("Reno", 10);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenlistClearedThenMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownExseption(){
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue(){
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

}