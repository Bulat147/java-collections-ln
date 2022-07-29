import java.util.Arrays;

public class CarArrayList implements CarList{
    private Car[] array = new Car[10]; // capacity = 10
    private int size = 0;

    @Override
    public void add(Car car) {
        if (size >= array.length){
            // ����� �������� ������ ���������� �������, ����� �� ������
            array = Arrays.copyOf(array, array.length*2);
        }
        array[size] = car;
        size++;
    }

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean remove(Car car) {
        for (int i=0; i<size; i++){
            if (array[i].equals(car)){ // ��� ��������� ���� ����� ���������� ���
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i=index; i<size-1; i++){ // �� ������������������ ��-��, �.�. ����� �������� � ������� �� ������� �������
            array[i] = array[i+1];
        }
        array[size-1] = null;
        size--;
        return true; // ����� ������������ ������ true, �.�. ��� false-�������� ����������� Exception
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException{
        if (index<0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}