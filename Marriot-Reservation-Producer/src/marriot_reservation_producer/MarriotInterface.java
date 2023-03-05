package marriot_reservation_producer;

import java.util.List;

public interface MarriotInterface {

	public int calAmount(int roomPrice, int noRooms, int noDays);
	public void printBill(List<Reservation> booking);
}