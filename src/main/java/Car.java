/** ��� ������ ������ � Java:
 *      1) � ��� ������� 1 �� �� ����, � ���� ����� �������� ����������� ���� � �� �����������
 *      � �������� ���������� � �������� �� ������� � ����(RAM, ���).
 *      2) � ��������� ����� ��� �������� ���� - � ��� ��� �������� ���� �������.
 *      3) ����� �� ������ ==, �� ���������� ���������� ������ �� �����, ������� ������������ ������.
 *
 *  ������� ��� hashcode � equals:
 *      1) ���� ������������� equals - ������������ � hashcode
 *      2) ���� hashcode ���� �������� ������ - ������� ���� ������
 *      3) ���� hashcode �������� ���������� - �� ����, ��� ������� ���� � �� ��, ��� ����� ���� ��������
 * */

import java.util.Objects;

public class Car implements Comparable<Car>{ // Generics � Comparable - ��� �� � ��� ����� ������ ����� ����������
    private final String model;
    private final int number;

    public static void main(String[] args) {
        Car car1 = new Car("TTC", 123);
        Car car2 = new Car("TTC", 123);
        System.out.println(car1 == car2); // ��������� ������� � �����
        System.out.println(car1.equals(car2)); // ��������� �������� � ����
        System.out.println(car1.hashCode()+" "+car2.hashCode()); // ����� ��������
    }

    public Car(String model, int number){
        this.model = model;
        this.number = number;
    }

    public String getModel(){
        return this.model;
    }

    public int getNum(){
        return this.number;
    }

    @Override
    public boolean equals(Object obj) {
        // ���������, ��� ��� obj ������������� car
        // ��� �������� - downCasting � if - ������� ������ car ������ Car �� ������� obj, ���� true
        if (obj instanceof Car car){
            // ������ DownCasting, ����� � obj �������� � �������� Car
            return this.model.equals(car.model) && this.number == car.number;
        }else{
            return false;
        }
    }
    // �� ������� ������: ������������� equals - ������������ hashcode
    /** ������ ������� �������� ����� ��� ���������� ������ HashSet, ���� ����� ������� � ����������� ������ (�� �������
     * ������ -> ������� ���������) ��� ����� ������ � ���������, ���� �� ������ */
    @Override
    public int hashCode() {
        // ���� ����� ������� ���, ����������� �� ����� �������
        return Objects.hash(model, number);
    }

    /** ���� ����� ����� �������������, ����� ������� TreeSet, ���� ��� ����� ���� ������� ���������� */
    @Override
    public int compareTo(Car o) {
        return this.getModel().compareTo(o.getModel()); // ������ 0 - �����, -1 - this ������, 1+ - this ������
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", number=" + number +
                '}';
    }
}
