package shangrilla_reservation_producer;

import java.util.List;

public interface ShangrillaInterface {

	public int calAmount(int roomPrice, int noRooms, int noDays);
	public void printBill(List<ShangrillaReservation> booking , int discount);
}